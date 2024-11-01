package stack;

import java.util.Stack;

public class MonotonicStack {
    private Stack<Integer> stack = new Stack<>();

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public void push(int num){
        if (stack.isEmpty() || stack.peek() <= num) {
            stack.push(num);
        } else {
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }
            stack.push(num);
        }
    }

    @Override
    public String toString() {
        return "MonotonicStack{" +
                "stack=" + stack +
                '}';
    }

    public static void main(String[] args) {
        MonotonicStack monotonicStack = new MonotonicStack();

        monotonicStack.push(1);
        monotonicStack.push(1);
        monotonicStack.push(2);
        monotonicStack.push(2);
        monotonicStack.push(2);
        monotonicStack.push(2);
        monotonicStack.push(-1);
        monotonicStack.push(4);
        monotonicStack.push(0);

        System.out.println(monotonicStack);
    }


}
