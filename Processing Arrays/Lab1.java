import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * CET - CS Academic Level 3
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Byron Jones
 * Student Number: 040585687
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD. 
 * 
  */
public class Lab1 {
	/**
	 * Stores value for option to initialize array
	 */
	private final static int INIT_ARRAY = 1;
	/**
	 * Stores value for option to initialize array with user input for size
	 */
	private final static int ARRAY_SIZE = 2;
	/**
	 * Stores value for option to add value to array
	 */
	private final static int ADD_VALUE = 3;
	/**
	 * Stores value for option to display values of array
	 */
	private final static int DISPLAY_VALUES = 4;
	/**
	 * Stores value for option to display the average, max, min and max min mod of array
	 */
	private final static int DISPLAY_AVG_MIN_MAX_MOD = 5;
	/**
	 * Stores value for option to exit program
	 */
	private final static int EXIT = 6;

	/**
	 * This class is the driver method and contains the menu method.
	 * @param args is the runtime argument array
	 */
	public static void main(String[] args) {
		displayMainMenu();
	}
	
	/**
	 * Displays a menu to user with selection of options.
	 */
	public static void displayMainMenu() {
		Scanner input = new Scanner(System.in);
		Numbers numbers = new Numbers();
		boolean continueProgram = true;
		do {
			try {
				// ask user for menu option
				System.out.print("Please select one of the following:" + "\n1: Initialize a default array"
						+ "\n2. To specifiy the max size of the array" + "\n3. Add value to the array"
						+ "\n4. Display values in the array"
						+ "\n5. Display average of the values, minimum value, maximum value, max mod min"
						+ "\n6: To Exit" + "\n>");
				String option1 = input.nextLine();
				int option = Integer.parseInt(option1);

				switch (option) {
				case INIT_ARRAY:
					numbers = new Numbers();
					break;
				case ARRAY_SIZE:
					// ask user for array size
					System.out.print("Enter new size of array: ");
					int size = input.nextInt();
					while (size < 0) { // if negative size continually ask user for positive array size
						System.out.print("\nSize must be a positive integer\nRe-enter size: ");
						size = input.nextInt();
					}
					numbers = new Numbers(size);
					input.nextLine();
					break;
				case ADD_VALUE:
					numbers.addValue(input);
					break;
				case DISPLAY_VALUES:
					System.out.println(numbers.toString());
					break;
				case DISPLAY_AVG_MIN_MAX_MOD:
					numbers.findMinMax();
					break;
				case EXIT:
					System.out.println("Exiting...");
					continueProgram = false;
					break;
				default:
					System.out.println("\nIncorrect selection\n");
					break;
				}
			} catch (NumberFormatException | InputMismatchException e) {
				System.err.println("Input mismatch");
			}
		} while (continueProgram);
		input.close();
	}
}
