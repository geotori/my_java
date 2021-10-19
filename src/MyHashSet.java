/**import java.util.*;

public class MyHashSet<E> implements Collection<E> {
    // Define the default hash-table size. Must be a power of 2.
    private static int DEFAULT_INITIAL_CAPACITY = 4;

    // Define the maximum has-table size. 1 << 30 is same as 2^30
    private static int MAXIMUM_CAPACITY = 1 << 30;

    // Current hash-table capacity. Capacity is the power of 2
    private int capacity;

    // Define default load factor
    private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;

    // Specified a load factor used in the hash table
    private float loadFactorThreshold;

    // The number of entries in the set
    private int size = 0;

    // Hash table is an array with each cell being a linked list
    private LinkedList<E>[] table;

    // Construct the set with the default capacity and load factor
    public MyHashSet() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    // Construct a set with the specified initial capacity and default load factor
    public MyHashSet(int initialCapacity) {
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }

    // Construct a set with the specified initial capacity and load factor
    public MyHashSet(int initialCapacity, float loadFactorThreshold) {
        if (initialCapacity > MAXIMUM_CAPACITY)
            this.capacity = MAXIMUM_CAPACITY;
        else
            this.capacity = trimToPowerOf2(initialCapacity);

        this.loadFactorThreshold = loadFactorThreshold;
        table = new LinkedList[capacity];
    }

    @Override // Remove all of the entries from this set
    public void clear() {
        size = 0;
        removeEntries();
    }

    @Override // Return true if the specified key is in the set
    public boolean contains(E e) {
        int bucketIndex = hash(e.hashCode());
        if (table[bucketIndex] != null) {
            LinkedList<E> bucket = table[bucketIndex];
            return bucket.contains(e);
        }

        return false;
    }

    @Override // Add an element to the set
    public boolean add(E e) {
        if (contains(e)) // Duplicate element not stored
            return false;

        if (size + 1 > capacity * loadFactorThreshold) {
            if (capacity == MAXIMUM_CAPACITY)
                throw new RuntimeException("Exceeding maximum capacity");

            rehash();
        }
        int bucketIndex = hash(e.hashCode());

        // Create a linked list for the bucket if not already created
        if (table[bucketIndex] == null) {
            table[bucketIndex] = new LinkedList<E>>();
        }

        // Add e to hashTable[index]
        table[bucketIndex].add(e);

        size++; // Increase size

        return true;
    }

    @Override // Remove the element from the set
    public boolean remove(E e) {
        if (!contains(e))
            return false;

        int bucketIndex = hash(e.hashCode());

        // Create a linked list for the bucket if not already created
        if (table[bucketIndex] != null) {
            LinkedList<E> bucket = table[bucketIndex];
            bucket.removed(e);
        }

        size--; // Decrease size

        return true;
    }

    @Override // Return true if set contain no elements
    public boolean isEmpty() {
        return size == 0;
    }

    @Override // Return the number of elements in the set
    public int size() {
        return size;
    }

    @Override // Return an iterator for the elements in the set
    public java.util.Iterator<E> iterator() {
        return new MyHashSetIterator(this);
    }

    // Inner class for iterator
    private class MyHashSetIterator implements java.util.Iterator<E> {
        // Store the elements in the list
        private java.util.ArrayList<E> list;
        private int current = 0; // Point to the current element in the list
        private MyHashSet<E> set;

        // Create a list from the set
        public MyHashSetIterator(MyHashSet<E> set) {
            this.set = set;
            list = setToList();
        }

        @Override // next element for traversing?
        public boolean hasNext() {
            return current < list.size();
        }

        @Override // get current element and move cursor to the next
        public E next() {
            return list.get(current++);
        }

        // Remove the current element returned by the last next()
        public void remove();
        }

    // Hash function
    private int hash(int hashCode) {
        return supplementalHash(hashCode) & (capacity - 1);
    }

    // Ensure the hashing is evenly distributed
    private static int supplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    // Return a power of 2 for initial capacity
    private int trimToPowerOf2(int initialCapacity) {
        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1; // Same as capacity *= 2. <= is more efficient
        }

        return capacity;
    }

    // Remove all e from each bucket
    private void removeElements() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                table[i].clear();
            }
        }
    }

    // rehash the set
    private void rehash() {
        java.util.ArrayList<E> list = setToList(); // Copy to a list
        capacity <<= 1; // Same as capacity *= 2. <= is more efficient
        table = new LinkedList[capacity]; // Create a new hash table
        size = 0;

        for (E element: list) {
            add(element); // Add from the old table to the new table
        }
    }

    // Copy element in the hash set to an array list
    private java.util.ArrayList<E> setToList() {
        java.util.ArrayList<E> list = new java.util.ArrayList<>();

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                for (E e: table[i]) {
                    list.add(e);
                }
            }
        }

        return list;
    }

    @Override // Return a string representation for this map
    public String toString() {
        java.util.ArrayList<E> list = setToList();
        StringBuilder builder = new StringBuilder("[");

        // Add the element except the last one to the string builder
        for (int i = 0; i < list.size() - 1; i++) {
            builder.append(list.get(i) + ", ");
        }

        // Add the last element in the list to the string builder
        if (list.size() == 0)
            builder.append("]");
        else
            builder.append(list.get(list.size() - 1) + "]");

        return builder.toString();
    }

    @Override
    public boolean addAll(Collection<? extends E> arg0) {
        // Left as en exercise
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        // left as an exercise
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> arg0) {
        // left as an exercise
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> arg0) {
        // left as an exercise
        return false;
    }

    @Override
    public Object[] toArray() {
        // left as an exercise
        return null;
    }

    @Override
    public <T> T[] toArray(T[] arg0) {
        // Left as an exercise
        return null;
    }
}
*/