package geekbrains.HomeTask_2;


public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        this.isSorted = false;
    }

    public Array(int capacity) {
        this();
        arr = new int[capacity];
        this.size = 0;
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int get(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;

    }

    public int length() {
        return size;
    }

    private void increaseCapacity() {
        int[] temp = arr;
        arr = new int[size * 2];
        System.arraycopy(temp, 0, arr, 0, size);
    }

    public void append(int value) {
        if (size >= arr.length) {
            increaseCapacity();
        }
        arr[size++] = value;
        isSorted = false;
    }

    public int deleteLast() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException(-1);
        return arr[--size];
    }

    public void insert(int index, int value) {
        if (index < 0) throw new ArrayIndexOutOfBoundsException(index);
        if (index < arr.length) {
            arr[index] = value;
        } else if (index > arr.length) {
            int[] temp = arr;
            arr = new int[index + 1];
            System.arraycopy(temp, 0, arr, 0, arr.length);
            arr[index] = value;
        }
    }

    public boolean deleteByValue(int value) {
        if (find(value) == -1) return false;
        else deleteByIndex(find(value));
        return true;
    }

    public boolean deleteByIndex(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
        return true;
    }

    public void deleteAll() {
        size = 0;
    }


    @Override
    public String toString() {
        if (arr == null) return "null";
        int iMax = size - 1;
        if (iMax == -1) return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
            i++;
        }
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("try the 'find' method");

        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) >> 1; // (l + r) / 2
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int sortBubble() {
        int count = 0;
        boolean pointer = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    pointer = true;
                }
            }
            if (!pointer) break;
        }
        isSorted = true;
        return count;
    }

    public int sortBubbleSimple() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
        isSorted = true;
        return count;
    }

    public int sortSelect() {
        int count = 0;
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            count++;
            for (int rem = flag + 1; rem < size; rem++)
                if (arr[rem] < arr[cMin]) {
                    cMin = rem;
                    count++;
                }
            swap(flag, cMin);
            count++;
        }
        isSorted = true;
        return count;
    }

    public int sortInsert() {
        int count = 0;
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            count++;
            int in = out;
            count++;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                count++;
                in--;
                count++;
            }
            arr[in] = temp;
            count++;
        }
        isSorted = true;
        return count;
    }
}
