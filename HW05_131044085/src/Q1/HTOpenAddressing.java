package Q1;

/**
 *
 * @param <K>
 * @param <V>
 */
public class HTOpenAddressing<K,V> implements Map<K,V> {

    private Entry < K, V > [] table;
    private static final int START_CAPACITY = 101;
    private double LOAD_THRESHOLD = 0.75;
    private int numKeys;
    private int numDeletes;
    private final Entry < K, V > DELETED =
            new Entry < K, V > (null, null);

    /**
     * Constructor
     */
    public HTOpenAddressing() {
        table = new Entry[START_CAPACITY];
    }

    /** Contains key-value pairs for a hash table. */
    private static class Entry < K, V > {

        /** The key */
        private K key;

        /** The value */
        private V value;

        /** Creates a new key-value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /** Retrieves the key.
         @return The key
         */
        public K getKey() {
            return key;
        }

        /** Retrieves the value.
         @return The value
         */
        public V getValue() {
            return value;
        }

        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }

    /** Returns the number of entries in the map */
    public int size() {
        return numKeys;
    }

    /** Returns true if empty */
    public boolean isEmpty() {
        return numKeys == 0;
    }

    /** Finds either the target key or the first empty slot in the
     search chain using double hashing.
     @param key The key of the target object
     @return The value of the target or null if
     the target is not in the table.
     */
    public V get(Object key) {
        // Calculate the starting index.

        int hashIndex = doubleHashing(key); // hash the key
        int stepSize = doubleHashing2(key); // get step size

        if (hashIndex < 0)
            hashIndex += table.length; // Make it positive.

        while (table[hashIndex].value != null) {
            if (table[hashIndex].getKey()==key)
                return table[hashIndex].value; // yes, return item
            hashIndex += stepSize; // add the step
            hashIndex %=  table.length; // for wraparound
        }
        return null; // can't find item
    }

    /**
     * Double Hashing
     * @param key
     * @return
     */
    private int doubleHashing(Object key) {
        return key.hashCode() %  table.length; }

    /**
     * Double Hashing 2
     * @param key
     * @return
     */
    private int doubleHashing2(Object key) {
        return 5 - key.hashCode() % 5; }


    /** Method put for class HTOpenAddressing.
     Calculates the double hashing and inserts. If the key is already
     in the table, its value is changed to the argument
     value and numKeys is not changed. If the LOAD_THRESHOLD
     is exceeded, the table is expanded.
     @param key The key of item being inserted
     @param value The value for this key
     @return Old value associated with this key if found;
     otherwise, null
     */
    public V put(K key, V value) {

        int hashIndex = doubleHashing(key); // hash the key
        int stepSize = doubleHashing2(key); // get step size

        if (hashIndex < 0)
            hashIndex += table.length; // Make it positive.

        while (table[hashIndex] != null && (!key.equals(table[hashIndex].key))) {
            hashIndex += stepSize; // add the step
            hashIndex %= table.length; // for wraparound
        }
        if (table[hashIndex] == null) {
            table[hashIndex] = new Entry < K, V > (key, value);
            numKeys++;
            // Check whether rehash is needed.
            double loadFactor =
                    (double) (numKeys + numDeletes) / table.length;
            if (loadFactor > LOAD_THRESHOLD){
                rehash();
                return null;}
        }
        // assert: table element that contains the key was found.
        // Replace value for this key.
        V oldVal = table[hashIndex].value;
        table[hashIndex].value = value;
        return oldVal;
    }

    /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
     post: The size of table is doubled and is an odd integer.
     Each nondeleted entry from the original table is
     reinserted into the expanded table.
     The value of numKeys is reset to the number of items
     actually inserted; numDeletes is reset to 0.
     */
    private void rehash() {

        // Save a reference to oldTable.
        Entry < K, V > [] oldTable = table;
        // Double capacity of this table.
        table = new Entry[2 * oldTable.length + 1];

        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;
        numDeletes = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if ( (oldTable[i] != null) && (oldTable[i] != DELETED)) {
                // Insert entry in expanded table
                put(oldTable[i].key, oldTable[i].value);
            }
        }
    }

    /** Remove the item with a given key value
     *  @param key The key to be removed
     *  @return The value associated with this key, or null
     *  if the key is not in the table.
     */
    public V remove(Object key) {

        int hashIndex = doubleHashing(key);
        int stepSize = doubleHashing2(key); // get step size

        if (hashIndex < 0)
            hashIndex += table.length; // Make it positive.

        while (table[hashIndex] != null) {
            if (table[hashIndex].getKey().equals(key)) {
                V oldValue = table[hashIndex].value; // save item
                table[hashIndex] = DELETED; // delete item
                numKeys--;
                numDeletes++;
                return oldValue; // return item
            }
            hashIndex += stepSize; // add the step
            hashIndex %= table.length; // for wraparound
        }
        return null; // can't find item

    }





}
