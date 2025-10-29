public class ArrayList<T> {
    private T[] data;     
    private int size;      
    private static final int default_cap = 10;

    
    public ArrayList() {
       
        data = (T[]) new Object[default_cap];
        size = 0;
    }
    

    
    public void add(T value) {
        ensureCapacity(size + 1);
        data[size++] = value;
    }
    

   
    public T remove(int index) {
        checkIndex(index);
        T removed = data[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[--size] = null; 
        return removed;
    }

    
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    
    public int size() {
        return size;
    }

    
    
    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= data.length) return;
        int newCapacity = Math.max(data.length * 2, minCapacity);
        T[] newData = (T[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

   
    
}
