package tudelft.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MirrorTest {

    private Mirror mirror;

    @BeforeEach
    public void Initialize(){
        mirror = new Mirror();
    }

    @ParameterizedTest
    @CsvSource({"abcWXYZcba,abc", "abca,a", "abba, abba", "aaaa,aaaa"})
    public void MirrorWithStringsHavingEvenLengths(String input, String expected){
        String result = mirror.mirrorEnds(input);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"abXYZba,ab", "label,l", "aba,aba", "ddd,ddd", "a,a"})
    public void MirrorWithStringsHavingOddLengths(String input, String expected){
        String result = mirror.mirrorEnds(input);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"xyz", "haha"})
    public void NoMirror(String input){
        String result = mirror.mirrorEnds(input);
        Assertions.assertEquals("", result);
    }

    @Test
    public void ZeroLengthInputString(){
        String result = mirror.mirrorEnds("");
        Assertions.assertEquals("", result);
    }
}
