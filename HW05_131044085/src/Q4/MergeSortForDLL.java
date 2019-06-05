package Q4;



/**
 * Merge Sort Algorithm which sorts Double Linked List
 */
public class MergeSortForDLL {

    /**
     * Sorts the given Double Linked List
     * @param dll
     * @param <E>
     */
    public static < E
            extends Comparable < E >> void sort(DoubleLinkedList<E> dll){
        dll.root=mergeSort(dll.root);
    }

    /**
     * Helper method of sort which divides the given list
     * @param root
     * @param <E>
     * @return
     */
    public static< E
            extends Comparable < E >> Node<E> mergeSort(Node<E> root) {
        if (null == root || root.next == null)
            return root;
        Node<E> firstHalf = root;
        Node<E> secondHalf;
        Node<E> pointToFirstHalf=root;
        Node<E> divider=root;

        while (divider.next != null && divider.next.next != null) {
            pointToFirstHalf = pointToFirstHalf.next;
            divider = divider.next.next;
        }
        secondHalf = pointToFirstHalf.next;
        secondHalf.prev = null;
        pointToFirstHalf.next = null;
        firstHalf = mergeSort(firstHalf);
        secondHalf = mergeSort(secondHalf);
        return merge(firstHalf, secondHalf);
    }

    /**
     * Merge the divided list
     * @param firstHalf
     * @param secondHalf
     * @param <E>
     * @return
     */
    public static < E
            extends Comparable < E >>Node<E> merge(Node<E> firstHalf, Node<E> secondHalf) {
        if (firstHalf == null)
            return secondHalf;
        if (secondHalf == null)
            return firstHalf;
        if ((firstHalf.data.compareTo(secondHalf.data)< 0) || (firstHalf.data.compareTo(secondHalf.data) == 0)) {
            firstHalf.next = merge(firstHalf.next, secondHalf);
            firstHalf.prev = null;
            firstHalf.next.prev = firstHalf;
            return firstHalf;
        } else {
            secondHalf.next = merge(firstHalf, secondHalf.next);
            secondHalf.next.prev = secondHalf;
            secondHalf.prev = null;
            return secondHalf;
        }
    }
}
