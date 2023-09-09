package data_structure.array;

import java.lang.reflect.Array;

public class ArrayStructure <T> implements ArrayStructureProtocol<T> {

    T[] array;
    int arraySize;
    Class<T> tClass;

    public T[] getArray() {
        return array;
    }

    public int getArraySize() {
        return arraySize;
    }

    public ArrayStructure(Class<T> tClass) {
        this.tClass = tClass;
        this.arraySize = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void createWithSize(int size) {
        this.array = (T[]) Array.newInstance(this.tClass, size);
    }

    @Override
    public void createWithElements(T[] items) {
        this.array = items;
        this.arraySize = items.length;
    }

    @Override
    public void addFirst(T item) {
        addWithPosition(item, 0);
    }

    @Override
    public void addLast(T item) {
        addWithPosition(item, this.arraySize);
    }

    @Override
    public void addWithPosition(T item, int position) {
        if (!isCreated()) return;
        if (!isPositionWithinRange(position)) return;

        if (isSaturated()) {
            extend();
        }

        incSize();

        shiftToRight(position, 1);

        this.array[position] = item;
    }

    @Override
    public void deleteFirst() {
        deleteWithPosition(0);
    }

    @Override
    public void deleteLast() {
        deleteWithPosition(this.arraySize - 1);
    }

    @Override
    public void deleteWithPosition(int position) {
        if (!isCreated()) return;
        if (!isPositionWithinRange(position)) return;
        if (isEmpty()) return;

        decSize();

        shiftToLeft(position, 1);
    }

    @Override
    public void deleteWithItem(T item) {

    }

    @Override
    public T pop() {

        if (isEmpty()) return null;

        T temp = this.array[this.arraySize - 1];
        deleteLast();
        return temp;
    }

    @Override
    public T shift() {

        if (isEmpty()) return null;

        T temp = this.array[0];
        deleteFirst();
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return this.arraySize == 0;
    }

    @Override
    public boolean isCreated() {
        return this.array != null;
    }

    @Override
    public boolean isSaturated() {
        return this.arraySize >= this.array.length;
    }

    @Override
    public void extend() {
        T[] tempArray = this.array;

        createWithSize(this.array.length * 2 + 1);

        System.arraycopy(tempArray, 0, this.array, 0, tempArray.length);
    }

    @Override
    public void truncate() {
        createWithSize(0);
        this.arraySize = 0;
    }

    @Override
    public void invalidate() {
        this.array = null;
        this.arraySize = 0;
    }

    @Override
    public void display() {
        System.out.println("--------------------");

        if (this.array == null) {
            System.out.println((Object) null);
            return;
        }

        System.out.println("array size: " + this.array.length);
        System.out.println("used array size: " + this.arraySize);
        for (int i = 0; i < this.arraySize; i++) {
            System.out.print(this.array[i] + (i == this.arraySize - 1 ? "":" -> "));
        }

        System.out.println();
    }

    @Override
    public boolean isPositionWithinRange(int position) {
        return position >= 0 && position <= this.arraySize;
    }

    @Override
    public boolean isItemWithin(T item) {
        return false;
    }

    @Override
    public void incSize() {
        this.arraySize++;
    }

    @Override
    public void decSize() {
        this.arraySize--;
    }

    @Override
    public void shiftToRight(int position, int step) {
        while (step != 0) {

            if (this.arraySize - 1 - position >= 0)
                System.arraycopy(this.array, position, this.array, position + 1, this.arraySize - 1 - position);

            step--;

        }
    }

    @Override
    public void shiftToLeft(int position, int step) {
        while (step != 0) {

            if (this.arraySize - 1 - position >= 0)
                System.arraycopy(this.array, position, this.array, position + 1, this.arraySize - 1 - position);

            step--;
        }
    }
}
