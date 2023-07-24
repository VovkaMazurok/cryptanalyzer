import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//"C:\Users\Admin\javarush\text.txt"
public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the file address");
        String file = scanner.nextLine();

        // System.out.println("Enter the path to the file where to write encrypted / encrypted text");
        // String file2 = scanner.nextLine();
        // Потрібно уточнити

        ArrayList<Character> textChar = new ArrayList<>();
// тут треба подумати над FileReader
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while (bufferedReader.ready()) {
                char ch = (char) bufferedReader.read();
                textChar.add(ch);
            }
            System.out.println(textChar);

        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist or is not available. Try another one " + e);
        } catch (IOException e) {
            System.out.println("Something went wrong. Try again " + e);
        }

        System.out.println("Please enter key (any number)");
        int key = scanner.nextInt();

        // Зроблено зчитування ключа( цифри ) і тексту з файлу і перетворення файлу

        System.out.println("Please choose a method and press the number: \n ...1 - encryption... \n ...2 - decryption...\n"
                + " ...3 - bruteForceDecrypt");
        int n = scanner.nextInt();

        if (n == 1) {
            encryption(textChar, key);
        } else if (n == 2) {
            decryption(textChar, key);
        } else if (n == 3) bruteForceDecrypt(textChar);

    }

    private static void encryption(ArrayList<Character>textChar, int key) {

        UkrainianAlphabet.ukrainianAlphabet();

        //  У "fileName" має бути записана змінна "file2"

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\javarush\\text2.txt"))) {

            for (int j = 0; j < textChar.size(); j++) {
                for (int i = 0; i < UkrainianAlphabet.alphabet.size(); i++) {
                    if (textChar.get(j).equals(UkrainianAlphabet.alphabet.get(i))) {
                        bufferedWriter.append((char) UkrainianAlphabet.alphabet.get((i + key) % 44));
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void decryption(ArrayList<Character> textChar, int key) {

        UkrainianAlphabet.ukrainianAlphabet();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\javarush\\text2.txt"))) {

            for (int j = 0; j < textChar.size(); j++) {
                for (int i = 0; i < UkrainianAlphabet.alphabet.size(); i++) {
                    if (textChar.get(j).equals(UkrainianAlphabet.alphabet.get(i))) {
                        bufferedWriter.append((char) UkrainianAlphabet.alphabet.get((44 + (i - key) % 44) % 44));
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Максимальне значення для ключа (1 до 25)
    public static void bruteForceDecrypt(ArrayList<Character> textChar) {

        int keyRange = 33;

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\javarush\\text2.txt"))) {

            for (int key = 1; key <= keyRange; key++) {
                ArrayList<Character> arrayList = new ArrayList<>();
                for (int i = 0; i < textChar.size(); i++) {
                    char ch = (char) textChar.get(i);
                    if (Character.isLetter(ch)) {
                        char base = Character.isUpperCase(ch) ? 'А' : 'а';
                        ch = (char) (((ch - base - key + 33) % 33) + base);
                    }
                    arrayList.add(ch);
                }
                System.out.println("Key " + key + ": " + arrayList);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
   }
}


