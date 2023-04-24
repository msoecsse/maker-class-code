package exam2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static exam2.Exam2ImplementationQuestions.isPalindromeSampleTwoStacks;
import static exam2.Exam2ImplementationQuestions.isPalindromeSampleStackAndQueue;
import static exam2.Exam2ImplementationQuestions.isPalindromeSampleSingleStack;
import static exam2.Exam2ImplementationQuestions.GCDSample;
import static exam2.Exam2ImplementationQuestions.GCDAdvanced;

public class Exam2ImplementationQuestionsTests {
    @Test
    public void validatesTwoStacksIsPalindrome() {
        Assertions.assertTrue(isPalindromeSampleTwoStacks("radar"));
        Assertions.assertTrue(isPalindromeSampleTwoStacks("RaDaR"));
        Assertions.assertTrue(isPalindromeSampleTwoStacks("Straw? No, too stupid a fad. I put soot on warts."));
        Assertions.assertTrue(isPalindromeSampleTwoStacks("racecar"));
        Assertions.assertFalse(isPalindromeSampleTwoStacks("NASCAR"));
    }

    @Test
    public void validatesStackAndQueueIsPalindrome() {
        Assertions.assertTrue(isPalindromeSampleStackAndQueue("radar"));
        Assertions.assertTrue(isPalindromeSampleStackAndQueue("RaDaR"));
        Assertions.assertTrue(isPalindromeSampleStackAndQueue("Straw? No, too stupid a fad. I put soot on warts."));
        Assertions.assertTrue(isPalindromeSampleStackAndQueue("racecar"));
        Assertions.assertFalse(isPalindromeSampleStackAndQueue("NASCAR"));
    }

    @Test
    public void validatesSingleStackIsPalindrome() {
        Assertions.assertTrue(isPalindromeSampleSingleStack("radar"));
        Assertions.assertTrue(isPalindromeSampleSingleStack("RaDaR"));
        Assertions.assertTrue(isPalindromeSampleSingleStack("Straw? No, too stupid a fad. I put soot on warts."));
        Assertions.assertTrue(isPalindromeSampleSingleStack("racecar"));
        Assertions.assertFalse(isPalindromeSampleSingleStack("NASCAR"));
    }

    @Test
    public void validatesGCD() {
        Assertions.assertEquals(6, GCDSample(366, 60));
        Assertions.assertEquals(6, GCDSample(60, 366));
        Assertions.assertEquals(12, GCDSample(24, 12));
        Assertions.assertEquals(12, GCDSample(24, 60));
        Assertions.assertEquals(1, GCDSample(25, 16));
        Assertions.assertEquals(12, GCDSample(12, 12));
        Assertions.assertEquals(2, GCDSample(414, 662));
    }

    @Test
    public void validatesGCDAdvanced() {
        Assertions.assertEquals(6, GCDAdvanced(366, 60));
        Assertions.assertEquals(6, GCDAdvanced(60, 366));
        Assertions.assertEquals(12, GCDAdvanced(24, 12));
        Assertions.assertEquals(12, GCDAdvanced(24, 60));
        Assertions.assertEquals(1, GCDAdvanced(25, 16));
        Assertions.assertEquals(12, GCDAdvanced(12, 12));
        Assertions.assertEquals(2, GCDAdvanced(414, 662));
    }
}
