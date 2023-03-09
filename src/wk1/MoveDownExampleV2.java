import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveDownExampleV2 {
    static void moveDown(List<Integer> list, int index) {
        if (index >= list.size() - 1 || index < 0) {
            System.out.println("Can't do that");
        } else {
            int element = list.remove(index);
            list.add(index + 1, element);
        }
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(8, 4, 13, -7));

        // Print out array before moveDown call(s)
        System.out.println("Before move:");
        arr.forEach(element -> System.out.println(element));
        System.out.println("*****************");

        // Testing the moveDown method manually
        moveDown(arr, -1);

        // Print out array after moveDown call(s)
        System.out.println("After move:");
        arr.forEach(element -> System.out.println(element));
    }
}
