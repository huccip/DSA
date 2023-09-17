package data_structure.linked_list.double_linked_list.list;

import data_structure.linked_list.double_linked_list.link.DoubleLink;

import java.util.Comparator;

public class DoubleLinkList<T> implements DoubleLinkListProtocol<T> {

    Class<T> tClass;

    DoubleLink<T> firstLink, lastLink;

    public DoubleLinkList(Class<T> tClass) {
        this.tClass = tClass;
    }

    public DoubleLinkList(Class<T> tClass, DoubleLink<T> firstLink, DoubleLink<T> lastLink) {
        this.tClass = tClass;
        this.firstLink = firstLink;
        this.lastLink = lastLink;
    }

    public DoubleLink<T> getFirstLink() {
        return firstLink;
    }

    public void setFirstLink(DoubleLink<T> firstLink) {
        this.firstLink = firstLink;
    }

    public DoubleLink<T> getLastLink() {
        return lastLink;
    }

    public void setLastLink(DoubleLink<T> lastLink) {
        this.lastLink = lastLink;
    }

    @Override
    public void insertFirst(T item) {

        DoubleLink<T> newDoubleLink = new DoubleLink<>(this.tClass, item);

        if (this.isEmpty()) this.lastLink = newDoubleLink;
        else this.firstLink.setPrevious(newDoubleLink);

        newDoubleLink.setNext(this.firstLink);
        this.firstLink = newDoubleLink;

    }

    @Override
    public void insertLast(T item) {

        DoubleLink<T> newDoubleLink = new DoubleLink<>(this.tClass, item);

        if (this.isEmpty()) {
            this.firstLink = newDoubleLink;
        } else {
            this.lastLink.setNext(newDoubleLink);
            newDoubleLink.setPrevious(this.lastLink);
        }

        this.lastLink = newDoubleLink;

    }

    @Override
    public void insertAfterKey(T item, T key) {

        DoubleLink<T> newDoubleLink = new DoubleLink<>(this.tClass, item);

        DoubleLink<T> currentLink = this.firstLink;

        while (currentLink.getItem() != key) {

            currentLink = currentLink.getNext();

            if (currentLink == null) {
                notFound(key);
                return;
            }

        }

        if (currentLink == this.lastLink) {
            this.lastLink = newDoubleLink;
        } else {
            newDoubleLink.setNext(currentLink.getNext());
            currentLink.getNext().setPrevious(newDoubleLink);
        }

        newDoubleLink.setPrevious(currentLink);
        currentLink.setNext(newDoubleLink);

    }

    @SuppressWarnings("unchecked")
    @Override
    public void insertInOrder(T item) {

        Comparator<String> stringLessThan = (String a, String b) -> a.length() < b.length() ? 1 : 0;
        Comparator<Integer> intLessThan = (a, b) -> a < b ? 1 : 0;
        Comparator<Character> charLessThan = (Character a, Character b) -> a < b ? 1 : 0;
        Comparator<Byte> byteLessThan = (Byte a, Byte b) -> a < b ? 1 : 0;

        Comparator<T> comparator = (Comparator<T>) intLessThan;

        DoubleLink<T> newDoubleLink = new DoubleLink<>(this.tClass, item);

        DoubleLink<T> previousLink = null;
        DoubleLink<T> currentLink = this.firstLink;

        if (this.tClass == String.class) {
            comparator = (Comparator<T>) stringLessThan;
        } else if (this.tClass == Character.class) {
            comparator = (Comparator<T>) charLessThan;
        } else if (this.tClass == Byte.class) {
            comparator = (Comparator<T>) byteLessThan;
        }

        while (currentLink != null && comparator.compare(currentLink.getItem(), item) > 0) {

            previousLink = currentLink;
            currentLink = currentLink.getNext();

        }

        if (previousLink == null) {
            this.firstLink = newDoubleLink;
        } else {
            previousLink.setNext(newDoubleLink);
        }

        newDoubleLink.setPrevious(previousLink);
        newDoubleLink.setNext(currentLink);

    }

    @Override
    public boolean isEmpty() {
        return this.firstLink == null;
    }

    @Override
    public void notFound(T target) {

        System.out.println("--------------------");

        System.out.println(target + " was not found");

    }

    @Override
    public void display() {

        System.out.println("--------------------");

        if (this.isEmpty()) {
            System.out.println((Object) null);
            return;
        }

        DoubleLink<T> temp = this.firstLink;

        do {
            temp.display();
            temp = temp.getNext();
        } while (temp != null);

        System.out.println();

    }
}
