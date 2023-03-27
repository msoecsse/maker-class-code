package wk4;

import java.lang.reflect.Array;

public class ArrayStack<E> {
    private E[] data;

    private int numItems;

    public ArrayStack() {
        data = null;
        numItems = 0;
    }

    public ArrayStack(E[] initialData) {
        data = initialData;
        numItems = initialData.length;
    }

    public E pop() {
        E result = data[numItems - 1];
        data[numItems - 1] = null;
        numItems -= 1;

        return result;
    }

    public void push(E element) {
        if(data.length == numItems) {
            resize();
        }

        data[numItems] = element;
        numItems += 1;
    }

    private void resize() {
        E[] newArray = (E[]) Array.newInstance(Object.class, numItems + (numItems / 2));

        for(int i = 0; i < data.length; i++) {
            newArray[i] = data[i];
        }

        data = newArray;
    }

    public E peek() {
        return data[numItems - 1];
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int size() {
        return numItems;
    }
}
