public class DoubleLinkedList implements LinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int at(int index) {
        // Return -1 for invalid indexes
        if (index < 0 || index >= size) return -1;

        // Quick direct returns for the ends
        if (index == 0) return head.value;
        if (index == size - 1) return tail.value;

        // Compute distances from both ends and pick the closer one
        int fromHead = index;
        int fromTail = (size - 1) - index;

        if (fromTail < fromHead) {
            // Start from tail and move backwards
            Node current = tail;
            for (int i = size - 1; i > index; i--) current = prev(current);
            return current.value;
        } else {
            // Start from head and move forwards
            Node current = head;
            for (int i = 0; i < index; i++) current = next(current);
            return current.value;
        }
    }

    @Override
    public void add(int value) {
        // Append to the tail
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        // Ignore invalid indexes
        if (index < 0 || index >= size) return;

        if (size == 1) {
            // Removing the only element
            head = null;
            tail = null;
        } else if (index == 0) {
            // Remove head
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            // Remove tail
            tail = tail.prev;
            tail.next = null;
        } else {
            // Remove from middle: choose the closer end to traverse from
            Node current;
            int fromHead = index;
            int fromTail = (size - 1) - index;
            if (fromTail < fromHead) {
                current = tail;
                for (int i = size - 1; i > index; i--) current = prev(current);
            } else {
                current = head;
                for (int i = 0; i < index; i++) current = next(current);
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    // Helper used by tests: prints when moving forward
    private Node next(Node node) {
        System.out.println("Go to next node");
        return node.next;
    }

    // Helper used by tests: prints when moving backward
    private Node prev(Node node) {
        System.out.println("Go to previous node");
        return node.prev;
    }
}