package trees;

import java.util.Objects;

public class Node implements TreePrinter.PrintableNode {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }

    @Override
    public TreePrinter.PrintableNode getPrintableLeft() {
        return this.left;
    }

    @Override
    public TreePrinter.PrintableNode getPrintableRight() {
        return this.right;
    }

    @Override
    public String getText() {
        return Integer.toString(this.value);
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }


}
