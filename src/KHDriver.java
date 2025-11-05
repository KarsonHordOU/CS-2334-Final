//KH

import java.util.Random;

public class KHDriver {
	public static void main(String[] args) {
        
		KHLinkedList<Integer> list = new KHLinkedList<>();
        Random generator = new Random();
        
        //Test speed of adding numbers to the end
        long startAdd = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
        	Integer number = generator.nextInt(101);
        	list.add(number);
        }
        long endAdd = System.nanoTime();
		long linkedAddTime = endAdd - startAdd;
		
		//Test speed of sequential access of all elements
		long startAccess = System.nanoTime();
		Integer target = 100;
		for (int i = 0; i < list.getSize(); i++) { 
            if (list.get(i).equals(target)) { 
                //System.out.println("Target " + target + " found at index: " + i);
            }
		}
        long endAccess = System.nanoTime();
        long linkedAccessTime = endAccess - startAccess;
        
        //Test speed of accessing elements at random using 100 lookups
        long startRandomAccess = System.nanoTime(); 
        	for (int i = 0; i < 100; i++) {
        		int randomIndex = generator.nextInt(list.getSize());
        		Object foundElement = list.get(randomIndex);
        		//System.out.println("Number " + foundElement + " found at index: " + randomIndex);
        	}
        long endRandomAccess = System.nanoTime();
        long linkedRandomAccessTime = endRandomAccess - startRandomAccess;
        
        KHLinkedList<Integer> list2 = new KHLinkedList<>();
        
        //Test adding numbers to the beginning
        long startAddFirst = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
        	Integer number = generator.nextInt(101);
        	list2.addFirst(number);
        }
        long endAddFirst = System.nanoTime();
		long linkedAddFirstTime = endAddFirst - startAddFirst;
		
		System.out.println("LinkedList AddFirst Time: " + linkedAddFirstTime + " ns");
		System.out.println("LinkedList Add Last Time: " + linkedAddTime + " ns");
        System.out.println("LinkedList Random Access Time: " + linkedRandomAccessTime + " ns");
        System.out.println("LinkedList Sequential Access Time: " + linkedAccessTime + " ns");
	}
}


