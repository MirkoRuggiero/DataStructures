package exception;

public class FullQueueException extends AbstractDSException {
    public FullQueueException() {
        super("Queue is full");
    }
}
