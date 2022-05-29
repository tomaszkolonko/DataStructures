package simple.linkedlist;

public class LinkedList {
    private Node first;
    private Node last;

    public LinkedList() {
        first = new Node(Integer.MIN_VALUE, null);
        last = new Node(Integer.MAX_VALUE, null);
    }

    public void addLast(int value) {
        Node node = new Node(value, null);
        Node currentNode = first;

        if(first.getNextNode() == null) {
            first.setNode(node);
            last.setNode(node);
            return;
        }

        while(currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }

        currentNode.setNode(node);
        last.setNode(node);
    }

    public int getSize() {
        int counter = 0;
        Node currentNode = first;

        while(currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
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
