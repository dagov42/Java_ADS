package geekbrains.HomeTask_4;

import java.util.NoSuchElementException;

public class IteratorImpl<T> implements Iterator {


    private Node<T> current;
    private Node<T> head;
    private Node<T> tail;

    public IteratorImpl() {
        reset();
    }

    public void reset() {
        current = new Node<T>(null);
        current.next = head;
    }

    public boolean hasNext() {
        return !atEnd();
    }

    public Object next() {
        if (hasNext()) {
            current = current.next;
            return current.getValue();
        } else {
            throw new NoSuchElementException();
        }
    }

    public T getCurrent() {
        if (isBeforeElements() || isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return current.getValue();
        }
    }

    public T deleteCurrent() {
        T value = getCurrent();
        if (isFirst()) {
            if (!atEnd()) {
                current.next.previous = null;
                head = current.next;
            } else {
                head = null;
                tail = null;
            }
            reset();
        } else if (atEnd()) {
            current = current.previous;
            current.next = null;
            tail = current;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            current = current.previous;
        }
        return value;
    }

    private boolean isBeforeElements() {
        return current.next == head;
    }

    private boolean isFirst() {
        return !isBeforeElements() && current.previous == null;
    }

    public boolean atEnd() {
        return current.next == null;
    }

    @Override
    public void insertAfter(Object value) {
        Node<T> insert = new Node<T>((T) value);
        if (isBeforeElements() || isEmpty()) {
            head = insert;
        } else {
            insert.previous = current;
        }
        insert.next = current.next;
        if (!atEnd()) {
            current.next.previous = insert;
        } else {
            tail = insert;
        }
        current.next = insert;

    }

    @Override
    public void insertBefore(Object value) {
        if (isBeforeElements()) {
            throw new IndexOutOfBoundsException();
        }
        if (isFirst()) {
            Node<T> insert = new Node<T>((T) value);
            insert.next = current;
            current.previous = insert;
            head = insert;
        } else {
            current = current.previous;
            insertAfter(value);
            current = current.next.next;
        }
    }

    private boolean isEmpty() {
        return head == null;
    }
}
