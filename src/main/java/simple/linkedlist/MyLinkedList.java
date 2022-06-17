package simple.linkedlist;

public class MyLinkedList {
    private static class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    public void addLast(int value) {
        Node node = new Node(value);

        if(first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public void addFirst(int value) {
        Node node = new Node(value);

        if(first == null) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
    }

    public int getSize() {
        int counter = 0;
        if(first == null) {
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
    // addLast
    // deleteFirst
    // deleteLast
    // contains
    // indexOf

}
