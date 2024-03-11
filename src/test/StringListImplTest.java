package test;

import main.StringListImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class StringListImplTest {
    StringListImpl stringList = new StringListImpl();
    @Test
    void getArray() {
    }
    @Test
    void testAdd() {
        stringList.add("Hello");
        assertEquals(1, stringList.size());
        assertTrue(stringList.contains("Hello"));
    }
    @Test
    void testAddAtIndex() {
        stringList.add("Hello");
        stringList.add("World");
        stringList.add(1, "Java");
        assertEquals("Java", stringList.get(1));
    }
    @Test
    void set() {
        stringList.add("Hello");
        stringList.set(0, "Java");
        assertEquals("Java", stringList.get(0));
    }
    @Test
    void removeAtItem() {
        stringList.add("apple");
        stringList.add("banana");
        String removedItem = stringList.remove("banana");
        assertEquals("banana", removedItem);
        assertFalse(stringList.contains("banana"));
        assertEquals(1, stringList.size());
    }
    @Test
    void removeAtIndex() {
        stringList.add("apple");
        stringList.add("banana");
        String removedItem = stringList.remove(1);
        assertEquals("banana", removedItem);
        assertFalse(stringList.contains("banana"));
        assertEquals(1, stringList.size());
    }



    @Test
    void indexOf() {
        stringList.add("apple");
        stringList.add("banana");
        int index = stringList.indexOf("banana");
        assertEquals(1, index);
    }
    @Test
    void lastIndexOf() {
        stringList.add("apple");
        stringList.add("banana");
        int index = stringList.indexOf("apple");
        assertEquals(0, index);
    }
}