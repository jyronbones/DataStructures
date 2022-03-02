/**
 * Processing data using Doubly Linked List CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * 
 * Professor: James Mwangi PhD
 * 
 * 
 * Student Name: Byron Jones
 * Student ID: 040585687
 * Program: Computer Engineering Technology - Computing Science
 * Course: CST 8130 - Data Structures
 * Lab Section: 302
 * 
 */

/**
 * This class contains method main
 */
class TestDLLApp {
	/**
	 * Driver method containing the doubly linked list and operations
	 * @param args is the runtime argument array
	 */
	public static void main(String[] args) {

		// write your lines of code here
		DoublyLinked<Integer> newLL = new DoublyLinked<Integer>();

		newLL.insertFirst(20);
		newLL.insertFirst(42);
		newLL.insertFirst(63);
		newLL.insertFirst(93);
		
		newLL.insertLast(9);
		newLL.insertLast(34);
		newLL.insertLast(51);
		
		newLL.printForwards();
		newLL.printBackwards();
		
		newLL.deleteFirstNode();
		newLL.deleteLastNode();
		
		newLL.searchAndDelete(9);
		
		newLL.printForwards();
		
		newLL.insertAfter(20, 69);
		newLL.insertAfter(34, 77);
		
		newLL.printForwards();
		System.out.println();
		
		DoublyLinked<String> newLL2 = new DoublyLinked<String>();
		
		newLL2.insertFirst("Bob");
		newLL2.insertFirst("Dro");
		newLL2.insertFirst("Crow");
		newLL2.insertFirst("Plonk");
		
		newLL2.insertLast("Awais");
		newLL2.insertLast("Xman");
		newLL2.insertLast("Jam");
		
		newLL2.printForwards();
		newLL2.printBackwards();
		
		newLL2.deleteFirstNode();
		newLL2.deleteLastNode();
		
		newLL2.searchAndDelete("Xman");
		
		newLL2.printForwards();
		
		newLL2.insertAfter("Crow", "Jess");
		newLL2.insertAfter("Dro", "Joe");
		
		newLL2.printForwards();
	} // end of main() method
} // end class TestDLLApp
