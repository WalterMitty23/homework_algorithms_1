package main;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private static final int initialCapacity = 10;
    private String[] stringArray;
    private int size;

    public StringListImpl() {
        stringArray = new String[initialCapacity];
        size = 0;
    }

    @Override
    public void add(String item) {
        if (size == stringArray.length) {
            expandCapacity();
        }
        if (item == null) {
            throw new IllegalArgumentException();
        }
        stringArray[size] = item;
        size++;
    }

    @Override
    public void add(int index, String item) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == stringArray.length) {
            expandCapacity();
        }
        if (item == null) {
            throw new IllegalArgumentException();
        }
        System.arraycopy(stringArray, index, stringArray, index + 1, size - index);
        stringArray[index] = item;
        size++;
    }

    @Override
    public void set(int index, String item) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Requested index is out of bounds");
        }
        if (item == null) {
            throw new IllegalArgumentException();
        }
        stringArray[index] = item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < size; i++) {
            if (stringArray[i].equals(item)) {
                return remove(i);
            }
        }
        throw new IllegalArgumentException("Requested element is not found");
    }

    @Override
    public String remove(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Requested index is out of bounds");
        }
        String removed = stringArray[index];
        System.arraycopy(stringArray, index + 1, stringArray, index, size - index - 1);
        stringArray[--size] = null;
        return removed;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (stringArray[i].equals(item)) return true;
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (stringArray[i].equals(item)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Requested element is not found");
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (stringArray[i].equals(item)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Requested element is not found");
    }

    @Override
    public String get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Requested index is out of bounds");
        }
        return stringArray[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Other list cannot be null");
        }
        if (this == otherList) {
            return true;
        }
        if (otherList.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!stringArray[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            stringArray[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[size];
        System.arraycopy(stringArray, 0, newArray, 0, size);
        return newArray;
    }

    public void expandCapacity() {
        int newCapacity = stringArray.length * 2;
        stringArray = Arrays.copyOf(stringArray, newCapacity);
    }
}