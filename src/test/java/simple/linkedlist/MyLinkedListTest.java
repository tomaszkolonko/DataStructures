package simple.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import simple.array.MyArray;

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

    @Test
    void contains() {
        createDefaultList();

        assertTrue(myLinkedList.contains(10));
        assertTrue(myLinkedList.contains(40));
        assertFalse(myLinkedList.contains(99));
    }

    @Test
    void indexOf() {
        createDefaultList();

        assertEquals(0, myLinkedList.indexOf(10));
        assertEquals(3, myLinkedList.indexOf(40));
        assertEquals(Integer.MIN_VALUE, myLinkedList.indexOf(99));
    }

    @Test
    void removigTooManyItems() {
        myLinkedList.addFirst(10);
        assertEquals(1, myLinkedList.getSize());
        myLinkedList.deleteFirst();
        assertEquals(0, myLinkedList.getSize());
        assertThrows(IllegalArgumentException.class, () -> myLinkedList.deleteFirst());
        assertThrows(IllegalArgumentException.class, () -> myLinkedList.deleteLast());
    }

    @Test
    @Disabled
    void convertToMyArray() {
        createDefaultList();
        MyArray myArray = myLinkedList.convertToMyArray();

        assertEquals(actualList.toString(), myArray.toString());
    }

    @Test
    void convertToArray() {
        createDefaultList();
        int[] array = myLinkedList.convertToArray();

        assertEquals(actualList.toString(), Arrays.toString(array));
    }

    @Test
    void reverse() {
        createDefaultList();

        LinkedList<Integer> reversedList = new LinkedList<>();
        reversedList.add(40);
        reversedList.add(30);
        reversedList.add(20);
        reversedList.add(10);

        myLinkedList.reverse();

        assertEquals(reversedList.toString(), myLinkedList.toString());
    }

    @Test
    void getKthFromTheEnd() {
        createDefaultList();

        int last = myLinkedList.getKthFromTheEnd(0);
        assertEquals(40, last);

        int oneFromTheEnd = myLinkedList.getKthFromTheEnd(1);
        assertEquals(30, oneFromTheEnd);

        int twoFromTheEnd = myLinkedList.getKthFromTheEnd(2);
        assertEquals(20, twoFromTheEnd);

        int threeFromTheEnd = myLinkedList.getKthFromTheEnd(3);
        assertEquals(10, threeFromTheEnd);

        assertThrows(IllegalArgumentException.class, () -> myLinkedList.getKthFromTheEnd(-1));
        assertThrows(IllegalArgumentException.class, () -> myLinkedList.getKthFromTheEnd(4));

    }

    private void createDefaultList() {
        myLinkedList.addFirst(10);
        myLinkedList.addLast(20);
        myLinkedList.addLast(30);
        myLinkedList.addLast(40);
    }

}