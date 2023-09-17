package data_structure.linked_list.double_linked_list.list;

public interface DoubleLinkListProtocol<T> {

    void insertFirst(T item);
    void insertLast(T item);
    void insertAfterKey(T item, T key);
    void insertInOrder(T item); // for String the order will be length

    // helpers
    boolean isEmpty();

    //display
    void notFound(T item);

    void display();



}
