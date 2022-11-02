package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String letters, String word) {
        List<String> listLetters = new ArrayList<>(Arrays.asList(letters.toLowerCase().split("")));
        List<String> listWord = new ArrayList<>(Arrays.asList(word.toLowerCase().split("")));

        for (String s : listWord) {
            if (!listLetters.contains(s.toLowerCase())) {
                return false;
            }
            listLetters.remove(s);
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
//END
