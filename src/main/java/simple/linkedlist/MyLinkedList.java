package simple.linkedlist;

import simple.array.MyArray;

public class MyLinkedList {

    private static class Node {
        private final int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    public void addLast(int value) {
        Node node = new Node(value);

        if(isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int value) {
        Node node = new Node(value);

        if(isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void deleteFirst() {
        if(first == null) {
            throw new IllegalArgumentException("Cannot delete from empty list");
        }
        Node secondNode = first.next;
        first.next = null;
        first = secondNode;
        size--;
    }

    public void deleteLast() {
        if(first == null) {
            throw new IllegalArgumentException("Cannot delete from empty list");
        }
        Node currentNode = first;
        Node previousNode = null;

        while(currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        last = previousNode;
        last.next = null;
        size--;
    }

    public boolean contains(final int value) {
        return indexOf(value) != Integer.MIN_VALUE;
    }

    public int indexOf(final int value) {
        int index = 0;
        Node currentNode = first;

        while(currentNode != null) {
            if(currentNode.value == value) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }

        return Integer.MIN_VALUE;
    }

    public int getSize() {
        return size;
    }

    public MyArray convertToMyArray() {
        MyArray myArray = new MyArray(size);
        Node currentNode = first;

        while(currentNode != null) {
            myArray.insert(currentNode.value);
            currentNode = currentNode.next;
        }

        return myArray;
    }

    public int[] convertToArray() {
        int[] array = new int[size];
        int index = 0;
        Node currentNode = first;

        while(currentNode != null) {
            array[index] = currentNode.value;
            currentNode = currentNode.next;
            index++;
        }

        return array;
    }


    @Override
    public String toString() {
        String result = "[";
        Node currentNode = first;
        while(currentNode.next != null) {
            result += currentNode.value + ", ";
            currentNode = currentNode.next;
        }
        result += currentNode.value + "]";
        return result;
    }

    private boolean isEmpty() {
        return first == null;
    }
}
