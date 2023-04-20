package wk5;

import java.util.List;

public class RecursionPractice {
    private static final int X = 2;

    public static int xToY(int y) {
        if (y == 0) {
            return 1;
        }

        return X * xToY(y - 1);
    }

    public static boolean groupSum(List<Integer> list, int target) {
        return list.isEmpty() ?
                target == 0
                :
                // Group sum when first element is ignored
                groupSum(list.subList(1, list.size()), target) ||
                        // Group sum when first element is used
                        groupSum(list.subList(1, list.size()), target - list.get(0));
    }

    public static int GCD(int n1, int n2) {
        if (n1 % n2 == 0) {
            return n2;
        } else if (n2 % n1 == 0) {
            return n1;
        }

        if (n1 > n2) {
            return GCD(n1 - n2, n2);
        } else {
            return GCD(n1, n2 - n1);
        }
    }

    public static int GCDAdvanced(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }

        return GCDAdvanced(n2, n1 % n2);
    }
}
