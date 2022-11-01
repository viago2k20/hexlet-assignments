package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String letters, String word) {
        if (letters.length() < word.length()) {
            return false;
        }
        List<String> listLetters = new ArrayList<>(Arrays.asList(letters.toLowerCase().split("")));
        List<String> listWord = new ArrayList<>(Arrays.asList(word.toLowerCase().split("")));

        for (int i = 0; i < listLetters.size(); i++) {
            for (int j = 0; j < listWord.size(); j++) {
                if ((listLetters.get(i).equals(listWord.get(j)))) {
                    listWord.remove(listLetters.get(i));
                    if (listWord.size() == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
//END
