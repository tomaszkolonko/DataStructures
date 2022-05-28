package simple;

import static org.junit.jupiter.api.Assertions.*;

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
    void retrieveAt() {
        assertEquals(11, items.retrieveAt(0));
        assertEquals(14, items.retrieveAt(3));

        assertThrows(IllegalArgumentException.class, () -> items.retrieveAt(10));
        assertThrows(IllegalArgumentException.class, () -> items.retrieveAt(-1));
    }

    @Test
    void insertIntoExpandedArray() {
        items.insert(15);

        assertEquals(5, items.pointerToNextElement());
        assertEquals(11, items.retrieveAt(0));
        assertEquals(12, items.retrieveAt(1));
        assertEquals(13, items.retrieveAt(2));
        assertEquals(14, items.retrieveAt(3));
        assertEquals(15, items.retrieveAt(4));
    }

    @Test
    void removeAt() {
        items.removeAt(3);
        assertEquals(3, items.pointerToNextElement());

        assertThrows(IllegalArgumentException.class, () -> items.removeAt(10));
        assertThrows(IllegalArgumentException.class, () -> items.removeAt(-1));
    }

    @Test
    void removeAtWithShrinkingArray() {
        assertEquals(8, items.size());
        items.removeAt(3);
        assertEquals(4, items.size());

        assertEquals(3, items.pointerToNextElement());
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
}