
public class MyLinkedList<T> {
	private class Node {
		T data;
		Node next;
		
		Node(T data) {
			this.data = data;
		}
	}
	
	private Node head;
	private int size;
	
	public void add(T element) {
		Node newNode = new Node(element);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		size++;
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
	
	public int size() {
		return size;
	}

}
