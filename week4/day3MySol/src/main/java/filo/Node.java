package filo;

public class Node<T> {
	private final T data;
	private Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}
	
    public Node<T> getNext() {
        return this.next;
    }
    
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
