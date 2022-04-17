package trees.views;

import trees.BinarySearchTree;
import trees.Node;

import java.util.ArrayList;
import java.util.List;

public class RightView {
    int currentLvl = 0;

    public static void main(String[] args) {
        RightView rightView = new RightView();
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

        System.out.println("Right view\n");
        List<Integer> view = new ArrayList<>();
        rightView.rightView(bst.getRoot(), view);
        System.out.println(view);
    }

    public void rightView(Node root, List<Integer> leftView) {
        rightView(root, leftView, 1);
        currentLvl = 0;
    }

    private void rightView(Node root, List<Integer> rightView, int lvl) {
        if (root == null) {
            return;
        }
        if (currentLvl < lvl) {
            rightView.add(root.getValue());
            currentLvl = lvl;
        }
        rightView(root.getRight(), rightView, lvl + 1);
        rightView(root.getLeft(), rightView, lvl + 1);
    }

}
