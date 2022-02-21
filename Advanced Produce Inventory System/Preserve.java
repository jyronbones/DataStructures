import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class contains the method to add and display a preserve food item
 * @author/Student Name: Byron Jones
 * Student Number: 040585687
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Professor: James Mwangi PhD. 
 * 
  */
public class Preserve extends FoodItem{
	
	/**
	 * Stores the jar size of preserve food item
	 */
	private int jarSize;
	
	/**
	 * Default constructor
	 */
	public Preserve() {
	}
	
	/**
	 * Adds food item details and jar size of preserve food item
	 * @param scanner - Scanner to use for input
	 * @param fromFile - boolean check if from from file
	 */
	@Override
	public boolean addItem(Scanner scanner, boolean fromFile) { // adds preserve food item details
		if (fromFile) // from file
			super.addItem(scanner, true);
		else { // user input
			super.addItem(scanner, false);
			// asks user for jar size of preserve food item
			System.out.print("Enter the size of the jar in millilitres: ");
		}
		while (true) {
			try {
				// reads jar size
				jarSize = scanner.nextInt();
				if (jarSize < 0) // check if jar size is negative
					throw new InputMismatchException();
				scanner.nextLine(); // clear buffer
				break;
			} catch (InputMismatchException e) {
				System.out.print("Error...invalid jar size, please try again: ");
				scanner.nextLine();
			}
		}
		return true;
	}
	/**
	 * Prints preserve food item details
	 */
	@Override
	public String toString() { // prints preserve food item details
		return String.format(super.toString() + " size: %dmL", jarSize);
	}
	
	/**
	 * Formats preserve food item to save to file
	 * @param writer - Formatter object for formatting output
	 */
	@Override
	public void outputItem (Formatter writer) { // formats preserve food item and jar size to save to file
		writer.format("%c\n", 'p'); // specifies food item type as preserve
		super.outputItem(writer); // call to super for formatted food item properties
		writer.format("%d\n", jarSize ); // formats jar size

	}
	
}
