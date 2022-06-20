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


    public void reverse() {
        if(isEmpty() || first.next == null) {
            return;
        }

        // reversing link direction
        Node previousNode = first;
        Node currentNode = first.next;
        while(currentNode != null) {
            var nextNode = currentNode.next;
            currentNode.next = previousNode;

            previousNode = currentNode;
            currentNode = nextNode;
        }

        // setting last and first
        last = first;
        last.next = null;
        first = previousNode;
    }

    public int getKthFromTheEnd(final int kthElement) {
        if(isEmpty()) {
            throw new IllegalArgumentException("linked list is empty");
        }
        if(kthElement >= getSize() || kthElement < 0) {
            throw new IllegalArgumentException("k-value needs to be one less then the size of the linked list");
        }

        Node pointerOne = first;
        Node pointerTwo = first;

        // create the right distance first
        for(int i = 0; i <= kthElement-1; i++) {
            pointerOne = pointerOne.next;
        }

        // then move both forward
        while(pointerOne != last) {
            pointerOne = pointerOne.next;
            pointerTwo = pointerTwo.next;
        }
        return pointerTwo.value;
    }


    @Override
    public String toString() {
        if(isEmpty()) {
            return "empty linked list, nothing to show...";
        }
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
