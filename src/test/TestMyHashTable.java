package test;

import hash.MyHashTable;

public class TestMyHashTable {
    public static void test() {
        MyHashTable<MyTestKey, MyStudent> hashTable = new MyHashTable<>();
        for (int i = 0; i < 20000; i++) {
            MyTestKey key = new MyTestKey(i, "Test");
            MyStudent val = new MyStudent("Test", i, "SE");
            hashTable.put(key, val);
        }

        System.out.println(hashTable.getSize());

        MyTestKey key = new MyTestKey(15000, "Test");
        System.out.println(hashTable.get(key));
    }
}
