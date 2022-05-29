package simple.linkedlist;

public class LinkedList {
    private class Node {
        private int value;
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



    // addFirst
    // addLast
    // deleteFirst
    // deleteLast
    // contains
    // indexOf

}
