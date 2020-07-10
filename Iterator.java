package geekbrains.HomeTask_4;

public interface Iterator<T> {
    void reset();

    T getCurrent();

    boolean atEnd();

    void insertAfter(T value);

    void insertBefore(T value);

    T deleteCurrent();

    boolean hasNext();

    T next();
}
