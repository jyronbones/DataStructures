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
	}

	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		this.numbers = new Float[size];
	}
	
	/**
	 * Adds a value in the array
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValue(Scanner keyboard) {
		if (numItems == numbers.length) {
			System.out.println("Array full");
			return;
		}
		// ask user for array value
		System.out.print("Enter value: ");
		try {
			float value = keyboard.nextFloat();			
			numbers[numItems] = value;
			numItems++;
		} catch (InputMismatchException e) {
			System.err.println("Input mismatch");
			keyboard.nextLine();
		}
		keyboard.nextLine();
	}
	
	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		float total = 0.0f;
		int i;
		for (i = 0; i < numbers.length; i++) { // summing elements in the array and skipping nulls
			if (numbers[i] == null)
				continue;
			total += numbers[i];
		}
		return total / numItems;
	}
	
	/**
	 * Calculates the max, min and max mod min of all the values in the numbers array.
	 */
	public void findMinMax() {
		if (numbers[0] == null) {
			System.out.printf("Average is: %.1f, Minimum value is %.1f, Maximum value is %.1f, Max Mod Min is %s\n\n", 0.0, 0.0, 0.0, "_____");
			return;
		}
		float max = numbers[0];
		float min = numbers[0];
		float maxModMin;
		
		for (int i = 0; i < numbers.length; i++) { // loops through array storing max and min values
			if (numbers[i] == null)
				continue;
			if (numbers[i] > max) {
				max = numbers[i];
			}
			if (numbers[i] < min) {
				min = numbers[i];
			}
		}
		maxModMin = max % min;

		System.out.printf("Average is: %.2f, Minimum value is %.1f, Maximum value is %.1f, Max Mod Min is %.1f\n\n", calcAverage(), min, max, maxModMin);
	}

	/**
	 * Returns a string of values in the array
	 */
	@Override
	public String toString() {
		String result = "Numbers are:\n";
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == null)
				continue;
			result = result.concat(numbers[i].toString() + "\n");
		}
		return result;
	}
}
