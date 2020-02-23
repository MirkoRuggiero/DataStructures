package exception;

public class EmptyQueueException extends AbstractDSException {
    public EmptyQueueException() {
        super("Queue is empty");
    }
}
