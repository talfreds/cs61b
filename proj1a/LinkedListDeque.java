public class LinkedListDeque<T> {
    private DequeNode sentinel;
    private int size;

    public class DequeNode {
        public DequeNode prev;
        public T item;
        public DequeNode next;

        public DequeNode(DequeNode p, T i, DequeNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    // Creates an empty linked list deque
    public LinkedListDeque() {
        sentinel = new DequeNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        sentinel.next = new DequeNode(sentinel.next.prev, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    // Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        sentinel.prev = new DequeNode(sentinel.prev, item, sentinel.prev.next);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        if (sentinel.next.item == null && sentinel.prev.item == null) {
            return true;
        } else {
            return false;
        }
    }

    // Returns the number of items in the deque.
    public int size() {
        return size;
    }

    // Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        DequeNode ptr = sentinel;
        while (ptr.next.item != null) {
            System.out.print(ptr.next.item + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    // Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst() {
        T i = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return  i;
    }

    // Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast() {
        T i = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return i;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        DequeNode ptr = sentinel.next;
        int i = 0;
        while (i < index) {
            ptr = ptr.next;
            i++;
        }
        return ptr.item;
    }

    public T getRecursiveHelper(DequeNode ptr, int i) {
        if (i == 0) {
            return ptr.item;
        } else {
            return getRecursiveHelper(ptr.next, i - 1);
        }
    }

    // Same as get, but uses recursion.
    public T getRecursive(int index) {
        if (index > size) {
            return null;
        } else {
            return getRecursiveHelper(sentinel.next, index);
        }
    }



}
