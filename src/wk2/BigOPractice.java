package wk2;

public class BigOPractice {
    // TODO: Find T(N) and O(N)
    public static void exampleFunction1(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            list[i] = list[i] * 10;
        }
    }

    // TODO: Find T(N) and O(N)
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

    // TODO: Find T(N) and O(N)
    public static boolean exampleFunction3(int[] list) {
        return list.length > 5;
    }

    // TODO: Find T(N) and O(N)
    public static void exampleFunction4(int[] list) {
        for (int i = 0; i < list.length * 10; i++) {
            System.out.println(i);
        }
    }

    // TODO: Find T(N) and O(N)
    public static void exampleFunction5(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = list.length - 1; j >= 0; j--) {
                System.out.println(list[i] + list[j]);
            }
        }
    }

    // TODO: Find T(N) and O(N)
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
