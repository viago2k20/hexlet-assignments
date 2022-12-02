package exercise;

import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
class App {
    public static Map<String, Object> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> listOfKeys = Stream.of(data1.keySet(), data2.keySet())
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        return listOfKeys.stream()
                .collect(Collectors.toMap(Function.identity(), x -> {
                    Object tmp = "";
                    if (!data1.containsKey(x) && data2.containsKey(x)) {
                        tmp = "added";
                    }
                    if (data1.containsKey(x) && !data2.containsKey(x)) {
                        tmp = "deleted";
                    }
                    if (data1.containsKey(x) && data2.containsKey(x) && !data2.get(x).equals(data1.get(x))) {
                        tmp = "changed";
                    }
                    if (data1.containsKey(x) && data2.containsKey(x) && data2.get(x).equals(data1.get(x))) {
                        tmp = "unchanged";
                    }
                    return tmp;
                }));
    }

    public static void main(String[] args) {
        Map<String, Object> data1 = new HashMap<>(
                Map.of("two", "own", "one", "one", "ten", "10")
        );
        Map<String, Object> data2 = new HashMap<>(
                Map.of("one", "one", "two", "two", "zero", "0")
        );

        Set<String> listOfKeys = Stream.of(data1.keySet(), data2.keySet())
                .flatMap(Collection::stream)
                .distinct()
                //.peek(x -> System.out.println("$" + x))
                .collect(Collectors.toSet());

        Map<String, Object> result = listOfKeys.stream()
                .collect(Collectors.toMap(Function.identity(), x -> {
                    Object tmp = "";
                    if (!data1.containsKey(x) && data2.containsKey(x)) {
                        tmp = "added";
                    }
                    if (data1.containsKey(x) && !data2.containsKey(x)) {
                        tmp = "deleted";
                    }
                    if (data1.containsKey(x) && data2.containsKey(x) && !data2.get(x).equals(data1.get(x))) {
                        tmp = "changed";
                    }
                    if (data1.containsKey(x) && data2.containsKey(x) && data2.get(x).equals(data1.get(x))) {
                        tmp = "unchanged";
                    }
                    return tmp;
                }));
        System.out.println(result);

    }
}
//END
