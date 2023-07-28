import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class BruteForceMethod {
    public static void bruteForceDecrypt(ArrayList<Character> textChar, String timeNow) {
DictionaryOfWords.dictionaryOfWords();
        int keyRange = 26;
        int key;
        String str = "";

        String way = "C:\\Users\\Admin\\javarush";
        String fileName = timeNow + "readme1.txt";
        File file = new File(way, fileName);

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            for (key = 1; key <= keyRange; key++) {
                for (int i = 0; i < textChar.size(); i++) {
                    char ch = (char) textChar.get(i);
                    if (Character.isLetter(ch)) {
                        char base = Character.isUpperCase(ch) ? 'A' : 'a';
                        str = str + (char) (((ch - base - key + 26) % 26) + base);
                    }


                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println( str);

//        String(char[] value)  конструктор для перетворення масиву символів у рядок.
       // char ch = (char) Character.toLowerCase(bufferedReader.read());


        if (checkDecryptedText(str, DictionaryOfWords.dictionary)) {
            System.out.println("Успішно зламано! Ключ: " + key);
            System.out.println("Розшифрований текст:");
            System.out.println(textChar);
        }
    }

    public static boolean checkDecryptedText(String str, HashSet<String> dictionary) {

        // Розбиваємо розшифрований текст на слова
        String[] words = str.split("\\s+");

        // Перевіряємо кожне слово на наявність у словнику
        for (String word : words) {
            if (!dictionary.contains(word.toLowerCase())) {
                return false;
            }
        }
        return true;

    }
}
