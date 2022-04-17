package trees.views;

import trees.BinarySearchTree;
import trees.Node;

import java.util.ArrayList;
import java.util.List;

public class LeftView {
    int currentLvl = 0;

    public static void main(String[] args) {
        LeftView leftView = new LeftView();
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(4);
        bst.insert(3);
        bst.insert(2);
        bst.insert(66);
        bst.insert(6);
        bst.insert(5);
        bst.insert(7);
        bst.insert(77);
        bst.insert(55);
        bst.print();

        System.out.println("Left view\n");
        List<Integer> view = new ArrayList<>();
        leftView.leftView(bst.getRoot(), view);
        System.out.println(view);
    }

    public void leftView(Node root, List<Integer> leftView) {
        leftView(root, leftView, 1);
        currentLvl = 0;
    }

    private void leftView(Node root, List<Integer> leftView, int lvl) {
        if (root == null) {
            return;
        }
        if (currentLvl < lvl) {
            leftView.add(root.getValue());
            currentLvl = lvl;
        }
        leftView(root.getLeft(), leftView, lvl + 1);
        leftView(root.getRight(), leftView, lvl + 1);
    }
}
