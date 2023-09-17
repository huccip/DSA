package data_structure.linked_list.single_linked_list.list;

import data_structure.linked_list.single_linked_list.link.Link;

public interface LinkListProtocol<T> {

    void insert(T item);

    void remove(); // removes first item
    void removeWithItem(T item);

    Link<T> find(T target); // finds first occurrence

    // helpers
    boolean isEmpty();

    // display
    void foundAt(T target, String at);
    void notFound(T target);

    void display();
}
