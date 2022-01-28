import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class contains method main and the menu
 * @author/Student Name: Byron Jones
 * Student Number: 040585687
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Professor: James Mwangi PhD. 
 * 
  */
public class TestSearch {

	/**
	 * stores value for add value menu option
	 */
	private static final int ADD_VALUE = 1;
	/**
	 * stores value for linear recursive and binary recursive search menu option
	 */
	private static final int SEARCH = 2;
	/**
	 * stores value for displaying array list menu option
	 */
	private static final int DISPLAY = 3;
	/**
	 * stores value for exit program menu option
	 */
	private static final int EXIT = 4;
	/**
	 * This class is the driver method and contains the menu method.
	 * @param args - runtime argument array
	 */
	public static void main(String[] args) {
		showMenu();
	}

	/**
	 * Displays a menu and allows user to pick an option
	 */
	public static void showMenu() { // displays a menu allowing user to pick an option
		Scanner input = new Scanner(System.in); // Scanner for input
		Lab3Search search = new Lab3Search(); // creates search object for method calls
		boolean continueProgram = true; // initialize menu loop
		int option = 0; // initialize option to unavailable menu option
		do {
			try {
				while (true) {
					try {
						// ask user for menu option
						System.out.println("Please enter:" 
						+ "\n1: Add Item"	
						+ "\n2: Search for Item Linear and Binary search" 
						+ "\n3: Display list" 
						+ "\n4: Exit");
						option = input.nextInt();
						break;
					} catch (InputMismatchException e) {
						System.out.println("\ninvalid option, Try 1-4 again..\n");
						input.nextLine();
					}
				}

				switch (option) {
				case ADD_VALUE: // add value to array list
					search.addItem(input);
					break;
				case SEARCH: // search array list for value
					// ask the user for value to search for
					System.out.println("Please specify an Integer: ");
					int value = input.nextInt();
					search.binaryAndLinearCalls(value);
					break;
				case DISPLAY: // print array list
					search.displayList();
					break;
				case EXIT: // exit program
					System.out.println("Exiting...");
					continueProgram = false;
					break;
				default:
					System.out.println("\ninvalid option, Try 1-4 again..\n");
					break;
				}
			} catch (InputMismatchException ee) {
				System.err.println("Input mismatch, not a valid Integer");
				input.nextLine();
			}

		} while (continueProgram);
		input.close(); // close scanner
	}
}
