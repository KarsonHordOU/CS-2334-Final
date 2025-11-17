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

    // =========================
    // GLOBAL TEST CONTROLS
    // =========================
    private static final int SIZE = 10000;          // main list size
    private static final int RANDOM_LOOKUPS = 100;  // number of random gets
    private static final int ADD_FIRST_COUNT = 100; // number of addFirst operations
    private static final int ADD_LAST_COUNT  = 100; // number of addLast operations

    // =========================
    // INTEGER TESTS
    // =========================
    private static void runIntegerTests() {
        Random gen = new Random();

        // -------- ArrayList<Integer> --------
        List<Integer> arrayList = new ArrayList<>();

        // Fill to SIZE
        for (int i = 0; i < SIZE; i++)
            arrayList.add(gen.nextInt(101));

        // --- Add Last ---
        long startAddLastArray = System.nanoTime();
        for (int i = 0; i < ADD_LAST_COUNT; i++)
            arrayList.add(gen.nextInt(101));
        long endAddLastArray = System.nanoTime();

        long arrayAddLastTime = endAddLastArray - startAddLastArray;

        // --- Add First ---
        List<Integer> arrayList2 = new ArrayList<>();
        long startAddFirstArray = System.nanoTime();
        for (int i = 0; i < ADD_FIRST_COUNT; i++)
            arrayList2.add(0, gen.nextInt(101));
        long endAddFirstArray = System.nanoTime();

        long arrayAddFirstTime = endAddFirstArray - startAddFirstArray;

        // --- Sequential Access ---
        long startSeqArray = System.nanoTime();
        for (int i = 0; i < arrayList.size(); i++)
            arrayList.get(i);
        long endSeqArray = System.nanoTime();

        long arraySequentialTime = endSeqArray - startSeqArray;

        // --- Random Access ---
        long startRandArray = System.nanoTime();
        for (int i = 0; i < RANDOM_LOOKUPS; i++)
            arrayList.get(gen.nextInt(arrayList.size()));
        long endRandArray = System.nanoTime();

        long arrayRandomTime = endRandArray - startRandArray;

        // -------- LinkedList<Integer> --------
        gen = new Random();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < SIZE; i++)
            linkedList.add(gen.nextInt(101));

        // Add Last
        long startAddLastLinked = System.nanoTime();
        for (int i = 0; i < ADD_LAST_COUNT; i++)
            linkedList.add(gen.nextInt(101));
        long endAddLastLinked = System.nanoTime();

        long linkedAddLastTime = endAddLastLinked - startAddLastLinked;

        // Add First
        List<Integer> linkedList2 = new LinkedList<>();
        long startAddFirstLinked = System.nanoTime();
        for (int i = 0; i < ADD_FIRST_COUNT; i++)
            linkedList2.add(0, gen.nextInt(101));
        long endAddFirstLinked = System.nanoTime();

        long linkedAddFirstTime = endAddFirstLinked - startAddFirstLinked;

        // Sequential
        long startSeqLinked = System.nanoTime();
        for (int i = 0; i < linkedList.size(); i++)
            linkedList.get(i);
        long endSeqLinked = System.nanoTime();

        long linkedSequentialTime = endSeqLinked - startSeqLinked;

        // Random
        long startRandLinked = System.nanoTime();
        for (int i = 0; i < RANDOM_LOOKUPS; i++)
            linkedList.get(gen.nextInt(linkedList.size()));
        long endRandLinked = System.nanoTime();

        long linkedRandomTime = endRandLinked - startRandLinked;

        // Print results
        System.out.println("===== Integer Java API Results =====");
        System.out.println("ArrayList AddFirst Time:   " + arrayAddFirstTime + " ns");
        System.out.println("ArrayList AddLast Time:    " + arrayAddLastTime + " ns");
        System.out.println("ArrayList Sequential Time: " + arraySequentialTime + " ns");
        System.out.println("ArrayList Random Time:     " + arrayRandomTime + " ns \n");

        System.out.println("LinkedList AddFirst Time:   " + linkedAddFirstTime + " ns");
        System.out.println("LinkedList AddLast Time:    " + linkedAddLastTime + " ns");
        System.out.println("LinkedList Sequential Time: " + linkedSequentialTime + " ns");
        System.out.println("LinkedList Random Time:     " + linkedRandomTime + " ns");
    }

    // =========================
    // STRING TESTS
    // =========================
    private static void runStringTests() {
        Random gen = new Random();

        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < SIZE; i++)
            arrayList.add("str" + gen.nextInt(101));

        long startAddLastArray = System.nanoTime();
        for (int i = 0; i < ADD_LAST_COUNT; i++)
            arrayList.add("str" + gen.nextInt(101));
        long arrayAddLastTime = System.nanoTime() - startAddLastArray;

        List<String> arrayList2 = new ArrayList<>();
        long startAddFirstArray = System.nanoTime();
        for (int i = 0; i < ADD_FIRST_COUNT; i++)
            arrayList2.add(0, "str" + gen.nextInt(101));
        long arrayAddFirstTime = System.nanoTime() - startAddFirstArray;

        long startSeqArray = System.nanoTime();
        for (int i = 0; i < arrayList.size(); i++)
            arrayList.get(i);
        long arraySequentialTime = System.nanoTime() - startSeqArray;

        long startRandArray = System.nanoTime();
        for (int i = 0; i < RANDOM_LOOKUPS; i++)
            arrayList.get(gen.nextInt(arrayList.size()));
        long arrayRandomTime = System.nanoTime() - startRandArray;

        // LinkedList<String>
        gen = new Random();
        List<String> linkedList = new LinkedList<>();
        for (int i = 0; i < SIZE; i++)
            linkedList.add("str" + gen.nextInt(101));

        long startAddLastLinked = System.nanoTime();
        for (int i = 0; i < ADD_LAST_COUNT; i++)
            linkedList.add("str" + gen.nextInt(101));
        long linkedAddLastTime = System.nanoTime() - startAddLastLinked;

        List<String> linkedList2 = new LinkedList<>();
        long startAddFirstLinked = System.nanoTime();
        for (int i = 0; i < ADD_FIRST_COUNT; i++)
            linkedList2.add(0, "str" + gen.nextInt(101));
        long linkedAddFirstTime = System.nanoTime() - startAddFirstLinked;

        long startSeqLinked = System.nanoTime();
        for (int i = 0; i < linkedList.size(); i++)
            linkedList.get(i);
        long linkedSequentialTime = System.nanoTime() - startSeqLinked;

        long startRandLinked = System.nanoTime();
        for (int i = 0; i < RANDOM_LOOKUPS; i++)
            linkedList.get(gen.nextInt(linkedList.size()));
        long linkedRandomTime = System.nanoTime() - startRandLinked;

        System.out.println("===== String Java API Results =====");
        System.out.println("ArrayList<String> AddFirst Time:   " + arrayAddFirstTime + " ns");
        System.out.println("ArrayList<String> AddLast Time:    " + arrayAddLastTime + " ns");
        System.out.println("ArrayList<String> Sequential Time: " + arraySequentialTime + " ns");
        System.out.println("ArrayList<String> Random Time:     " + arrayRandomTime + " ns \n");

        System.out.println("LinkedList<String> AddFirst Time:   " + linkedAddFirstTime + " ns");
        System.out.println("LinkedList<String> AddLast Time:    " + linkedAddLastTime + " ns");
        System.out.println("LinkedList<String> Sequential Time: " + linkedSequentialTime + " ns");
        System.out.println("LinkedList<String> Random Time:     " + linkedRandomTime + " ns");
    }

    // =========================
    // DOUBLE TESTS
    // =========================
    private static void runDoubleTests() {
        Random gen = new Random();

        List<Double> arrayList = new ArrayList<>();
        for (int i = 0; i < SIZE; i++)
            arrayList.add(gen.nextDouble() * 100);

        long startAddLastArray = System.nanoTime();
        for (int i = 0; i < ADD_LAST_COUNT; i++)
            arrayList.add(gen.nextDouble() * 100);
        long arrayAddLastTime = System.nanoTime() - startAddLastArray;

        List<Double> arrayList2 = new ArrayList<>();
        long startAddFirstArray = System.nanoTime();
        for (int i = 0; i < ADD_FIRST_COUNT; i++)
            arrayList2.add(0, gen.nextDouble() * 100);
        long arrayAddFirstTime = System.nanoTime() - startAddFirstArray;

        long startSeqArray = System.nanoTime();
        for (int i = 0; i < arrayList.size(); i++)
            arrayList.get(i);
        long arraySequentialTime = System.nanoTime() - startSeqArray;

        long startRandArray = System.nanoTime();
        for (int i = 0; i < RANDOM_LOOKUPS; i++)
            arrayList.get(gen.nextInt(arrayList.size()));
        long arrayRandomTime = System.nanoTime() - startRandArray;

        // LinkedList<Double>
        gen = new Random();
        List<Double> linkedList = new LinkedList<>();
        for (int i = 0; i < SIZE; i++)
            linkedList.add(gen.nextDouble() * 100);

        long startAddLastLinked = System.nanoTime();
        for (int i = 0; i < ADD_LAST_COUNT; i++)
            linkedList.add(gen.nextDouble() * 100);
        long linkedAddLastTime = System.nanoTime() - startAddLastLinked;

        List<Double> linkedList2 = new LinkedList<>();
        long startAddFirstLinked = System.nanoTime();
        for (int i = 0; i < ADD_FIRST_COUNT; i++)
            linkedList2.add(0, gen.nextDouble() * 100);
        long linkedAddFirstTime = System.nanoTime() - startAddFirstLinked;

        long startSeqLinked = System.nanoTime();
        for (int i = 0; i < linkedList.size(); i++)
            linkedList.get(i);
        long linkedSequentialTime = System.nanoTime() - startSeqLinked;

        long startRandLinked = System.nanoTime();
        for (int i = 0; i < RANDOM_LOOKUPS; i++)
            linkedList.get(gen.nextInt(linkedList.size()));
        long linkedRandomTime = System.nanoTime() - startRandLinked;

        System.out.println("===== Double Java API Results =====");
        System.out.println("ArrayList<Double> AddFirst Time:   " + arrayAddFirstTime + " ns");
        System.out.println("ArrayList<Double> AddLast Time:    " + arrayAddLastTime + " ns");
        System.out.println("ArrayList<Double> Sequential Time: " + arraySequentialTime + " ns");
        System.out.println("ArrayList<Double> Random Time:     " + arrayRandomTime + " ns \n");

        System.out.println("LinkedList<Double> AddFirst Time:   " + linkedAddFirstTime + " ns");
        System.out.println("LinkedList<Double> AddLast Time:    " + linkedAddLastTime + " ns");
        System.out.println("LinkedList<Double> Sequential Time: " + linkedSequentialTime + " ns");
        System.out.println("LinkedList<Double> Random Time:     " + linkedRandomTime + " ns");
    }
}





