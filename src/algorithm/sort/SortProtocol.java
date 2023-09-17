package algorithm.sort;

public interface SortProtocol<T> {

    void bubbleSort(T[] array, int arraySize);
    void selectionSort(T[] array, int arraySize);

    void insertionSort(T[] array, int arraySize);
    // performance improves than insertionSort() because we eliminate the need to shift many indexes in the array
    void shellSort(T[] array, int arraySize);

    void quickSort(T[] array, int lowerBound, int upperBound);

    // helpers
    void swap(T[] array, int index1, int index2);
    int partition(T[] array, int lowerBound, int upperBound, T pivot);
}
