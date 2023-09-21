package algorithm.sort;

public interface SortProtocol<T> {

    void bubbleSort(T[] array, int arraySize);
    void mergeSort(T[] array, int arraySize); // divide and conquer
    void selectionSort(T[] array, int arraySize);

    void insertionSort(T[] array, int arraySize);
    void shellSort(T[] array, int arraySize); // introducing a gap concept, performance improves than insertionSort() because we eliminate the need to shift many indexes in the array

    void quickSort(T[] array, int lowerBound, int upperBound);
    void quickSort(T[] array, int arraySize); // main

    // helpers
    void swap(T[] array, int index1, int index2);
    void merge(T[] array, T[] leftArray, T[] rightArray);
    int partition(T[] array, int lowerBound, int upperBound, T pivot);
}
