//KH

import java.util.Random;

public class KHDriver {

    public static void main(String[] args) {
        runIntegerTests();
        System.out.println();
        runStringTests();
        System.out.println();
        runDoubleTests();
    }

    // =========================
    // Integer tests 
    // =========================
    private static void runIntegerTests() {
        KHLinkedList<Integer> list = new KHLinkedList<>();
        Random generator = new Random();

        // Test speed of adding numbers to the end
        long startAdd = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            Integer number = generator.nextInt(101);
            list.add(number);
        }
        long endAdd = System.nanoTime();
        long linkedAddTime = endAdd - startAdd;

        // Test speed of sequential access of all elements
        long startAccess = System.nanoTime();
        Integer target = 100;
        for (int i = 0; i < list.getSize(); i++) {
            if (list.get(i).equals(target)) {
                //System.out.println("Target " + target + " found at index: " + i);
            }
        }
        long endAccess = System.nanoTime();
        long linkedAccessTime = endAccess - startAccess;

        // Test speed of accessing elements at random using 100 lookups
        long startRandomAccess = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            int randomIndex = generator.nextInt(list.getSize());
            Object foundElement = list.get(randomIndex);
            //System.out.println("Number " + foundElement + " found at index: " + randomIndex);
        }
        long endRandomAccess = System.nanoTime();
        long linkedRandomAccessTime = endRandomAccess - startRandomAccess;

        // Test adding numbers to the beginning
        KHLinkedList<Integer> list2 = new KHLinkedList<>();
        long startAddFirst = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            Integer number = generator.nextInt(101);
            list2.addFirst(number);
        }
        long endAddFirst = System.nanoTime();
        long linkedAddFirstTime = endAddFirst - startAddFirst;

        System.out.println("===== Integer LinkedList Results =====");
        System.out.println("Integer LinkedList AddFirst Time: " + linkedAddFirstTime + " ns");
        System.out.println("Integer LinkedList Add Last Time: " + linkedAddTime + " ns");
        System.out.println("Integer LinkedList Random Access Time: " + linkedRandomAccessTime + " ns");
        System.out.println("Integer LinkedList Sequential Access Time: " + linkedAccessTime + " ns");
    }

    // =========================
    // String tests
    // =========================
    private static void runStringTests() {
        KHLinkedList<String> list = new KHLinkedList<>();
        Random generator = new Random();

        // Test speed of adding strings to the end
        long startAdd = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            int num = generator.nextInt(101);
            String value = "str" + num;
            list.add(value);
        }
        long endAdd = System.nanoTime();
        long linkedAddTime = endAdd - startAdd;

        // Test speed of sequential access of all elements
        long startAccess = System.nanoTime();
        String target = "str100";
        for (int i = 0; i < list.getSize(); i++) {
            if (list.get(i).equals(target)) {
                //System.out.println("Target " + target + " found at index: " + i);
            }
        }
        long endAccess = System.nanoTime();
        long linkedAccessTime = endAccess - startAccess;

        // Test speed of accessing elements at random using 100 lookups
        long startRandomAccess = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            int randomIndex = generator.nextInt(list.getSize());
            Object foundElement = list.get(randomIndex);
            //System.out.println("String " + foundElement + " found at index: " + randomIndex);
        }
        long endRandomAccess = System.nanoTime();
        long linkedRandomAccessTime = endRandomAccess - startRandomAccess;

        // Test adding strings to the beginning
        KHLinkedList<String> list2 = new KHLinkedList<>();
        long startAddFirst = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            int num = generator.nextInt(101);
            String value = "str" + num;
            list2.addFirst(value);
        }
        long endAddFirst = System.nanoTime();
        long linkedAddFirstTime = endAddFirst - startAddFirst;

        System.out.println("===== String LinkedList Results =====");
        System.out.println("String LinkedList AddFirst Time: " + linkedAddFirstTime + " ns");
        System.out.println("String LinkedList Add Last Time: " + linkedAddTime + " ns");
        System.out.println("String LinkedList Random Access Time: " + linkedRandomAccessTime + " ns");
        System.out.println("String LinkedList Sequential Access Time: " + linkedAccessTime + " ns");
    }

    // =========================
    // Double tests
    // =========================
    private static void runDoubleTests() {
        KHLinkedList<Double> list = new KHLinkedList<>();
        Random generator = new Random();

        // Test speed of adding doubles to the end
        long startAdd = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            // random double between 0 and 100
            Double number = generator.nextDouble() * 100.0;
            list.add(number);
        }
        long endAdd = System.nanoTime();
        long linkedAddTime = endAdd - startAdd;

        // Test speed of sequential access of all elements
        long startAccess = System.nanoTime();
        Double target = 50.0;
        for (int i = 0; i < list.getSize(); i++) {
            if (list.get(i).equals(target)) {
                //System.out.println("Target " + target + " found at index: " + i);
            }
        }
        long endAccess = System.nanoTime();
        long linkedAccessTime = endAccess - startAccess;

        // Test speed of accessing elements at random using 100 lookups
        long startRandomAccess = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            int randomIndex = generator.nextInt(list.getSize());
            Object foundElement = list.get(randomIndex);
            //System.out.println("Double " + foundElement + " found at index: " + randomIndex);
        }
        long endRandomAccess = System.nanoTime();
        long linkedRandomAccessTime = endRandomAccess - startRandomAccess;

        // Test adding doubles to the beginning
        KHLinkedList<Double> list2 = new KHLinkedList<>();
        long startAddFirst = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            Double number = generator.nextDouble() * 100.0;
            list2.addFirst(number);
        }
        long endAddFirst = System.nanoTime();
        long linkedAddFirstTime = endAddFirst - startAddFirst;

        System.out.println("===== Double LinkedList Results =====");
        System.out.println("Double LinkedList AddFirst Time: " + linkedAddFirstTime + " ns");
        System.out.println("Double LinkedList Add Last Time: " + linkedAddTime + " ns");
        System.out.println("Double LinkedList Random Access Time: " + linkedRandomAccessTime + " ns");
        System.out.println("Double LinkedList Sequential Access Time: " + linkedAccessTime + " ns");
    }
}


