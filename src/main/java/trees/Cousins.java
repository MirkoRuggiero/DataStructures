package trees;

public class Cousins {
    public static void main(String[] args) {
        //BST manipulated
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
        bst.insert(3);
        bst.getRoot().right = new Node(5);
        bst.getRoot().getLeft().left = new Node(7);
        bst.getRoot().getLeft().getLeft().right = new Node(11);
        bst.getRoot().getLeft().right = new Node(8);
        bst.getRoot().getRight().left = new Node(1);
        bst.getRoot().getRight().left.right = new Node(10);
        bst.getRoot().getRight().right = new Node(3);
        bst.print();

        System.out.println(areCousins(bst, 10, 11));

    }

    public static boolean areCousins(BinarySearchTree bst, int a, int b) {
        System.out.print(String.format("Are %d and %d cousins? ", a, b));
        return bst.getDepth(a) == bst.getDepth(b) && bst.getDepth(a) != -1 && a != b
                && !bst.haveSameParent(a, b);
    }
}
