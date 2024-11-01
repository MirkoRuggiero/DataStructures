package stack;

public class MinStack2 {

    private Node head;

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.minSoFar), head);
        }
    }

    public int pop() {
        if (head != null) {
            int ret = head.val;
            head = head.next;
            return ret;
        } else {
            throw new IllegalStateException("MinStack is empty");
        }
    }

    public int top() {
        if (head != null) {
            return head.val;
        }
        throw new IllegalStateException("MinStack is empty");
    }

    public int min() {
        if (head != null) {
            return head.minSoFar;
        }
        throw new IllegalStateException("MinStack is empty");
    }

    private static class Node {
        private int val;
        private int minSoFar;
        private Node next;

        public Node(int val, int minSoFar, Node next) {
            this.val = val;
            this.minSoFar = minSoFar;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min()); // returns -3
        System.out.println("popped " + minStack.pop()); // returns -3
        System.out.println(minStack.top());
        System.out.println(minStack.min()); // returns -2
    }
}
