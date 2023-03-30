package wk4;

// If you want to do @BeforeEach, don't import this one!!!
// import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class UnitTests {

    /**
     * NOTICE:
     * Might not see this pattern in our course, but can be used IRL as away to organize different
     * method tests for a class.
     *
     * Really just using this patterns as a good way to demo the concepts of how to test + debug
     */
    @Tag("addInts")
    public static class AddIntTests {

        private static UnitTestableStuff myUnitTestableClass;

        @BeforeEach
        void setUp() {
            myUnitTestableClass = new UnitTestableStuff();
        }
        @Test
        public void addTwoPositiveInts_expectPositiveValue() {
            int num1 = 1;
            int num2 = 2;

            int expectedResult = 3;

            Assertions.assertEquals(expectedResult, myUnitTestableClass.addTwoInts(num1, num2));
        }

        @Test
        public void addTwoNegativeInts_expectNegativeValue() {
            int num1 = -1;
            int num2 = -2;

            int expectedResult = -3;

            Assertions.assertEquals(expectedResult, myUnitTestableClass.addTwoInts(num1, num2));
        }

        @Test
        public void addPositiveIntToSmallerNegativeInt_expectPositiveValue() {
            int num1 = 10;
            int num2 = -2;

            int expectedResult = 8;

            Assertions.assertEquals(expectedResult, myUnitTestableClass.addTwoInts(num1, num2));
        }

        @Test
        public void addPositiveIntToLargerNegativeInt_expectNegativeValue() {
            int num1 = -10;
            int num2 = 2;

            int expectedResult = -8;

            Assertions.assertEquals(expectedResult, myUnitTestableClass.addTwoInts(num1, num2));
        }

        @Test
        public void addMaxValues_expectSomething() {
            int num1 = Integer.MAX_VALUE;
            int num2 = Integer.MAX_VALUE;

            int expectedResult = Integer.MAX_VALUE; // TODO: Wonder what this should be actually be?

            Assertions.assertEquals(expectedResult, myUnitTestableClass.addTwoInts(num1, num2));
        }

        @Test
        public void addMaxAndMinValues_expectSomething() {
            int num1 = Integer.MAX_VALUE;
            int num2 = Integer.MIN_VALUE;

            int expectedResult = 0; // TODO: Wonder what this should be actually be?

            Assertions.assertEquals(expectedResult, myUnitTestableClass.addTwoInts(num1, num2));
        }
    }

    @Tag("encrypt")
    public static class EncryptTest {
        private static UnitTestableStuff myUnitTestableClass;

        private static final String RANDOM_STRING_PREFIX = "aaaAAA";
        private static final String RANDOM_STRING_SUFFIX = "zzzZZZ";
        private static final String KEY_BOUND_RETURN_STRING = "KEY CAN'T BE LESS THAN 0 OR GREATER THAN 100";

        @BeforeEach
        void setUp() {
            myUnitTestableClass = new UnitTestableStuff();
        }

        @Test
        public void encryptSimpleStringOfA_WithKeyOfTwo_expectC() {
            String stringInput = "A";
            int key = 2;

            String expectedString = "C";

            Assertions.assertEquals(expectedString, myUnitTestableClass.encryptString(stringInput, key));
        }

        @Test
        public void encryptEmptyString_withPositiveSmallKey_expectRandomString() {
            String stringInput = "";
            int key = 2;

            String output = myUnitTestableClass.encryptString(stringInput, key);

            Assertions.assertTrue(output.startsWith(RANDOM_STRING_PREFIX));
            Assertions.assertTrue(output.endsWith(RANDOM_STRING_SUFFIX));
        }

        @Test
        public void encryptEmptyString_withNegativeKey_expectRandomString() {
            String stringInput = "";
            int key = -2;

            String output = myUnitTestableClass.encryptString(stringInput, key);

            Assertions.assertTrue(output.startsWith(RANDOM_STRING_PREFIX));
            Assertions.assertTrue(output.endsWith(RANDOM_STRING_SUFFIX));
        }

        @Test
        public void encryptEmptyString_withLargeKey_expectRandomString() {
            String stringInput = "";
            int key = 1000000;

            String output = myUnitTestableClass.encryptString(stringInput, key);

            Assertions.assertTrue(output.startsWith(RANDOM_STRING_PREFIX));
            Assertions.assertTrue(output.endsWith(RANDOM_STRING_SUFFIX));
        }

        @Test
        public void encryptEmptyStringWithSpaces_withPositiveSmallKey_expectRandomString() {
            String stringInput = "           ";
            int key = 2;

            String output = myUnitTestableClass.encryptString(stringInput, key);

            Assertions.assertTrue(output.startsWith(RANDOM_STRING_PREFIX));
            Assertions.assertTrue(output.endsWith(RANDOM_STRING_SUFFIX));
        }

        @Test
        public void encryptEmptyStringWithSpaces_withNegativeKey_expectRandomString() {
            String stringInput = "               ";
            int key = -2;

            String output = myUnitTestableClass.encryptString(stringInput, key);

            Assertions.assertTrue(output.startsWith(RANDOM_STRING_PREFIX));
            Assertions.assertTrue(output.endsWith(RANDOM_STRING_SUFFIX));
        }

        @Test
        public void encryptEmptyStringWithSpaces_withLargeKey_expectRandomString() {
            String stringInput = "            ";
            int key = 1000000;

            String output = myUnitTestableClass.encryptString(stringInput, key);

            Assertions.assertTrue(output.startsWith(RANDOM_STRING_PREFIX));
            Assertions.assertTrue(output.endsWith(RANDOM_STRING_SUFFIX));
        }

        @Test
        public void encryptSimpleString_withLargeKey_expectKeyBoundString() {
            String stringInput = "A";
            int key = 101;

            Assertions.assertEquals(KEY_BOUND_RETURN_STRING, myUnitTestableClass.encryptString(stringInput, key));
        }

        @Test
        public void encryptLongerString_withLargeKey_expectKeyBoundString() {
            String stringInput = "A quick brown fox jumped over the lazy dog";
            int key = 101;

            Assertions.assertEquals(KEY_BOUND_RETURN_STRING, myUnitTestableClass.encryptString(stringInput, key));
        }

        @Test
        public void encryptSimpleString_withNegativeKey_expectKeyBoundString() {
            String stringInput = "A";
            int key = -1;

            Assertions.assertEquals(KEY_BOUND_RETURN_STRING, myUnitTestableClass.encryptString(stringInput, key));
        }

        @Test
        public void encryptLongerString_withNegativeKey_expectKeyBoundString() {
            String stringInput = "A quick brown fox jumped over the lazy dog";
            int key = -1;

            Assertions.assertEquals(KEY_BOUND_RETURN_STRING, myUnitTestableClass.encryptString(stringInput, key));
        }

        @Test
        public void encryptLongerString_withPositiveKey_expectSomething() {
            // TODO: Implement this test. Use the debugger as your friend
        }

        @Test
        public void encryptLongerString_withKeyAs0_expectSomething() {
            // TODO: Implement this test. Use the debugger as your friend
        }
    }

    @Tag("findAverageFromStrings")
    public static class SomeOtherTests {
        private static UnitTestableStuff myUnitTestableClass;

        @BeforeEach
        void setUp() {
            myUnitTestableClass = new UnitTestableStuff();
        }

        // TODO: Implement at least 5 test cases. Use the debugger and step through the code!!
        // Sample cases could be: Happy path (only ints in input), Strings that aren't ints, Strings of doubles,
        // empty strings, empty list, null input, negative values, etc.

        // Note: Sometimes we expect code to throw exceptions. In cases like that, use the Assertions.assertThrows
        // method. Example:
        // Assertions.assertThrows(<some exception class name>.class, () -> myUnitTestableClass.findAverageFromStrings(<some input>))
    }
}
