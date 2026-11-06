/*
 * Name: Noah Teng
 * Email: noteng@ucsd.edu
 * TSN: 200326335
 * Sources Used: zybooks reading, in-class notes, w3schools
 */

/**
 * MyHashMap
 * 
 * Instances:
 * hashTable: The underlying array for the hash table.
 * size: The number of (key, value) pairs currently in the hash table.
 * 
 * MyHashMap
 * 
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 5;
    private static final double LOAD_FACTOR = 0.8;
    private static final int EXPAND_CAPACITY_RATIO = 2;
    private static final int HASH_CODE_MASK = 0x7fffffff;

    Node[] hashTable;
    int size;
    boolean collisionYes;

    @SuppressWarnings("unchecked")
    public K someMethod() {
        return (K) hashTable[0];
    }

    /**
     * Initializing MyHashMap with the initial capacity given
     */
    public MyHashMap() {
        this.hashTable = new Node[DEFAULT_CAPACITY];
    }

    public MyHashMap(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.hashTable = new Node[initialCapacity];
    }

    /**
     * Returns the Value to which the specified key IS MAPPED, or null if
     * this key is not in the hash map.
     * 
     * @param key
     * @return
     */
    public V get(K key) { // TODO: REVISIT LATER to make GET more universal
        /* Add your implementation here */
        if ((K) key == null) {
            throw new NullPointerException();
        }
        
        for(int i = 0; i < hashTable.length; i++) {
            if (hashTable[i].getKey() == key) {
                return (V) hashTable[i].getValue();
            } 
            while(hashTable[i].next != null) {   
                if (hashTable[i].getKey() == key) {
                    return (V) hashTable[i].getValue();
                }
                hashTable[i].getNext();
                hashTable[0].length;
            }
        }
        // or null if this key is not in the hash map
        return (V) null;
        
    }

    /**
     * Associates the specified value with the specified key in this map.
     * 
     * @param key
     * @param value
     * @return the value previously mapped to this key or null if
     *         this key was not previously in the hash map
     */
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        if (size >= hashTable.length * LOAD_FACTOR) {
            // If so, expand the capacity to double its current capacity.
            this.expandCapacity();
        }

        V result = this.get(key);
        // If hash collision happens, the node should be added to the end of the linked
        // list.
        // if()) {
        // ______ = hashTable[].next;
        // size++;
        // }
        return (V) result; // TODO
    }

    /**
     * 
     * @param key
     * @return the value previously mapped to this key or null if this key was not
     *         in the hash map
     */
    public V remove(K key) {
        /* Add your implementation here */

        // Adjust the Node linked list appropriately to reflect this removal.
        size--;

        return null; // TODO
    }

    /**
     * 
     * @return the number of (key, value) pairs in the hash map.
     */
    public int size() {
        /* Add your implementation here */
        return size; // TODO
    }

    /**
     * 
     * @return the capacity of the hash map
     */
    public int getCapacity() {
        /* Add your implementation here */
        return hashTable.length; // TODO
    }

    /**
     * Removes all of the mappings from this hash map.
     */
    public void clear() {
        // TODO
        // Removes all of the mappings from this hash map.
        for (int i = 0; i < size(); i++) {
            hashTable[i] = null;
        }
        size = 0;
    }

    /**
     * 
     * @return true if the map is empty
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Double the capacity of the hash table and rehash all (key, value)
     * pairs into the new hash table.
     * 
     * Should only be called when the map is at or above its maximum load.
     */
    public void expandCapacity() {
        /* Add your implementation here */
        // This method should only be called when the map is at or above its maximum
        // load.
        int capacity = hashTable.length * EXPAND_CAPACITY_RATIO; // UHHHHHHH
        Node[] hash2 = new Node[capacity];

        for (int i = 0; i < hashTable.length - 1; i++) {
            hash2[i] = hashTable[i];
        }
        hashTable = hash2;
    }

    /**
     * 
     * @param key      key maintained by this map
     * @param capacity total capacity of this hashmap
     * @return
     */
    public int getHash(K key, int capacity) {
        /* Add your implementation here */
        // TODO: Add checks for invalid inputs
        if (key == null) {
            throw new NullPointerException();
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        // Hashing function is given here. DO NOT MODIFY THIS
        // You do not need to understand how it works
        return (key.hashCode() & HASH_CODE_MASK) % capacity;
    }

    /**
     * A Node class that holds (key, value) pairs and references to the next node in
     * the linked list
     */
    protected class Node<K, V> {
        K key;
        V value;
        Node next;

        /**
         * Constructor to create a single node
         * 
         * @param key   key to store in this node
         * @param value value to store in this node
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        /**
         * Accessor to get the next node in the list
         * 
         * @return the next node
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Set the next node in the list
         * 
         * @param n the new next node
         */
        public void setNext(Node n) {
            next = n;
        }

        /**
         * Accessor to get the node's key
         * 
         * @return this node's key
         */
        public K getKey() {
            return this.key;
        }

        /**
         * Set the node's key
         * 
         * @param key the new key
         */
        public void setKey(K key) {
            this.key = key;
        }

        /**
         * Accessor to get the node's value
         * 
         * @return this node's value
         */
        public V getValue() {
            return this.value;
        }

        /**
         * Set the node's value
         * 
         * @param value the new value
         */
        public void setValue(V value) {
            this.value = value;
        }

        /**
         * Check if this node is equal to another node
         * 
         * @param other the other node to check equality with
         * @return whether or not this node is equal to the other node
         */
        public boolean equals(Node<K, V> other) {
            return this.key.equals(other.key) && this.value.equals(other.value);
        }
    }
}
