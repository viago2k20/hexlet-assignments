package exercise;

//import com.sun.jdi.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

//import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String txt) {
        String line;
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new StringReader(txt))) {
            while ((line = reader.readLine()) != null) {
                if (line.contains("environment=")) {
                    list.add(line.substring(13));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String tmp = list.stream()
                .map(x -> x.replaceAll("\"", ","))
                .collect(Collectors.joining(""));

        return Arrays.stream(tmp.split(","))
                .filter(x -> x.contains("X_FORWARDED_"))
                .map(x -> x.substring(12))
                //.peek(x -> System.out.println("$: " + x))
                .collect(Collectors.joining(","));
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    public static void main(String[] args) throws Exception {
        String data2 = readFixture("s2.conf");
        String result2 = App.getForwardedVariables(data2);

        System.out.println("Ответ: " + result2);
    }

}
//END
