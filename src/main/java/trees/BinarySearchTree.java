package trees;

public final class BinarySearchTree {

    private Node root;

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(20);
        binarySearchTree.insert(1);
        binarySearchTree.insert(9);
        binarySearchTree.insert(15);
        binarySearchTree.insert(30);

        System.out.println(binarySearchTree.contains(5));
        System.out.println(binarySearchTree.contains(20));
        System.out.println(binarySearchTree.contains(30));

        binarySearchTree.print();


        binarySearchTree.delete(5);
        binarySearchTree.delete(20);

        System.out.println(binarySearchTree.contains(5));
        System.out.println(binarySearchTree.contains(20));

        binarySearchTree.print();
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        }
        if (value > root.value) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null) {
            return node;
        }
        if (value == node.value) {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }
            int smallest = smallest(node.right);
            node.value = smallest;
            node.right = delete(node.right, smallest);
            return node;
        }
        if (value < node.value) {
            node.left = delete(node.left, value);
            return node;
        }
        node.right = delete(node.right, value);
        return node;
    }

    private int smallest(Node right) {
        return right.left == null ? right.value : smallest(right.left);
    }

    public boolean contains(int value) {
        return search(root, value);
    }

    private boolean search(Node node, int value) {
        if (node == null) {
            return false; // we reached a leaf
        }
        if (value == node.value) {
            return true;
        }
        if (value < node.value) {
            return search(node.left, value);
        }
        return search(node.right, value);
    }

    public void print() {
        print(root, 0);
    }

    private void print(Node node, int indentation) {
        if (node != null) {
            for (int i = 0; i < indentation; i++) {
                System.out.print(" ");
            }
            System.out.print(node.value + "\n");
            if (node.left != null) {
                print(node.left, indentation + 4);
            }
            if (node.right != null) {
                print(node.right, indentation + 4);
            }

        }
    }
}
