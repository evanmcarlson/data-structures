import java.util.EmptyStackException;

public class BinaryHeap {

    int[] data = new int[10];
    int size = 0;

    public void add(int item) {
        if(size == data.length - 1) {
            growArray();
        }
        data[size++] = item;
        int current = size-1;
        int parent = (current - 1) / 2;
        while(data[current] < data[parent] && current != 0) {
            swap(data, current, parent);
            current = parent;
            parent = (parent - 1) / 2;
        }
    }

    public int remove() {
        if (size == 0) { throw new EmptyStackException(); }// throw exception if empty
        swap(data, 0, size - 1); // swap the root value with the final-1 value in array (sort the end of the array)
        size--;
        if(size > 0) {
            shiftdown(0); // work way down tree recursively, swapping values to restore the order property
        }
        return data[size];
    }

    public void shiftdown(int position) {
        int smallest = position;
        int left = (2 * position) + 1;
        int right = (2 * position) + 2;


        if (left < size && data[left] < data[smallest]) {
            smallest = left;
        }
        if (right < size && data[right] < data[smallest]) {
            smallest = right;
        }

        if (smallest != position) {
            swap(data, smallest, position);
            shiftdown(smallest);
        }
    }

    private void swap(int[]a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    protected void growArray() {
        int[] temp = new int[data.length * 2];
        for(int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
