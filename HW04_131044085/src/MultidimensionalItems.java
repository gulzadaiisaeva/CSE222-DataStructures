import java.util.Vector;

public class MultidimensionalItems implements Comparable<MultidimensionalItems> {
    /**
     * Keeps Multidimensional Items
     */
    public Vector<Integer> multiData= new Vector<>();

    /**
     * Constructor
     */
    public MultidimensionalItems(){}

    /**
     * Constructor
     * @param x To be assigned
     * @param y To be assigned
     * @param z To be assigned
     */
    public MultidimensionalItems(int x, int y, int z)
    {
        multiData.add(x);
        multiData.add(y);
        multiData.add(z);
    }

    /**
     * Compare method
     * @param o To be compared
     * @return
     */
    @Override
    public int compareTo(MultidimensionalItems o) {
        if(o.multiData.equals(this))
            return 0;
        else
            return 1;
    }

    /**
     * To String Metodu
     * @return
     */
    @Override
    public String toString() {
        return multiData.toString() ;
    }
}
