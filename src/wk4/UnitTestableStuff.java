package wk4;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class UnitTestableStuff {

    public UnitTestableStuff() {}
    public int addTwoInts(int num1, int num2) {
        return num1 + num2;
    }

    /**
     * Simple method to practice debugging with a rational cipher encryption algorithm with a twist.
     * The idea will be to follow the normal rules of a rational cipher, where a string and a key will be
     * provided. The key will tell us how many letters to shift for each element in the string. For example,
     * if our string was simply "a" and the key was 2, the result would be "c". The same rule should apply for
     * each element in the string.
     *
     * However, to add a little extra pizzazz we will enact a few rules:
     * 1. If a string is empty (either "" or a blank string only containing empty spaces), then regardless of what the
     * key is, we will return a random string of 10 characters prefixed with "aaaAAA" and suffixed with "zzzZZZ"
     * 2. If the key is negative OR it's greater than 100 we will just return a string saying "KEY CAN'T BE LESS THAN 0 OR GREATER THAN 100"
     * @param stringToHide - Initial string we want to encrypt
     * @param key - int to determine logic that is invoked on each letter in the string
     * @return - Encrypted version of our string based on
     */
    public String encryptString(String stringToHide, int key) {
        char[] chars = stringToHide.toCharArray();

        if(stringToHide.trim().length() == 0) {
            final String PREFIX = "aaaAAA";
            final String SUFFIX = "zzzZZZ";
            final int RAND_STRING_LEN = 10;

            byte[] byteArr = new byte[RAND_STRING_LEN];
            new Random().nextBytes(byteArr);

            return PREFIX + new String(byteArr, StandardCharsets.UTF_8) + SUFFIX;
        }

        if(key < 0 || key > 100) {
            return "KEY CAN'T BE LESS THAN 0 OR GREATER THAN 100";
        }

        for(int i = 0; i < chars.length; i ++) {
            int incrementedChar = (int) chars[i] +  key;

            chars[i] = (char) incrementedChar;
        }

        return String.valueOf(chars);
    }

    public double findAverageFromStrings(String[] input) {
        double result = 0;

        for (String s : input) {
            result += Integer.parseInt(s);
        }

        return result / input.length;
    }
}
