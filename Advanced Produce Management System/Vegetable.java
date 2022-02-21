import java.util.Formatter;
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
	 * @param scanner - Scanner to use for input
	 * @param fromFile - boolean check if from from file
	 */
	@Override
	public boolean addItem(Scanner scanner, boolean fromFile) { // adds vegetable food item details
		if (fromFile) // from file
			super.addItem(scanner, true);
		else { // user input
			super.addItem(scanner, false);
			// asks user for farm supplier of vegetable food item
			System.out.print("Enter the name of the farm supplier: ");
		}
		farmName = scanner.nextLine(); // read farm name
		
		return true;
	}
	
	/**
	 * Prints vegetable food item details
	 */
	@Override
	public String toString() { // prints vegetable food item details
		return String.format(super.toString() + " farm supplier: %s", farmName);
	}
	
	/**
	 * Formats vegetable food item to save to file
	 * @param writer - Formatter object for formatting output
	 */
	@Override
	public void outputItem(Formatter writer) { // formats vegetable food item and farm name to save to file
		writer.format("%c\n", 'v'); // specifies food item type as vegetable
		super.outputItem(writer); // call to super for formatted food item properties
		writer.format("%s\n", farmName); // formats jar size
	}
}
