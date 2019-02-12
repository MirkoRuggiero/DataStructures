package stack;

public class Stack<T> {

    private final int MAX_SIZE = 1000;
    private int top = -1;
    private int[] array;

    public Stack() {
        this.array = new int[MAX_SIZE];
    }

    /**
     * O(1)
     *
     * @return
     */
    public boolean isEmpty() {
        return top < 0;
    }

    /**
     * O(1)
     *
     * @return
     */
    public int peek() {
        if (!isEmpty())
            return array[top];
        else throw new RuntimeException("stack is empty");
    }

    /**
     * O(1)
     *
     * @return
     */
    public void push(int a) {
        if (top >= MAX_SIZE - 1) {
            throw new RuntimeException("stack underflow!");
        } else {
            array[++top] = a;
        }
    }

    /**
     * O(1)
     *
     * @return
     */
    public int pop() {
        if (top < 0) {
            throw new RuntimeException("stack underflow!");
        } else {
            return array[top--];
        }
    }

    public static void main(String[] args) {

        Stack stack = new Stack();
        System.out.println("Pushing 1..");
        stack.push(1);
        System.out.println("Pushing 2..");
        stack.push(2);
        System.out.println("Pushing 3..");
        stack.push(3);

        System.out.println("Popping..");
        System.out.println(stack.pop());
        System.out.println("Popping..");
        System.out.println(stack.pop());
        System.out.println("Peeking..");
        System.out.println(stack.peek());
        System.out.println("Is empty? " + stack.isEmpty());
        System.out.println("Popping..");
        System.out.println(stack.pop());
        System.out.println("Is empty? " + stack.isEmpty());
    }
}
