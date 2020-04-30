
public class TreeMain {

	public static void main(String[] args) {
		System.out.println("Tree task");
		Tree<Integer> treeInteger = new Tree<Integer>();
		treeInteger.add(8);
		treeInteger.add(3);
		treeInteger.add(10);
		treeInteger.add(11);
		treeInteger.add(2);
		
		Tree<Integer> otherTree = new Tree<>();
		otherTree.add(5);
		
		treeInteger.joinTrees(otherTree, 2);
		System.out.println("Added Node: " + treeInteger.root.getLeftNode().getLeftNode().getRightNode().getData());
		
		Tree<Character> treeCharacter = new Tree<>();
		treeCharacter.add('W');
		treeCharacter.add('A');
		treeCharacter.add('Z');
		System.out.println("Right Node: " + treeCharacter.root.getLeftNode().getData());	
	}

}
