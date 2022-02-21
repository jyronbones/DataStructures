import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class contains the food item inventory and the methods of to modify inventory array
 * @author/Student Name: Byron Jones
 * Student Number: 040585687
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Professor: James Mwangi PhD. 
 * 
  */
public class Inventory {

	/**
	 * Inventory array holding food items
	 */
	private ArrayList<FoodItem> inventory; // inventory array holding food items
	/**
	 * Number of items in inventory array
	 */
	private int numItems = 0; // number of items in inventory array
	
	/**
	 * Default constructor initializing inventory size to 20
	 */
	public Inventory() {
		inventory = new ArrayList<>(20); // initialize inventory array list to size of 20
	}
	
	/**
	 * Adds item to inventory depending on food item type specified
	 * @param scanner - Scanner object to use for input
	 * @param fromFile - boolean check if input is from file
	 * @return returns true if item added successfully
	 */
	public boolean addItem(Scanner scanner, boolean fromFile) {
		if (fromFile) { // read food item(s) from file
			readFromFile(scanner);
		} else { // read food item details from user
			String option;
			FoodItem foodItem = new FoodItem(); // food item object
			if (numItems == 20) { // check if inventory array is full (cannot be more than 20 items)
				System.out.println("Inventory is full");
				return false;
			}

			while (true) { // ask user for valid option until valid option input
				System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
				option = scanner.next(); // store user option
				if (option.equals("f") || option.equals("v") || option.equals("p")) // valid user option
					break;
				else // invalid user option
					System.out.println("Invalid entry");
				scanner.nextLine(); // clear buffer
			}

			switch (option) {
			case "f": // fruit
				foodItem = new Fruit(); // creates a fruit food item
				break;
			case "v": // vegetable
				foodItem = new Vegetable(); // creates a vegetable food item
				break;
			case "p": // preserve
				foodItem = new Preserve(); // creates a preserve food item
				break;

			default:
				break;
			}
			foodItem.inputCode(scanner, false); // reads food item's item code
			if (alreadyExists(foodItem) == -1) { // item code does not already exist
				foodItem.addItem(scanner, false); // read food item's details
				inventory.add(foodItem); // adds food item to inventory array
				numItems++;
			} else // item code already exists
				System.out.println("Item code already exists");
				return false;
		}
		Collections.sort(inventory); // sorts inventory array list by item code in descending order
		return true;
	}
	
	/**
	 * Checks if item code already exists in the inventory
	 * @param item - FoodItem object
	 * @return returns the index of the food item if found or -1 if not found
	 */
	public int alreadyExists(FoodItem item) { // checks if item code already exists in the inventory array
		for (int i = 0; i < numItems; i++) { // loops through all items in inventory
			if (inventory.get(i).isEqual(item)) // checks if item's item code matches any item codes in inventory
				return i;	// index of the item in inventory
		}
		return -1;
	}
	/**
	 * Updates the quantity of the food item in inventory depending on if user buys or sells
	 * @param scanner - Scanner object to use for input
	 * @param buyOrSell - represents true for buy and false for sell
	 * @return returns true if quantity is updated
	 */
	public boolean updateQuantity(Scanner scanner, boolean buyOrSell) { // updates quantity of the food item stored in inventory
		FoodItem foodItem = new FoodItem(); // make a FoodItem object
		int quantity = 0; // holds the quantity of the food item to be updated by in inventory
		String buyOrSellMessage = buyOrSell ? "buy" : "sell"; // buy or sell word for message
		String message = "Error... could not " + buyOrSellMessage + " item"; // error message if unable to buy or sell
	
		if (numItems <= 0) { // empty inventory
			System.out.println(message);
			return false;
		}
		foodItem.inputCode(scanner, false); // take item code for food item Object
		int foodItemIndex = alreadyExists(foodItem); // holds the index of food item if exists or -1 if inexistent
		
		if (alreadyExists(foodItem) > -1) { // check if foodItem object exists in the inventory array
			while (true) {
				try {
					System.out.print("Enter valid quantity to " + buyOrSellMessage + ": "); // ask user for buy or sell quantity
					quantity = scanner.nextInt(); // store quantity entered by user
					if (quantity < 1)
						throw new InputMismatchException();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid entry");
					scanner.nextLine();
				}
			}
			if (!buyOrSell) { // if sell item 
				quantity *= -1; // negative quantity
			}
			inventory.get(foodItemIndex).updateItem(quantity); // update the food item quantity in inventory
			return true;
		} else { // food item doesn't exist
			System.out.println(message);
			return false;
		}
	}
	
