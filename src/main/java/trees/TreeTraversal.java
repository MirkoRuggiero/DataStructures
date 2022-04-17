package trees;

import java.util.*;

public class TreeTraversal {

    public static void main(String[] args) {
        /**          4
         *          /  \
         *         3    6
         *        /    /
         *       2    5
         **/
        Node tree1 = new Node(4);
        tree1.left = new Node(3);
        tree1.left.left = new Node(2);
        tree1.right = new Node(6);
        tree1.right.left = new Node(5);
        System.out.println("Tree 1\n");
        TreePrinter.print(tree1);
        /**           4
         *           /  \
         *          3    5
         *         /      \
         *        2        6
         **/
        Node tree2 = new Node(4);
        tree2.left = new Node(3);
        tree2.left.left = new Node(2);
        tree2.right = new Node(5);
        tree2.right.right = new Node(6);
        System.out.println("Tree 2\n");
        TreePrinter.print(tree2);

        Node tree3 = new Node(10);
        tree3.left = new Node(2);
        tree3.left.right = new Node(3);
        tree3.right = new Node(4);
        System.out.println("Tree 3\n");
        TreePrinter.print(tree3);

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        inOrderTraversal(tree1, l1);
        inOrderTraversal(tree2, l2);
        System.out.println(l1.equals(l2));
        System.out.println("Tree 1 and 2 in-order traversal " + l1);

        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        postOrderTraversal(tree1, l3);
        postOrderTraversal(tree2, l4);
        System.out.println("Tree 1 post-order traversal " + l3);
        System.out.println("Tree 2 post-order traversal " + l4);

        List<Integer> l5 = new ArrayList<>();
        List<Integer> l6 = new ArrayList<>();
        List<Integer> l7 = new ArrayList<>();
        List<Integer> l8 = new ArrayList<>();
        preOrderTraversal(tree1, l5);
        preOrderTraversal(tree2, l6);
        preOrderTraversalITERATIVE(tree1, l7);
        preOrderTraversalITERATIVE(tree2, l8);
        assert l5.equals(l7);
        assert l6.equals(l8);
        System.out.println("Tree 1 pre-order traversal " + l5);
        System.out.println("Tree 2 pre-order traversal " + l6);
        System.out.println("Tree 1 pre-order traversal (ITERATIVE) " + l7);
        System.out.println("Tree 2 pre-order traversal (ITERATIVE) " + l8);
    }


    public static void preOrderTraversal(Node root, List<Integer> traversedNodes) {
        if (root == null) {
            return;
        }
        traversedNodes.add(root.value);
        preOrderTraversal(root.left, traversedNodes);
        preOrderTraversal(root.right, traversedNodes);
    }

    public static void preOrderTraversalITERATIVE(Node root, List<Integer> traversedNodes) {
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            Node popped = stack.pop();
            traversedNodes.add(popped.value);
            if (popped.right != null) {
                stack.push(popped.right);
            }
            if (popped.left != null) {
                stack.push(popped.left);
            }
        }
    }

    public static void inOrderTraversal(Node root, List<Integer> traversedNodes) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, traversedNodes);
        traversedNodes.add(root.value);
        inOrderTraversal(root.right, traversedNodes);
    }

    public static void postOrderTraversal(Node root, List<Integer> traversedNodes) {
        if (root == null) {
            return;
        }
        traversedNodes.add(root.value);
        postOrderTraversal(root.right, traversedNodes);
        postOrderTraversal(root.left, traversedNodes);
    }

    public static void BFStraversal(Node root, List<Integer> traversedNodes) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node nodeInExam = queue.poll();
            traversedNodes.add(nodeInExam.value);
            if (nodeInExam.left != null) {
                queue.add(nodeInExam.left);
            }
            if (nodeInExam.right != null) {
                queue.add(nodeInExam.right);
            }
        }
    }
}
