package queue;

import exception.EmptyQueueException;
import exception.FullQueueException;

import java.util.Arrays;
import java.util.Objects;

public class DefaultQueue implements Queue {

    private static final int MAX_SIZE = 100;
    private static Task[] queue = new Task[MAX_SIZE];

    public static void main(String[] args) {
        DefaultQueue queue = new DefaultQueue();
        queue.enqueue(new Task(5));
        queue.enqueue(new Task(9));
        queue.enqueue(new Task(10));
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.print();
    }

    public void print() {
        System.out.print("Queue: ");
        for (int i = 0; i < size(); i++) {
            System.out.print(queue[i].id + " ");
        }
    }

    public Task dequeue() {
        Task res = queue[0];
        if (res == null) {
            throw new EmptyQueueException();
        }
        if (size() - 1 >= 0)
            System.arraycopy(queue, 1, queue, 0, size() - 1);
        queue[size() - 1] = null;

        System.out.println("Dequeued: " + res.id);
        return res;
    }

    public void enqueue(Task element) {
        if (size() < MAX_SIZE) {
            queue[size()] = element;
            System.out.println("Enqueued " + element.id);
        } else throw new FullQueueException();
    }

    public int size() {
        //MAX_SIZE is integer
        return (int) Arrays.stream(queue.clone())
                .filter(Objects::nonNull)
                .count();
    }
}
