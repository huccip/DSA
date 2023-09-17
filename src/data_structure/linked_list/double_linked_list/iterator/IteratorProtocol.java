package data_structure.linked_list.double_linked_list.iterator;

import data_structure.linked_list.double_linked_list.link.DoubleLink;

public interface IteratorProtocol<T> {

    boolean hasNext();
    DoubleLink<T> next();
    void remove();
}
