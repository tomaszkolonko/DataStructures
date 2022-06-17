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
    void addLast() {
        myLinkedList.addLast(10);
        myLinkedList.addLast(20);
        myLinkedList.addLast(30);
        myLinkedList.addLast(40);

        assertEquals(4, myLinkedList.getSize());
        assertEquals(myLinkedList.toString(), actualList.toString());
    }

    @Test
    void addFirst() {
        myLinkedList.addFirst(20);
        myLinkedList.addLast(30);
        myLinkedList.addLast(40);
        myLinkedList.addFirst(10);

        assertEquals(4, myLinkedList.getSize());
        assertEquals(myLinkedList.toString(), actualList.toString());
    }

    @Test
    void deleteFirst() {
        createDefaultList();
        myLinkedList.addFirst(5);

        assertEquals(5, myLinkedList.getSize());
        assertEquals(myLinkedList.toString(), "[5, 10, 20, 30, 40]");

        myLinkedList.deleteFirst();

        assertEquals(4, myLinkedList.getSize());
        assertEquals(myLinkedList.toString(), actualList.toString());
    }

    @Test
    void deleteLast() {
        createDefaultList();
        myLinkedList.addLast(99);

        assertEquals(5, myLinkedList.getSize());
        assertEquals(myLinkedList.toString(), "[10, 20, 30, 40, 99]");

        myLinkedList.deleteLast();

        assertEquals(4, myLinkedList.getSize());
        assertEquals(myLinkedList.toString(), actualList.toString());
    }

    private void createDefaultList() {
        myLinkedList.addFirst(10);
        myLinkedList.addLast(20);
        myLinkedList.addLast(30);
        myLinkedList.addLast(40);
    }

}