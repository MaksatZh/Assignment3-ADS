import java.util.Iterator;
import java.util.Stack;

public class MyBinarySearchTree<K extends Comparable<K>, V> implements Iterable<MyBinarySearchTree.Node<K, V>> {
    public Node<K, V> root;
    private int size;

    public static class Node<K, V> {
        K key;
        V val;
        Node<K, V> left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getVal() {
            return val;
        }

        @Override
        public String toString() {
            return "{" + key + "=" + val + "}";
        }
    }

    public void insert(K key, V val) {
        root = insert(root, key, val);
    }

    private Node<K, V> insert(Node<K, V> current, K key, V val) {
        if (current == null) {
            size++;
            return new Node<>(key, val);
        }
        if (key.compareTo(current.key) > 0)
            current.left = insert(current.left, key, val);
        else
            current.right = insert(current.right, key, val);
        return current;
    }

    public void remove(K key) {
        root = remove(root, key);
    }

    private Node<K, V> remove(Node<K, V> current, K key) {
        if (current == null)
            return null;
        if (key.compareTo(current.key) < 0)
            current.left = remove(current.left, key);
        else if (key.compareTo(current.key) > 0)
            current.right = remove(current.right, key);
        else {
            //case 1: no child
            if (current.left == null && current.right == null)
                return null;

            //case 2: only one child
            if (current.left == null)
                return current.right;

            if (current.right == null)
                return current.left;

            Node<K, V> t = findSmallestValue(current.left);
            current.key = t.key;
            current.val = t.val;
            size--;
        }
        return current;
    }

    public int getSize() {
        return size;
    }

    private Node<K, V> findSmallestValue(Node<K, V> node) {
        return node.right == null ? node : findSmallestValue(node.right);
    }

    public Iterator<Node<K, V>> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Node<K, V>> {
        private final Stack<Node<K, V>> stack;

        public MyIterator() {
            stack = new Stack<>();
            addNodes(root);
        }

        private void addNodes(Node<K, V> node) {
            if (node == null) return;
            addNodes(node.left);
            stack.push(node);
            addNodes(node.right);
        }

        @Override
        public boolean hasNext() {
            return !stack.empty();
        }

        @Override
        public Node<K, V> next() {
            return stack.pop();
        }
    }
}