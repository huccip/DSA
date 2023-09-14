package algorithm.search;

public interface SearchProtocol<T> {

    int linearSearch(T target, T[] array, int arraySize); // index of item or -1
    int binarySearch(T target, T[] array, int arraySize);

    void display();
}
