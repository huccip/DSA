package algorithm.sort;

import algorithm.utils.SortBy;

import java.util.Comparator;

public class Sort implements SortProtocol<Integer> {

    private SortBy sortBy;

    private final Comparator<Integer> lessThan = (a, b) -> a < b ? 1 : 0;
    private final Comparator<Integer> greaterThan = (a, b) -> a > b ? 1 : 0;
    private Comparator<Integer> comparator;

    public Sort() {
        this.sortBy = SortBy.ASCENDING;
        comparator = greaterThan;
    }

    public Sort(SortBy sortBy) {
        this.sortBy = sortBy;

        switch (this.sortBy) {
            case ASCENDING -> this.comparator = greaterThan;
            case DESCENDING -> this.comparator = lessThan;
            default -> throw new IllegalStateException("Unexpected value: " + this.sortBy);
        }
    }

    public void setSortBy(SortBy sortBy) {
        this.sortBy = sortBy;

        switch (this.sortBy) {
            case ASCENDING -> this.comparator = greaterThan;
            case DESCENDING -> this.comparator = lessThan;
            default -> throw new IllegalStateException("Unexpected value: " + this.sortBy);
        }
    }

    @Override
    public void bubbleSort(Integer[] array, int arraySize) {

        boolean isSwapped;

        for (int i = 0; i < arraySize - 1; i++) {
            isSwapped = false;

            for (int j = 0; j < arraySize - i - 1; j++) {
                if (this.comparator.compare(array[j], array[j + 1]) > 0) {
                    swap(array, j, j+1);
                    isSwapped = true;
                }
            }

            // if no two elements were swapped in inner loop -> the array is already sorted
            if (!isSwapped) break;
        }

    }

    @Override
    public void selectionSort(Integer[] array, int arraySize) {

        for (int i = 0; i < arraySize; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arraySize; j++) {
                if (comparator.compare(array[i], array[minIndex]) > 0) {
                    minIndex = j;
                }
            }

            swap(array, i, minIndex);
        }

    }

    @Override
    public void insertionSort(Integer[] array, int arraySize) {

        for (int i = 1; i < arraySize; i++) {

            int key = array[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;

        }

    }

    @Override
    public void swap(Integer[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[2];
        array[index2] = temp;
    }
}
