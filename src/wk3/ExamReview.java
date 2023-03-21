package wk3;

public class ExamReview {

    public static void bigOPractice(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            helperFunctionToDivideByTwoThenConvertToInt(list);
        }
    }
    private static void helperFunctionToDivideByTwoThenConvertToInt(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            double divResult = ((double) list[i]) / 2;
            list[i] = (int) divResult;
        }

        int justSomethingToAddToTValue = 0;
    }

    public static void bigOPractice2(int[] list) {
        int i = 0;

        while ( i < list.length) {
            System.out.print(i);
            i--;
        }
    }

    public static void bigOPractice3(int[] list1, String[] list2) {
        // n = length of list1
        // m = length of list2

        for (int i = 0; i <list1.length - 1; i ++) {
            for (int j = 0; j < list2.length - 1; j++) {
                    System.out.print(i + j);
            }
        }

        for (int j = 0; j < list2.length - 1; j++) {
            // Some constant time operation here
        }
    }
}
