import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
        checkIndex(index);
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (elements.length + 1) * 2);
        }

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public void add(E element) {
        add(size, element);
    }

    public void set(int index, E element) {
        checkIndex(index);

        elements[index] = element;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        validateIndexBounds(index);

        return (E) elements[index];
    }

    public void remove(int index) {
        validateIndexBounds(index);

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

    @SuppressWarnings("unchecked")
    public void bubbleSortForMyArrayList() {
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < size - 1; i++) {
                if (((Comparable<E>) get(i)).compareTo(get(i + 1)) > 0) {
                    swap(i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private void swap(int i, int j) {
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

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }

    private void validateIndexBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder builder = new StringBuilder("[");
            for (int i = 0; i < size - 1; i++) {
                builder.append(elements[i]).append(", ");
            }
            builder.append(elements[size - 1]).append("]");
            return builder.toString();
        }
    }
}