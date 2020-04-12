import java.util.EmptyStackException;

class Assert {
    public static boolean not_false(boolean condition) {
        if(condition) {
            return true;
        }
        throw new EmptyStackException();
    }
}

public class LinkedList<T> implements List<T> {

    Node head;
    int size = 0;

    class Node<T> { // T is for template; its the type of data that we want to store
        T data;
        Node next;

        public Node(T data) {	// CONSTRUCTOR
            this.data = data;
            next = null;
        }

        public void set_next(Node next) {	// FUNCTIONS
            this.next = next;
        }

        public Node get_next() {
            return this.next;
        }

        public T get_data() {
            return this.data;
        }

        public void set_data(T data) {
            this.data = data;
        }
    }

    public void add(T item) {
        if (head == null) {
            Node<T> newNode = new Node(item); // requires arg bc we need “data” to pass to the constructor
            head = newNode;
            size++;
        } else {
            Node previous = head;
            for (int i = 0; i < size - 1; i++) {
                previous = previous.get_next();
            }
            Node<T> newNode = new Node(item);
            previous.set_next(newNode);
            size++;
        }
    }

    public void add(int position, T data){
        Assert.not_false(position <= size && position >= 0);  // input validation
        ++size;  // change size of LinkedList
        if(position == 0) { // inserting a new head
            Node node = new Node(data);
            node.set_next(head);
            head = node;
        }
        else { // inserting at any other position in the array
            Node previous = head;
            for (int i = 0; i < position - 1; i++) { // find previous node
                previous = previous.get_next();
            }
            Node node = new Node(data);
            node.set_next(previous.get_next());
            previous.set_next(node);
        }
    }

    public T get(int position) {
        Assert.not_false(position >= 0 && position < size);
        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.get_next();
        }
        return (T) current.get_data();
    }

    // in order to simplify the code and remove the special case, we can set a dummy head of data 0 thats pts to the leading entry (do this in constructor)
    public T remove(int position) { // we return the node to keep a record of the removed element
        Assert.not_false(position < size && position >= 0);  // input validation *maybe pos <= size?*
        if(position == 0) { // removing the head of the LinkedList
            Node current = head;
            head = current.get_next();
            --size;
            return (T) current.get_data();
        }
        else {
            Node previous = head;
            for (int i = 0; i < position - 1; i++) { // find previous node
                previous = previous.get_next();
            }
            Node current = previous.get_next();
            previous.set_next(current.get_next());
            --size; // decrement size of LinkedList
            return (T) current.data;
        }
    }

    public int size() {
        return size;
    }
}
