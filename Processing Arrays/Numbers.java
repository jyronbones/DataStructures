import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: 
 * Student Number: 
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD. 
 * 
  */
public class Numbers {
	/**
	 * Stores Float values.
	 */
	private Float [] numbers;
	
	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems;

	/**
	 * Default Constructor
	 */
	public Numbers() {
		this.numbers = new Float[10];
		for (int i = 0; i < numbers.length; i++) // assigning each element in numbers to 0.0
			numbers[i] = 0.0f;
	}

	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		this.numbers = new Float[size];
		Arrays.fill(numbers, 0.0f); // Assigning numbers' elements to 0.0
	}
	
	/**
	 * Adds a value in the array
	 * @param isFromFile - boolean if value(s) from file
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValue(boolean isFromFile, Scanner keyboard) {
		if (isFromFile == true)
			readFileValues(keyboard);
		else {
		if (numItems == numbers.length) {
			System.out.println("Array full");
			return;
		}
		// ask user for array value
		try {
			System.out.print("Enter value: ");
			float value = keyboard.nextFloat();			
			numbers[numItems] = value;
			numItems++;
		} catch (InputMismatchException e) {
			System.err.println("Input mismatch");
		}
		keyboard.nextLine();
		}
	}
	
	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		if (numItems == 0)
			return 0.0f;
		float total = 0.0f;
		for (int i = 0; i < numItems; i++) { // summing elements in the array and skipping nulls
			total += numbers[i];
		}
		return total / numItems;
	}
	
	/**
	 * Calculates the max, min and max mod min of all the values in the numbers array.
	 */
	public void findMinMax() {
		float max = numbers[0];
		float min = numbers[0];
		float maxModMin = 0;
		
		for (int i = 0; i < numItems; i++) { // loops through array storing max and min values
			if (numbers[i] > max) 
				max = numbers[i];
			if (numbers[i] < min)
				min = numbers[i];
		}
		if (min == 0 || min == max) 
			maxModMin = 0.0f;
		else
			maxModMin = max % min;

		System.out.printf("Average is: %.2f, minimum value = %.1f, maximum value = %.1f, maxValue Mod minValue is %.2f\n\n", calcAverage(), min, max, maxModMin);
	}
	
	/**
	 * Allows the user to enter multiple values into the array
	 * @param keyboard - Scanner object to use for input
	 */
	public void multiValues(Scanner keyboard) {
		// ask user for number of values
		System.out.print("How many values do you wish to add? ");
		int numValues = keyboard.nextInt();
		if ((numValues + numItems) > numbers.length) {
			System.out.println("No room in array to add all values");
			return;
		}
		while (numValues < 0) { // if negative numValues, continually ask user for number of items
			System.out.print("\nNumber of values must be a positive integer\nRe-enter number of values: ");
			numValues = keyboard.nextInt();
		}
		for (int i = 0; i < numValues; i++) { // loops asking user to enter value for the amount of values chosen
			System.out.print("Enter value: ");
			float value = keyboard.nextFloat();
			numbers[numItems] = value;
			numItems++;
		}
	}
	
	/**
	 * Reads values from a specified file
	 * @param keyboard - Scanner object to use for input
	 */
	public void readFileValues(Scanner keyboard) {
		// ask the user for filename
		System.out.println("Name of file to read from:");
		String fileName = keyboard.nextLine();
		while (true) { // ensures filename is of type txt
			if (!fileName.endsWith(".txt")) {
				System.out.println("Please specify a valid file type (.txt): ");
				fileName = keyboard.nextLine();
			} else
				break;
		}
		try {
			keyboard = new Scanner(new File(fileName));
			while (keyboard.hasNextLine()) { // loops through file adding values to numbers array
					numbers[numItems] = keyboard.nextFloat();
					numItems++;
				if (numItems >= numbers.length) {
					System.out.println("No room in array to add all values");
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		}
	}
	
	/**
	 * Saves values of array to specified file
	 * @param keyboard - Scanner object to use for input
	 */
	public void saveValuesFile(Scanner keyboard) {
		// ask the user for filename
		System.out.println("Name of file to save to:");
		String fileName = keyboard.nextLine();
		while (true) { // ensures filename is of type txt
			if (!fileName.endsWith(".txt")) {
				System.out.println("Please specify a valid file type (.txt): ");
				fileName = keyboard.nextLine();
			} else
				break;
		}
		try {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
				for (int i = 0; i < numItems; i++) { // writes numbers array values to file
					if (i == numItems -1)
						writer.write(numbers[i].toString());
					else
					writer.write(numbers[i].toString() + "\n");
				}
				writer.flush();
			}
		} catch (IOException ioe) {
			System.err.println("IO Exception");
		}
	}

	/**
	 * Returns a string of values in the array
	 */
	@Override
	public String toString() {
		String result = "Numbers are:\n";
		for (int i = 0; i < numItems; i++) // loops through adding numbers values to result
			result = result.concat(numbers[i].toString() + "\n");
		return result;
	}
}