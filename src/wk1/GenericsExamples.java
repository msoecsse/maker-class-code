import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class GenericsExamples {
    public List<String> fromArrayToList(String[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    @Test
    public void givenArrayOfStrings_thenListOfStringsReturnedOK() {
        String[] stringArray = {"1", "2", "3", "4", "5"};
        List<String> stringList = fromArrayToList(stringArray);

        assertThat(stringList, hasItems("1", "2", "3", "4", "5"));
    }

    public <T> List<T> genericV1FromArrayToList(T[] a) {
        // Turns the list into a stream, collects it as a list and returns the result
        return Arrays.stream(a).collect(Collectors.toList());
    }

    @Test
    public void givenArrayOfIntegers_thanListOfIntegersReturnedOK() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<Integer> intList = genericV1FromArrayToList(intArray);

        assertThat(intList, hasItems(1, 2, 3, 4, 5));
    }

    public static <T, G> List<G> genericV2FromArrayToList(T[] a, Function<T, G> mapperFunction) {
                // First creates a stream of the array being passed in to be able to iterate over it
        return Arrays.stream(a)
                // Then uses the mapper function to perform an operation on each element in the list and
                // store those results into a new stream
                .map(mapperFunction)
                // Collects the results and stores the stream as a List to conform to the return type
                .collect(Collectors.toList());
    }

    @Test
    public void givenArrayOfIntegers_thanListOfStringReturnedOK() {
        Integer[] intArray = {1, 2, 3, 4, 5};

        // Object::toString is just fancy syntax to make a function that just calls the "toString()"
        // method on the element that's calling that. In this case, this function will be used in the
        // map() call, so that will create a new list where the results will be [1.toString(), 2.toString() ...],
        // and we should get our expected output
        List<String> stringList
                = genericV2FromArrayToList(intArray, Object::toString);

        // Make sure that our int list got mapped to be a list of strings with the same values
        assertThat(stringList, hasItems("1", "2", "3", "4", "5"));
    }

    public static <T extends Number, G extends Number> List<G> genericWithExtendsFromArrayToList(T[] a, Function<T, G> mapperFunction) {
        // First creates a stream of the array being passed in to be able to iterate over it
        return Arrays.stream(a)
                // Then uses the mapper function to perform an operation on each element in the list and
                // store those results into a new stream
                .map(mapperFunction)
                // Collects the results and stores the stream as a List to conform to the return type
                .collect(Collectors.toList());
    }

    @Test
    public void givenArrayOfDoubles_thanListOfIntegersReturnedOK() {
        Double[] doubleArray = {1.1, 2.6, 3.4, 4.000000001, 5.123456789};

        // Double::intValue is just fancy syntax again, see givenArrayOfIntegers_thanListOfStringReturnedOK
        // for a similar explanation
        List<Integer> intList
                = genericWithExtendsFromArrayToList(doubleArray, Double::intValue);

        assertThat(intList, hasItems(1, 3, 3, 4, 5));
    }

    private static double sumWithWildcard(List<? extends Number> list) {
        double sum = 0.0;
        for (Number i : list) {
            sum += i.doubleValue();
        }

        return sum;
    }

    @Test
    public void givenListOfIntegers_thanSumOfDoublesReturnsOK() {
        List<Integer> intArray = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5)
        );

        double sumResult
                = sumWithWildcard(intArray);

        assertEquals(sumResult, 15.0);
    }

    @Test
    public void givenListOfFloats_thanSumOfDoublesReturnsOK() {
        List<Float> floatArray = new ArrayList<>(
                Arrays.asList(
                        (float) 1.23,
                        (float) 2.25,
                        (float) 3.89,
                        (float) 4.99916,
                        (float) 5.4938)
        );

        double sumResult
                = sumWithWildcard(floatArray);

        assertEquals(sumResult, 17.86296010017395);
    }
}
