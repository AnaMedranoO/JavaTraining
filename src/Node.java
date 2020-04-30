
public class Node<T>{
	T data;
	Node<T> leftNode;
	Node<T> rightNode;
	
	public Node(T data)
	{
		this.data = data;
		this.leftNode = null;
		this.rightNode = null;
	}
	
	public T getData() {
		return data;
	}
	
	public Node<T> getLeftNode() {
		return leftNode;
	}
	
	public Node<T> getRightNode() {
		return rightNode;
	}
	
	public void setLeftNode(Node<T> data)
	{
		this.leftNode = data;
	}
	
	public void setRightNode(Node<T> data)
	{
		this.rightNode = data;
	}
}
