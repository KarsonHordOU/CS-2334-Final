import java.util.*;
public class Driver {

	public static void main(String[] args) {
		MyArrayList<Student> arrayList = new MyArrayList<>();
		MyLinkedList<Student> linkedList = new MyLinkedList<>();
		
		String[] lifestyles = {"Night Owl", "Social Butterfly", "Scholar", "Athlete", "Gamer"};
		Random rand = new Random();
		
		int numStudents = 10000;
		
		//Test MyArrayList and add performance
		long start = System.nanoTime();
		for (int i = 0; i < numStudents; i++) {
			Student s = new Student("Student" + i, lifestyles[rand.nextInt(lifestyles.length)]);
			arrayList.add(s);
		}
		long end = System.nanoTime();
		long arrayAddTime = end - start;
		
		//Test MyLinkedList and add performance
		start = System.nanoTime();
		for (int i = 0; i < numStudents; i++) {
			Student s = new Student("Student" + i, lifestyles[rand.nextInt(lifestyles.length)]);
			linkedList.add(s);
		}
		end = System.nanoTime();
		long linkedAddTime = end - start;
		
		//Test search performance
		Student target = new Student("Student5000", "Athlete");
		
		start = System.nanoTime();
		boolean arrayContains = arrayList.contains(target);
		end = System.nanoTime();
		long arraySearchTime = end - start;
		
		start = System.nanoTime();
		boolean linkedContains = linkedList.contains(target);
		end = System.nanoTime();
		long linkedSearchTime = end - start;
		
		//Define group members
		Student chelsea = new Student("Chelsea", "Scholar");
		Student kate = new Student("Kate", "Social Butterfly");
		Student karson = new Student("Karson", "Night Owl");
		Student daniel = new Student("Daniel", "Gamer");
		
		Student[] groupMembers = {chelsea, kate, karson, daniel};
		
		//Test add for just 4 group members
		MyArrayList<Student> smallArray = new MyArrayList<>();
		MyLinkedList<Student> smallLinked = new MyLinkedList<>();
		
		start = System.nanoTime();
		for (Student s : groupMembers) smallArray.add(s);
		end = System.nanoTime();
		long smallArrayAddTime = end - start;
		
		start = System.nanoTime();
		for (Student s : groupMembers) smallLinked.add(s);
		end = System.nanoTime();
		long smallLinkedAddTime = end - start;
		
		/*arrayList.add(chelsea);
		arrayList.add(kate);
		arrayList.add(karson);
		arrayList.add(daniel);
		
		linkedList.add(chelsea);
		linkedList.add(kate);
		linkedList.add(karson);
		linkedList.add(daniel);*/
		
		//Display results
		System.out.println("===== Campus Lifestyle Data Structure Test =====");
		System.out.println("Number of students tested: " + numStudents);
		System.out.println();
		System.out.println("ArrayList Add Time (large): " + arrayAddTime + " ns");
		System.out.println("LinkedList Add Time (large): " + linkedAddTime + " ns");
		System.out.println("ArrayList Search Time: " + arraySearchTime + " ns");
		System.out.println("LinkedList Search Time: " + linkedSearchTime + " ns");
		System.out.println();
		System.out.println("ArrayList Add Time (group members): " + smallArrayAddTime + " ns");
		System.out.println("LinkedList Add Time (group members): " + smallLinkedAddTime + " ns");
		System.out.println();
		
		
		//Display group members
		System.out.println("===== Group Members & Their Lifestyles =====");
		
		for (Student s: groupMembers) {
			System.out.println(s);
		}
	}
}
		/*ArrayList<String> list = new ArrayList<>();
		list.add("Chelsea");
		list.add("Kate");
		list.add("Karson");
		list.add("Daniel");
		
		
		System.out.println(list);
		
		String name = list.get(0);
		System.out.println("The name at index 0 is: " + name);
		
		String removeName = list.remove(0);
		System.out.println("The name removed is: " + removeName);
		
		System.out.println(list);
		
		int numPeople = list.size();
		System.out.println("The size is: " + numPeople);
	}*/
