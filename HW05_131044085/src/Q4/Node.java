package Q4;

/**
 * A Node is the building block for a double-linked list.
 * @param <E>
 */
public class Node<E
        extends Comparable < E >> {
    /**
     * data
     */
    public E data;
    /**
     * Previous node
     */
    public Node<E> prev;
    /**
     * next node
     */
    public Node<E> next;

    /**
     * constructor
     */
    public Node() {

    }

    /**
     * constructor
     * @param data
     */
    public Node(E data) {
        super();
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    /**
     * To String method
     * @return
     */
    @Override
    public String toString() {
        return "Node [data=" + data + "]";
    }

}