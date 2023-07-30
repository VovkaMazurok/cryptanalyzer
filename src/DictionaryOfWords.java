import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public final class DictionaryOfWords {
   public static HashSet<String> dictionary = new HashSet<>();
    public static void dictionaryOfWords() {

       File DictionaryOfEnglishWords = new File("src/DictionaryOfEnglishWords.txt");

        try (Scanner scanner = new Scanner(DictionaryOfEnglishWords)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                dictionary.add(line);

            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
