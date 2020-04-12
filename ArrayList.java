public class ArrayList<T> implements List<T> {

    T[] arr;
    int size;

    public ArrayList() {
        T[] temp = (T[]) new Object[10];
        arr = temp;
        size = 0;
    }

    public void add(T item) {
        add(size, item);
    }

    public void add(int pos, T item) {
        Assert.not_false(pos > 0 || pos < size + 1);
        if(pos == arr.length) { growArray(); }
        for(int i = size; pos < i; i++) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = item;
        size++;
    }

    protected void growArray() {
        T[] temp = (T[]) new Object[size * 2];
        for(int i = 0; i < size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public T get(int pos) {
        Assert.not_false(pos >= 0 && pos < size);
        return arr[pos];
    }

    public T remove(int pos) {
        Assert.not_false(pos >= 0 && pos < size);
        T removed = arr[pos];
        for(int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return removed;
    }

    public int size() {
        return size;
    }
}
