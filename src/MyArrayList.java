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

    }

    public boolean add(E element) {
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
}
// add, get, remove, addAll