import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
    T[] arr;
    int top;
    int size = 10;

    public ArrayStack() {
        T[] temp = (T[]) new Object[size];
        arr = temp;
        top = -1;
    }

    public boolean empty() {
        return top == -1;
    }

    public T pop() {
        if(empty()) {
            throw new EmptyStackException();
        }
        return arr[top--];
    }

    public T peek() {
        if(empty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }

    public void push(T t) {
        if(top == arr.length - 1) {
            growArray();
        }
        arr[++top] = t;
    }

    protected void growArray() {
        T[] temp = (T[]) new Object[arr.length * 2];
        size = (arr.length * 2)-1;
        for(int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }
}
