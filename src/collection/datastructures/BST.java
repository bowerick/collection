package collection.datastructures;

public class BST {

	private BSTNode root;

	private int size;
	
	public int traversals;

	public BST() {
		root = null;
		size = 0;
	}

	public BST add(int data) {
		root = add(root,data);
		return this;
	}

	private BSTNode add(BSTNode node, int data) {
		BSTNode n;
		if(node == null)
		{
			node = new BSTNode(data);
			size++;
		}
			
		else
		{
			if(data < node.data)
				node.left = add(node.left,data);
			else
				node.right = add(node.right,data);
		}
		
		n=node;
		return n;
	}

	public int findMax()
	{
		return findMax(root);
	}
	
	private int findMax(BSTNode node)
	{
		if(node.right == null) return node.data;
		return (findMax(node.right));
	}
	
	public int findMin()
	{
		return findMin(root);
	}
	
	private int findMin(BSTNode node)
	{
		if(node.left == null) return node.data;
		return (findMin(node.left));
	}
	
	public boolean find(int data)
	{
		return find(root,data);
	}
	
	private boolean find(BSTNode node,int data)
	{
		traversals++;
		if(node == null)
			return false;
		if(node.data == data)
			return true;
		if(data < node.data)
			return find(node.left,data);
		if(data > node.data)
			return find(node.right,data);
		return false;
	}
	
	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	private void inOrderTraversal(BSTNode node) {
		if (node == null)
			return;
		inOrderTraversal(node.left);
		System.out.println(node.data);
		inOrderTraversal(node.right);
	}
}
