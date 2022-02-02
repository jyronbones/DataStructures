import java.util.Scanner;
/**
 * This class contains the method to add and display a fruit food item
 * @author/Student Name: Byron Jones
 * Student Number: 040585687
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Professor: James Mwangi PhD. 
 * 
  */
public class Fruit extends FoodItem{

	/**
	 * Stores orchard name of fruit food item
	 */
	private String orchardName;
	
	/**
	 * Default constructor
	 */
	public Fruit() {
	}
	
	/**
	 * Adds food item details and orchard name of fruit food item
	 */
	@Override
	public boolean addItem(Scanner input) { // adds fruit food item details
		super.addItem(input);
		
		//asks user for orchard supplier
		System.out.print("Enter the name of the orchard supplier: ");
		orchardName = input.nextLine();
		return true;
	}
	
	/**
	 * Prints fruit food item details
	 */
	@Override
	public String toString() { // prints fruit food item details
		return String.format(super.toString() + " orchard supplier: %s", orchardName);
	}
}
