
public class TreeMain {

	public static void main(String[] args) {
		System.out.println("Tree task");
		System.out.println("----------------------JOIN TWO TREES---------------------------------");
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
		System.out.println("---------------------------------------------------------------------");
		
		Tree<Integer> secondTree = new Tree<>();
		secondTree.add(5);
		secondTree.add(6);
		secondTree.add(7);
		
		treeInteger.joinTrees(secondTree, 2);
		
		Tree<Character> treeCharacter = new Tree<>();
		treeCharacter.add('W');
		treeCharacter.add('A');
		treeCharacter.add('Z');
		
		System.out.println("-----------------------CHARACTERS TREE----------------------------------");
		System.out.println("Right Node: " + treeCharacter.root.getLeftNode().getData());	
		System.out.println("Left Node: " + treeCharacter.root.getRightNode().getData());
		treeCharacter.print("", treeCharacter.getRootNode(), false);
	}

}
