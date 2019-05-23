package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarShiftCipherTest {

    private CaesarShiftCipher caesar;

    @BeforeEach()
    public void Initialize(){
        this.caesar = new CaesarShiftCipher();
    }

    @ParameterizedTest()
    @CsvSource({"abc,3,def", "xyz,3,abc", "a o,1,b p", "f,7,m", "yyy,5,ddd"})
    public void PositiveShiftValue(String message, int shift, String expected){
        String result = caesar.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest()
    @CsvSource({"abc,-3,xyz", "xyz,-3,uvw", "b p,-1,a o", "m,-7,f", "ddd,-5,yyy"})
    public void NegativeShiftValue(String message, int shift, String expected){
        String result = caesar.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest()
    @CsvSource({"abc", "xyz", "t   v h" ,"s", "qqq"})
    public void ZeroShiftValue(String message){
        String result = caesar.CaesarShiftCipher(message, 0);
        Assertions.assertEquals(message, result);
    }

    @ParameterizedTest()
    @CsvSource({"q!2", "@#$%", "Car", "C^2", "2010","a|b"})
    public void InvalidMessage(String message){
        String result;
        result = caesar.CaesarShiftCipher(message, -3);
        Assertions.assertEquals("invalid", result);
        result = caesar.CaesarShiftCipher(message, 0);
        Assertions.assertEquals("invalid", result);
        result = caesar.CaesarShiftCipher(message, 3);
        Assertions.assertEquals("invalid", result);
    }
}
