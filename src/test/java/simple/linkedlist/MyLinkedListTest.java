package simple.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyLinkedListTest {

    MyLinkedList myLinkedList;
    static LinkedList<Integer> actualList = new LinkedList<>();

    @BeforeAll
    public static void init() {
        actualList.addLast(10);
        actualList.addLast(20);
        actualList.addLast(30);
        actualList.addLast(40);
    }

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
        myLinkedList.addLast(40);

        assertEquals(4, myLinkedList.getSize());
        assertEquals(myLinkedList.toString(), actualList.toString());
    }

    @Test
    void testAddFirst() {
        myLinkedList.addFirst(20);
        myLinkedList.addLast(30);
        myLinkedList.addLast(40);
        myLinkedList.addFirst(10);

        assertEquals(4, myLinkedList.getSize());
        assertEquals(myLinkedList.toString(), actualList.toString());

    }
}