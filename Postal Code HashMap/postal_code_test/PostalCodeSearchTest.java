package postal_code_test;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import postal_code.PostalCodeEntry;

/**
 * Starter file for Assigment3 for CST8130
 * @auther James, Georger
 */
/**
 * 
 * This class contains method main
 *
 */
public class PostalCodeSearchTest { // This class contains method main

	/**
	 * main() which opens and read CSV file of Canadian postal codes
	 * Creates a hash map storing postal code prefix as key and postal code prefix and info as value
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) { // main() which opens and read CSV file of Canadian postal codes
		Map<String, PostalCodeEntry> map = new HashMap<>(); // Creates a Hashmap object

		String filename = "ottawa_postal_codes.csv"; // Stores name of file in filename
		Path file = Paths.get(filename); // Converts a path String for a path to file
		try (BufferedReader input = Files.newBufferedReader(file)) { // Creates a buffered reader for file
			String line = null; // declare and initialize a String variable line to null
			while ((line = input.readLine()) != null) { // assigns each line of the file until end of file
				String[] postalInfo = line.split(","); // stores line data in array delimited by a comma
				PostalCodeEntry postalCode = new PostalCodeEntry(postalInfo[0], postalInfo[1], postalInfo[2], postalInfo[3], postalInfo[4]); // creates a postal code entry object of each line's data
				map.put(postalCode.getPrefix(), postalCode); // stores postal code entry prefix as key and object as value
			}//while
		}
		catch (IOException ioException) { // exception handling error reading file
			System.err.println("Error opening file");
			ioException.printStackTrace();
			

		} 
		// no need to close input. Used try-with-resources above
		
		for (int i = 0; i < 10; i++) { // generates 10 random postal code prefixes displaying map value contents if postal code prefix key is found or not found
			String randPrefix = PostalCodeEntry.getRandomPrefix();
			System.out.printf("Retrieving: %s\n\t%s\n", randPrefix, (map.containsKey(randPrefix) ? map.get(randPrefix) : "NOT found"));
		}
	}// main()

}// class
