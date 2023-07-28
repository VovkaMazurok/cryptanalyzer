import java.util.ArrayList;

public class EnglishAlphabet {
    public static ArrayList<Character> alphabet = new ArrayList<>();

    public static void englishAlphabet() {


        String abc = "abcdefghijklmnopqrstuvwxyz.,”):’-!(? ";
        char[] abcArray = abc.toCharArray();


        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }
    }
}
