package tudelft.countletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CountLettersTest {

    @ParameterizedTest
    @CsvSource({"cats|dogs","land rover car","star&planets"})
    public void multipleMatchingWords(String example) {
        int words = new CountLetters().count(example);
        Assertions.assertEquals(2, words);
    }

    @Test
    public void lastWordDoesNotMatch() {
        int words = new CountLetters().count("cats|dog");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void noMatchingWords() {
        int words = new CountLetters().count("cat|dog");
        Assertions.assertEquals(0, words);
    }

}