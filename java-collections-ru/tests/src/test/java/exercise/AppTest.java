package exercise;

//import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

    List<Integer> numbers;
    ArrayList<Integer> arr;

    @BeforeEach
    void initIntegerList() {
        this.numbers = new ArrayList<>();
        this.numbers.add(5);
        this.numbers.add(6);
        this.numbers.add(7);
        this.numbers.add(4);
        this.numbers.add(1);
        arr = new ArrayList<>(Arrays.asList(5, 6, 7, 4, 1));
    }

    @Test
    void testTake() {
        // BEGIN
        Assertions.assertEquals(App.take(numbers, 2), new ArrayList<>(Arrays.asList(5, 6)));
        Assertions.assertEquals(App.take(numbers, 8), arr);
        // END
    }
}
