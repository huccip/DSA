package data_structure.linked_list.single_linked_list.list;

import data_structure.linked_list.single_linked_list.link.Link;

public class LinkList<T> implements LinkListProtocol<T> {

    Class<T> tClass;
    Link<T> currentLink;

    public LinkList(Class<T> tClass) {
        this.tClass = tClass;
        this.currentLink = null;
    }

    public LinkList(Class<T> tClass, Link<T> currentLink) {
        this.tClass = tClass;
        this.currentLink = currentLink;
    }

    public Link<T> getCurrentLink() {
        return currentLink;
    }

    public void setCurrentLink(Link<T> currentLink) {
        this.currentLink = currentLink;
    }

    @Override
    public void insert(T item) {
        Link<T> newLink = new Link<>(this.tClass, item); // our new guest has arrived
        newLink.setNext(this.currentLink);
        this.currentLink = newLink;
    }

    @Override
    public void remove() {

        if (this.isEmpty()) {
            display();
            return;
        }

        this.currentLink = this.currentLink.getNext();
    }

    @Override
    public Link<T> find(T target) {

        if (this.isEmpty()) {
            this.display();
            return null;
        }

        Link<T> temp = this.currentLink;

        do {
            if (target == temp.getItem()) {
                this.foundAt(temp.getItem(), temp.getClassRef());
                return temp;
            }

            temp = temp.getNext();
        } while (temp != null);

        notFound(target);
        return null;
    }

    @Override
    public void removeWithItem(T item) {

        if (this.isEmpty()) {
            this.display();
            return;
        }

        if (this.currentLink.getNext() == null) {
            remove();
            return;
        }

        Link<T> currentLink = this.currentLink;
        Link<T> previousLink;

        do {

            if (currentLink.getNext() == null) {
                notFound(item);
                return;
            }

            previousLink = currentLink;
            currentLink = currentLink.getNext();

        } while (currentLink.getItem() != item);

        if (currentLink == this.currentLink) {
            remove();
        } else {
            previousLink.setNext(currentLink.getNext());
        }

    }

    @Override
    public boolean isEmpty() {
        return this.currentLink == null;
    }

    @Override
    public void foundAt(T target, String at) {

        System.out.println("--------------------");

        System.out.println(target + " was found at address " + at);

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

        Link<T> temp = this.currentLink;

        do {
            temp.display();
            temp = temp.getNext();
        } while (temp != null);

        System.out.println();

    }
}
