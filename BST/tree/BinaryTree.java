package tree;
/**
 * Lab 5 - Binary Trees
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 *  
 */

public class BinaryTree {
	/**
	 * creates a root type BinaryTreeNode set to null
	 */
	BinaryTreeNode root = null;

	/**
	 * create new node with these contents and insert in the proper location
	 * using BST logic
	 * @param newData - the number to be stored in tree node
	 */

	public void insertInTree(int newData) {
		if (root == null)
			root = new BinaryTreeNode(newData);
		else
			root.insert(newData);
	}

	/**
	 * Display tree contents using inorder traversal
	 */
	public void displayInOrder() {
		displayInOrder(root);
	}

	/**
	 * Start at subtree and display tree contents using inorder traversal
	 * @param subRoot starting location in tree
	 */
	private void displayInOrder(BinaryTreeNode subRoot) {
		if (subRoot == null)
			return;
		displayInOrder(subRoot.getLeft());
		System.out.print(" " + subRoot.getData() + " ");
		displayInOrder(subRoot.getRight());
	}
	
	/**
	 * Display tree contents using preorder traversal
	 */
	public void displayPreOrder() {
		displayPreOrder(root);
	}
	
	/**
	 * Start at subtree and display tree contents using preorder traversal
	 * @param subRoot starting location in tree
	 */
	private void displayPreOrder(BinaryTreeNode subRoot) {
		if (subRoot == null)
			return;
		System.out.print(" " + subRoot.getData() + " ");
		displayPreOrder(subRoot.getLeft());
		displayPreOrder(subRoot.getRight());
	}
	
	/**
	 * Display tree contents using postorder traversal
	 */
	public void displayPostOrder() {
		displayPostOrder(root);
	}
	
	/**
	 * Start at subtree and display tree contents using postorder traversal
	 * @param subRoot starting location in tree
	 */
	private void displayPostOrder(BinaryTreeNode subRoot) {
		if (subRoot == null)
			return;
		displayPostOrder(subRoot.getLeft());
		displayPostOrder(subRoot.getRight());
		System.out.print(" " + subRoot.getData() + " ");
	}
	
	/**
	 * Iterative search in binary search tree checking if given key exists or not
	 * @param key - passed value from user to search for in tree
	 * @return returns true if key is found and false if key is not found
	 */
	public boolean search(int key) {
		BinaryTreeNode searchRoot = root;
		while (searchRoot != null) {
			if (key == searchRoot.getData())			// key is root node data
				return true;
			else if (key > searchRoot.getData())		// key greater than node data
				searchRoot = searchRoot.getRight();
			else 										// key less than node data
				searchRoot = searchRoot.getLeft();
		}
		return false;									// key not found
	}
}// class
