package simple.linkedlist;

public class Node {
    private int value;
    private Node nextNode;

    public Node(int value, Node node) {
        this.value = value;
        this.nextNode = node;
    }

    public void setNode(Node otherNode) {
        this.nextNode = otherNode;
    }

    public Node getNextNode() {
        return nextNode;
    }
}
