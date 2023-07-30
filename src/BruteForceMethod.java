import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class BruteForceMethod {

    public static void bruteForceDecrypt(ArrayList<Character> textChar) {

        EnglishAlphabet.englishAlphabet();
        DictionaryOfWords.dictionaryOfWords();

        File file = new File(Main.way, Main.fileName);

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (int key = 1; key <= EnglishAlphabet.alphabet.size(); key++) {

                ArrayList<String> stringArrayList = new ArrayList<>();
                String world = "";

                for (int i = 0; i < textChar.size(); i++) {
                    char encryptedChar = textChar.get(i);
                    int encryptedCharIndex = EnglishAlphabet.alphabet.indexOf(encryptedChar);
                    int decryptedCharIndex = (encryptedCharIndex - key + EnglishAlphabet.alphabet.size()) % EnglishAlphabet.alphabet.size();
                    if (Character.isLetter(EnglishAlphabet.alphabet.get(decryptedCharIndex))) {
                        world = world + (EnglishAlphabet.alphabet.get(decryptedCharIndex));
                    } else {
                        stringArrayList.add(world);
                        world = "";
                    }
                }

                int wordsInDictionary = 0;
                int maxWordsInDictionary = 0;

                for (int j = 0; j < stringArrayList.size(); j++) {
                    if (DictionaryOfWords.dictionary.contains(stringArrayList.get(j))) {
                        wordsInDictionary++;
                    }
                }

                if ((wordsInDictionary / (double) stringArrayList.size()) * 100 > 30 && wordsInDictionary > maxWordsInDictionary) {

                    String str = "Hacked successfully! Key: " + key + "\nDecoded text: " + stringArrayList;
                    bufferedWriter.append(str);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



