package hashtable_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

import hashtable.HashtableChained;

/**
 * 
 */

/**
 * Starter files for Lab6 for CST8130
 * Prof. James Mwangi PhD.
 */

public class OttawaPostalCodeSearchTest { // Class contains method main

	/**
	 * main() which opens and read CSV file of Canadian postal codes for Ottawa
	 * 
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) { // main() which opens and reads CSV file of Canadian postal codes

		HashtableChained<String> htc = new HashtableChained<String>(); // creates a chained hash table object of type String
		String filename = "ottawapostalcodes_prefix_only.csv"; // stores file name
		Path file = Paths.get(filename); // // converts a path String for a path to file
		try (BufferedReader input = Files.newBufferedReader(file)) { // creates a buffered reader for file
			String line = null; // declare and initialize a String variable line to null
			while ((line = input.readLine()) != null) { // assigns each line of the file until end of file
				htc.add(line); // adds line of CSV file to entry of chained hash table
			} // while
		} catch (IOException ioException) { // exception handling error reading file
			System.err.println("...Error opening file...");
			ioException.printStackTrace(); // prints stack trace

		}
		// no need to close input. Use try-with-resources to auto-close the stream

		System.out.println("\n...Generating random prefixes...");
		
		for (int i = 0; i < 10; i++) { // generates 10 random postal code prefixes checking if found or not in hash table
			String rand = getRandomPrefix(); // stores random postal code prefix
			System.out.printf("Retrieving: %s\n", htc.contains(rand) ? rand + " found" : rand + " NOT found"); // check and display if found or not found
		}
	}// end of main()

	/*
	 *  create random generator once. To be used for the life of main(). Global
	 *  visibility
	 *  provide a seed value to get same random sequence
	 *  remove seed after testing
	 */
	// final static SecureRandom rand = new
	// SecureRandom("abcdefghijklmnop".getBytes());

	/**
	 * creates an object of a random number generator
	 */
	final static SecureRandom rand = new SecureRandom(); // creates an object of a random number generator
	/**
	 * Assigns alphabet characters to alpha String
	 */
	final static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // stores alphabet as a String
	/**
	 * Assigns numbers to number String
	 */
	final static String number = "0123456789"; // stores numbers as a String

	/**
	 * randomly generate a prefix using the correct format for Canadian postal codes
	 * 
	 * @return randomly generated prefix of the postal code
	 */
	public static String getRandomPrefix() { // randomly generate a prefix using the correct format for Canadian postal codes
		int randA = rand.nextInt(alpha.length()); // random letter from alphabet
		int randN = rand.nextInt(number.length()); // random number

		return "K" + number.charAt(randN) + alpha.charAt(randA); // returns randomly generated postal code prefix
	}// end of getRandomPrefix()

}// end of class
