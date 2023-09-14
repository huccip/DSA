package data_structure.stack;

// LIFO

public interface StackStructureProtocol<T> {

    void push(T item);
    T pop();

    boolean isEmpty();
    boolean isCreated();

    boolean isSaturated();
    void extend();
    void shrink(); // LIFO

    void display();
    void peek(); // display top of stack
}
