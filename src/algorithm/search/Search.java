package algorithm.search;

import java.util.Objects;

public class Search implements SearchProtocol<Integer> {

    private int target;
    private int at = -1;

    @Override
    public int linearSearch(Integer target, Integer[] array, int arraySize) {

        this.target = target;

        for (int i = 0; i < arraySize; i++) {
            if (Objects.equals(array[i], target)) {
                this.at = i;
                return i;
            }
        }

        return -1;
    }

    @Override
    public int binarySearch(Integer target, Integer[] array, int arraySize) {

        this.target = target;

        int lowerBound = 0;
        int upperBound = arraySize - 1;

        while (lowerBound <= upperBound) {

            int midIndex = lowerBound + (upperBound - lowerBound) / 2;

            if (array[midIndex] < target) lowerBound = midIndex + 1;

            else if (array[midIndex] > target) upperBound = midIndex - 1;

            else { // found the first match
                this.at = midIndex;
                return midIndex;
            }
        }

        return -1;
    }

    @Override
    public void display() {
        System.out.println("--------------------");

        System.out.println(at == -1 ? target + " was not found" : target + " was found at : " + at);

        System.out.println();
    }
}
