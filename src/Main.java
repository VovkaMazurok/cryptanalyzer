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

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while (bufferedReader.ready()) {
                char ch = (char) fileReader.read();
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

        System.out.println("Please choose a method and press the number: \n ...1 - encryption... \n ...2 - decryption...");
        int n = scanner.nextInt();
        if (n == 1) {
            encryption(textChar, key);
        } else if (n == 2) {
            decryption(textChar, key);
        }

    }

    private static void encryption(ArrayList textChar, int key) {

        UkrainianAlphabet.ukrainianAlphabet();

        //  У "fileName" має бути записана змінна "file2"

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\javarush\\text2.txt"))) {

            for (int j = 0; j < textChar.size(); j++) {
                for (int i = 0; i < UkrainianAlphabet.alphabet.size(); i++) {
                    if (textChar.get(j).equals(UkrainianAlphabet.alphabet.get(i))) {
                        bufferedWriter.append((char) UkrainianAlphabet.alphabet.get((i + key) % 41));
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void decryption(ArrayList textChar, int key) {

        UkrainianAlphabet.ukrainianAlphabet();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\javarush\\text2.txt"))) {

            for (int j = 0; j < textChar.size(); j++) {
                for (int i = 0; i < UkrainianAlphabet.alphabet.size(); i++) {
                    if (textChar.get(j).equals(UkrainianAlphabet.alphabet.get(i))) {
                        bufferedWriter.append((char) UkrainianAlphabet.alphabet.get((i + key) % 41));
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
// Шифрування / розшифрування
}

