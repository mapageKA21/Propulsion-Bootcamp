package stack;

public class Stack<T> {
	
    private Node<T> top = null;
    
    public void push(T data) {
        Node<T> node = new Node<>(data);
        node.setNext(this.top);
        this.top = node;
    }
    
    public T pop() throws NullPointerException {
        if(isEmpty())
            return null;
        
        Node<T> node = this.top;
        this.top = node.getNext();
        return node.getData();
    }
    
    public Node<T> peek() {
        return this.top;
    }
    
    private int getSizeRecursive(Node<T> node, int size) {
        size++;
        return node.getNext() == null ? size : getSizeRecursive(node.getNext(), size);
    }
    
    public int size() {
        if (this.top == null)
            return 0;
        return getSizeRecursive(this.top, 0);
    }
    
    public boolean isEmpty() {
        return this.top == null;
    }
}
