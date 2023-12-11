import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + initialCapacity);
        }
        elements = new Object[initialCapacity];
        size = 0;
    }

    public MyArrayList(Collection<? extends E> collection) {
        elements = new Object[collection.size()];
        size = collection.size();
        int index = 0;
        for (E item : collection) {
            elements[index++] = item;
        }
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }

        Object[] temp = elements;
        elements = new Object[temp.length];
        System.arraycopy(temp, 0, elements, 0, index);
        int elementsAmountAfterIndex = temp.length - index - 1;
        System.arraycopy(temp, index + 1, elements, index, elementsAmountAfterIndex);
        elements[index] = element;
        size++;
    }

    public boolean add(E element) {
        add(size, element);
        return true;
    }

    public E get(int index) {
        return null;
    }

    public E remove(int index) {
        return null;
    }

    public boolean remove(E element) {
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return true;
    }

    public boolean addAll(int index, Collection<? extends E> collection) {
        return true;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
// add, get, remove, addAll