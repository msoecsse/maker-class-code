package wk5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static wk5.Recursion.*;

public class RecursionTests {
    @Tag("printStarsTest")
    public static class PrintStartsTests {
        @Test
        public void throwsExceptionOnBadNonRecursiveMethodCall() {
            Assertions.assertThrows(RuntimeException.class, () -> printStarsBadExample(5));
        }

        @Test
        public void throwsExceptionOnBadRecursiveMethodCall() {
            Assertions.assertThrows(RuntimeException.class, () -> printStarsExampleStartingToUseRecursion(5));
        }
    }

    @Tag("mysteryMethods")
    public static class MysteryTest {

        /**
         * NOTE: THESE ARE NOT GOOD TEST NAMES OR A GOOD WAY TO SPLIT THESE UP. THIS IS JUST FOR DEMO PURPOSES
         */
        @Test
        public void validatesMystery1Behavior() {
            Assertions.assertEquals(9, mystery1(648));
            Assertions.assertEquals(5, mystery1(203));
            Assertions.assertEquals(9, mystery1(999));
            Assertions.assertEquals(2, mystery1(1001));
        }

        @Test
        public void validatesMystery2Behavior() {
            Assertions.assertEquals(334488, mystery2(348));
            Assertions.assertEquals(2222, mystery2(22));
            Assertions.assertEquals(11000011, mystery2(1001));
        }
    }
}
