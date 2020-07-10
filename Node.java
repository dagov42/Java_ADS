package geekbrains.HomeTask_4;

public class Node<T> {
    private final T value;
    public Node<T> previous;
    public Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
