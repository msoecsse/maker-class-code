package wk5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static wk5.RecursionPractice.*;

public class RecursionPracticeTests {
    @Test
    public void validatesXToY() {
        Assertions.assertEquals(8, RecursionPractice.xToY(3));
        Assertions.assertEquals(16, RecursionPractice.xToY(4));
        Assertions.assertEquals(32, RecursionPractice.xToY(5));
    }

    @Test
    public void validatesGroupList() {
        Assertions.assertTrue(groupSum(List.of(2, 2), 0));
        Assertions.assertTrue(groupSum(List.of(2, 2), 2));
        Assertions.assertTrue(groupSum(List.of(2, 2), 4));
        Assertions.assertFalse(groupSum(List.of(2, 2), 5));
        Assertions.assertTrue(groupSum(List.of(0, 3, 2), 5));
    }
}
