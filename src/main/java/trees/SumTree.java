package trees;

public class SumTree {
    public static void main(String[] args) {
        Node tree = new Node(26);
        tree.left = new Node(10);
        tree.right = new Node(3);
        tree.right.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(6);
        TreePrinter.print(tree);
        System.out.println("Is sum tree? " + isSumTree(tree));
    }

    public static boolean isSumTree(Node node) {
        if (node == null) {
            return true;
        }
        boolean isThisSumTree;
        if (node.left != null) {
            if (node.right != null) {
                isThisSumTree = node.value == (sum(node.left) + sum(node.right));
            } else {
                isThisSumTree = node.value == sum(node.left);
            }
        } else if (node.right != null) {
            isThisSumTree = node.value == sum(node.right);
        } else {
            return true;
        }

        return isThisSumTree && isSumTree(node.left) && isSumTree(node.right);
    }

    private static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        return sum(root.left) + sum(root.right) + root.value;
    }
}
