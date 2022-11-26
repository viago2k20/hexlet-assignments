package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {

    @Test
    void testEnlargeSimple() {
        String[][] one = {
                {"*"}
        };
        String[][] result = {
                {"*", "*"},
                {"*", "*"}
        };

        String[][] actual = App.enlargeArrayImage(one);
        assertThat(actual).isEqualTo(result);
    }

    @Test
    void testEnlargeSquare() {
        String[][] square = {
                {"*", "*"},
                {" ", " "}
        };
        String[][] doubleSquare = {
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {" ", " ", " ", " "},
                {" ", " ", " ", " "}
        };

        String[][] actual = App.enlargeArrayImage(square);
        assertThat(actual).isEqualTo(doubleSquare);
    }


    @Test
    void testEnlargeArrayImage() {
        String[][] tall = {
                {" ", " "},
                {" ", "*"},
                {" ", "*"},
                {" ", "*"},
        };
        String[][] expected = {
                {" ", " ", " ", " "},
                {" ", " ", " ", " "},
                {" ", " ", "*", "*"},
                {" ", " ", "*", "*"},
                {" ", " ", "*", "*"},
                {" ", " ", "*", "*"},
                {" ", " ", "*", "*"},
                {" ", " ", "*", "*"}
        };

        String[][] actual = App.enlargeArrayImage(tall);
        assertThat(actual).isEqualTo(expected);
    }
}
// END
