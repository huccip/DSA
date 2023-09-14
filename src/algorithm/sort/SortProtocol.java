package algorithm.sort;

public interface SortProtocol<T> {

    void bubbleSort(T[] array, int arraySize);
    void selectionSort(T[] array, int arraySize);
    void insertionSort(T[] array, int arraySize);
    void swap(T[] array, int index1, int index2);
}
