import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static Object[] elements;
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
        elements[index] = element;
        int elementsAmountAfterIndex = temp.length - index - 1;
        System.arraycopy(temp, index, elements, index + 1, elementsAmountAfterIndex);
        size++;
    }

    public void add(E element) {
        add(size, element);
    }

    public void set(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }

        elements[index] = element;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        return (E) elements[index];
    }

    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    public void remove(E element) {
        int index = Integer.MIN_VALUE;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == element) {
                index = i;
            }
        }
        if (index >= 0) {
            remove(index);
        }
    }

    public void addAll(Collection<? extends E> collection) {
        addAll(size, collection);
    }

    public void addAll(int index, Collection<? extends E> collection) {
        for (E item : collection) {
            add(index++, item);
        }
    }

    public static <T extends Comparable<? super T>> void bubbleSortForMyArrayList(MyArrayList<T> list) {
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    swap(i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private static void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    public static <E extends Comparable<? super E>> void bubbleSortForAnotherListTypes(List<E> list) {
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    Collections.swap(list, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}