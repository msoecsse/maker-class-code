package wk2;

import java.util.Random;

public class BigOAnswers {
    // T(N) = n
    // f(n) = O(n)
    // We rely on n elements in the list to perform our operations and within the loop we do a constant time
    // operation of simply setting a new value to the index of the array so n iterations at O(1) complexity
    // translates to O(n)
    public static void exampleFunction1(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            list[i] = list[i] * 10;
        }
    }

    // T(N) = 2 + n + m
    // f(n) = O(n + m)
    // T(n) has two constant time operations happening by initializing ints and then two sequential for loops that
    // each take n time, as they are only iterating through n elments in list1 and m elements in list2. O(N) is just
    // removes the 2 as we can't make assertions about n or m really
    public static void exampleFunction2(int[] list1, int[] list2) {
        int someRandomVar = 0;
        int anotherRandomVar = 0;

        for (int i = 0; i < list1.length - 1; i++) {
            list1[i] = list1[i] * 10;
        }

        for (int i = 0; i < list2.length - 1; i++) {
            list1[i] = 0;
        }
    }

    // T(N) = 3 + n
    // f(n) = O(n)
    // The first three lines execute in constant time regardless of n elments in our list. However, we do
    // iterate through the list doing constant time operations so we have at worst n iterations
    public static boolean exampleFunction3(int[] list) {
        Random random = new Random();
        final int MAGIC_NUMBER = random.nextInt(list.length);
        int count = 0;

        for (int i = 0; i < list.length - 1; i++) {
            count++;

            if (count > MAGIC_NUMBER) {
                return true;
            }
        }

        return false;
    }

    // T(N) = 1 + 1 + 1 = 3
    // f(n) = O(1)
    // Initializing the random object and finding the random number each execute in constant time, then doing
    // the single boolean comparison between two ints and returning all executes in constant time as well.
    // Because we don't rely on the length of the list here this has a constant runtime.
    public static boolean moreEfficientExampleFunction3(int[] list) {
        Random random = new Random();
        final int MAGIC_NUMBER = random.nextInt(list.length);
        return list.length > MAGIC_NUMBER;
    }

    // T(N) = 10n + 1
    // f(n) = O(n)
    // Because we are going from 0 to 10 * n, this leaves us with 10n + 1 total iterations. Each iteration of
    // this prints to the console which takes constant time. Because of we end up with our time complexities and
    // are able to simplify from 10n to just n as all linear time complexities we can treat the same when referring
    // to O(N)
    public static void exampleFunction4(int[] list) {
        for (int i = 0; i < list.length * 10; i++) {
            System.out.println(i);
        }
    }

    // T(N) = n^2
    // f(n) = O(n^2)
    // We loop through n elements in the outer loop, and for each iteration are again looping through n elements.
    // Within the second loop we are performing a print which takes constant time, so essentially this is (n * (n * (1)))
    // executions. Simplifying that we get to n^2
    public static void exampleFunction5(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = list.length - 1; j >= 0; j--) {
                System.out.println(list[i] + list[j]);
            }
        }
    }

    // T(N) = n(n + 1) = n^2 + n
    // f(n) = O(n^2)
    // Just because our for loop seems to be a single loop, we have to keep in mind the complexity of our helper
    // functions being called within a loop as well. Below we can see that the helper function has time complexity
    // T(N) = n + 1 due to the n iterations done for the for loop and then the one random int initialization.
    // So when we are examining this as a whole, we can take our outer n iterations and multiply them by the inner
    // time complexity -> n * (n + 1), which leaves us with n^2 + n. When simplifying for O(N) this just goes to O(n^2)
    public static void exampleFunction6(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            helperFunctionToDivideByTwoThenConvertToInt(list);
        }
    }

    // T(N) = n + 1
    // O(n)
    private static void helperFunctionToDivideByTwoThenConvertToInt(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            double divResult = ((double) list[i]) / 2;
            list[i] = (int) divResult;
        }

        int justSomethingToAddToTValue = 0;
    }
}
