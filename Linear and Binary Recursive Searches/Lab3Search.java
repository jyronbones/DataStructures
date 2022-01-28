import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * This class contains the array list and methods to add items, display items, binary and linear search for an item
 * @author/Student Name: Byron Jones
 * Student Number: 040585687
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Professor: James Mwangi PhD. 
 * 
 */
public class Lab3Search {
	
	/**
	 * array list to hold integers
	 */
	private ArrayList<Integer> numList;

	/**
	 * Default constructor
	 */
	public Lab3Search() { // instantiate numList
		numList = new ArrayList<Integer>(); 
	}

	/**
	 * Ask user for integer and add to array list numList
	 * @param input - Scanner object to use for input
	 */
	public void addItem(Scanner input) { // allows user to input integer to add to numList
		// ask user for integer to add to array list
		System.out.println("Please specify an Integer: ");
		numList.add(input.nextInt());
		System.out.println();
		Collections.sort(numList); // sort array list
	}
	
	/**
	 * Calls linear recursive and binary recursive methods to search for value
	 * @param value - integer chosen by user to search for
	 */
	public void binaryAndLinearCalls(int value) { // linear recursion and binary recursion method calls

		recursiveLinearSearch(0, numList.size() - 1, value);
		recursiveBinarySearch(0, numList.size(), value);
		System.out.println();
	}

	/**
	 * Continuously splits the array list into 2 partitions recursively calling the partition which range contains value, searching for value
	 * @param start - first index of the array list
	 * @param end - last index of the array list
	 * @param value - integer to be searched
	 * @return returns located index
	 */
	public int recursiveBinarySearch(int start, int end, int value) { // searches for a value using binary recursion
		
		if (start >= end) { // partition of  0 elements
			System.out.println("Binary Search: Index of Integer is: Not Found");
			return -1;
		}

		int midpoint = (start + end) / 2;

		if (numList.get(midpoint) == value) { // value is midpoint
			System.out.println("Binary Search: Index of Integer is: " + midpoint);
			return midpoint;
		} else if (numList.get(midpoint) < value) { // value in the right partition
			return recursiveBinarySearch( midpoint + 1, end, value); // recursive call, start = midpoint + 1
		} else { // value in the left partition
			return recursiveBinarySearch( start, midpoint, value); // recursive call, end = midpoint
		}
	}

	/**
	 * Searches for a value by constantly checking first and last index and recursive call incrementing first and decrementing last if not found
	 * @param start - first index of the array list
	 * @param end - last index of the array list
	 * @param value - integer to be searched
	 * @return returns located index
	 */
	public int recursiveLinearSearch(int start, int end, int value) { // search for value using linear recursion
		
		if (end < 0) { // partition of  no elements
			System.out.println("Linear Search: Index of Integer is: Not Found");
			return -1;
		}
		if (numList.get(start) == value) { // first index is value
			System.out.println("Linear Search: Index of Integer is: " + start);
			return start;
		}
		if (numList.get(end) == value) { // last index is value
			System.out.println("Linear Search: Index of Integer is: " + end);
			return end;
		}
		return recursiveLinearSearch(start + 1, end - 1, value); // recursive call incrementing start and decrementing end
	}

	/**
	 * Prints array list numList
	 */
	public void displayList() { // prints numList
		System.out.println("Arraylist contains " + numList.toString());
	}
}
