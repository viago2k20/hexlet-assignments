package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> map = new HashMap<>();
        if (sentence.length() == 0) {
            return map;
        }

        String[] arrCurrent = sentence.split(" ");
        for (String word : arrCurrent) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }

    public static String toString(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder result = new StringBuilder("{\n");
        for (Map.Entry<String, Integer> words : map.entrySet()) {
            result.append("  ")
                    .append(words.getKey())
                    .append(": ")
                    .append(words.getValue())
                    .append("\n");
        }
        return result.append("}").toString();
    }

    public static void main(String[] args) {

    }
}
//END
