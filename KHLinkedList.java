// KH

public class KHLinkedList<T> {
    private Node<T> head;
    private int size;

    // =========================
    // Node class
    // =========================
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // =========================
    // Basic operations
    // =========================

    public int getSize() {
        return size;
    }

    public void add(T data) { // adds data to the back of the list
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void addFirst(T data) { // adds data to the front of the list
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Add in the "middle" of the list.
     * We define middle index as size / 2 (integer division).
     * Example: size=4 → index 2 (0,1,2,3), size=5 → index 2.
     */
    public void addMiddle(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        // If list is empty or 1 element, just add at end (simplest reasonable behavior)
        if (size == 0) {
            add(data);         // becomes the only element
            return;
        } else if (size == 1) {
            // Insert after head (still "middle")
            Node<T> newNode = new Node<>(data);
            head.next = newNode;
            size++;
            return;
        }

        int index = size / 2;  // index where we want to insert
        Node<T> newNode = new Node<>(data);

        // Traverse to node BEFORE the index
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    /**
     * Indexed add (optional utility) – insert at a specific index.
     * 0 <= index <= size
     */
    public void add(int index, T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    // =========================
    // Remove operations
    // =========================

    // Remove from the beginning
    public T removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    // Keep old name remove() as alias to "remove from front"
    public T remove() {
        return removeFirst();
    }

    // Remove from the end
    public T removeLast() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        if (head.next == null) { // only one element
            T data = head.data;
            head = null;
            size--;
            return data;
        }

        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        T data = current.next.data;
        current.next = null;
        size--;
        return data;
    }

    // Remove by index (0 = first, size-1 = last, anything between = middle)
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            return removeFirst();
        }

        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        T removedData = current.next.data;
        current.next = current.next.next; // bypass node
        size--;
        return removedData;
    }

    /**
     * Remove from the middle of the list.
     * Uses index size/2 (same definition as addMiddle).
     */
    public T removeMiddle() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        if (size == 1) {
            return removeFirst();
        }

        int index = size / 2;
        return remove(index);
    }

    // =========================
    // Other utilities
    // =========================

    public boolean contains(T element) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

// You don't really need this class for the linked list to work,
// but I'm leaving it here since you had it.
class type<T> {

    private T type;

    // Constructor
    public type(T type) {
        this.type = type;
    }

    // getters and setters
    public void setType(T type) {
        this.type = type;
    }

    public T getType() {
        return type;
    }
}

