/**
 * Processing data using Doubly Linked List CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * 
 * Professor: James Mwangi PhD
 * 
 * Lab4
 * Student Name: Byron Jones
 * Student ID: 040585687
 * Program: Computer Engineering Technology - Computing Science
 * Course: CST 8130 - Data Structures
 * Lab Section: 302
 * 
 */

// ===================== class starts here=============================
/**
 * This class contains information about the Node
 */
class Node {
	/**
	 * Data stored in node
	 */
	public int mData; // data item
	/**
	 * Next node in list
	 */
	public Node next; // next node in list
	/**
	 * Previous node in list
	 */
	public Node previous; // previous node in list
	// -------------------------------------------------------------

	/**
	 * Constructor setting node's data to passed number
	 * @param d - passed number to be stored in node
	 */
	public Node(int d) // constructor
	{
		mData = d;
	}

	// -------------------------------------------------------------
	
	// display this node data
	/**
	 * Displays node data
	 */
	public void displayNode() {
		System.out.print(mData + " ");
	}
	// -------------------------------------------------------------
} // end class Node

// ===================== class design starts here =============================
/**
 * This class contains the functionality of a doubly linked list
 */
class DoublyLinked {
	private Node first;
	private Node last;

	// -------------------------------------------------------------
	/**
	 * No-argument constructor initializing first and last to null
	 */
	public DoublyLinked() { // No-argument constructor initializing first and last to null
		first = null;
		last = null;
	}

	// -------------------------------------------------------------
	/**
	 * Check if list is empty
	 * @return returns true if first node is null
	 */
	public boolean isEmpty() { 	// Check if list is empty
		return first == null;
	}

	// -------------------------------------------------------------
	/**
	 * Inserts node at from of doubly linked list
	 * @param num - passed number to be stored in node
	 */
	public void insertFirst(int num) { // Insert at the beginning
		Node newNode = new Node(num);

		if (isEmpty()) { // list is empty
			last = newNode;
		} else {
			first.previous = newNode;
			newNode.next = first;
		}
		first = newNode;
	}

	// -------------------------------------------------------------
	/**
	 * Inserts node at end of doubly linked list
	 * @param num - passed number to be stored in node
	 */
	public void insertLast(int num) { // Insert at the end

		Node newNode = new Node(num);
		if (isEmpty()) { // list is empty
			first = newNode;
		} else {
			last.next = newNode;
			newNode.previous = last;
		}
		last = newNode;
	}

	// insert newNumber just after numToFind
	/**
	 * Inserts a node after a specific number
	 * @param numToFind - is the data contained in node to find
	 * @param newNumber - is the data to be stored in the new node
	 * @return returns false if node not found for insertion
	 */
	public boolean insertAfter(int numToFind, int newNumber) { // (assumes non-empty list)

		Node node = first;
		while (node.mData != numToFind) { // search list for number
			node = node.next;
			if (node == null)
				return false;
		}
		Node newNode = new Node(newNumber);
		
		newNode.next = node.next;
		newNode.previous = node;
		node.next = newNode;
		return true;
	}

	// ------------------------------------------------
	/**
	 * Deletes node at front of doubly linked list
	 * @return returns the removed node or null if empty
	 */
	public Node deleteFirstNode() { // delete first node

		if (isEmpty()) // list is empty
			return null;
		
		Node removeNode = first;
		
		first.next.previous = null;
		
		first = first.next;
		
		return removeNode;
	}

	// -----------------------------------------------
	/**
	 * Deletes node at end of doubly linked list
	 * @return returns the removed node or null if empty
	 */
	public Node deleteLastNode() { // delete last node

		if (isEmpty()) // empty list
			return null;
		
		Node removeNode = last;
		
		last.previous.next = null;
		
		last = last.previous;
		
		return removeNode;
	}

	// -------------------------------------------------------------

	// -----------------------------------------finds, deletes and returns the node
	// that contains the given int value
	/**
	 * Searches for a node and removes from doubly linked list
	 * @param number - the number to search for node to be deleted
	 * @return returns the removed node or null if not found
	 */
	public Node searchAndDelete(int number) {

		Node node = first;
		while (node.mData != number) { // search list for number
			node = node.next;
			if (node == null)
				return null;
		}
		
		node.previous.next = node.next;
		node.next = node.previous;
		return node;
	}

	// -------------------------------------------display data from first node to
	// last node
	/**
	 * Prints the doubly linked list from first node to last node
	 */
	public void printForwards() {
		System.out.print("Linked List: [From first_to_last]: ");
		// write your code here
		Node tempNode = first;
		while (tempNode != null) { // iterates through list from first to last
			tempNode.displayNode();
			tempNode = tempNode.next;
		}
		System.out.println();
	}

	// -------------------------------------------display data from last node to
	// first node
	/**
	 * Prints the doubly linked list from last node to first node
	 */
	public void printBackwards() {
		System.out.print("Linked List: [From last_to_first]: ");
		Node tempNode = last;
		while (tempNode != null) { // iterates through list from last to first
			tempNode.displayNode();
			tempNode = tempNode.previous;
		}
		System.out.println();
	}
	// -------------------------------------------------------------
} // end class DoublyLinkedList

// ==========================================================