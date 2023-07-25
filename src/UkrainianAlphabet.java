import java.util.ArrayList;

public final class UkrainianAlphabet {
    public static ArrayList<Character> alphabet = new ArrayList<>();

    public static final void ukrainianAlphabet() {


        String abc = "abcdefghijklmnopqrstuvwxyz.,”):’-!(? ";
        char[] abcArray = abc.toCharArray();


        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }
    }
}
