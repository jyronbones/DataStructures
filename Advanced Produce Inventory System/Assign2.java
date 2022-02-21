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
public class Assign2 {
	/**
	 * Stores value for option to add item to inventory
	 */
	private static final String ADD_ITEM = "1";
	/**
	 * Stores value for option to display inventory
	 */
	private static final String DISP_INV = "2";
	/**
	 * Stores value for option to buy item(s) from inventory
	 */
	private static final String BUY_ITEM = "3";
	/**
	 * Stores value for option to sell item(s) from inventory
	 */
	private static final String SELL_ITEM = "4";
	/**
	 * Stores value for option to search an item from inventory
	 */
	private static final String SEARCH_ITEM = "5";
	/**
	 * Stores value for option to save inventory to a file
	 */
	private static final String SAVE_FILE = "6";
	/**
	 * Stores value for option to read inventory from a file
	 */
	private static final String READ_FILE = "7";
	/**
	 * Stores value for option to exit program
	 */
	private static final String EXIT = "8";
	
	/**
	 * Driver method running the menu
	 * @param args is the runtime argument array
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // scanner object for user input
		Inventory inventory = new Inventory(); // creates an inventory object
		boolean continueProgram = true;
		String option = "";
		
		do {
				displayMenu(); // displays menu
				option = input.nextLine(); // ask user and store menu option
				switch (option) {
				case ADD_ITEM: // add item to inventory
					inventory.addItem(input, false);
					break;
				case DISP_INV: // display items in inventory
					System.out.println(inventory.toString());
					break;
				case BUY_ITEM: // buy item(s) from inventory
					inventory.updateQuantity(input, true);
					break;
				case SELL_ITEM: // sells item(s) from inventory
					inventory.updateQuantity(input, false);
					break;
				case SEARCH_ITEM: // searches for item in inventory
					inventory.searchForItem(input);
					break;
				case SAVE_FILE: // saves inventory to a file
					inventory.saveToFile(input);
					break;
				case READ_FILE: // reads inventory from a file
					inventory.addItem(input, true);
					break;
				case EXIT: // exits program
					System.out.println("Exiting...");
					continueProgram = false;
					break;
				default: // default case for bad input
					System.out.println("Invalid option, please enter option 1-5...");
					break;
				}
		} while (continueProgram);
		input.close(); // close scanner
	}
	
	/**
	 * Displays a menu to user for option selection
	 */
	public static void displayMenu() { // displays a menu to user for option selection
		System.out.print("Please select one of the following:\n" // menu options
				+ "1: Add Item to Inventory\n"
				+ "2: Display Current Inventory\n"
				+ "3: Buy Item(s)\n"
				+ "4: Sell Item(s)\n"
				+ "5: Search for Item\n"
				+ "6: Save Inventory to File\n"
				+ "7: Read Inventory from File\n"
				+ "8: To Exit\n"
				+ "> ");
	}
}
