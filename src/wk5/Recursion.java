package wk5;

public class Recursion {

    // Prints a line containing the given number of stars.
    // Precondition: n >= 0
    public static void printStars(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();   // end the line of output

        // Okay, let's try getting rid of this loop
    }

    public static void printStarsBadExample(int n) {
        if (n == 1) {
            // base case; just print one star
            System.out.println("*");
        } else if (n == 2) {
            System.out.print("*");
            System.out.println("*");
        } else if (n == 3) {
            System.out.print("*");
            System.out.print("*");
            System.out.println("*");
        } else if (n == 4) {
            System.out.print("*");
            System.out.print("*");
            System.out.print("*");
            System.out.println("*");
        } else {
            throw new RuntimeException("This is a bad implementation due to repeated and unscalable code. Let's try recursion");
        }
    }

    public static void printStarsExampleStartingToUseRecursion(int n) {
        if (n == 1) {
            // base case; just print one star
            System.out.println("*");
        } else if (n == 2) {
            System.out.print("*");
            printStarsExampleStartingToUseRecursion(1);
        } else if (n == 3) {
            System.out.print("*");
            printStarsExampleStartingToUseRecursion(2);
        } else if (n == 4) {
            System.out.print("*");
            printStarsExampleStartingToUseRecursion(3);
        } else {
            throw new RuntimeException("Getting better, but still is not scalable and repeats itself a lot with magic numbers.");
        }
    }

    public static void printStarsRecursiveExample1(int n) {
        if (n == 1) {
            // base case; just print one star
            System.out.println("*");
        } else {
            // recursive case; print one more star
            System.out.print("*");
            printStarsRecursiveExample1(n - 1);
        }
    }

    public static void printStarsRecursiveExample2(int n) {
        if (n == 0) {
            // base case; print nothing instead and return void
            System.out.println();
        } else {
            // recursive case; print one more star
            System.out.print("*");
            printStarsRecursiveExample2(n - 1);
        }
    }

    public static int mystery1(int n) {
        if (n < 10) {
            return n;
        } else {
            int a = n / 10;
            int b = n % 10;

            return mystery1(a + b);
        }
    }

    public static int mystery2(int n) {
        if (n < 10) {
            return (10 * n) + n;
        } else {
            int a = mystery2(n / 10);
            int b = mystery2(n % 10);
            return (100 * a) + b;
        }
    }

}
