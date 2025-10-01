public class CircularLinkedList implements LinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int at(int index) {
        if (index < 0 || size == 0) return -1;
        
        if (index == 0) return head.value;
        
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
            // First element - points to itself
            head = newNode;
            tail = newNode;
            head.next = head; // circular reference
        } else {
            // traverse from head to the current tail using next()
            // this intentionally uses next() (which prints) so tests observe traversal
            Node current = head;
            for (int i = 0; i < size - 1; i++) {
                current = next(current);
            }
            // current is the node before insertion (old tail)
            current.next = newNode;
            newNode.next = head; // new node points back to head
            tail = newNode;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size || size == 0) return;

        if (size == 1) {
            // Removing the only element
            head = null;
            tail = null;
        } else if (index == 0) {
            // Remove head without traversal (tests expect no output here)
            head = head.next;
            tail.next = head; // update tail to point to new head
        } else {
            // Traverse index times to reach the node to remove (this will print each step)
            Node current = head;
            Node prev = head;
            for (int i = 0; i < index; i++) {
                prev = current;
                current = next(current);
            }

            // current is the node to remove; prev is the node before it
            prev.next = current.next;

            // If we removed the tail, update tail pointer
            if (current == tail) {
                tail = prev;
            }
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