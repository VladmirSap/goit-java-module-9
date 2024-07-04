package Task1;

import java.util.Arrays;

public class MyArrayList<T> {
    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.data = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Add an element to the end of the list
    public void add(T value) {
        ensureCapacity(size + 1);
        data[size++] = value;
    }

    // Remove the element at the specified index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // Shift elements to the left to fill the gap
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null; // Clear the last element
        size--;
    }

    // Clear the list
    public void clear() {
        Arrays.fill(data, null);
        size = 0;
    }

    // Return the size of the list
    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) data[index];
    }

    // Ensure the capacity of the internal array
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }
}
