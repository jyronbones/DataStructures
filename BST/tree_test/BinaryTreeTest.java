package tree_test;
import tree.BinaryTree;

/**
 * Lab 5 - Binary Trees
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * 
 */
public class BinaryTreeTest {

	/**
	 * main() method to test features of BinaryTree
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int[] nums = {26, 38, 34, 33, 70, 11, 25, 72, 14, 51,
				13, 77, 6, 40, 95, 84, 50, 35, 31, 54,
				88, 74, 46, 86, 57, 39, 85, 80, 19, 92 };

		for(int num : nums) { // inserting array numbers into tree
			tree.insertInTree(num);
		}
		
		System.out.println("Tree display using in-order traversal:");
		tree.displayInOrder();
		
		System.out.println("\n\nTree display using pre-order traversal:");
		tree.displayPreOrder();
		
		System.out.println("\n\nTree display using post-order traversal:");
		tree.displayPostOrder();
		
		System.out.printf("\n\nSearching for %d: %s\n", 26, tree.search(26) ? "found" : "NOT found");
		System.out.printf("Searching for %d: %s\n", 11, tree.search(11) ? "found" : "NOT found");
		System.out.printf("Searching for %d: %s\n", 38, tree.search(38) ? "found" : "NOT found");
		System.out.printf("Searching for %d: %s", 100, tree.search(100) ? "found" : "NOT found");
	}//main()

}// class
