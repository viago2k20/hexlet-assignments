package exercise;

import java.util.List;
//import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> list) {
        return list.stream()
                .filter(name -> name.endsWith("gmail.com")
                        || name.endsWith("yandex.ru")
                        || name.endsWith("hotmail.com"))
                .count();
    }
}
// END
