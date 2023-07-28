import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public final class DictionaryOfWords {
   public static HashSet<String> dictionary = new HashSet<>();
    public static void dictionaryOfWords() {



        //File file = new File("https://github.com/VovkaMazurok/cryptanalyzer/blob/f482d3d03180f00ab5e0b32123ce7a94c2f2dd45/src/DictionaryOfEnglishWords.txt");
        File file = new File("D:\\programs\\cryptanalyzer\\src\\DictionaryOfEnglishWords.txt");
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                dictionary.add(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено");
        }
    }
}
