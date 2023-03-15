package wk2;

import java.util.*;

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

    /**
     * ***************************************************************
     *
     * BASICS COVERED ON MONDAY WITHOUT NEED FOR ITERATORS.
     *
     * Any ideas as to why these are implemented without iterators while
     * other methods below aren't? Can these be implemented with iterators?
     *
     * ***************************************************************
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public E get(int index) {
        E result = null;
        if (index == 0 && head != null) {
            result = head.value;
        } else if (size() > 0) {
            ListIterator<E> itr = listIterator(index - 1);
            result = itr.next();
        }

        if (result == null) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + index);
        }

        return result;

        // Original class code without iterators:
        //        Node node = walkTo(index);
        //        if(node==null) {
        //            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + index);
        //        }
        //
        //        return null;
    }

    @Override
    public E set(int index, E element) {
        if (index > size() - 1) {
            throw new IndexOutOfBoundsException("Index cannot be greater than the size of the linked list");
        }

        E oldValue;

        if (index == 0 && head != null) {
            oldValue = head.value;

            head.value = element;
            return oldValue;
        } else if (size() > 0) {
            oldValue = get(index);

            ListIterator<E> itr = listIterator(index);
            itr.set(element);
            return oldValue;
        }

        return null;

        // Original class code without iterators:
        //        Node node = walkTo(index);
        //        if(node==null) {
        //            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + index);
        //        }
        //        E oldValue = node.value;
        //        node.value = element;
        //        return oldValue;
    }

    // TODO: Try your hand at implementing these methods with iterators
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

    /**
     * ***************************************************************
     *
     * NEW STUFF FOR ITERATORS
     *
     * ***************************************************************
     */
    @Override
    public Iterator<E> iterator() {
        return new LLIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        return new LLIterator();
    }

    @Override
    public boolean contains(Object o) {
        Iterator<E> itr = iterator();
        boolean found = false;
        while(!found && itr.hasNext()) {
            found = o.equals(itr.next());
        }
        return found;
    }

    @Override
    public E remove(int index) {
        ListIterator<E> itr = listIterator(index);
        E value = itr.next();
        itr.remove();
        return value;
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = false;
        ListIterator<E> itr = listIterator();
        while(!removed && itr.hasNext()) {
            if(o.equals(itr.next())) {
                itr.remove();
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if(index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        ListIterator<E> itr = new LLIterator();
        int i = 0;
        try {
            for(; i < index; ++i) {
                itr.next();
            }
        } catch(NoSuchElementException e) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + i);
        }
        return itr;
    }

    // TODO: Let's implement this together
    @Override
    public int indexOf(Object o) {
        int index = 0;
        ListIterator<E> itr = listIterator();
        boolean found = false;
        while(!found && itr.hasNext()) {
            if (o.equals(itr.next())) {
                return index;
            }

            index ++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size();
        ListIterator<E> itr = listIterator(index);
        boolean found = false;
        while(!found && itr.hasPrevious()) {
            found = o.equals(itr.previous());
            --index;
        }
        if(!found) {
            index = -1;
        }
        return index;
    }

    private class LLIterator implements ListIterator<E> {

        private Node currentNode;
        private int index;
        private boolean isModifiable;

        private LLIterator() {
            currentNode = new Node(null, head, null);
            index = -1;
            isModifiable = false;
        }

        @Override
        public boolean hasNext() {
            return currentNode.next != null;
        }

        @Override
        public E next() {
            // TODO: Handle error cases
            if (currentNode == null || !hasNext()) {
                throw new IndexOutOfBoundsException("");
            }
            return currentNode.next.value;
        }

        @Override
        public boolean hasPrevious() {
            return currentNode.prev != null;
        }

        @Override
        public E previous() {
            // TODO: Handle error cases
            if (currentNode == null || !hasNext()) {
                throw new IndexOutOfBoundsException("");
            }
            return currentNode.prev.value;
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            if(!isModifiable) {
                throw new IllegalStateException("Must call next or previous before remove");
            }
            if(currentNode.prev == null) {  // At beginning of list
                LinkedList.this.head = currentNode.next;        // 1
            } else {                     // In middle of list
                currentNode.prev.next = currentNode.next;          // 2
            }
            if(currentNode.next == null) {  // At end of list
                LinkedList.this.tail = currentNode.prev;        // 3
            } else {                     // In middle of list
                currentNode.next.prev = currentNode.prev;          // 4
            }
            isModifiable = false;
        }

        @Override
        public void set(E e) {
            if(!isModifiable) {
                throw new IllegalStateException("Must call next or previous before remove");
            }
            currentNode.value = e;
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException("ListIterator.add() not supported for this example.");
        }
    }

    /**
     * ***************************************************************
     *
     * IGNORED METHODS FOR NOW. TRY IMPLEMNTING THEM FOR YOURSELF AS
     * A CHALLENGE!
     *
     * ***************************************************************
     */
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

    // Leaving this be as is for now
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
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
}
