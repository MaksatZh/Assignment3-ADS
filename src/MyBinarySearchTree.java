public class MyBinarySearchTree {
    public Node root;

    public class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node current, int data) {
        if (current == null)
            return new Node(data);
        if (data < current.data)
            current.left = insert(current.left, data);
        else
            current.right = insert(current.right, data);
        return current;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void remove(int data) {
        root = remove(root, data);
    }

    private Node remove(Node current, int data) {
        if (current == null)
            return null;
        if (data < current.data)
            current.left = remove(current.left, data);
        else if (data > current.data)
            current.right = remove(current.right, data);
        else {
            //case 1: no child
            if (current.left == null && current.right == null)
                return null;

            //case 2: only one child

            if (current.left == null)
                return current.right;

            if (current.right == null)
                return current.left;

            int smallestValue = findSmallestValue(current.left);
            current.data =smallestValue;
            current.left = remove(current.left, smallestValue);
        }
        return current;
    }

    private int findSmallestValue(Node node) {
        return node.right == null ? node.data : findSmallestValue(node.right);
    }
}