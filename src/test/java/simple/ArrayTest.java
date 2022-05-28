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
    }

    @Test
    void insert() {
        items.insert(15);
        assertEquals(15, items.retrieveAt(4));
    }

    @Test
    void removeAt() {
        items.removeAt(3);
        assertEquals(3, items.size());
    }

    @Test
    void indexOf() {
        assertEquals(0, items.indexOf(11));
        assertEquals(2, items.indexOf(13));

    }
}