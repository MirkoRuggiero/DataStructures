package queue;

public interface Queue {

    void enqueue(Task task);

    Task dequeue();

    int size();

    void print();
}
