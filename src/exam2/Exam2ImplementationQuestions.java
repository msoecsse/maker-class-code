package exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Exam2ImplementationQuestions {
    public static boolean isPalindromeSampleTwoStacks(String phrase) {
        Stack<Character> normalStack = new Stack<>();
        Stack<Character> reverseStack = new Stack<>();

        phrase = phrase.toLowerCase();

        for (char c : phrase.toCharArray()) {
            if(Character.isLetter(c)) {
                normalStack.push(c);
            }
        }

        for (int i = phrase.length() - 1; i >= 0; i--) {
            char c = phrase.charAt(i);
            if(Character.isLetter(c)) {
                reverseStack.push(c);
            }
        }

        while (normalStack.size() > 0) {
            if (!normalStack.pop().equals(reverseStack.pop())) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindromeSampleStackAndQueue(String phrase) {
        Stack<Character> stack = new Stack<>();
        List<Character> queue = new ArrayList<>();

        phrase = phrase.toLowerCase();

        for (char c : phrase.toCharArray()) {
            if(Character.isLetter(c)) {
                stack.push(c);
                queue.add(c);
            }
        }

        while (stack.size() > 0) {
            if (!stack.pop().equals(queue.remove(0))) {
                return false;
            }
        }

        return true;
    }

    public static int GCDSample(int n1, int n2) {
        if (n1 % n2 == 0) {
            return n2;
        } else if (n2 % n1 == 0) {
            return n1;
        }

        if (n1 > n2) {
            return GCDSample(n1 - n2, n2);
        } else {
            return GCDSample(n1, n2 - n1);
        }
    }

    public static int GCDAdvanced(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }

        return GCDAdvanced(n2, n1 % n2);
    }
}
