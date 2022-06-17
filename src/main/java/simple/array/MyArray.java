package simple.array;

import java.util.Arrays;
import java.util.Objects;

public class MyArray {

    private int[] items;
    private int nextSpot;

    public MyArray(int initialSize) {
        if(initialSize <= 0) {
            throw new IllegalArgumentException("initialSize cannot be 0 or smaller");
        }
        items = new int[initialSize];
        nextSpot = 0;
    }

    public int retrieveAt(int index) { // O(1)
        checkBounds(index);
        return items[index];
    }

    public void insert(int item) { // O(n)
        if(nextSpot == items.length-1) {
            expandArray();
        }

        items[nextSpot] = item;
        nextSpot = nextSpot + 1;
    }

    public void removeAt(int index) { // O(n)
        checkBounds(index);

        items[index] = 0;
        for(int i = index; i < nextSpot; i++) {
            items[index] = items[index + 1];
        }
        nextSpot = nextSpot - 1;

        if(nextSpot <= (items.length/2)) {
            shrinkArray();
        }
    }

    public int pointerToNextSpot() {
        return nextSpot;
    }

    public int size() {
        return items.length;
    }

    public int indexOf(int item) { // O(n)
        for(int i = 0; i < nextSpot; i++) {
            if(items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public int max() { // O(n)
        int champion = items[0];
        for(int challenger : items) {
            if(challenger > champion) {
                champion = challenger;
            }
        }
        return champion;
    }

    public int min() { // O(n)
        int champion = items[0];
        for(int challenger : items) {
            if(challenger < champion) {
                champion = challenger;
            }
        }
        return champion;
    }

    public MyArray intersect(final MyArray otherMyArray) { // O(n^2)
        MyArray resultOfIntersect = new MyArray(1);

        for(int thisIndex = 0; thisIndex < this.nextSpot; thisIndex++) {
            for(int otherIndex = 0; otherIndex < otherMyArray.nextSpot; otherIndex++) {
                if(otherMyArray.items[otherIndex] == this.items[thisIndex]) {
                    resultOfIntersect.insert(this.items[thisIndex]);
                }
            }
        }

        return resultOfIntersect;
    }

    public MyArray reversed() { // O(n)
        MyArray reversedMyArray = new MyArray(this.nextSpot);

        for(int index = nextSpot -1; index >= 0; index--) {
            reversedMyArray.insert(items[index]);
        }
        return reversedMyArray;
    }

    public void insertAt(final int index, final int item) { // O(1)
        if(index > nextSpot || index < 0) {
            throw new IllegalArgumentException("this index does not exist");
        }

        items[index] = item;
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof MyArray && this.equals((MyArray) other);
    }

    private boolean equals(final MyArray other) {
        return items.length == other.items.length && Arrays.equals(items, other.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nextSpot);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    @Override
    public String toString() {
        return "Array{" +
            "items=" + Arrays.toString(items) +
            ", pointer=" + nextSpot +
            '}';
    }

    private void checkBounds(final int index) {
        if(index < 0 || index > nextSpot) {
            throw new IllegalArgumentException("no item at this index");
        }
    }

    private void expandArray() { // O(n)
        int[] newArray = new int[items.length * 2];
        for(int i = 0; i <= nextSpot; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }

    private void shrinkArray() { // O(n)
        int[] newArray = new int[items.length / 2];
        for(int i = 0; i <= nextSpot; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }
}
