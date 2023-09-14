package data_structure.stack;

import java.lang.reflect.Array;

public class StackStructure<T> implements StackStructureProtocol<T> {

    private T[] stackArray;
    private int stackSize;
    private int topOfStack = -1;
    private Class<T> tClass;

    @SuppressWarnings("unchecked")
    public StackStructure(int stackSize, Class<T> tClass) {
        this.stackSize = stackSize;
        this.tClass = tClass;
        this.stackArray = (T[]) Array.newInstance(tClass, stackSize);
    }

    @SuppressWarnings("unchecked")
    public StackStructure(Class<T> tClass) {
        this.tClass = tClass;
        this.stackSize = 0;
        this.stackArray = (T[]) Array.newInstance(tClass, 0);
    }

    @SuppressWarnings("unchecked")
    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
        this.stackArray = (T[]) Array.newInstance(tClass, stackSize);
        this.topOfStack = stackSize - 1;
    }

    public void setStackArray(T[] stackArray) {
        this.stackArray = stackArray;
        this.stackSize = stackArray.length;
        this.topOfStack = stackArray.length - 1;
    }

    public T[] getStackArray() {
        return stackArray;
    }

    public int getStackSize() {
        return stackSize;
    }

    public int getTopOfStack() {
        return topOfStack;
    }

    @Override
    public void push(T item) {
        if (!this.isCreated()) return;

        if (this.isSaturated()) {
            this.extend();
        }

        this.stackArray[this.topOfStack] = item;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        if (!isCreated()) return null;

        T temp = this.stackArray[this.topOfStack];

        this.shrink();

        return temp;
    }

    @Override
    public boolean isEmpty() {
        return this.topOfStack == -1;
    }

    @Override
    public boolean isCreated() {
        return this.stackArray != null;
    }

    @Override
    public boolean isSaturated() {
        return this.topOfStack + 1 >= this.stackSize;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void extend() {
        T[] tempStackArray = (T[]) Array.newInstance(this.tClass, this.stackSize + 1);
        System.arraycopy(this.stackArray, 0, tempStackArray, 0, this.stackSize);

        this.setStackSize(++this.stackSize);
        System.arraycopy(tempStackArray, 0, this.stackArray, 0, this.stackSize);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void shrink() {
        T[] tempStackArray = (T[]) Array.newInstance(this.tClass, --this.stackSize);
        System.arraycopy(this.stackArray, 0, tempStackArray, 0, this.stackSize);

        this.setStackSize(this.stackSize);
        System.arraycopy(tempStackArray, 0, this.stackArray, 0, this.stackSize);
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

        System.out.println(this.stackArray[this.topOfStack]);
    }

    @Override
    public void display() {
        System.out.println("--------------------");

        if (!this.isCreated()) {
            System.out.println((Object) null);
            return;
        }

        System.out.println("array size: " + this.stackArray.length);
        System.out.println("used stackArray size: " + this.stackSize);
        System.out.println("top of stack is at: " + this.topOfStack);
        for (int i = 0; i < this.stackSize; i++) {
            System.out.print(this.stackArray[i] + (i == this.stackSize - 1 ? "":" -> "));
        }

        System.out.println();
    }
}
