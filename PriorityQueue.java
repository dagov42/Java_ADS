package geekbrains.HomeTask_3;

import java.util.NoSuchElementException;

public class PriorityQueue extends Queue {
    public PriorityQueue(int capacity) {
        super(capacity);
    }

    @Override
    public int remove() {
        return super.remove();
    }

    @Override
    public void insert(int value) {
        if (isFull())
            throw new NoSuchElementException("Queue is empty");

        int i;
        for (i = 0; i < getSize(); i++)
            if (getQueue()[i] > value) break;

        System.arraycopy(getQueue(), i, getQueue(), i + 1, getSize() - i);
        getQueue()[i] = value;
        setSize(getSize() + 1);
    }
}
