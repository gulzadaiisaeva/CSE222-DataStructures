package Q2;

import java.util.*;

/** Hash table implementation using chaining.
*   @author Koffman and Wolfgang
* */

public class HashtableChain <E >
    implements Set <E> {

    private Table<E> [] table;
    /** The number of keys */
    private int numKeys;

    /** The capacity */
    private static final int CAPACITY = 101;

    /**
     * Constructor
     */
    public HashtableChain(){
        table = new Table[CAPACITY];
    }


    /**
     * Method add for class HashtableChain.
     * Calculates the hashcode and inserts. If the item is already
     * in the table, return false
     * @param obj item being inserted
     * @return true if inserted
     */
    @Override
    public boolean add(E obj){

     int index = obj.hashCode() % table.length;
      if (index < 0)
          index += table.length;

      if (table[index] == null) {
          numKeys++;
          table[index] = new Table<E>(obj);
          return true;
      }

      if(table[index].getData().equals(obj))
          return false;

      addRecursive(table[index].nextTable,primeNumber(table.length-1),obj);

      return true;
  }

    /**
     * If there is collusion , continues calculate the hash index untill there are
     * no element in that index
     * @param node next table of data
     * @param size size of next table
     * @param obj item being inserted
     */
    public void addRecursive(Table<E> []node, int size,E obj)
    {
      int index = obj.hashCode() % size;

      if(node==null)
      {
          node=new Table[size];
      }
      if(node[index].getData()==obj){
          int newSize=primeNumber(size-1);
          addRecursive(node[index].nextTable,newSize,obj);
      }
      else{
          node[index].setData(obj);
          numKeys++;
      }
    }

    /**
     * Inserts all the element of c which not in the table
     * @param c collection which will be inserted
     * @return
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (add(e)){
                numKeys++;
                modified = true;}
        }
        return modified;
    }

    /**
     * Checks if obj is in the table
     * @param obj item will be checked
     * @return
     */
    @Override
    public boolean contains(Object obj){
        int index = obj.hashCode() % table.length;
        if(table[index]==null)
            return false;
        if(table[index].getData().equals(obj))
            return true;
        else
            return containsHelper(table[index].nextTable,obj,primeNumber(table.length-1));

    }

    /**
     * Helper recursive function to traverse all the tables
     * @param node
     * @param obj
     * @param size
     * @return
     */
    public boolean containsHelper(Table<E>[] node, Object obj,int size){
        int index = obj.hashCode() % size;
        if(node[index]==null)
            return false;
        if(!node[index].getData().equals(obj))
            containsHelper(node[index].nextTable,obj,primeNumber(size-1));

        return true;
    }

    /**
     * Checks if all elements of c are in the table
     * @param c
     * @return
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        int flag=0;
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
       return true;
    }

    /**
     * checks if table is empty
     * @return
     */
    @Override
    public boolean isEmpty(){
        return size()==0;
    }

    /**
     * Returns iterator to table
     * @return
     */
    public Iterator<E> iterator(){
        return null;
    }

    /**
     * Removes the element from table
     * @param obj
     * @return
     */
    @Override
    public boolean remove(Object obj){
        return true;
    }

    /**
     * Set intersection operation of c and table
     * @param c
     * @return
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * Set difference operation of c and table
     * @param c
     * @return
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    /**
     * Clear the table
     */
    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i]=null;
        }
    }

    /**
     * return size
     * @return
     */
    @Override
    public int size(){
        return numKeys;
    }

    /**
     * Finds the primeNumber which less than n
     * @param n
     * @return
     */
    private int primeNumber(int n){
        int result=n;
        while(!isPrime(result)){
            result--;
        }
          return result;
    }

    /**
     * checks if number is prime
     * @param n
     * @return
     */
    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    /**
     * Inner class data and its next hash table
     * @param <E>
     */
    private static class Table<E> {
        /**
         * data
         */
        private   E data;
        /**
         * size
         */
        private int size;
        /**
         * next hash table
         */
        private Table [] nextTable =null;

        /**
         * Constructor
         * @param size
         */
        Table(int size){
            this.size=size;
            nextTable = new Table[size];
        }

        /**
         * Constructor
         * @param obj
         */
        Table(E obj){
            this.data=obj;
        }
        Table(E data,int size){
            this.data=data;
            this.size=size;
            nextTable = new Table[size];
        }

        /**
         * returns the data
         * @return
         */
        public E getData() {
            return data;
        }

        /**
         * set the data
         * @param data
         */
        public void setData(E data) {
            this.data = data;
        }

    }

}
