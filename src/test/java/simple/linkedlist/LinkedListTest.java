package simple.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    LinkedList myLinkedList;

    @BeforeEach
    void setUp() {
        myLinkedList = new LinkedList();
    }

    @Test
    void testAddLast() {
        myLinkedList.addLast(10);
        myLinkedList.addLast(20);
        myLinkedList.addLast(30);

        assertEquals(3, myLinkedList.getSize());
    }

}