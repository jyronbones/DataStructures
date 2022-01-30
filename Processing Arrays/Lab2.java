import java.utihttps://github.com/jyronbones/DataStructures/tree/main/Processing%20Arraysl.InputMismatchException;
import java.util.Scanner;
/**
 * This class contains the dynamically allocated array and it's processing
 * 
  */
public class Lab2 {
	/**
	 * Stores value for option to initialize array
	 */
	private static final int INIT_ARRAY = 1;
	/**
	 * Stores value for option to initialize array with user input for size
	 */
	private static final int ARRAY_SIZE = 2;
	/**
	 * Stores value for option to add value to array
	 */
	private static final int ADD_VALUE = 3;
	/**
	 * Stores value for option to display values of array
	 */
	private static final int DISPLAY_VALUES = 4;
	/**
	 * Stores value for option to display the average, max, min and max min mod of array
	 */
	private static final int DISPLAY_AVG_MIN_MAX_MOD = 5;
	/**
	 * Stores value for option to enter multiple values into array
	 */
	private static final int MULTIPLE_VALUES = 6;
	/**
	 * Stores value for option to read values of array from file
	 */
	private static final int READ_FILE_VALUES = 7;
	/**
	 * Stores value for option to save values of array to file
	 */
	private final static int SAVE_VALUES_FILE = 8;
	/**
	 * Stores value for option to exit program
	 */
	private final static int EXIT = 9;

	/**
	 * Driver method and contains the menu method.
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
				System.out.print("Please select one of the following:" 
						+ "\n1: Initialize a default array"
						+ "\n2: To specifiy the max size of the array" 
						+ "\n3: Add value to the array"
						+ "\n4: Display values in the array"
						+ "\n5: Display average of the values, minimum value, maximum value, max mod min"
						+ "\n6: Enter multiple values"
						+ "\n7: Read values from file"
						+ "\n8. Save values to file"
						+ "\n9: To Exit" + "\n>");
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
					numbers.addValue(false, input);
					break;
				case DISPLAY_VALUES:
					System.out.println(numbers.toString());
					break;
				case DISPLAY_AVG_MIN_MAX_MOD:
					numbers.findMinMax();
					break;
				case MULTIPLE_VALUES:
					numbers.multiValues(input);
					input.nextLine();
					break;
				case READ_FILE_VALUES:
					numbers.addValue(true, input);
					break;
				case SAVE_VALUES_FILE:
					numbers.saveValuesFile(input);
					break;
				case EXIT:
					System.out.println("Exiting...");
					continueProgram = false;
					break;
				default:
					System.out.println("\ninvalid input, enter options 1-9\n");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("\ninvalid input, enter options 1-9\n");
			} catch (InputMismatchException ee) {
				System.err.println("Input mismatch");
				input.nextLine();
			}
		} while (continueProgram);
		input.close();
	}
}
