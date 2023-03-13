package wk2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LinkedListTests {
    @Test
    public void givenNewLinkedList_returnZeroForSize() {
        LinkedList<String> linkedList = new LinkedList<>();

        assertEquals(0, linkedList.size());
    }

    @Test
    public void givenNewLinkedList_returnIndexOutOfBoundsExceptionOnGet() {
        LinkedList<String> linkedList = new LinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));
    }

    @Test
    public void givenNewLinkedList_returnIndexOutOfBoundsExceptionOnSet() {
        LinkedList<String> linkedList = new LinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(1, "test"));
    }

    @Test
    public void givenNewLinkedList_returnOKOnAdd() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("New String");

        String getReturnValue = linkedList.get(0);

        assertEquals(1, linkedList.size());
        assertEquals("New String", getReturnValue);
    }

    @Test
    public void givenNewLinkedList_returnOKOnSet() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("New String");

        String getReturnValue = linkedList.get(0);

        assertEquals(1, linkedList.size());
        assertEquals("New String", getReturnValue);

        linkedList.set(0, "Replaced!!!");
        String getNewStringValue = linkedList.get(0);

        assertEquals(1, linkedList.size());
        assertEquals("Replaced!!!", getNewStringValue);

    }

}
