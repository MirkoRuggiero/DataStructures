package trees;

public final class BinarySearchTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(20);
        binarySearchTree.insert(1);
        binarySearchTree.insert(9);
        binarySearchTree.insert(15);
        binarySearchTree.insert(30);
        binarySearchTree.insert(30);
        binarySearchTree.insert(7);
        binarySearchTree.insert(27);
        binarySearchTree.insert(16);
        binarySearchTree.insert(4);
        binarySearchTree.insert(8);

        binarySearchTree.print();

        System.out.println("Contains 5 " + binarySearchTree.contains(5));
        System.out.println("Contains 20 " + binarySearchTree.contains(20));
        System.out.println("Contains 30 " + binarySearchTree.contains(30));

        binarySearchTree.delete(5);
        binarySearchTree.delete(20);
        System.out.println("Deleting 5 and 20");
        binarySearchTree.print();


        System.out.println("Contains 5 " + binarySearchTree.contains(5));
        System.out.println("Contains 20 " + binarySearchTree.contains(20));
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
            return null;
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

    public int getDepth(int value) {
        return getDepth(this.root, value, 1);
    }

    private int getDepth(Node node, int value, int lvl) {
        if (node == null) {
            return -1;
        }
        if (value == node.value) {
            return lvl;
        }
        int foundLeft = getDepth(node.left, value, lvl + 1);
        if (foundLeft != -1) {
            return foundLeft;
        }
        return getDepth(node.right, value, lvl + 1);
    }

    public void print() {
        TreePrinter.print(this.root);
    }

    public int depth() {
        return depth(this.root);
    }

    private int depth(Node root) {
        int c = 0;
        if (root != null) {
            c++;
            c += Math.max(depth(root.left), depth(root.right));
        }
        return c;
    }

    public boolean haveSameParent(int a, int b) {
        return haveSameParent(root, a, b);
    }

    private boolean haveSameParent(Node root, int a, int b) {
        if (root == null) {
            return false;
        }
        return (root.left != null && root.left.value == a && root.right != null && root.right.value == b)
                || (root.left != null && root.left.value == b && root.right != null && root.right.value == a)
                || haveSameParent(root.left, a, b)
                || haveSameParent(root.right, a, b);
    }
}
