package wk4;

public class LinkedStack<E> {

    private Node top;

    private int numItems;

    private class Node {
        private E value;
        private Node next;
        private Node prev;

        public Node(E val, Node nxt, Node prv) {
            value = val;
            next = nxt;
            prev = prv;
        }
    }

    public LinkedStack() {
        top = null;
        numItems = 0;
    }

    public E pop() {
        E result = top.value;
        top = top.prev;
        top.next = null;
        numItems -= 1;

        return result;
    }

    public void push(E element) {
        Node newTop = new Node(element, null, top);
        top.next = newTop;
        top = newTop;

        numItems += 1;
    }

    public E peek() {
        return top.value;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int size() {
        return numItems;
    }
}
