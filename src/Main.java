import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//"C:\Users\Admin\javarush\text.txt"
public class Main {
    public static void main(String[] args) {

        UkrainianAlphabet.UkrainianAlphabet();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the file address");
        String file = scanner.nextLine();

        System.out.println("Please enter key (any number)");
        int key = scanner.nextInt();

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            ArrayList<Character> textChar = new ArrayList<>();

            while (bufferedReader.ready()) {
                char ch = (char) fileReader.read();
                textChar.add(ch);
            }
            // Зроблено зчитування ключа( цифри ) і тексту з файлу і перетворення файлу на char
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist or is not available. Try another one " + e );
        } catch (IOException e) {
            System.out.println("Something went wrong. Try again " + e);
        }
    }
}

