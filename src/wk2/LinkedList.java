package wk2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<E> implements List<E> {
    /**
     * First node in the LinkedList, null if empty
     */
    private Node head;

    /**
     * Final node in the LinkedList, null if empty
     */
    private Node tail;

    /**
     * Nodes are the inner makeup of the LinkedList. We will traverse LinkedLists by navigating
     * nodes by referencing the next and prev nodes connected to each node and using the node
     * values as need be.
     */
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

    public LinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public E get(int index) {
        Node node = walkTo(index);
        if(node==null) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + index);
        }
        return node.value;
    }

    @Override
    public E set(int index, E element) {
        Node node = walkTo(index);
        if(node==null) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + index);
        }
        E oldValue = node.value;
        node.value = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        Node node = walkTo(index);                                 // 1
        if(node==null) {                                           // At end of list
            add(element);
        } else if(node.prev == null) { // At beginning of list
            Node newNode = new Node(element, node, null);        // 2
            node.prev = newNode;                                     // 3
            head = newNode;                                          // 4
        } else {                                                     // Somewhere in middle of list
            Node newNode = new Node(element, node, node.prev);       // 5
            node.prev = newNode;                                     // 6
            newNode.prev.next = newNode;                             // 7
        }
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    // TODO: Talk about this on Wednesday
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    // TODO: Talk about this on Wednesday
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    // Leaving this be as is for now
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        Node walker = head;
        while(walker != null) {
            walker = walker.next;
            ++count;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    // Leaving this be as is for now, feel free to work with this
    @Override
    public boolean contains(Object o) {
        return false;
    }

    // Leaving this be as is for now, feel free to work with this
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    // Leaving this be as is for now, feel free to work with this
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    // Leaving this be as is for now, feel free to work with this
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E element) {
        Node newNode = new Node(element, null, tail);  // 1
        if(head == null) {
            head = newNode;                               // 2
            tail = newNode;                               // 3
        } else {
            tail.next = newNode;                          // 4
            tail = newNode;                               // 5
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    // Leaving this be as is for now, feel free to work with this
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    // Leaving this be as is for now, feel free to work with this
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    // Leaving this be as is for now, feel free to work with this
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    // Leaving this be as is for now, feel free to work with this
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    // Leaving this be as is for now, feel free to work with this
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    private Node walkTo(int index) {
        if(index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node walker = head;
        int i = 0;
        try {
            for(; i < index; ++i) {
                walker = walker.next;
            }
        } catch(NullPointerException e) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + i);
        }
        return walker;
    }
}
