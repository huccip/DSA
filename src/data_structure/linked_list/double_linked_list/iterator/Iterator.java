package data_structure.linked_list.double_linked_list.iterator;

import data_structure.linked_list.double_linked_list.link.DoubleLink;
import data_structure.linked_list.double_linked_list.list.DoubleLinkList;

public class Iterator<T> implements IteratorProtocol<T> {

    Class<T> tClass;

    DoubleLink<T> currentLink, previousLink;
    DoubleLinkList<T> doubleLinkList;

    public Iterator(Class<T> tClass) {
        this.tClass = tClass;
    }

    public Iterator(Class<T> tClass, DoubleLinkList<T> doubleLinkList) {
        this.tClass = tClass;
        this.doubleLinkList = doubleLinkList;

        this.currentLink = doubleLinkList.getFirstLink();
        this.previousLink = doubleLinkList.getLastLink();
    }

    @Override
    public boolean hasNext() {
        return currentLink.getNext() != null;
    }

    @Override
    public DoubleLink<T> next() {

        if (!this.hasNext()) return null;

        this.previousLink = currentLink;
        currentLink = currentLink.getNext();

        return currentLink;
    }

    @Override
    public void remove() {

        if (this.previousLink == null) {
            doubleLinkList.setFirstLink(currentLink.getNext());
            return;
        }

        previousLink.setNext(currentLink.getNext());

        if (currentLink.getNext() != null) {
            currentLink = currentLink.getNext();
            return;

        }

        currentLink = doubleLinkList.getFirstLink();
        previousLink = null;

    }
}
