package algorithm.sort;

import algorithm.utils.SortBy;

import java.util.Comparator;

public class Sort implements SortProtocol<Integer> {

    private SortBy sortBy;

    private final Comparator<Integer> lessThan = (a, b) -> a < b || a.equals(b) ? 1 : 0;
    private final Comparator<Integer> greatThan = (a, b) -> a > b || a.equals(b) ? 1 : 0;
    private final Comparator<Integer> strictLessThan = (a, b) -> a < b ? 1 : 0;
    private final Comparator<Integer> strictGreatThan = (a, b) -> a > b ? 1 : 0;
    private Comparator<Integer> comparator;
    private Comparator<Integer> strictComparator;

    public Sort() {
        this.sortBy = SortBy.ASCENDING;
        comparator = lessThan;
        strictComparator = strictLessThan;
    }

    public Sort(SortBy sortBy) {
        this.sortBy = sortBy;

        switch (this.sortBy) {
            case ASCENDING -> {
                this.comparator = lessThan;
                this.strictComparator = strictLessThan;
            }
            case DESCENDING -> {
                this.comparator = greatThan;
                this.strictComparator = strictGreatThan;
            }
            default -> throw new IllegalStateException("Unexpected value: " + this.sortBy);
        }
    }

    public void setSortBy(SortBy sortBy) {
        this.sortBy = sortBy;

        switch (this.sortBy) {
            case ASCENDING -> {
                this.comparator = lessThan;
                this.strictComparator = strictLessThan;
            }
            case DESCENDING -> {
                this.comparator = greatThan;
                this.strictComparator = strictGreatThan;
            }
            default -> throw new IllegalStateException("Unexpected value: " + this.sortBy);
        }
    }

    @Override
    public void bubbleSort(Integer[] array, int arraySize) {

        boolean isSwapped;

        for (int i = 0; i < arraySize - 1; i++) {
            isSwapped = false;

            for (int j = 0; j < arraySize - i - 1; j++) {

                if (this.comparator.compare(array[j], array[j + 1]) > 0) continue; // if in order

                swap(array, j, j+1);
                isSwapped = true;
            }

            // if no two elements were swapped in inner loop -> the array is already sorted
            if (!isSwapped) break;
        }

    }

    @Override
    public void mergeSort(Integer[] array, int arraySize) {

        if (arraySize < 2) return;

        int midIndex = arraySize / 2;

        Integer[] leftArray = new Integer[midIndex];
        Integer[] rightArray = new Integer[arraySize - midIndex];

        // divide
        System.arraycopy(array, 0, leftArray, 0, midIndex); // fill left half
        if (arraySize - midIndex >= 0)
            System.arraycopy(array, midIndex, rightArray, 0, arraySize - midIndex); // fill right half

        mergeSort(leftArray, leftArray.length);
        mergeSort(rightArray, rightArray.length);

        // conquer (merge)
        merge(array, leftArray, rightArray);

    }

    @Override
    public void merge(Integer[] array, Integer[] leftArray, Integer[] rightArray) {

        int i, j, k; // i cursor for leftArray, j cursor for rightArray, k cursor for mergedArray (array)

        i = j = k = 0;

        while (i < leftArray.length && j < rightArray.length) {

            if (comparator.compare(leftArray[i], rightArray[j]) > 0) { // if left item in order place it
                array[k++] = leftArray[i++];
                continue;
            }

            array[k++] = rightArray[j++]; // if right item in order place it

        }

        while (i < leftArray.length) { // copy what's left from left half
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) { // copy what's left from right half
            array[k++] = rightArray[j++];
        }

    }

    @Override
    public void selectionSort(Integer[] array, int arraySize) {

        for (int i = 0; i < arraySize - 1; i++) {

            int min = array[i];
            int minIndex = i;

            for (int j = i + 1; j < arraySize; j++) {
                if (strictComparator.compare(array[j], min) > 0) {
                    min = array[j];
                    minIndex = j;
                }
            }

            swap(array, i, minIndex);

        }

    }

    @Override
    public void insertionSort(Integer[] array, int arraySize) {

        for (int i = 1; i < arraySize; i++) {

            int current = array[i];
            int j = i - 1;

            // shifting items less/greater than current 1 position to the right
            while (j >= 0 && strictComparator.compare(current, array[j]) > 0) {
                array[j + 1] = array[j--];
            }

            array[j + 1] = current;

        }

    }

    @Override
    public void shellSort(Integer[] array, int arraySize) {

        // start with a large gap and reduce it til we get to a gap that equals to 1
        int gap = arraySize / 2;

        while (gap > 0) {

            // perform insertion sort for the elements at gap intervals
            for (int i = gap; i < arraySize; i++) {
                int current = array[i];
                int j = i;

                // compare and move elements until the correct position is found
                while (j >= gap && comparator.compare(current, array[j - gap]) > 0) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                // place the current (current) element in its correct position
                array[j] = current;
            }

            gap /= 2;
        }

    }

    @Override
    public void quickSort(Integer[] array, int arraySize) {
        quickSort(array, 0, arraySize - 1);
    }

    @Override
    public void quickSort(Integer[] array, int lowerBound, int upperBound) {

        if (lowerBound >= upperBound) return;

        int pivot = array[upperBound];

        int leftPointer = partition(array, lowerBound, upperBound, pivot);

        quickSort(array, lowerBound, leftPointer - 1);
        quickSort(array, leftPointer + 1, upperBound);

    }

    @Override
    public int partition(Integer[] array, int lowerBound, int upperBound, Integer pivot) {

        int leftPointer = lowerBound;
        int rightPointer = upperBound;

        while (leftPointer < rightPointer) {

            while (comparator.compare(pivot, array[leftPointer]) <= 0 && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (comparator.compare(pivot, array[rightPointer]) > 0 && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);

        }

        swap(array, leftPointer, upperBound);

        return leftPointer;
    }

    @Override
    public void swap(Integer[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
