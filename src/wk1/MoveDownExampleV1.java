import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveDownExampleV1 {
    static void moveDown(List<Integer> list, int index) {
        int element = list.remove(index);
        list.add(element);
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(8, 4, 13, -7));

        // Print out array before moveDown call(s)
        System.out.println("Before move:");
        arr.forEach(element -> {System.out.println(element);});
        System.out.println("*****************");

        // Testing the moveDown method manually
        moveDown(arr, 2);

        // Print out array after moveDown call(s)
        System.out.println("After move:");
        arr.forEach(element -> {System.out.println(element);});
    }
}