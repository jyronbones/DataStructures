import java.util.Scanner;
/**
 * This class contains the method to add and display a vegetable food item
 * @author/Student Name: Byron Jones
 * Student Number: 040585687
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Professor: James Mwangi PhD. 
 * 
  */
public class Vegetable extends FoodItem{
	
	/**
	 * Stores farm name of vegetable food item
	 */
	private String farmName;
	
	/**
	 * Default constructor
	 */
	public Vegetable() {
	}
	
	/**
	 * Adds food item details and farm supplier of vegetable food item
	 */
	@Override
	public boolean addItem(Scanner input) { // adds vegetable food item details
		super.addItem(input);
		
		// asks user for farm supplier of vegetable food item
		System.out.print("Enter the name of the farm supplier: ");
		farmName = input.nextLine();
		
		return true;
	}
	
	/**
	 * Prints vegetable food item details
	 */
	@Override
	public String toString() { // prints vegetable food item details
		return String.format(super.toString() + " farm supplier: %s", farmName);
	}
}
