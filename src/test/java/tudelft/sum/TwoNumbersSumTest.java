package tudelft.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoNumbersSumTest {

    @Test
    public void sameLengthNumbers(){
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        first.add(2);
        ArrayList<Integer> second = new ArrayList<Integer>();
        second.add(8);
        second.add(9);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(0);
        expected.add(1);
        ArrayList<Integer> sum = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertEquals(expected, sum);
    }

    @Test
    public void firstNumberHasMoreDigits(){
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        ArrayList<Integer> second = new ArrayList<Integer>();
        second.add(8);
        second.add(9);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(9);
        expected.add(0);
        ArrayList<Integer> sum = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertEquals(expected, sum);
    }

    @Test
    public void secondNumberHasMoreDigits(){
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        first.add(4);
        ArrayList<Integer> second = new ArrayList<Integer>();
        second.add(3);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(7);
        ArrayList<Integer> sum = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertEquals(expected, sum);
    }


    // The next two tests are meant to test the for loop when there
    // is zero or only one element.
    @Test
    public void numbersHaveNoDigits(){
        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        ArrayList<Integer> sum = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertEquals(expected, sum);
    }

    @Test
    public void oneNumberHasNoDigits(){
        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>();
        second.add(6);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(6);
        ArrayList<Integer> sum = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertEquals(expected, sum);
    }
}
