import java.util.ArrayList;

public final class UkrainianAlphabet {
    public static void UkrainianAlphabet(){


        String abc = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩьЮЯ.,””:-!? ";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabetChar = new ArrayList<>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabetChar.add(abcArray[i]);
        }
    }
}
