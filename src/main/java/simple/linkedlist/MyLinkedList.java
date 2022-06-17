package simple.linkedlist;

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

    public void addLast(int value) {
        Node node = new Node(value);

        if(isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public void addFirst(int value) {
        Node node = new Node(value);

        if(isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
    }

    public void deleteFirst() {
        Node secondNode = first.next;
        first.next = null;
        first = secondNode;
    }

    public void deleteLast() {
        Node currentNode = first;
        Node previousNode = null;

        while(currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        last = previousNode;
        last.next = null;
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
        int counter = 0;
        if(isEmpty()) {
            return counter;
        }

        Node currentNode = first;
        counter++;

        while(currentNode.next != null) {
            currentNode = currentNode.next;
            counter++;
        }

        return counter;
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
