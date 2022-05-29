package simple.array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayTest {

    Array items;

    @BeforeEach
    void setUp() {
        items = new Array(4);
        items.insert(11);
        items.insert(12);
        items.insert(13);
        items.insert(14);
    }

    @Test
    void createZeroArray() {
        assertThrows(IllegalArgumentException.class, () -> new Array(0));
    }

    @Test
    void retrieveAt() {
        assertEquals(11, items.retrieveAt(0));
        assertEquals(14, items.retrieveAt(3));

        assertThrows(IllegalArgumentException.class, () -> items.retrieveAt(10));
        assertThrows(IllegalArgumentException.class, () -> items.retrieveAt(-1));
    }

    @Test
    void insertIntoExpandedArray() {
        items.insert(15);

        assertEquals(5, items.pointerToNextSpot());
        assertEquals(11, items.retrieveAt(0));
        assertEquals(12, items.retrieveAt(1));
        assertEquals(13, items.retrieveAt(2));
        assertEquals(14, items.retrieveAt(3));
        assertEquals(15, items.retrieveAt(4));
    }

    @Test
    void removeAt() {
        items.removeAt(3);
        assertEquals(3, items.pointerToNextSpot());

        assertThrows(IllegalArgumentException.class, () -> items.removeAt(10));
        assertThrows(IllegalArgumentException.class, () -> items.removeAt(-1));
    }

    @Test
    void removeAtWithShrinkingArray() {
        assertEquals(8, items.size());
        items.removeAt(3);
        assertEquals(4, items.size());

        assertEquals(3, items.pointerToNextSpot());
        assertEquals(11, items.retrieveAt(0));
        assertEquals(12, items.retrieveAt(1));
        assertEquals(13, items.retrieveAt(2));
    }

    @Test
    void indexOf() {
        assertEquals(0, items.indexOf(11));
        assertEquals(2, items.indexOf(13));

        assertEquals(-1, items.indexOf(100));
    }

    @Test
    void max() {
        items.insert(99);
        items.insert(2);
        items.insert(-99);

        assertEquals(99, items.max());
    }

    @Test
    void min() {
        items.insert(99);
        items.insert(2);
        items.insert(-99);

        assertEquals(-99, items.min());
    }

    @Test
    void intersect() {
        Array newArray = new Array(6);
        newArray.insert(0);
        newArray.insert(10);
        newArray.insert(12);
        newArray.insert(13);
        newArray.insert(18);

        Array resultOfIntersect = new Array(2);
        resultOfIntersect.insert(12);
        resultOfIntersect.insert(13);

        assertEquals(resultOfIntersect, items.intersect(newArray));
    }

    @Test
    void reversed() {
        Array newArray = new Array(4);
        newArray.insert(14);
        newArray.insert(13);
        newArray.insert(12);
        newArray.insert(11);

        assertEquals(newArray, items.reversed());
    }

    @Test
    void insertAt() {
        items.insertAt(2, 23);

        assertEquals(23, items.retrieveAt(2));
    }

    @Test
    void insertAtIllegalIndex() {
        assertThrows(IllegalArgumentException.class, () -> items.insertAt(-2, 23));
        assertThrows(IllegalArgumentException.class, () -> items.insertAt(22, 23));
    }
}