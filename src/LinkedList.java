
public class LinkedList<T> {
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
	
	
	public void addFirst(T data) { //adds data to be front of the list
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
	
	public T remove() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
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
