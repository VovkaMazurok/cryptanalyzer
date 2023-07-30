import java.io.*;
import java.util.ArrayList;

public final class CaesarsCipher {
    public static void encryption(ArrayList<Character> textChar, int key) {

        EnglishAlphabet.englishAlphabet();

        File file = new File(Main.way, Main.fileName);

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            for (int j = 0; j < textChar.size(); j++) {
                for (int i = 0; i < EnglishAlphabet.alphabet.size(); i++) {
                    if (textChar.get(j).equals(EnglishAlphabet.alphabet.get(i))) {
                        if (key > 0) {
                            bufferedWriter.append((char) EnglishAlphabet.alphabet.get((i + key) % 37));
                        } else if(key < 0) {
                             bufferedWriter.append((char) EnglishAlphabet.alphabet.get((37 + (i + key) % 37) % 37));
                        }
                    }
                }
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void decryption(ArrayList<Character> textChar, int key) {

        EnglishAlphabet.englishAlphabet();

        File file = new File(Main.way, Main.fileName);

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            for (int j = 0; j < textChar.size(); j++) {
                for (int i = 0; i < EnglishAlphabet.alphabet.size(); i++) {

                    if (textChar.get(j).equals(EnglishAlphabet.alphabet.get(i))) {
                        if(key > 0) {
                            bufferedWriter.append((char) EnglishAlphabet.alphabet.get((37 + (i - key) % 37) % 37));
                        } else if (key < 0) {
                            bufferedWriter.append((char) EnglishAlphabet.alphabet.get((i - key) % 37));
                        }
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
