package stack;

public class MinStack1 {

    private final java.util.Stack<Integer> stack;
    private final java.util.Stack<Integer> minStack;


    public MinStack1() {
        stack = new java.util.Stack<>();
        minStack = new java.util.Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
        stack.push(val);
    }

    public int pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min()); // returns -3
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min()); // returns -2
    }
}
