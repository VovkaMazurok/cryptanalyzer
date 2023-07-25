import java.io.*;
import java.util.ArrayList;

public class CaesarsCipher {
    public static void encryption(ArrayList<Character> textChar, int key, String  timeNow) {

        UkrainianAlphabet.ukrainianAlphabet();

        String way = "C:\\Users\\Admin\\javarush";
        String fileName = timeNow + "readme1.txt";
        File file = new File(way, fileName);

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            for (int j = 0; j < textChar.size(); j++) {
                for (int i = 0; i < UkrainianAlphabet.alphabet.size(); i++) {
                    if (textChar.get(j).equals(UkrainianAlphabet.alphabet.get(i))) {
                        bufferedWriter.append((char) UkrainianAlphabet.alphabet.get((i + key) % 38));
                    }
                }
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void decryption(ArrayList<Character> textChar, int key, String timeNow) {

        UkrainianAlphabet.ukrainianAlphabet();

        String way = "C:\\Users\\Admin\\javarush";
        String fileName = timeNow + "readme1.txt";
        File file = new File(way, fileName);

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            for (int j = 0; j < textChar.size(); j++) {
                for (int i = 0; i < UkrainianAlphabet.alphabet.size(); i++) {
                    if (textChar.get(j).equals(UkrainianAlphabet.alphabet.get(i))) {
                        bufferedWriter.append((char) UkrainianAlphabet.alphabet.get((38 + (i - key) % 38) % 38));
                    }
                }
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
