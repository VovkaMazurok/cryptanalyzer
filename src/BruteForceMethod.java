import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BruteForceMethod {
    public static void bruteForceDecrypt(ArrayList<Character> textChar, String timeNow) {

        int keyRange = 26;

        String way = "C:\\Users\\Admin\\javarush";
        String fileName = timeNow + "readme1.txt";
        File file = new File(way, fileName);

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            for (int key = 1; key <= keyRange; key++) {
                for (int i = 0; i < textChar.size(); i++) {
                    char ch = (char) textChar.get(i);
                    if (Character.isLetter(ch)) {
                        char base = Character.isUpperCase(ch) ? 'A' : 'a';
                        ch = (char) (((ch - base - key + 26) % 26) + base);
                    }
                    bufferedWriter.append(ch);
                }
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
