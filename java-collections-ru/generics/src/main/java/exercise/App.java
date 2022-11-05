package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();

        List<String> searchWords = new ArrayList<>(where.values());
        int count;
        for (Map<String, String> book : books) {
            count = 0;
            List<String> setBook = new ArrayList<>(book.values());
            for (String word : searchWords) {
                if (setBook.contains(word)) {
                    count++;
                }
                if (count == searchWords.size()) {
                    result.add(book);
                }
            }
        }
        return result;
    }
}
//END
