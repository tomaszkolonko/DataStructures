package simple;

import java.util.Arrays;
import java.util.Objects;

public class Array {

    private int[] items;
    private int pointer;

    public Array(int initialSize) {
        if(initialSize <= 0) {
            throw new IllegalArgumentException("initialSize cannot be 0 or smaller");
        }
        items = new int[initialSize];
        pointer = 0;
    }

    public int retrieveAt(int index) {
        checkBounds(index);
        return items[index];
    }

    public void insert(int item) {
        if(pointer == items.length-1) {
            expandArray();
        }

        items[pointer] = item;
        pointer = pointer + 1;
    }

    public void removeAt(int index) {
        checkBounds(index);

        items[index] = 0;
        for(int i = index; i < pointer; i++) {
            items[index] = items[index + 1];
        }
        pointer = pointer - 1;

        if(pointer <= (items.length/2)) {
            shrinkArray();
        }
    }

    public int pointerToNextElement() {
        return pointer;
    }

    public int size() {
        return items.length;
    }

    public int indexOf(int item) {
        for(int i = 0; i < pointer; i++) {
            if(items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public int max() {
        int champion = items[0];
        for(int challenger : items) {
            if(challenger > champion) {
                champion = challenger;
            }
        }
        return champion;
    }

    public int min() {
        int champion = items[0];
        for(int challenger : items) {
            if(challenger < champion) {
                champion = challenger;
            }
        }
        return champion;
    }

    public Array intersect(final Array otherArray) {
        Array resultOfIntersect = new Array(1);

        for(int thisIndex = 0; thisIndex < this.pointer; thisIndex++) {
            for(int otherIndex = 0; otherIndex < otherArray.pointer; otherIndex++) {
                if(otherArray.items[otherIndex] == this.items[thisIndex]) {
                    resultOfIntersect.insert(this.items[thisIndex]);
                }
            }
        }

        return resultOfIntersect;
    }

    public Array reversed() {
        Array reversedArray = new Array(this.pointer);

        for(int index = pointer-1; index >= 0; index--) {
            reversedArray.insert(items[index]);
        }
        return reversedArray;
    }

    public void insertAt(final int index, final int item) {
        if(index > pointer || index < 0) {
            throw new IllegalArgumentException("this index does not exist");
        }

        items[index] = item;
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof Array && this.equals((Array) other);
    }

    private boolean equals(final Array other) {
        return items.length == other.items.length && Arrays.equals(items, other.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(pointer);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    @Override
    public String toString() {
        return "Array{" +
            "items=" + Arrays.toString(items) +
            ", pointer=" + pointer +
            '}';
    }

    private void checkBounds(final int index) {
        if(index < 0 || index > pointer) {
            throw new IllegalArgumentException("no item at this index");
        }
    }

    private void expandArray() {
        int[] newArray = new int[items.length * 2];
        for(int i = 0; i <= pointer; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }

    private void shrinkArray() {
        int[] newArray = new int[items.length / 2];
        for(int i = 0; i <= pointer; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }
}
