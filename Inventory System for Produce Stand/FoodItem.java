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
public class FoodItem {

	/**
	 * Stores item code of food item
	 */
	protected int itemCode;
	/**
	 * Stores item name of food item
	 */
	protected String itemName;
	/**
	 * Stores item quantity in stock of food item
	 */
	protected int itemQuantityInStock;
	/**
	 * Stores item cost of food item
	 */
	protected float itemCost;
	/**
	 * Stores item price of food item
	 */
	protected float itemPrice;
	
	/**
	 * Default constructor
	 */
	public FoodItem() {
	}
	
	/**
	 * Asks user to input food item code
	 * @param scanner - Scanner object to use for input
	 * @return returns true if item code successfully stored
	 */
	public boolean inputCode(Scanner scanner) {
		while (true) {
			try {
				// asks the user for food item code
				System.out.print("Enter the code for the item: ");
				itemCode = scanner.nextInt();
				scanner.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid code");
				scanner.nextLine();
			}
		}
		return true;
	}

	/**
	 * Adds food item property details based on user input
	 * @param scanner - Scanner object to use for input
	 * @return returns true if food item details added successfully
	 */
	public boolean addItem(Scanner scanner) { // reads from the Scanner object passed in and fills the data member fields of the class with valid data;
		inputCode(scanner); // asks user for item code
		
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
				scanner.nextLine();
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
		} else {
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
}
