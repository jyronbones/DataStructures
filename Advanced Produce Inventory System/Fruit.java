import java.util.Formatter;
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
	 * @param scanner - Scanner to use for input
	 * @param fromFile - boolean check if from from file
	 */
	@Override
	public boolean addItem(Scanner scanner, boolean fromFile) { // adds fruit food item details
		if (fromFile) { // from file
			super.addItem(scanner, true);
		} else { // user input
			super.addItem(scanner, false);
			//asks user for orchard supplier
			System.out.print("Enter the name of the orchard supplier: ");
		}
		orchardName = scanner.nextLine();
		return true;
	}
	
	/**
	 * Prints fruit food item details
	 */
	@Override
	public String toString() { // prints fruit food item details
		return String.format(super.toString() + " orchard supplier: %s", orchardName);
	}
	
	/**
	 * Formats fruit food item to save to file
	 * @param writer - Formatter object for formatting output
	 */
	@Override
	public void outputItem (Formatter writer) {  // formats vegetable food item and farm name to save to file
		writer.format("%c\n", 'f'); // specifies food item type as fruit
		super.outputItem(writer); // call to super for formatted food item properties
		writer.format("%s\n", orchardName);
	}
}
