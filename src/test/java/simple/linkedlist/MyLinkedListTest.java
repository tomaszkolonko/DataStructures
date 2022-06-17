package simple.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyLinkedListTest {

    MyLinkedList myLinkedList;

    @BeforeEach
    void setUp() {
        myLinkedList = new MyLinkedList();
    }

    @Test
    void getSizeOfEmptyLinkedList() {
        assertEquals(0, myLinkedList.getSize());
    }

    @Test
    void testAddLast() {
        myLinkedList.addLast(10);
        myLinkedList.addLast(20);
        myLinkedList.addLast(30);

        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(3, myLinkedList.getSize());
        assertEquals(myLinkedList.toString(), list.toString());
    }
}