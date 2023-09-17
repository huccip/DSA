package data_structure.linked_list.single_linked_list.link;

public class Link<T> implements LinkProtocol<T> {

    Class<T> tClass;
    T item;

    Link<T> next;

    String classRef;

    public Link(Class<T> tClass) {
        this.tClass = tClass;

        String[] classNameArray = this.toString().split("\\.");
        this.classRef = classNameArray[classNameArray.length - 1];
    }

    public Link(Class<T> tClass, T item) {
        this.item = item;
        this.tClass = tClass;

        String[] classNameArray = this.toString().split("\\.");
        this.classRef = classNameArray[classNameArray.length - 1];
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public String getClassRef() {
        return classRef;
    }

    @Override
    public void display() {

        System.out.print(this.classRef + ": " + this.item + (this.getNext() != null ? " -> " : ""));

    }
}
