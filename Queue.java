public interface Queue<T> {
	
	public T dequeue();
	public void enqueue(T item);
	public boolean empty();

}
