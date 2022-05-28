package simple;

public class Array {

    private int[] items;
    private int pointer;

    public Array(int initialSize) {
        items = new int[initialSize];
        pointer = 0;
    }

    public int retrieveAt(int index) {
        return items[index];
    }

    public void insert(int item) {
        if(pointer == items.length-1)
            expandArray();
        items[pointer] = item;
        pointer = pointer + 1;

    }

    public void removeAt(int index) {
        items[index] = 0;
        for(int i = index; i < pointer; i++) {
            items[index] = items[index + 1];
        }
        pointer = pointer - 1;
    }

    public int size() {
        return pointer;
    }

    public int indexOf(int item) {
        for(int i = 0; i < pointer; i++) {
            if(items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public void print() {

    }

    private void expandArray() {
        int[] newArray = new int[pointer*2];
        for(int i = 0; i <= pointer; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }
}
