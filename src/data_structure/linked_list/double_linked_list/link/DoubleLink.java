package data_structure.linked_list.double_linked_list.link;

public class DoubleLink<T> implements DoubleLinkProtocol<T> {

    Class<T> tClass;
    T item;

    DoubleLink<T> next;
    DoubleLink<T> previous;

    String classRef;

    public DoubleLink(Class<T> tClass) {
        this.tClass = tClass;

        String[] classNameArray = this.toString().split("\\.");
        this.classRef = classNameArray[classNameArray.length - 1];
    }

    public DoubleLink(Class<T> tClass, T item) {
        this.tClass = tClass;
        this.item = item;

        String[] classNameArray = this.toString().split("\\.");
        this.classRef = classNameArray[classNameArray.length - 1];
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public DoubleLink<T> getNext() {
        return next;
    }

    public void setNext(DoubleLink<T> next) {
        this.next = next;
    }

    public DoubleLink<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLink<T> previous) {
        this.previous = previous;
    }

    public String getClassRef() {
        return classRef;
    }

    @Override
    public void display() {
        System.out.print(this.classRef + ": " + this.item + (this.getNext() != null ? " "+ (this.getPrevious() != null ? "<" : "") +"-> " : ""));
    }
}
