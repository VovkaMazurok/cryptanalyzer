import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

//"C:\Users\Admin\javarush\text.txt"  це мій файл яким я перевіряю програму
public class Main {
    public static String way = "D:\\";
    public static String fileName = String.valueOf(LocalTime.now().getNano()) + "readme.txt";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello user!) The program works with English words, letters and punctuation marks");
        System.out.println("Please enter the file address");
        String file = scanner.nextLine();

        ArrayList<Character> textChar = new ArrayList<>();

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while (bufferedReader.ready()) {
                char ch = (char) Character.toLowerCase(bufferedReader.read());
                textChar.add(ch);
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist or is not available. Try another one " + e);
        } catch (IOException e) {
            System.out.println("Something went wrong. Try again " + e);
        }

        System.out.println("Please select the method you want to use and press the corresponding number: \n" +
                "...1 - Caesar's Cipher...\n" +
                "...2 - Brute force method...");
        int method = scanner.nextInt();

        if (method == 1) {
            System.out.println("Please choose a method and press the number:\n...1 - encryption...\n...2 - decryption...");
            int encOrDec = scanner.nextInt();

            if (encOrDec == 1) {
                System.out.println("Enter the cryptographic key to encrypt the tex");
                int keyEncrypt = scanner.nextInt();
                CaesarsCipher.encryption(textChar, keyEncrypt);
            } else if (encOrDec == 2) {
                System.out.println("Enter the cryptographic key to decrypt the text");
                int keyDec = scanner.nextInt();
                CaesarsCipher.decryption(textChar, keyDec);
            }
        } else if (method == 2) {
            BruteForceMethod.bruteForceDecrypt(textChar);
        }
    }
}


