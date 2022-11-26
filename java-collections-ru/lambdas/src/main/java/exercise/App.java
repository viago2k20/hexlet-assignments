package exercise;

import java.util.Arrays;

import static java.util.stream.Stream.of;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        return Arrays.stream(image)
                .flatMap(x -> of(Arrays.stream(x)
                        .flatMap(i -> of(i, i))
                        .toArray(String[]::new), Arrays.stream(x)
                        .flatMap(a -> of(a, a))
                        .toArray(String[]::new)))
                .toArray(String[][]::new);
    }
//    public static String[][] enlargeArrayImage(String[][] image) {
//        int num = 2;
//        int lineSize = image.length * num;
//        int columnSize = image[0].length * num;
//        String[][] enlargeArray = new String[lineSize][columnSize];
//
//        int count;
//        int m = 0;
//        for (int k = 0; k < enlargeArray.length; k++) {
//            count = num;
//            int j = 0;
//            for (int i = 0; i < enlargeArray[k].length; i++) {
//                enlargeArray[k][i] = image[m][j];
//                count--;
//                if (count == 0) {
//                    count = num;
//                    j++;
//                }
//            }
//            m++;
//            for (int a = 0; a < (num - 1); a++) {
//                k++;
//                enlargeArray[k] = Arrays.copyOf(enlargeArray[k - 1], enlargeArray[k - 1].length);
//            }
//        }
//        return enlargeArray;
//    }
}
// END
