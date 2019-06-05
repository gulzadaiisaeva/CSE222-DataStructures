package part3;

import part1.CourseData;

import java.util.NoSuchElementException;

/**
 * A course list structure which besides the links between courses
 * used to form the list, courses in same semester are also linked together as circular
 * list
 */
public class CourseListStructure {

    /**
     * Keep first item of list
     */
    private static Node head;
    /**
     * Number of nodes
     */
    private static int numNodes;

    /**
     * Constructor
     * @param dat to be assigned
     */
    public CourseListStructure(CourseData dat)
    {
        head = new Node(dat);
    }
    /**
     * Constructor
     *
     */
    public CourseListStructure()
    {
        head = null;
    }

    /**
     * Adds the given item at head
     * @param data The data to be added
     */
    public void addAtHead(CourseData data)
    {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    /**
     * Adds the given item at tail
     * @param data The data to be added
     */
    public void addAtTail(CourseData data)
    {
        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = new Node(data);
        numNodes++;
    }
    /**
     * Remove item at given index
     * @param index The index of item
     */
    public void removeAtIndex(int index)
    {
        Node temp = head;
        for(int i=0; i< index - 1 && temp.next != null; i++)
        {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        numNodes--;
    }

    /**
     * Get size of list
     * @return number of nodes
     */
    public  int size()
    {
        return numNodes;
    }

    /**
     * Node class which will keep node of courseList
     */
    private class Node
    {
        /**
         * Next node
         */
        private Node next;
        /**
         * Data about course
         */
        private CourseData data;

        /**
         * Constructor
         * @param newData
         */
        public Node(CourseData newData)
        {
            data = newData;
        }

        /**
         * Get data of node
         * @return data
         */
        public CourseData getData()
        {
            return data;
        }

        /**
         * To string method
         * @return
         */
        @Override
        public String toString()
        {
            return  data.toString();
        }

    }

    /**
     * iterator method
     * @return Course List Iterator
     */
    public CourseListStructureIterator iterator(){
        return new CourseListStructureIterator();
    }

    /**
     * Iterator of CourseList
     */
    public class CourseListStructureIterator
    {
        /**
         * Next node
         */
        private Node nextNode;
        /**
         * this variable keeps head,
         * used for nextInSemester method
         */
        private Node start;

        /**
         * Constructor
         */
        public CourseListStructureIterator()
        {
            nextNode = head;
            start=head;
        }

        /**
         * next method of iterator
         * @return course data
         */
        public CourseData next()
        {
            if(!hasNext()) throw new NoSuchElementException();
            CourseData res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }

        /**
         * This method iterate the course in same semester
         * as circular list
         * Since iterator iterate until the tail
         * start will bi assigned, iterator iterate as circular list
         * @param index start index
         * @return course data
         */
        public CourseData nextInSemester(int index)
        {
            if(!hasNext()){
                nextNode=start;
            }
            CourseData res2 = nextNode.data;
            if (res2.getSemester()!=index) {
                while (res2.getSemester() != index) {
                    nextNode = nextNode.next;
                    if(!hasNext()){
                        nextNode=start;
                    }
                    res2 = nextNode.data;
                }
                nextNode = nextNode.next;
            }
            else {
                nextNode = nextNode.next;
            }
            return res2;
        }

        /**
         * Always true if nextNode is not null
         * @return true is not null
         */
        public boolean hasNext()
        {
            return nextNode!=null;
        }

    }
}
