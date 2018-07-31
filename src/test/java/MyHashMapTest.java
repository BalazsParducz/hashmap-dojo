import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    KeyValue keyValue2 = new KeyValue(2, "TWO");

    @org.junit.jupiter.api.Test
    void addAndGetTest() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.add("One", 1);

        assertEquals(1, myHashMap.getValue("One"));
    }
}