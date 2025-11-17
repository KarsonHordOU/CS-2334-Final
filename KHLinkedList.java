//KH

public class KHLinkedList<T> {
	private Node<T> head;
	private int size;
		
	private static class Node<T> {
		T data;
	    Node<T> next;

	    Node(T data) {
	    	this.data = data;
	    	this.next = null;
	    }
	}
	
	public void add(T data) { //adds data to the back of the list
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
	
	
	public void addFirst(T data) { //adds data to the front of the list
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
		}
		if (head != null) {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}
	
	public T add(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        T addData;

        if (index == 0) { // Removing the head
            addData = head.data;
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            addData = current.next.data;
            current.next = current.next.next; // Bypass the node to be removed
        }
        size++;
        return addData;
    }
	
	public T remove() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }
	
	public T removeLast() {
        if (head == null) {
            return null; // Or throw NoSuchElementException
        }
        if (head.next == null) {
            T data = head.data;
            head = null;
            return data;
        }

        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        T data = current.next.data;
        current.next = null;
        return data;
    }
	
	public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        T removedData;

        if (index == 0) { // Removing the head
            removedData = head.data;
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedData = current.next.data;
            current.next = current.next.next; // Bypass the node to be removed
        }
        size--;
        return removedData;
    }
	
	public boolean contains(T element) {
		Node current = head;
		while (current != null) {
			if (current.data.equals(element)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	public int getSize() {
		return size;
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

class type<T> {
	
	private T type;

	//Constructor
	public type(T type) {
		this.type = type;
	}
	
	//getters and setters
	public void setType(T type) {
		this.type = type;
	}

	public T getType(T type) {
		return type;
	}
}
