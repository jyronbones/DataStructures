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
	private FoodItem[] inventory; // inventory array holding food items
	/**
	 * Number of items in inventory array
	 */
	private int numItems = 0; // number of items in inventory array
	
	/**
	 * Default constructor initializing inventory size to 20
	 */
	public Inventory() {
		inventory = new FoodItem[20]; // initialize inventory array to size of 20
	}
	
	/**
	 * Adds item to inventory depending on food item type specified
	 * @param scanner - Scanner object to use for input
	 * @return returns true if item added successfully
	 */
	public boolean addItem(Scanner scanner) {
		String option;
		if (numItems == inventory.length) { // check if inventory array is full
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
				scanner.nextLine();
		}

		switch (option) {
		case "f": // fruit
			FoodItem fruit = new Fruit(); // creates a fruit food item
			fruit.addItem(scanner); // reads details of fruit item from user
			inventory[numItems] = fruit; // stores fruit object in inventory array
			numItems++;
			break;
		case "v": // vegetable
			FoodItem vegetable = new Vegetable(); // creates a vegetable food item
			vegetable.addItem(scanner); // reads details of vegetable item from user
			inventory[numItems] = vegetable; // stores vegetable object in inventory array
			numItems++;
			break;
		case "p": // preserve
			FoodItem preserve = new Preserve(); // creates a preserve food item
			preserve.addItem(scanner); // reads details of preserve item from user
			inventory[numItems] = preserve; // stores preserve object in inventory array
			numItems++;
			break;

		default:
			break;
		}
		return true;
	}
	
	/**
	 * Checks if item code already exists in the inventory
	 * @param item - FoodItem object
	 * @return returns the index of the food item if found or -1 if not found
	 */
	public int alreadyExists(FoodItem item) { // checks if item code already exists in the inventory array
		for (int i = 0; i < numItems; i++) { // loops through all items in inventory
			if (inventory[i].isEqual(item)) // checks if item's item code matches any item codes in inventory
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
		foodItem.inputCode(scanner); // take item code for food item Object
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
			inventory[foodItemIndex].updateItem(quantity); // update the food item quantity in inventory
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
			result = result.concat(inventory[i].toString() + "\n"); 
		}
		return result;
	}

}
