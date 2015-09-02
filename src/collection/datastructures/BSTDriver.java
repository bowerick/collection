package collection.datastructures;

public class BSTDriver {
	public static void main(String[] args) {
		BST bst = new BST();
		bst.add(50).add(40).add(110).add(30).add(45).add(99).add(115).add(111).add(119).add(20).add(35).add(41).add(49).add(32).inOrderTraversal();
		System.out.println(bst.find(41));
		System.out.println(bst.findMax());
		System.out.println(bst.findMin());
	}
}
