package Q5;

public class DoubleLinkedList<E
        extends Comparable < E >> {

    /**
     * Root of list
     */
    public Node<E> root;

    /**
     * add elements to list
     * @param data
     */
    public void add(E data) {
        Node<E> newNode = new Node<E>(data);
        if (null == root) {
            root = newNode;
        } else {
            Node<E> temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }
            newNode.prev = temp;
            temp.next = newNode;
        }
    }


    /**
     * To String method
     * @return
     */
    public String toString() {
        Node<E> temp = root;
        String str="";
        while (temp != null) {
            str+=temp.data + " ";
            temp = temp.next;
        }
        return str;
    }



}