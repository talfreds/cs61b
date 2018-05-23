public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    // Creates an empty array deque.
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public int minusOne(int index) {
        if (index == 0) {
            return (items.length - 1);
        } else {
            return (index - 1);
        }
    }

    public int plusOne(int index) {
        if (index == items.length - 1) {
            return 0;
        } else {
            return (index + 1);
        }
    }

    public void incrSize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, nextLast, a, 0, size - nextLast);
        System.arraycopy(items, 0, a, size - nextLast, nextLast);

        items = a;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    public void decrSize(int capacity) {
        T[] a = (T[]) new Object[capacity];

        if (items[0] == null) {
            System.arraycopy(items, plusOne(nextFirst), a, 0, size);
        } else {
            System.arraycopy(items, plusOne(nextFirst), a, 0, items.length - plusOne(nextFirst));
            System.arraycopy(items, 0, a, items.length - plusOne(nextFirst), nextLast);
        }

        items = a;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        if (size == items.length) {
            incrSize(size * 2);
        }

        items[nextFirst] = item;
        size++;
        nextFirst = minusOne(nextFirst);
    }

    // Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        if (size == items.length) {
            incrSize(size * 2);
        }

        items[nextLast] = item;
        size++;
        nextLast = plusOne(nextLast);
    }

    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return (size == 0);
    }

    // Returns the number of items in the deque.
    public int size() {
        return size;
    }

    // Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        int front = plusOne(nextFirst);
        int back = minusOne(nextLast);
        while (front != back) {
            System.out.print(items[front] + " ");
            front = plusOne(front);
        }
        System.out.println(items[front]);
    }

    // Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst() {
        int front = plusOne(nextFirst);
        T rmv = items[front];
        items[front] = null;
        nextFirst = front;
        size--;


        if (items.length >= 16 && size / (double)items.length < 0.25) {
            decrSize(items.length / 2);
        }

        return rmv;
    }

    // Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast() {
        int end = minusOne(nextLast);
        T rmv = items[end];
        items[end] = null;
        nextLast = end;
        size--;

        if (items.length >= 16 && size / (double)items.length < 0.25) {
            decrSize(items.length / 2);
        }

        return rmv;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        int front = plusOne(nextFirst);

        return items[(front + index) % (items.length)];
    }
}
