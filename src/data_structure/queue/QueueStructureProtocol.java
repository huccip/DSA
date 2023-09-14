package data_structure.queue;

// FIFO

public interface QueueStructureProtocol<T> {

    void insert(T item);
    void insertByPriority(Integer item);
    void remove();

    boolean isSaturated();
    boolean isCreated();
    boolean isEmpty();

    void extend();
    void shrink(); // FIFO

    void display();
    void peek(); // display front of queue
}
