package data_structure.queue;

import java.lang.reflect.Array;

public class QueueStructure<T> implements QueueStructureProtocol<T> {

    private T[] queueArray;
    private int queueSize;
    private Class<T> tClass;
    private int start, end = -1;
    private int itemsCount = 0;

    @SuppressWarnings("unchecked")
    public QueueStructure(Class<T> tClass) {
        this.tClass = tClass;
        this.queueSize = 0;
        this.queueArray = (T[]) Array.newInstance(tClass, 0);
    }

    @SuppressWarnings("unchecked")
    public QueueStructure(int queueSize, Class<T> tClass) {
        this.queueSize = queueSize;
        this.tClass = tClass;
        this.queueArray = (T[]) Array.newInstance(tClass, queueSize);
        this.end = queueSize - 1;
    }

    public void setQueueArray(T[] queueArray) {
        this.queueArray = queueArray;
        this.queueSize = queueArray.length;
        this.end = queueArray.length - 1;
        this.itemsCount = queueArray.length;
    }

    @SuppressWarnings("unchecked")
    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
        this.queueArray = (T[]) Array.newInstance(tClass, queueSize);
        this.end = queueSize - 1;
        this.itemsCount = queueSize;
    }

    public void settClass(Class<T> tClass) {
        this.tClass = tClass;
    }

    public T[] getQueueArray() {
        return queueArray;
    }

    public int getQueueSize() {
        return queueSize;
    }

    @Override
    public void insert(T item) {
        if (!this.isCreated()) return;

        if (this.isSaturated()) {
            this.extend();
        }

        queueArray[end] = item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void insertByPriority(Integer item) {
        if (!this.isCreated()) return;

        if (this.isEmpty()) {
            insert((T) item);
            return;
        }

        extend(); // get enough room for our guest

        Integer[] tempQueueArray = (Integer[]) this.queueArray;
        int i;

        for (i = this.end - 1; i > -1; i--) {

            if (item < tempQueueArray[i]) break;

            tempQueueArray[i + 1] = tempQueueArray[i];

        }

        tempQueueArray[i + 1] = item;

        this.setQueueArray((T[]) tempQueueArray);
    }

    @Override
    public void remove() {
        if (!this.isCreated()) return;
        if (this.isEmpty()) return;

        shrink();
    }

    @Override
    public boolean isSaturated() {
        return this.itemsCount + 1 >= this.queueSize;
    }

    @Override
    public boolean isCreated() {
        return this.queueArray != null;
    }

    @Override
    public boolean isEmpty() {
        return this.itemsCount == 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void extend() {
        T[] tempStackArray = (T[]) Array.newInstance(this.tClass, this.queueSize + 1);
        System.arraycopy(this.queueArray, 0, tempStackArray, 0, this.queueSize);

        this.setQueueSize(++this.queueSize);
        System.arraycopy(tempStackArray, 0, this.queueArray, 0, this.queueSize);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void shrink() {
        T[] tempStackArray = (T[]) Array.newInstance(this.tClass, --this.queueSize);
        System.arraycopy(
                this.queueArray,
                this.itemsCount == 1 ? 0 : 1,
                tempStackArray,
                0,
                this.queueSize
        );

        this.setQueueSize(this.queueSize);
        System.arraycopy(tempStackArray, 0, this.queueArray, 0, this.queueSize);
    }

    @Override
    public void peek() {
        System.out.println("--------------------");

        if (this.isEmpty()) {
            System.out.println("Empty");
            return;
        }

        if (!this.isCreated()) {
            System.out.println((Object) null);
            return;
        }

        System.out.println(this.queueArray[0]);
    }

    @Override
    public void display() {
        System.out.println("--------------------");

        if (!this.isCreated()) {
            System.out.println((Object) null);
            return;
        }

        System.out.println("array size: " + this.queueArray.length);
        System.out.println("used queueArray size: " + this.queueSize);
        System.out.println("number of items: " + this.itemsCount);
        for (int i = 0; i < this.queueSize; i++) {
            System.out.print(this.queueArray[i] + (i == this.queueSize - 1 ? "":" -> "));
        }

        System.out.println();
    }
}
