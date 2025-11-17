//KH

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class KHJavaAPIDriver {

    public static void main(String[] args) {
        runIntegerTests();
        System.out.println();
        runStringTests();
        System.out.println();
        runDoubleTests();
    }

    // Common parameters
    private static final int ADD_LAST_SIZE = 50000;    // how many to add at the end
    private static final int ADD_FIRST_SIZE = 10000;   // how many to add at the beginning
    private static final int RANDOM_LOOKUPS = 100;     // how many random accesses

    // =========================
    // Integer tests
    // =========================
    private static void runIntegerTests() {
        Random generator = new Random();

        // -------- ArrayList<Integer> --------
        List<Integer> arrayList = new ArrayList<>();

        // Add to end
        long startAddArray = System.nanoTime();
        for (int i = 0; i < ADD_LAST_SIZE; i++) {
            Integer number = generator.nextInt(101);
            arrayList.add(number);
        }
        long endAddArray = System.nanoTime();
        long arrayAddLastTime = endAddArray - startAddArray;

        // Sequential access
        long startAccessArray = System.nanoTime();
        Integer targetInt = 100;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(targetInt)) {
                // System.out.println("ArrayList<Integer>: Target " + targetInt + " found at index: " + i);
            }
        }
        long endAccessArray = System.nanoTime();
        long arraySequentialAccessTime = endAccessArray - startAccessArray;

        // Random access (100 lookups)
        long startRandomAccessArray = System.nanoTime();
        for (int i = 0; i < RANDOM_LOOKUPS; i++) {
            int randomIndex = generator.nextInt(arrayList.size());
            Integer foundElement = arrayList.get(randomIndex);
            // System.out.println("ArrayList<Integer>: " + foundElement + " at index " + randomIndex);
        }
        long endRandomAccessArray = System.nanoTime();
        long arrayRandomAccessTime = endRandomAccessArray - startRandomAccessArray;

        // Add to beginning (addFirst style)
        List<Integer> arrayList2 = new ArrayList<>();
        long startAddFirstArray = System.nanoTime();
        for (int i = 0; i < ADD_FIRST_SIZE; i++) {
            Integer number = generator.nextInt(101);
            arrayList2.add(0, number);
        }
        long endAddFirstArray = System.nanoTime();
        long arrayAddFirstTime = endAddFirstArray - startAddFirstArray;


        // -------- LinkedList<Integer> --------
        generator = new Random(); // reset to keep things comparable
        List<Integer> linkedList = new LinkedList<>();

        // Add to end
        long startAddLinked = System.nanoTime();
        for (int i = 0; i < ADD_LAST_SIZE; i++) {
            Integer number = generator.nextInt(101);
            linkedList.add(number);
        }
        long endAddLinked = System.nanoTime();
        long linkedAddLastTime = endAddLinked - startAddLinked;

        // Sequential access
        long startAccessLinked = System.nanoTime();
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).equals(targetInt)) {
                // System.out.println("LinkedList<Integer>: Target " + targetInt + " found at index: " + i);
            }
        }
        long endAccessLinked = System.nanoTime();
        long linkedSequentialAccessTime = endAccessLinked - startAccessLinked;

        // Random access (100 lookups)
        long startRandomAccessLinked = System.nanoTime();
        for (int i = 0; i < RANDOM_LOOKUPS; i++) {
            int randomIndex = generator.nextInt(linkedList.size());
            Integer foundElement = linkedList.get(randomIndex);
            // System.out.println("LinkedList<Integer>: " + foundElement + " at index " + randomIndex);
        }
        long endRandomAccessLinked = System.nanoTime();
        long linkedRandomAccessTime = endRandomAccessLinked - startRandomAccessLinked;

        // Add to beginning (addFirst style)
        List<Integer> linkedList2 = new LinkedList<>();
        long startAddFirstLinked = System.nanoTime();
        for (int i = 0; i < ADD_FIRST_SIZE; i++) {
            Integer number = generator.nextInt(101);
            linkedList2.add(0, number);
        }
        long endAddFirstLinked = System.nanoTime();
        long linkedAddFirstTime = endAddFirstLinked - startAddFirstLinked;


        // -------- Print results --------
        System.out.println("===== Integer Java API Results =====");
        System.out.println("ArrayList<Integer> AddFirst Time: " + arrayAddFirstTime + " ns");
        System.out.println("ArrayList<Integer> Add Last Time: " + arrayAddLastTime + " ns");
        System.out.println("ArrayList<Integer> Random Access Time: " + arrayRandomAccessTime + " ns");
        System.out.println("ArrayList<Integer> Sequential Access Time: " + arraySequentialAccessTime + " ns \n");

        System.out.println("LinkedList<Integer> AddFirst Time: " + linkedAddFirstTime + " ns");
        System.out.println("LinkedList<Integer> Add Last Time: " + linkedAddLastTime + " ns");
        System.out.println("LinkedList<Integer> Random Access Time: " + linkedRandomAccessTime + " ns");
        System.out.println("LinkedList<Integer> Sequential Access Time: " + linkedSequentialAccessTime + " ns");
    }

    // =========================
    // String tests
    // =========================
    private static void runStringTests() {
        Random generator = new Random();

        // -------- ArrayList<String> --------
        List<String> arrayList = new ArrayList<>();

        // Add to end
        long startAddArray = System.nanoTime();
        for (int i = 0; i < ADD_LAST_SIZE; i++) {
            int num = generator.nextInt(101);
            String value = "str" + num;
            arrayList.add(value);
        }
        long endAddArray = System.nanoTime();
        long arrayAddLastTime = endAddArray - startAddArray;

        // Sequential access
        long startAccessArray = System.nanoTime();
        String targetStr = "str100";
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(targetStr)) {
                // System.out.println("ArrayList<String>: Target " + targetStr + " found at index: " + i);
            }
        }
        long endAccessArray = System.nanoTime();
        long arraySequentialAccessTime = endAccessArray - startAccessArray;

        // Random access (100 lookups)
        long startRandomAccessArray = System.nanoTime();
        for (int i = 0; i < RANDOM_LOOKUPS; i++) {
            int randomIndex = generator.nextInt(arrayList.size());
            String foundElement = arrayList.get(randomIndex);
            // System.out.println("ArrayList<String>: " + foundElement + " at index " + randomIndex);
        }
        long endRandomAccessArray = System.nanoTime();
        long arrayRandomAccessTime = endRandomAccessArray - startRandomAccessArray;

        // Add to beginning
        List<String> arrayList2 = new ArrayList<>();
        long startAddFirstArray = System.nanoTime();
        for (int i = 0; i < ADD_FIRST_SIZE; i++) {
            int num = generator.nextInt(101);
            String value = "str" + num;
            arrayList2.add(0, value);
        }
        long endAddFirstArray = System.nanoTime();
        long arrayAddFirstTime = endAddFirstArray - startAddFirstArray;


        // -------- LinkedList<String> --------
        generator = new Random(); // reset
        List<String> linkedList = new LinkedList<>();

        // Add to end
        long startAddLinked = System.nanoTime();
        for (int i = 0; i < ADD_LAST_SIZE; i++) {
            int num = generator.nextInt(101);
            String value = "str" + num;
            linkedList.add(value);
        }
        long endAddLinked = System.nanoTime();
        long linkedAddLastTime = endAddLinked - startAddLinked;

        // Sequential access
        long startAccessLinked = System.nanoTime();
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).equals(targetStr)) {
                // System.out.println("LinkedList<String>: Target " + targetStr + " found at index: " + i);
            }
        }
        long endAccessLinked = System.nanoTime();
        long linkedSequentialAccessTime = endAccessLinked - startAccessLinked;

        // Random access (100 lookups)
        long startRandomAccessLinked = System.nanoTime();
        for (int i = 0; i < RANDOM_LOOKUPS; i++) {
            int randomIndex = generator.nextInt(linkedList.size());
            String foundElement = linkedList.get(randomIndex);
            // System.out.println("LinkedList<String>: " + foundElement + " at index " + randomIndex);
        }
        long endRandomAccessLinked = System.nanoTime();
        long linkedRandomAccessTime = endRandomAccessLinked - startRandomAccessLinked;

        // Add to beginning
        List<String> linkedList2 = new LinkedList<>();
        long startAddFirstLinked = System.nanoTime();
        for (int i = 0; i < ADD_FIRST_SIZE; i++) {
            int num = generator.nextInt(101);
            String value = "str" + num;
            linkedList2.add(0, value);
        }
        long endAddFirstLinked = System.nanoTime();
        long linkedAddFirstTime = endAddFirstLinked - startAddFirstLinked;


        // -------- Print results --------
        System.out.println("===== String Java API Results =====");
        System.out.println("ArrayList<String> AddFirst Time: " + arrayAddFirstTime + " ns");
        System.out.println("ArrayList<String> Add Last Time: " + arrayAddLastTime + " ns");
        System.out.println("ArrayList<String> Random Access Time: " + arrayRandomAccessTime + " ns");
        System.out.println("ArrayList<String> Sequential Access Time: " + arraySequentialAccessTime + " ns \n");

        System.out.println("LinkedList<String> AddFirst Time: " + linkedAddFirstTime + " ns");
        System.out.println("LinkedList<String> Add Last Time: " + linkedAddLastTime + " ns");
        System.out.println("LinkedList<String> Random Access Time: " + linkedRandomAccessTime + " ns");
        System.out.println("LinkedList<String> Sequential Access Time: " + linkedSequentialAccessTime + " ns");
    }

    // =========================
    // Double tests
    // =========================
    private static void runDoubleTests() {
        Random generator = new Random();

        // -------- ArrayList<Double> --------
        List<Double> arrayList = new ArrayList<>();

        // Add to end
        long startAddArray = System.nanoTime();
        for (int i = 0; i < ADD_LAST_SIZE; i++) {
            Double number = generator.nextDouble() * 100.0; // 0 to 100
            arrayList.add(number);
        }
        long endAddArray = System.nanoTime();
        long arrayAddLastTime = endAddArray - startAddArray;

        // Sequential access
        long startAccessArray = System.nanoTime();
        Double targetDouble = 50.0; // probably not found exactly, but fine for timing
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(targetDouble)) {
                // System.out.println("ArrayList<Double>: Target " + targetDouble + " found at index: " + i);
            }
        }
        long endAccessArray = System.nanoTime();
        long arraySequentialAccessTime = endAccessArray - startAccessArray;

        // Random access (100 lookups)
        long startRandomAccessArray = System.nanoTime();
        for (int i = 0; i < RANDOM_LOOKUPS; i++) {
            int randomIndex = generator.nextInt(arrayList.size());
            Double foundElement = arrayList.get(randomIndex);
            // System.out.println("ArrayList<Double>: " + foundElement + " at index " + randomIndex);
        }
        long endRandomAccessArray = System.nanoTime();
        long arrayRandomAccessTime = endRandomAccessArray - startRandomAccessArray;

        // Add to beginning
        List<Double> arrayList2 = new ArrayList<>();
        long startAddFirstArray = System.nanoTime();
        for (int i = 0; i < ADD_FIRST_SIZE; i++) {
            Double number = generator.nextDouble() * 100.0;
            arrayList2.add(0, number);
        }
        long endAddFirstArray = System.nanoTime();
        long arrayAddFirstTime = endAddFirstArray - startAddFirstArray;


        // -------- LinkedList<Double> --------
        generator = new Random(); // reset
        List<Double> linkedList = new LinkedList<>();

        // Add to end
        long startAddLinked = System.nanoTime();
        for (int i = 0; i < ADD_LAST_SIZE; i++) {
            Double number = generator.nextDouble() * 100.0;
            linkedList.add(number);
        }
        long endAddLinked = System.nanoTime();
        long linkedAddLastTime = endAddLinked - startAddLinked;

        // Sequential access
        long startAccessLinked = System.nanoTime();
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).equals(targetDouble)) {
                // System.out.println("LinkedList<Double>: Target " + targetDouble + " found at index: " + i);
            }
        }
        long endAccessLinked = System.nanoTime();
        long linkedSequentialAccessTime = endAccessLinked - startAccessLinked;

        // Random access (100 lookups)
        long startRandomAccessLinked = System.nanoTime();
        for (int i = 0; i < RANDOM_LOOKUPS; i++) {
            int randomIndex = generator.nextInt(linkedList.size());
            Double foundElement = linkedList.get(randomIndex);
            // System.out.println("LinkedList<Double>: " + foundElement + " at index " + randomIndex);
        }
        long endRandomAccessLinked = System.nanoTime();
        long linkedRandomAccessTime = endRandomAccessLinked - startRandomAccessLinked;

        // Add to beginning
        List<Double> linkedList2 = new LinkedList<>();
        long startAddFirstLinked = System.nanoTime();
        for (int i = 0; i < ADD_FIRST_SIZE; i++) {
            Double number = generator.nextDouble() * 100.0;
            linkedList2.add(0, number);
        }
        long endAddFirstLinked = System.nanoTime();
        long linkedAddFirstTime = endAddFirstLinked - startAddFirstLinked;


        // -------- Print results --------
        System.out.println("===== Double Java API Results =====");
        System.out.println("ArrayList<Double> AddFirst Time: " + arrayAddFirstTime + " ns");
        System.out.println("ArrayList<Double> Add Last Time: " + arrayAddLastTime + " ns");
        System.out.println("ArrayList<Double> Random Access Time: " + arrayRandomAccessTime + " ns");
        System.out.println("ArrayList<Double> Sequential Access Time: " + arraySequentialAccessTime + " ns \n");

        System.out.println("LinkedList<Double> AddFirst Time: " + linkedAddFirstTime + " ns");
        System.out.println("LinkedList<Double> Add Last Time: " + linkedAddLastTime + " ns");
        System.out.println("LinkedList<Double> Random Access Time: " + linkedRandomAccessTime + " ns");
        System.out.println("LinkedList<Double> Sequential Access Time: " + linkedSequentialAccessTime + " ns");
    }
}




