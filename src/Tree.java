
public class Tree<T extends Comparable<T>> {
	public Node<T> root;
	
	public Tree() {
		this.root = null;	
	}

	public int compareValues(final T firstValue, final T secondValue) 
    {
        return Integer.compare((Integer) firstValue, (Integer) secondValue);
    }	
	
	public Node<T> getRootNode()
	{
		return this.root;
	}
	
	public void add(T data)
	{
		if(this.root == null)
		{
			this.root = new Node<T>(data);
		} else {
			addRecursive(data, this.root);
		}
	}
	
	private void addRecursive(T data, Node<T> node)
	{
		int compareResult = node.getData().compareTo(data);
		
		if(compareResult > 0)
		{
			if( node.getLeftNode() == null){
				node.setLeftNode(new Node<T>(data));
			}
			else {
				addRecursive(data, node.getLeftNode());
			}
		} else 
		{
			if( node.getRightNode() == null){
				node.setRightNode(new Node<T>(data));
			}
			else {
				addRecursive(data, node.getRightNode());
			}
		}
	}
	
	public void joinTrees(Tree<T> tree, T data)
	{
		Node<T> founded = findNode(data, this.root);
		
		if(founded != null)
		{
			int compareResult = founded.getData().compareTo(tree.getRootNode().getData());
			int levelFoundedNode = getLevelNode(data, this.root);
			int levelTree = getLevelTree(tree);
			int totalLevel  = levelFoundedNode + levelTree;

				if(compareResult > 0)
				{
					if( founded.getLeftNode() == null){
						if(totalLevel <= 5)
						{
							founded.setLeftNode(tree.getRootNode());
						} else
						{
							System.out.println("The tree is not able to join because the level would exceed to 5");
						}
					}
					else {
						System.out.println("The tree is not able to join because the Left Node has a node");
					}
				} else 
				{
					if( founded.getRightNode() == null){
						if(totalLevel <= 5)
						{
							founded.setRightNode(tree.getRootNode());
						}
						else
						{
							System.out.println("The tree is not able to join because the level would exceed to 5");
						}
					}
					else {
						System.out.println("The tree is not able to join because the Right Node has a node");
					}
				}
		} else
		{
			System.out.println("The element wasn't found");
		}

		print("", this.root, false);
	}
	
	private Node<T> findNode(T data, Node<T> node)
	{
		int compareResult = node.getData().compareTo(data);
		
		if(node.getData().equals(data))
		{
			return node;
		} 
		
		if(compareResult > 0)
		{
			if(node.getLeftNode() != null){
				return findNode(data, node.getLeftNode());
			}
		} else 
		{
			if(node.getRightNode()!= null)
			{
				return findNode(data, node.getRightNode());
			}
		}
		return null;
	}
	
	private int getLevelNode(T data, Node<T> node)
	{
		return getLevelNodeRecursive(data, node);
	}
	
	private int getLevelNodeRecursive(T data, Node<T> node)
	{
		int compareResult = node.getData().compareTo(data);
		
		if(node.getData().equals(data))
		{
			return 1;
		} 

		if(compareResult > 0)
		{
			if(node.getLeftNode() != null){
				return 1 + getLevelNodeRecursive(data, node.getLeftNode());
			} else {
				return getLevelNodeRecursive(data, node.getLeftNode());
			}
		} else 
		{
			if(node.getRightNode()!= null)
			{
				return 1 + getLevelNodeRecursive(data, node.getRightNode());
			} else {
				return getLevelNodeRecursive(data, node.getRightNode());
			}
		}
	}
	
	public int getLevelTree(Tree<T> tree)
	{
		return getLevelTreeRecursive(tree.getRootNode());
	}
	
	private int getLevelTreeRecursive(Node<T> node)
	{		
		if(node.getLeftNode() == null && node.getRightNode() == null)
		{
			return 1;
		} 

		if(node.getLeftNode() != null){
			return 1 + getLevelTreeRecursive(node.getLeftNode());
		}
		
		if(node.getRightNode()!= null)
		{
			return 1 + getLevelTreeRecursive( node.getRightNode());
		}
	
		return 0;
	}
	 
	 public void print(String prefix, Node<T> node, boolean isLeft) {
		 if (node != null) {
			 print(prefix + " ", node.getRightNode(), false);
			 System.out.println (prefix + ("|-- ") + node.getData());
			 print(prefix + " ", node.getLeftNode(), true);
		 }
	}
}
