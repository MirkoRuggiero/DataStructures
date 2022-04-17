package linkedlist;

/**
 * Singly linked list
 * Compared to the doubly linked list, this has a smaller memory footprint but during traversal you only have the reference to the next node.
 * It means that you don't have access to the previous node.
 */
public class LinkedList {

    private Node head;
    private int size;

    public LinkedList(int head) {
        this.head = new Node(head);
    }

    /**
     * O(1)
     *
     * @param data
     */
    public void addAtHead(int data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        size++;
    }

    /**
     * O(n)
     * <p>
     * We could store the tail reference and make this operation O(1)
     *
     * @param data
     */
    public void addAtTail(int data) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        size++;
    }

    /**
     * O(n) worst case
     *
     * @param data
     * @param index
     */
    public void addAtIndex(int data, int index) {
        if (index == 0) { // O(1)
            addAtHead(data);
            return;
        }
        Node tempLeft = head;
        Node tempRight;
        for (int i = 0; i < index - 1 && tempLeft.next != null; i++) {
            tempLeft = tempLeft.next;
        }
        tempRight = tempLeft.next;
        tempLeft.next = new Node(data);
        tempLeft.next.next = tempRight;
        size++;
    }

    /**
     * O(1)
     */
    public void deleteAtHead() {
        head = head.next;
        size--;
    }

    /**
     * O(n) worst case
     *
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index == 0) {
            deleteAtHead();
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    /**
     * O(n) if the element is the last
     *
     * @param node
     * @return Index of the Node, if found
     */
    public int find(Node node) {
        Node temp = head;
        int index = 0;
        while (!temp.equals(node)) {
            index++;
            temp = temp.next;
        }
        return index;
    }

    /**
     * O(n) if the element is the last
     *
     * @param index
     * @return Node at the index
     */
    public Node find(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * O(n)
     *
     * @return Last node of the list
     */
    public Node findLastElement() {
        //O(n) complexity, where n size of the list
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    public void printList() {
        Node temp = head;
        System.out.println(temp.data);
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp.data);
        }
        System.out.println("--------");
    }

    static class Node {
        private Node next;

        private int data;

        Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return data == node.data;
        }

    }

    /**
     * Deep copy
     *
     * @return a copy of the head node
     */
    public Node getHead() {
        return new Node(head.data);
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(2);
        ll.printList();

        ll.addAtHead(1);
        ll.addAtTail(3);
        ll.printList();

        assert ll.find(0).data == 1;
        assert ll.find(new Node(2)) == 1;

        ll.addAtIndex(0, 0);
        ll.printList();

        ll.deleteAtIndex(0);
        ll.printList();

        assert ll.findLastElement().data == 3;
    }
}
