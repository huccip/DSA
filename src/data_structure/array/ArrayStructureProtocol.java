package data_structure.array;

public interface ArrayStructureProtocol<T> {

    void createWithSize(int size);
    void createWithElements(T[] items);

    void addFirst(T item);
    void addLast(T item);
    void addWithPosition(T item, int position);

    void deleteFirst();
    void deleteLast();
    void deleteWithPosition(int position);
    void deleteWithItem(T item);

    T pop(); // delete and get last item
    T shift(); // delete and get first item

    // helpers
    boolean isEmpty();
    boolean isCreated();
    boolean isSaturated();
    void extend();
    void truncate(); // or reset
    void invalidate(); // or destroy
    void display();

    boolean isPositionWithinRange(int position);
    boolean isItemWithin(T item);
    void incSize();
    void decSize();

    void shiftToRight(int position, int step);
    void shiftToLeft(int position, int step);
}
