import com.sun.javaws.exceptions.InvalidArgumentException;

import java.security.InvalidKeyException;
import java.util.LinkedList;

public class MyHashMap<K, V> {


    private int bucketSize = 16;

    private LinkedList<KeyValue>[] elements = new LinkedList[bucketSize];

    public void add(K key, V value){
        int position = getHash(key);
        // If the key already exists throw an error.
        for (LinkedList list: elements) {
            if(list.contains(key)) {
                throw new IllegalArgumentException();
            }
        }
        // Make a new instance of the KeyValue class,
        KeyValue keyValue = new KeyValue(key, value);
        LinkedList list = new LinkedList();
        // fill it with the key, value parameters
        list.add(keyValue);
        // then add it to the list.
        elements[position] = list;
    }


    public V getValue(K key) {
        // 1. Calculate the hash of the key. This defines which element to get from the "elements" array
        // 2. Find in the List in this position the KeyValue element that has this key, then return its value.
        //    If none of the items in the list has this key throw error.
        int atHash = getHash(key);
        for(KeyValue<K,V> keyValue: elements[atHash]) {
            if (keyValue.getKey().equals(key)) {
                return keyValue.getValue();
            }
            else throw new NullPointerException("This Key is not present");
        }
        return null;
    }


    private int getHash(K key) {
        // This function converts somehow the key to an integer between 0 and bucketSize
        // In C# GetHashCode(), in Java hashCode() is a function of Object, so all non-primitive types
        // can easily be converted to an integer.
        return key.hashCode() % bucketSize;
    }

    public void getElements() {
        for (LinkedList list: elements) {
            System.out.println(list.getFirst());
        }
    }
}
