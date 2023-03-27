package wk3;

import java.util.ArrayList;
import java.util.List;

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

        while (i < list.length) {
            System.out.print(i);
            i--;
        }
    }

    public static void bigOPractice3(int[] list1, String[] list2) {
        // n = length of list1
        // m = length of list2

        for (int i = 0; i < list1.length - 1; i++) {
            for (int j = 0; j < list2.length - 1; j++) {
                System.out.print(i + j);
            }
        }

        for (int j = 0; j < list2.length - 1; j++) {
            // Some constant time operation here
        }
    }

    public static double someMethodName(List<String> words) {
        List<Integer> wordLengths = new ArrayList<>();
        for (int i = 0; i < words.size() - 1; i++) {
            if (i % 2 == 0) {
                wordLengths.add(words.get(i).length());
            }
        }

        double totalLength = 0.0;
        for (Integer length : wordLengths) {
            totalLength += length;
        }

        return totalLength / wordLengths.size();
    }

    public static <E extends Number> E findMax(List<E> numbers) {
        E currentMax = null;

        for (E number : numbers) {
            if (currentMax == null || number.intValue() > currentMax.intValue()) {
                currentMax = number;
            }
        }

        return currentMax;
    }

    public <E extends Number> E countOdd(List<E> numbers) {
        return null;
    }
}