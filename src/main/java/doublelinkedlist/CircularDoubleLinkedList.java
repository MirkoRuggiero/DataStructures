package doublelinkedlist;

import com.google.common.base.Preconditions;

public class CircularDoubleLinkedList<T> {

    private Node<T> node;
    private int size;

    public static void main(String[] args) {
        CircularDoubleLinkedList<String> cdll = new CircularDoubleLinkedList<>();
//    cdll.add(0);
        cdll.add("uno");
        cdll.add("due");
        cdll.add("tre");
        cdll.add("quattro");
        cdll.addHead("zero");
//        cdll.add(null);
        cdll.print();
        cdll.printReverse();

        System.out.println(cdll.contains("zero"));
    }

    public void add(T element) {
        addTail(element);
    }

    public void addAt(int index) {
        //TODO
    }

    public void addTail(T element) {
        Preconditions.checkNotNull(element);
        Node<T> nodeToAdd = new Node<>(element);
        Node<T> head = node;
        if (node == null) {
            nodeToAdd.next = nodeToAdd;
            nodeToAdd.previous = nodeToAdd;
            node = nodeToAdd;
        } else {
            for (int i = 0; i < size - 1; i++) {
                head = head.next;
            }
            nodeToAdd.next = head.next;
            nodeToAdd.previous = head;
            head.next = nodeToAdd;
        }
        size++;
    }

    public void addHead(T element) {
        Node<T> nodeToAdd = new Node<>(element);
        if (node == null) {
            nodeToAdd.next = nodeToAdd;
            nodeToAdd.previous = nodeToAdd;
        } else {
            nodeToAdd.next = node;
            nodeToAdd.previous = node.previous;
        }
        node = nodeToAdd;
        size++;
    }

    public int contains(T element) {
        if (node.data == element) {
            return 0;
        }
        Node<T> head = node;
        int index = size;
        while (index > 0) {
            if (head.data.equals(element)) {
                return index;
            }
            head = head.next;
            index--;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public void remove(T element) {
        //remove first occurrence
        Node<T> head = node;
        int index = size;
        while (index > 0) {
            if (head.data.equals(element)) {
                //TODO do not call remove at index
                remove(index - 1);
                return;
            }
            index--;
        }
    }

    public void remove(int index) {
        //TODO
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int loop = size;
        Node<T> head = node;
        while (loop > 0) {
            sb.append(head.data).append(" ");
            head = head.next;
            loop--;
        }
        return sb.toString().trim();
    }

    public void print() {
        System.out.println(this);
    }

    public void printReverse() {
        System.out.println(new StringBuilder(this.toString()).reverse().toString());
    }

    static class Node<T> {

        private T data;
        private Node<T> next;
        private Node<T> previous;

        private Node(T data) {
            this.data = data;
        }
    }
}