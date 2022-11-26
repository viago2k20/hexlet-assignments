package exercise;

//import java.util.ArrayList;
//import java.util.Comparator;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
//import java.time.LocalDate;
//import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> user) {
        return user.stream()
                .sorted(Comparator.comparing(i -> i.get("birthday")))
                .filter(x -> x.get("gender").equals("male"))
                .map(x -> x.get("name"))
                .toList();
    }
}
// END