	/**
	 * Prints items of the inventory array
	 */
	@Override
	public String toString() { // prints items of the inventory array
		String result = "Inventory:\n";
		for (int i = 0; i < numItems; i++) { // loops through inventory adding items to result message
			result = result.concat(inventory.get(i).toString() + "\n"); 
		}
		return result;
	}
	
	/**
	 * Searches inventory array for an item code and prints food item details if found
	 * @param scanner - Scanner object to use for input
	 */
	public void searchForItem(Scanner scanner) {
		int itemCode = Integer.MIN_VALUE; // initialize item code
		try {
			while (true) {
				// ask user for item code
				System.out.print("Enter the code for the item: ");
				itemCode = scanner.nextInt();
				scanner.nextLine(); // clear buffer
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid entry");
			scanner.nextLine(); // clear buffer
		}
        int start = 0, end = inventory.size() - 1; 
        
        while (start <= end)
        { 
            int mid = start + (end - start) / 2; 
    
            // Check if item code is present at mid 
			if (inventory.get(mid).getItemCode() == itemCode) {
				System.out.println(inventory.get(mid).toString());
				return;
			}
    
            // If item code greater, ignore left half 
            if (inventory.get(mid).getItemCode() < itemCode) 
                start = mid + 1; 
    
            // If item code is smaller, ignore right half 
            else
                end = mid - 1; 
        } 
        
        // item code is not present 
        System.out.println("Code not found in inventory..."); 
	}
	
	/**
	 * Reads food items from a file
	 * @param scanner - Scanner object used to read food items
	 */
	public void readFromFile(Scanner scanner) {
		FoodItem foodItem = new FoodItem(); // food item object created
		// ask the user for filename
		System.out.print("Enter the filename to read from: ");
		String fileName = scanner.nextLine();
		while (true) { // ensures filename is of type txt
			if (!fileName.endsWith(".txt")) {
				System.out.println("Please specify a valid file type (.txt): ");
				fileName = scanner.nextLine();
			} else
				break;
		}
		try {
			scanner = new Scanner(new File(fileName));
			while (scanner.hasNextLine()) { // loops through file adding values to numbers array
					String foodType = scanner.nextLine(); // reads food type
					if (numItems == 20) { // checks if inventory array list is full
						System.out.println("cannot add more items, inventory is full");
						return;
					}
					switch (foodType) {
					case "f": // fruit food item
						foodItem = new Fruit();
						break;
					case "v": // vegetable food item
						foodItem = new Vegetable();
						break;
					case "p": // preserve food item
						foodItem = new Preserve();
						break;
					}
					foodItem.inputCode(scanner, true); // reads food item's item code
					if (alreadyExists(foodItem) == -1) { // check if food item's item code doesn't exist
						foodItem.addItem(scanner, true); // reads food item details
						inventory.add(foodItem); // adds food item to inventory array list
						numItems++;
						Collections.sort(inventory); // sorts inventory array list by item code in descending order
					} else { // food item's item code already exists
						System.out.println("Item code already exists\n"
								+ "Error Encountered while reading the file, aborting...");
						break;
					}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found, ignoring...");
		}
	}
	
	/**
	 * saves inventory of food item(s) to file
	 * @param scanner - Scanner object to use for input
	 */
	public void saveToFile(Scanner scanner) {
		// ask the user for filename
		System.out.print("Enter the filename to save to: ");
		String fileName = scanner.nextLine();
		while (true) { // ensures filename is of type txt
			if (!fileName.endsWith(".txt")) {
				System.out.println("Please specify a valid file type (.txt): ");
				fileName = scanner.nextLine();
			} else
				break;
		}
		try {
			Formatter formatter = new Formatter(fileName);
			for (int i = 0; i < numItems; i++) { // iterates through the inventory list writing to file
				inventory.get(i).outputItem(formatter);
			}
			formatter.close(); // close formatter
		} catch (IOException ioe) {
			System.err.println("IO Exception");
		}
	}

}
