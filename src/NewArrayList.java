

public class NewArrayList <T>{

		private T[] data;
		private int size = 1000;
		private static final int CAPACITY = 10;
		
		public NewArrayList() {
			data = (T[]) new Object[CAPACITY];
			size = 0;
		}
		
		// Add Elements at the end of the list
		public void addEnd(T element) {
			
			if (element == null) {
				throw new IllegalArgumentException ("Element is incorrect");
			}
			
			
			if (size == data.length) {
				resize();
			}
			
			data[size] = element;
			size++;
			
			
			/*ArrayList <T> list = new ArrayList <>();
			for (int i = 0; i < size ; i++) {
				list.add(0, i);
			}*/
		}
		

		// Add elements at the beginning
		public void addBeg (T element) {
		
			
			
		}
		
		
		
		// add elements in the middle
		public void addMid (int index, T element) throws IllegalArgumentException, IndexOutOfBoundsException{
			if (element == null) {
				throw new IllegalArgumentException ("wrong element!");
			}
			
			if (index < 0 || index > size) {
				throw new IndexOutOfBoundsException ("Number out of bounds!");
			}
			
			
		}
		
		// remove elements Beginning 
		
		
		// Remove elements at the end 
		
		
		// remove elements in the middle
		
		
		// get the element
		public T get (int index) {
			if (index < 0 || index > size) {
				throw new IndexOutOfBoundsException ("Number out of bounds!");
			}
			return data[index];
		}
		
		// check the ArrayList
		public boolean contains (T element) {
			for (int i = 0; i < size; i++) {
				if (data[i].equals(element) && data[i] != null) {
					return true;
				}
			}
			return false;
		}
		
		// resize the array 
		public void resize () {
		T [] newData = (T[]) new Object [data.length *2];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];		
			}
			data = newData;
		}
		
		@Override
		public String toString () {
			if (size == 0) {
				return "[]";
			}
			
			StringBuilder sb = new StringBuilder ();
			sb.append("[");
			for (int i = 0; i < size; i++) {
				sb.append(data[i]);
				if (i < size - 1) {
					sb.append(",");
				}
			}
			sb.append("]");
			return sb.toString ();
		}
		
		
}
