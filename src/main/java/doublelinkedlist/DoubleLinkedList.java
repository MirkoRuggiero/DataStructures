package doublelinkedlist;

public class DoubleLinkedList {

    private Node head;
    //private int size;


    public DoubleLinkedList(int head) {
        this.head = new Node(head);
    }


    public static void main(String[] args) {
        DoubleLinkedList ddl = new DoubleLinkedList(1);
        ddl.add(2);
        ddl.add(2);
        ddl.add(2);
        ddl.add(2);

        ddl.printDll(ddl.head);

        System.out.println(ddl.atIndex(ddl.head, ddl.head.next.next.next.prev));

        ddl.delete(ddl.head, ddl.head);
        ddl.printDll(ddl.head);

    }

    public void add(int newValue) {
        //Create a new node to insert
        Node newNode = new Node(newValue);

        //Set newNode next to be the head of the dll
        newNode.next = head;
        //and prev to null
        newNode.prev = null;
        if (head != null) {
            //prev of head now point to new node
            head.prev = newNode;
        }
        //and finally head now is the new node
        head = newNode;
    }

    public void delete(Node head, Node toDelete) {
        if (head == null || toDelete == null) {
            return;
        }
        if (head == toDelete) {
            //shift ahead the head of one step
            head = head.next;
            head.prev = null;
        }


        if (toDelete.next != null) {// is NOT the last node
            toDelete.next.prev = toDelete.prev;
        }

        if (toDelete.prev != null) {// is NOT the first node
            toDelete.prev.next = toDelete.next;
        }
    }

    public int atIndex(Node temp, Node toSearch) {
        int count = 0;
        Node head = temp;
        if (head == toSearch) return count;

        while (head.next != null) {
            if (head.next == toSearch){
                count++;
                return count;
            }
            count++;
            head = head.next;
        }
        return count;
    }

    public void printDll(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }
}
