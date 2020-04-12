import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class ArrayQueue<T> implements Queue<T> {

    T[] queue;
    int head;
    int tail;
    int size = 10;

    public ArrayQueue() {
        T[] temp = (T[]) new Object[size];
        queue = temp;
        head = 0;
        tail = 0;
    }

    public boolean empty() {
        return head == tail;
    }

    public T dequeue() {
        if(empty()) {
            throw new EmptyStackException(); // or return NULL;

        }
        T temp = queue[head];

        head = (head + 1) % queue.length;
        return temp;
    }

    public void enqueue(T t) {
        if (tail == size) {
            growArray();
        }
        queue[tail] = t; // store t in last index
        tail = (tail + 1); // advance tail index
    }

    public void growArray() {
        T[] temp = (T[]) new Object[queue.length * 2];
        size = (queue.length * 2)-1;
//        // growing a circular array
//        for(int i = head; i < queue.length; i++) {
//            temp[i] = queue[i];
//        }
//        for(int i = 0; i < tail; i++) {
//            temp[i] = queue[i];
//        }
        head = 0;
        for(int scan = 0; scan < queue.length; scan++)
        {
            temp[scan] = queue[head];
            head=(head+1);
        }

        head = 0;
        tail = queue.length;
        queue = temp;
    }
}
