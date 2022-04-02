package postal_code;

import java.security.SecureRandom;

/**
 * Starter file for Assigment3 for CST8130
 * 
 *
 *
 */
/**
 * This class contains the properties and behaviors of a postal code entry
 *
 */
public class PostalCodeEntry { // This class contains the properties and behaviors of a postal code entry
	private String prefix; // stores prefix
	private String place_name; // stores place name
	private String province; // stores province
	private String latitude; // stores latitude
	private String longitude; // stores longitude

	/**
	 * class that corresponds one entry/row in CSV file of Canadian postal codes
	 * 
	 * @param prefix     the first portion of the postal code
	 * @param place_name name of the place corresponding to the postal code
	 * @param province   province where the place is located
	 * @param latitude   latitude of the centre of the postal code
	 * @param longitude  longitude of the centre of the postal code
	 */
	// overloaded constructor setting all instance variables to passed values
	public PostalCodeEntry(String prefix, String place_name, String province, String latitude, String longitude) {
		this.prefix = prefix;
		this.place_name = place_name;
		this.province = province;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * no-argument constructor set all instance variables to null
	 */
	public PostalCodeEntry() { // no-argument constructor set all instance variables to null
	}

	/**
	 * constructor that uses an array to initialize the class
	 * 
	 * @param fields array of String corresponding to: <br>
	 *               prefix <br>
	 *               place_name <br>
	 *               province <br>
	 *               latitude <br>
	 *               longitude
	 */
	public PostalCodeEntry(String[] fields) { // constructor that uses an array to initialize the class
		this(fields[0], fields[1], fields[2], fields[3], fields[4]);
	}

	/**
	 * prefix is first 3 characters of the postal code <br>
	 * Correct format is: ALPHAnumberALPHA <br>
	 * where ALPHA is an upper-case chosen from A through Z
	 * 
	 * @return the first portion of the postal code
	 */
	public String getPrefix() { // gets the prefix of a postal code entry
		return prefix;
	}

	/**
	 * Formats properties of postal code entry to String
	 */
	@Override
	public String toString() { // Formats properties of postal code entry to String
		return String.format("%s, %s, %s, %s, %s\n", prefix, place_name, province, latitude, longitude);
	}

	// create random generator once. To be used for the life of main(). Global
	// visibility
	// provide a seed value to get same random sequence
	// remove seed after testing
//	final static SecureRandom rand = new SecureRandom("abcdefghijklmnop".getBytes());
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
	public static String getRandomPrefix() { // gets a random postal code prefix
		int randA = rand.nextInt(alpha.length()); // random letter from alphabet
		int randN = rand.nextInt(number.length()); // random number

		return "K" + number.charAt(randN) + alpha.charAt(randA); // returns randomly generated postal code prefix
	}// getRandom()

}// class
