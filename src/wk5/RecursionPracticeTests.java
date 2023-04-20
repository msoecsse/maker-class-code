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

    @Test
    public void validatesGCD() {
        Assertions.assertEquals(6, GCD(366, 60));
        Assertions.assertEquals(6, GCD(60, 366));
        Assertions.assertEquals(12, GCD(24, 12));
        Assertions.assertEquals(12, GCD(24, 60));
        Assertions.assertEquals(1, GCD(25, 16));
        Assertions.assertEquals(12, GCD(12, 12));
        Assertions.assertEquals(2, GCD(414, 662));
    }

    @Test
    public void validatesGCDAdvanced() {
        Assertions.assertEquals(6, GCDAdvanced(366, 60));
        Assertions.assertEquals(6, GCDAdvanced(60, 366));
        Assertions.assertEquals(12, GCDAdvanced(24, 12));
        Assertions.assertEquals(12, GCDAdvanced(24, 60));
        Assertions.assertEquals(1, GCDAdvanced(25, 16));
        Assertions.assertEquals(12, GCDAdvanced(12, 12));
        Assertions.assertEquals(2, GCDAdvanced(414, 662));
    }
}
