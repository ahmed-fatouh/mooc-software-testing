package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {

    private GHappy ghappy;
    private boolean result;

    @BeforeEach
    public void Initialize(){
        this.ghappy = new GHappy();
    }

    @ParameterizedTest
    @CsvSource({"nudge", "google", "gig"})
    public void SeparatedGs(String word){
        this.result = ghappy.gHappy(word);
        Assertions.assertFalse(this.result);
    }

    @ParameterizedTest
    @CsvSource({"toggle", "xtuggggmk", "ggg", "gguuhhgg", "knggguuggo", "ggxggxgg"})
    public void ConsecutiveGs(String word){
        this.result = ghappy.gHappy(word);
        Assertions.assertTrue(this.result);
    }

    @ParameterizedTest
    @CsvSource({"goggle", "gxgg", "uxgggxcgh"})
    public void MixedSeparatedAndConsecutiveGs(String word){
        this.result = ghappy.gHappy(word);
        Assertions.assertFalse(this.result);
    }

    @Test
    public void CheckForNullInputs(){
        Assertions.assertThrows(AssertionError.class, () -> ghappy.gHappy(null));
    }
}
