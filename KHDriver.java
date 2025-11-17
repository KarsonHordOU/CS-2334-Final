//KH

import java.util.Random;

public class KHDriver {

    // =========================
    // GLOBAL CONTROLS
    // =========================
    private static final int SIZE = 50000;          // main list size for access tests
    private static final int RANDOM_LOOKUPS = 100;  // random get() calls
    private static final int ADD_FIRST_COUNT = 100; // number of addFirst operations
    private static final int ADD_LAST_COUNT  = 100; // number of extra add() operations

    public static void main(String[] args) {
        runIntegerTests();
        System.out.println();
        runStringTests();
        System.out.println();
        runDoubleTests();
    }

    // =========================
    // INTEGER TESTS
    // =========================
    private static void runIntegerTests() {
        Random generator = new Random();

        KHLinkedList<Integer> list = new KHLinkedList<>();

        // --- Fill list to SIZE (setup, not timed) ---
        for (int i = 0; i < SIZE; i++) {
            Integer number = generator.nextInt(101);
            list.add(number);          // uses add(E), just like your original code
        }

        // --- Test extra add-to-end operations ---
        long startAdd = System.nanoTime();
        for (int i = 0; i < ADD_LAST_COUNT; i++) {
            Integer number = generator.nextInt(101);
            list.add(number);
        }
        long endAdd = System.nanoTime();
        long linkedAddTime = endAdd - startAdd;

        // --- Sequential access of all elements ---
        long startAccess = System.nanoTime();
        for (int i = 0; i < list.getSize(); i++) {
            list.get(i);
        }
        long endAccess = System.nanoTime();
        long linkedAccessTime = endAccess - startAccess;

        // --- Random access (100 lookups) ---
        long startRandomAccess = System.nanoTime();
        for (int i = 0; i < RANDOM_LOOKUPS; i++) {
            int randomIndex = generator.nextInt(list.getSize());
            list.get(randomIndex);
        }
        long endRandomAccess = System.nanoTime();
        long linkedRandomAccessTime = endRandomAccess - startRandomAccess;

        // --- Add to beginning (addFirst) on a fresh list ---
        KHLinkedList<Integer> list2 = new KHLinkedList<>();
        long startAddFirst = System.nanoTime();
        for (int i = 0; i < ADD_FIRST_COUNT; i++) {
            Integer number = generator.nextInt(101);
            list2.addFirst(number);
        }
        long endAddFirst = System.nanoTime();
        long linkedAddFirstTime = endAddFirst - startAddFirst;

        System.out.println("===== Integer KHLinkedList Results =====");
        System.out.println("Integer LinkedList AddFirst Time:     " + linkedAddFirstTime + " ns");
        System.out.println("Integer LinkedList AddLast Time:      " + linkedAddTime + " ns");
        System.out.println("Integer LinkedList Random Access:     " + linkedRandomAccessTime + " ns");
        System.out.println("Integer LinkedList Sequential Access: " + linkedAccessTime + " ns");
    }

    // =========================
    // STRING TESTS
    // =========================
    private static void runStringTests() {
        Random generator = new Random();

        KHLinkedList<String> list = new KHLinkedList<>();

        // Fill list
        for (int i = 0; i < SIZE; i++) {
            String value = "str" + generator.nextInt(101);
            list.add(value);
        }

        // AddLast test
        long startAdd = System.nanoTime();
        for (int i = 0; i < ADD_LAST_COUNT; i++) {
            String value = "str" + generator.nextInt(101);
            list.add(value);
        }
        long endAdd = System.nanoTime();
        long linkedAddTime = endAdd - startAdd;

        // Sequential access
        long startAccess = System.nanoTime();
        for (int i = 0; i < list.getSize(); i++) {
            list.get(i);
        }
        long endAccess = System.nanoTime();
        long linkedAccessTime = endAccess - startAccess;

        // Random access
        long startRandomAccess = System.nanoTime();
        for (int i = 0; i < RANDOM_LOOKUPS; i++) {
            int randomIndex = generator.nextInt(list.getSize());
            list.get(randomIndex);
        }
        long endRandomAccess = System.nanoTime();
        long linkedRandomAccessTime = endRandomAccess - startRandomAccess;

        // AddFirst test
        KHLinkedList<String> list2 = new KHLinkedList<>();
        long startAddFirst = System.nanoTime();
        for (int i = 0; i < ADD_FIRST_COUNT; i++) {
            String value = "str" + generator.nextInt(101);
            list2.addFirst(value);
        }
        long endAddFirst = System.nanoTime();
        long linkedAddFirstTime = endAddFirst - startAddFirst;

        System.out.println("===== String KHLinkedList Results =====");
        System.out.println("String LinkedList AddFirst Time:     " + linkedAddFirstTime + " ns");
        System.out.println("String LinkedList AddLast Time:      " + linkedAddTime + " ns");
        System.out.println("String LinkedList Random Access:     " + linkedRandomAccessTime + " ns");
        System.out.println("String LinkedList Sequential Access: " + linkedAccessTime + " ns");
    }

    // =========================
    // DOUBLE TESTS
    // =========================
    private static void runDoubleTests() {
        Random generator = new Random();

        KHLinkedList<Double> list = new KHLinkedList<>();

        // Fill list
        for (int i = 0; i < SIZE; i++) {
            Double number = generator.nextDouble() * 100.0;
            list.add(number);
        }

        // AddLast test
        long startAdd = System.nanoTime();
        for (int i = 0; i < ADD_LAST_COUNT; i++) {
            Double number = generator.nextDouble() * 100.0;
            list.add(number);
        }
        long endAdd = System.nanoTime();
        long linkedAddTime = endAdd - startAdd;

        // Sequential access
        long startAccess = System.nanoTime();
        for (int i = 0; i < list.getSize(); i++) {
            list.get(i);
        }
        long endAccess = System.nanoTime();
        long linkedAccessTime = endAccess - startAccess;

        // Random access
        long startRandomAccess = System.nanoTime();
        for (int i = 0; i < RANDOM_LOOKUPS; i++) {
            int randomIndex = generator.nextInt(list.getSize());
            list.get(randomIndex);
        }
        long endRandomAccess = System.nanoTime();
        long linkedRandomAccessTime = endRandomAccess - startRandomAccess;

        // AddFirst test
        KHLinkedList<Double> list2 = new KHLinkedList<>();
        long startAddFirst = System.nanoTime();
        for (int i = 0; i < ADD_FIRST_COUNT; i++) {
            Double number = generator.nextDouble() * 100.0;
            list2.addFirst(number);
        }
        long endAddFirst = System.nanoTime();
        long linkedAddFirstTime = endAddFirst - startAddFirst;

        System.out.println("===== Double KHLinkedList Results =====");
        System.out.println("Double LinkedList AddFirst Time:     " + linkedAddFirstTime + " ns");
        System.out.println("Double LinkedList AddLast Time:      " + linkedAddTime + " ns");
        System.out.println("Double LinkedList Random Access:     " + linkedRandomAccessTime + " ns");
        System.out.println("Double LinkedList Sequential Access: " + linkedAccessTime + " ns");
    }
}

