import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//"C:\Users\Admin\javarush\text.txt"
public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the file address");
        String file = scanner.nextLine();

        System.out.println("Please enter key (any number)");
        int key = scanner.nextInt();

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

        // Зроблено зчитування ключа( цифри ) і тексту з файлу і перетворення файлу

        encryption(textChar, key);
        decryption(textChar, key);
    }

    private static void encryption(ArrayList textList, int key) throws Exception {
        UkrainianAlphabet.ukrainianAlphabet();


        ArrayList<Character> characterArrayList = new ArrayList<>();
        for (int j = 0; j < textList.size(); j++) {
            for (int i = 0; i < UkrainianAlphabet.alphabet.size(); i++) {
                if (textList.get(j).equals(UkrainianAlphabet.alphabet.get(i))) {
                    characterArrayList.add((char) UkrainianAlphabet.alphabet.get((i + key) % 41));
                } else
                    continue;
            }
        }
        System.out.println(characterArrayList.toString());

    }

    private static void decryption(ArrayList arrayList, int key) {

    }
// Шифрування / розшифрування
}

