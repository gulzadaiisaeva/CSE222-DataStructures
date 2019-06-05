package Q2;

import java.util.Collection;
import java.util.Iterator;

public interface Set<E> {

    boolean add(E obj);
    boolean addAll(Collection<? extends E> coll);
    boolean contains(Object obj);
    boolean containsAll(Collection<?> coll);
    boolean isEmpty();
    Iterator<E> iterator();
    boolean remove(Object obj);
    boolean removeAll(Collection<?> coll);
    boolean retainAll(Collection<?> coll);
    int size();
    void clear();
}
