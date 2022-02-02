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
	int jarSize;
	
	/**
	 * Default constructor
	 */
	public Preserve() {
	}
	
	/**
	 * Adds food item details and jar size of preserve food item
	 */
	@Override
	public boolean addItem(Scanner input) { // adds preserve food item details
		super.addItem(input);
		
		// asks user for jar size of preserve food item
		while (true) {
			try {
				System.out.print("Enter the size of the jar in millilitres: ");
				jarSize = input.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Error...invalid jar size");
				input.nextLine();
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
	
}
