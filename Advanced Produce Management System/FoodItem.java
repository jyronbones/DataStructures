import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class contains the food item properties and methods to read and modify food item info
 * @author/Student Name: Byron Jones
 * Student Number: 040585687
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Professor: James Mwangi PhD. 
 * 
  */
public class FoodItem implements Comparable<FoodItem>{

	/**
	 * Stores item code of food item
	 */
	private int itemCode;
	/**
	 * Stores item name of food item
	 */
	private String itemName;
	/**
	 * Stores item quantity in stock of food item
	 */
	private int itemQuantityInStock;
	/**
	 * Stores item cost of food item
	 */
	private float itemCost;
	/**
	 * Stores item price of food item
	 */
	private float itemPrice;
	
	/**
	 * Default constructor
	 */
	public FoodItem() {
	}
	
	/**
	 * Asks user to input food item code
	 * @param scanner - Scanner object to use for input
	 * @param fromFile - boolean if input code is from file
	 * @return returns true if item code successfully stored
	 */
	public boolean inputCode(Scanner scanner, boolean fromFile) {
		if (fromFile) { // reading food item code from file
			itemCode = scanner.nextInt();
			scanner.nextLine();
		} else { // user input
			while (true) {
				try {
					// asks the user for food item code
					System.out.print("Enter the code for the item: ");
					itemCode = scanner.nextInt();
					scanner.nextLine(); // clear buffer
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid code");
					scanner.nextLine(); // clear buffer
				}
			}
		}
		return true;
	}
	
	/**
	 * Gets the item code of a food item
	 * @return returns the item code of a food item
	 */
	public int getItemCode() {
		return itemCode;
	}

	/**
	 * Adds food item property details based on user input
	 * @param scanner - Scanner object to use for input
	 * @param fromFile - boolean check if input code is from file
	 * @return returns true if food item details added successfully
	 */
	public boolean addItem(Scanner scanner, boolean fromFile) { // reads from the Scanner object passed in and fills the data member fields of the class with valid data;
		if (fromFile) { // reading item details from file
			itemName = scanner.nextLine(); // item name
			itemQuantityInStock = scanner.nextInt(); // quantity of item
			itemCost = scanner.nextFloat(); // item cost
			itemPrice = scanner.nextFloat(); // item price
		} else { // reading item details from user
			// asks user for item name
			System.out.print("Enter the name for the item: ");
			itemName = scanner.nextLine();

			while (true) {
				try {
					// ask user for item quantity
					System.out.print("Enter the quantity for the item: ");
					itemQuantityInStock = scanner.nextInt();
					if (itemQuantityInStock < 0) // quantity cannot be negative
						throw new InputMismatchException();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid entry");
					scanner.nextLine();
				}
			}

			while (true) {
				try {
					// asks user for item cost
					System.out.print("Enter the cost of the item: ");
					itemCost = scanner.nextFloat();
					if (itemCost < 0) // cost cannot be negative
						throw new IllegalArgumentException();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid entry");
					scanner.nextLine();
				} catch (IllegalArgumentException ee) {
					System.out.println("Invalid entry");
				}
			}

			while (true) {
				try {
					// ask user for item price
					System.out.print("Enter the sales price of the item: ");
					itemPrice = scanner.nextFloat();
					if (itemPrice < 0) // item price cannot be negative
						throw new IllegalArgumentException();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid entry");
					scanner.nextLine();
				} catch (IllegalArgumentException ee) {
					System.out.println("Invalid entry");
				}
			}
		}
		scanner.nextLine(); // clear buffer
		return true;
	}
	
	/**
	 * Updates food item quantity based on passed amount
	 * @param amount - amount to update the quantity by
	 * @return returns true if successfully updated food item quantity
	 */
	public boolean updateItem(int amount) {
		if (itemQuantityInStock + amount < 0) { // checks if quantity after update is negative
			System.out.println("Error... could not sell item");
			return false;
		} else { // quantity after update is positive
			itemQuantityInStock += amount;
			return true;
		}
	}
	
	/**
	 * Checks if passed food item's item code is equal to any food item's item code
	 * @param item - passed food item object
	 * @return returns true if food item item code is equal to any food items item code
	 */
	public boolean isEqual(FoodItem item) {
		return item.itemCode == itemCode;
	}
	
	/**
	 * Prints food item details
	 */
	@Override
	public String toString() { // prints food item details
		return String.format("Item: %d %s %d price: $%.2f cost: $%.2f", itemCode, itemName, itemQuantityInStock, itemPrice, itemCost);
	}
	
	/**
	 * Formats food item's properties to be written to a file
	 * @param writer - Formatter to format food item properties
	 */
	public void outputItem (Formatter writer) {
		writer.format("%d\n%s\n%d\n%.2f\n%.2f\n", itemCode, itemName, itemQuantityInStock, itemCost, itemPrice );
	}
	
	/**
	 * Overrides compareTo(), compares a food item code for sorting
	 * @param food - FoodItem passed to compare food item's code
	 */
    @Override
    public int compareTo(FoodItem food) {
        return Integer.compare(itemCode, food.itemCode);
    }
}
