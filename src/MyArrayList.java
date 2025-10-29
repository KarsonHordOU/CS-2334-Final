import java.util.*;

public class MyArrayList<T> {
	private T[] data;
	private int size;
	
	public MyArrayList() {
		data = (T[]) new Object[10];
		size = 0;
	}
	
	public void add(T element) {
		if (size == data.length) {
			resize();
		}
		data[size] = element;
		size++;
	}
	private void resize() {
		T[] newData = (T[]) new Object[data.length * 2];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		return data[index];
	}
	public int size() {
		return size;
	}
	public boolean contains(T element) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(element)) {
				return true;
			}
		}
		return false;
	}
}
