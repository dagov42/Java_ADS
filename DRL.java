package geekbrains.HomeTask_4;

public class DRL<T>{

    private Node<T> head;
    private Node<T> tail;

    public void add(T value) {
        if (tail != null) {
            tail.next = new Node<>(value);
            tail.next.previous = tail;
            tail = tail.next;
        } else {
            head = new Node<>(value);
            tail = head;
        }
    }

    public void insert(T value, int index) {
        IteratorImpl iterator = prepareIterator(index);
        iterator.insertAfter(value);
    }

    private IteratorImpl prepareIterator(int index) {
        IteratorImpl iterator = this.iterator();
        for (int i = 0; i <= index; i++) {
            if (iterator.hasNext()) {
                iterator.next();
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        return iterator;
    }

    public Object remove(int index) {
        Iterator iterator = prepareIterator(index);
        return iterator.deleteCurrent();
    }

    public T get(int index) {
        IteratorImpl iterator = prepareIterator(index);
        return (T) iterator.getCurrent();
    }

    public IteratorImpl iterator() {
        return new IteratorImpl();
    }

//    public static class Node<T> {
//        private final T value;
//        public Node<T> previous;
//        public Node<T> next;
//
//        public Node(T value) {
//            this.value = value;
//        }
//
//        public T getValue() {
//            return value;
//        }
//    }
}
