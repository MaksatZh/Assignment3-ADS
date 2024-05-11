public class Main {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer, String> tree = new MyBinarySearchTree<>();

        tree.insert(5, "a");
        tree.insert(3, "b");
        tree.insert(7, "c");
        tree.insert(2, "d");
        tree.insert(4, "e");
        tree.insert(6, "f");
        tree.insert(8, "g");
        tree.insert(9, "h");
        tree.insert(10, "i");

        for (MyBinarySearchTree.Node<Integer, String> node : tree) {
            System.out.print(node + " ");
        }
        System.out.println();

        tree.remove(5);

        for (MyBinarySearchTree.Node<Integer, String> node : tree) {
            System.out.print(node + " ");
        }

//        TestMyHashTable.test();
    }
}