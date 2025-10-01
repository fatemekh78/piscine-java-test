public class SingleLinkedList implements LinkedList {
    private Node head;
    private int size;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int at(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = next(current);
        }
        return current.value;
    }

    @Override
    public void add(int value) {
        Node newNode = new Node(value);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = next(current);
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        
        if (index == 0) {
            // Remove head - don't call next() method
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = next(current); // This MUST call next() for traversal
            }
            // Skip the node to remove - don't call next() here
            current.next = current.next.next;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    private Node next(Node node) {
        System.out.println("Go to next node");
        return node.next;
    }
}