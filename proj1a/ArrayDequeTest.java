/** Performs some basic array tests. */
public class ArrayDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkGet(String expected, String actual) {
        if (expected != actual) {
            System.out.println("get() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the array, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("----> Running add/isEmpty/Size test.");

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("----> Running add/remove test.");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        printTestStatus(passed);
    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void resizeTest() {

        System.out.println("----> Running resize test.");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        lld1.addFirst(9);
        lld1.addFirst(8);
        lld1.addFirst(7);
        lld1.addFirst(6);
        lld1.addFirst(5);
        lld1.addFirst(4);
        lld1.addFirst(3);
        lld1.addFirst(2);
        lld1.addFirst(1);

        lld1.printDeque();
        // index: 0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15
        // items: 3  4  5  6  7  8  9  10                    --> 1   2

        lld1.removeFirst();
        lld1.removeFirst();
        lld1.removeFirst();
        lld1.removeFirst();
        lld1.removeFirst();
        lld1.removeFirst();
        lld1.removeFirst();

        lld1.printDeque();
        // index: 0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15
        // items:            --> 8  9  10
        // index: 0  1  2  3  4  5  6  7
        // items: 8  9  10


        ArrayDeque<Integer> lld2 = new ArrayDeque<Integer>();

        lld2.addFirst(10);
        lld2.addFirst(9);
        lld2.addFirst(8);
        lld2.addFirst(7);
        lld2.addFirst(6);
        lld2.addFirst(5);
        lld2.addFirst(4);
        lld2.addFirst(3);
        lld2.addFirst(2);
        lld2.addFirst(1);

        lld2.printDeque();
        // index: 0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15
        // items: 3  4  5  6  7  8  9  10                    --> 1   2

        lld2.removeLast();
        lld2.removeLast();
        lld2.removeLast();
        lld2.removeLast();
        lld2.removeLast();
        lld2.removeLast();
        lld2.removeLast();

        lld2.printDeque();
        // index: 0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15
        // items: 3                                          --> 1   2
        // index: 0  1  2  3  4  5  6  7
        // items: 1  2  3

        printTestStatus(passed);

    }


    public static void myTest() {
        System.out.println("----> Running myTest.");

        ArrayDeque<String> lld1 = new ArrayDeque<String>();


        lld1.addFirst("first1");
        lld1.addFirst("first2");
        lld1.addFirst("first3");
        lld1.addFirst("first4");


        lld1.addLast("back1");
        lld1.addLast("back2");
        lld1.addLast("back3");
        lld1.addLast("back4");


        System.out.println("Printing out deque: ");
        lld1.printDeque();


        lld1.addLast("ResizedLast");
        lld1.addFirst("ResizedFirst");
        System.out.println("Printing out resized deque: ");
        lld1.printDeque();

        boolean passed = checkGet("first3", lld1.get(2));

        lld1.removeFirst();
        lld1.removeFirst();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();
        lld1.printDeque();

        printTestStatus(passed);

    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        resizeTest();
        myTest();
    }
}