package part2;

import part1.CourseData;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.security.InvalidParameterException;
import java.util.ListIterator;

/**
 * The list which extended from LinkedList, also have disable, enable and showDisable methods
 * @param <E> list is generic
 */
public class ExtendedLinkedList<E> extends LinkedList<E> {

    /**
     * Keeps indexes of Disabled Lists
     */
    private ArrayList<Integer> indexOfDisabledList =new ArrayList<>();

    /**
     * Default constructor
     */
    public ExtendedLinkedList() {
        super();
    }

    /**
     * Copy anotherList to extended list
     * @param anotherList to be assigned
     */
    public ExtendedLinkedList(LinkedList<E> anotherList) {
        super(anotherList);
    }

    /**
     * Decrease every index of disabled list if any enable list
     * is removed from list.
     * For example 1.index is disabled. But if we remove 0.index ,
     * the disabled list's index will be 0
     */
    private void decrease()
    {
        for (int i = 0; i < indexOfDisabledList.size() ; i++) {
            indexOfDisabledList.set(i, indexOfDisabledList.get(i)-1);
        }
    }

    /**
     * Checks whether given index in IndexOFDisabledList
     * @param index which will be checked
     * @return true if given index in disabledList, otherwise false
     */
    private boolean isDisabled(int index)
    {
        for (int i = 0; i < indexOfDisabledList.size() ; i++) {
            if (indexOfDisabledList.get(i)==index)
                return true;
        }

        return false;
    }

    /**
     * Disable the element from list. Add index of this element to IndexOfDisabledList
     * @param index of element which will be disabled
     * @throws InvalidParameterException if index is invalid
     */
    public void disable(int index) throws InvalidParameterException
    {
        if(index<0 || index>= super.size())
            throw new InvalidParameterException("There is no such a courses to disable \n");
        indexOfDisabledList.add(index);

    }

    /**
     * Enable the element from list. Remove index of this element from IndexOfDisabledList
     * @param index of element which will be enabled
     * @throws InvalidParameterException if index is invalid
     * @return true enabled
     */
    public boolean enable(int index) throws InvalidParameterException
    {
        if(index<0 || index>= super.size())
            throw new InvalidParameterException("There is no such a courses to enable \n");
        for (int i = 0; i < indexOfDisabledList.size() ; i++) {
            if (indexOfDisabledList.get(i)==index) {
                indexOfDisabledList.remove(i);
                return true;
            }
        }
        return false;

    }

    /**
     * Shows the all Disabled List
     */
    public LinkedList<E> showDisabled()
    {
        LinkedList<E> obj=new LinkedList<>();
        if(indexOfDisabledList.size()!=0) {
            for (int i = 0; i < super.size(); i++) {
                if (isDisabled(i)) {
                    System.out.println(super.get(i).toString());
                    obj.add(super.get(i));
                }
            }
        }
        else {
            System.out.println("\nThere is no disabled list\n");
        }
        return obj;
    }

    /**
     * Overriding the get method so that disabled items are prevent from
     * this method.First it will check if given element is in DisabledList, if it is
     * the method will give message and return null, if not calls get method of super class
     * @param index of element will be returned
     * @return null
     */
    @Override
    public E get(int index)
    {
        if(isDisabled(index)) {
            System.out.println("This is disabled list that prevented from get method!You cannot use this method\n");
            return null;
        }
        else
            return super.get(index);
    }
    /**
     * Overriding the get method so that disabled items are prevent from
     * this method.First it will check if given element is in DisabledList, if it is
     * the method will give message, if not calls set method of super class
     * @param index of element will be set
     * @param element will be returned
     * @return element
     */
    @Override
    public E set(int index, E element) throws InvalidParameterException
    {
        if(index<0 || index>=super.size()-1)
            throw new InvalidParameterException("Invalid index\n");
        if(isDisabled(indexOf(element))) {
           System.out.println("This is disabled list that prevented from set method!You cannot use this method\n");
        }
        else
        {
            super.set(index,element);
        }
        return element;
    }

    /**
     * Overriding the get method so that disabled items are prevent from
     * this method.First it will check if given element is in DisabledList, if it is
     * the method will give message, if not calls remove method of super class
     * Also call decrease method
     * @param index of element will be removed
     * @return element which is removed
     */
    @Override
    public E remove(int index) throws InvalidParameterException
    {
        if(index<0 || index>=super.size()-1)
            throw new InvalidParameterException("Invalid index\n");
        if (isDisabled(index)) {
            System.out.println("This is disabled list that prevented from remove method!You cannot use this method\n");
            return null;
        }
        E obj=get(index);
        super.remove(index);
        decrease();
        return obj;
    }

    /**
     * Overriding the get method so that returns number of enabled + num
     * of disabled element
     *
     * @return number of enabled list
     */
    @Override
    public int size(){
        return super.size()- indexOfDisabledList.size();
    }

    /**
     * Overriding the get method so that disabled items are prevent from
     * this method
     * @param index
     * @return
     */
    @Override
    public ListIterator<E> listIterator(int index)
    {
        if(isDisabled(index))
        {
            while (!isDisabled(index)) {
                index++;
            }
            return super.listIterator(index);
        }
        else
        {
            return super.listIterator(index);
        }

    }

}
