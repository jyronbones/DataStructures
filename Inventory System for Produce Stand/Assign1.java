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
public class Assign1 {
	/**
	 * Stores value for option to add item to inventory
	 */
	private static final int ADD_ITEM = 1;
	/**
	 * Stores value for option to display inventory
	 */
	private static final int DISP_INV = 2;
	/**
	 * Stores value for option to buy item(s) from inventory
	 */
	private static final int BUY_ITEM = 3;
	/**
	 * Stores value for option to sell item(s) from inventory
	 */
	private static final int SELL_ITEM = 4;
	/**
	 * Stores value for option to exit program
	 */
	private static final int EXIT = 5;
	
	/**
	 * Driver method running the menu
	 * @param args is the runtime argument array
	 */
	public static void main(String[] args) {
		displayMenu();

	}
	
	/**
	 * Displays a menu to user for option selection
	 */
	public static void displayMenu() { // displays a menu to user for option selection
		Scanner input = new Scanner(System.in); // scanner object for user input
		Inventory inventory = new Inventory(); // creates an inventory object
		boolean continueProgram = true;
		int option = 0;
		
		do {
			try {
				System.out.print("Please select one of the following:\n" // menu options
						+ "1: Add Item to Inventory\n"
						+ "2: Display Current Inventory\n"
						+ "3: Buy Item(s)\n"
						+ "4: Sell Item(s)\n"
						+ "5: To Exit\n"
						+ ">");
				option = input.nextInt(); // ask user and store menu option
				switch (option) {
				case ADD_ITEM: // add item to inventory
					inventory.addItem(input);
					break;
				case DISP_INV: // display items in inventory
					System.out.println(inventory.toString());
					break;
				case BUY_ITEM: // buy item(s) from inventory
					inventory.updateQuantity(input, true);
					break;
				case SELL_ITEM: // sell item(s) from inventory
					inventory.updateQuantity(input, false);
					break;
				case EXIT: // exits program
					System.out.println("Exiting...");
					continueProgram = false;
					break;
				default: // default case for invalid option
					System.out.println("Invalid option, please enter option 1-5...");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid option, please enter option 1-5...");
				input.nextLine();
			}
		} while (continueProgram);
		input.close(); // close scanner
	}

}
