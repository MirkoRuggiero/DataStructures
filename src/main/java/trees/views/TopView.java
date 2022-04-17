package trees.views;

import trees.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopView { //TODO
    int currentLvl = 0;

    private void topView(Node root, List<Integer> topView, int lvl) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node polled = queue.poll();
            if (lvl > currentLvl) {
                currentLvl = lvl;
                topView.add(polled.getValue());
            }
        }


    }
}
