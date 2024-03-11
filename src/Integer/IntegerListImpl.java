package Integer;

import exceptions.ArrayIsFullException;
import exceptions.ElementNotFoundException;
import exceptions.InvalidIndexException;
import exceptions.NullElementException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    public Integer[] getArray() {
        return array;
    }

    private final Integer[] array;
    private int size;

    public IntegerListImpl() {
        array = new Integer[10];

    }

    public IntegerListImpl(int initSize) {
        array = new Integer[initSize];

    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        validateSize();
        array[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateIndex(index);
        validateItem(item);

        if (index == size) {
            array[size++] = item;
            return item;
        }
        System.arraycopy(array, size, array, size + 1, size - index);
        array[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        array[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        if (index != size) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = array[index];
        if (index != size) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] arrCopy = toArray();
        SortedMethodAnalise.sortSelection(arrCopy);
        return binarySearch(arrCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
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
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(array, size);
    }

    public Integer[] toArray(Integer[] array) {
        return Arrays.copyOf(array, array.length);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullElementException();
        }
    }

    private void validateSize() {
        if (size == array.length) {
            throw new ArrayIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException();
        }
    }

    private void sort(Integer[] arr) {

    }

    private boolean binarySearch(Integer[] arr, int item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}