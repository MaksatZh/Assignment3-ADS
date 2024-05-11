package hash;

public class MyHashTable<K, V> {

    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private Node<K, V>[] chainArray;
    private static final int M = 11;
    private int size;

    public MyHashTable() {
        this(M);
    }

    public MyHashTable(int capacity) {
        chainArray = new Node[capacity];
    }

    public void put(K key, V value) {
        if (size > chainArray.length / 2)
            resize();
        int index = indexForKey(key);
        Node<K, V> newNode = new Node<>(key, value);

        if (chainArray[index] == null) {
            chainArray[index] = newNode;
            size++;
            return;
        }

        Node<K, V> current = chainArray[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            if (current.next == null)
                break;
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    public V get(K key) {
        int index = indexForKey(key);
        Node<K, V> current = chainArray[index];
        while (current != null) {
            if (current.key.equals(key))
                return current.value;
            current = current.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = indexForKey(key);

        Node<K, V> current = chainArray[index];
        if (current == null)
            return null;
        V value;

        if (current.key.equals(key)) {
            value = chainArray[index].value;
            chainArray[index] = current.next;
            return value;
        }

        while (current.next != null) {
            if (current.next.key.equals(key)) {
                value = current.next.value;
                current.next = current.next.next;
                return value;
            }
            current = current.next;
        }

        return null;
    }

    public boolean contains(V value) {
        return getKey(value) != null;
    }

    public K getKey(V value) {
        for (Node<K, V> node : chainArray)
            while (node != null) {
                if (node.value.equals(value))
                    return node.key;
                node = node.next;
            }
        return null;
    }

    public int getSize() {
        return size;
    }

    private int hash(K key) {
        return key.hashCode();
    }

    private void resize() {
        Node<K, V>[] oldTable = chainArray;
        chainArray = new Node[chainArray.length * 2];
        size = 0;
        rehash(oldTable);
    }

    private void rehash(Node<K, V>[] oldTable) {
        for (Node<K, V> node : oldTable) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    private int indexForKey(K key) {
        int hash = hash(key);
        return Math.abs(hash) % chainArray.length;
    }
}
