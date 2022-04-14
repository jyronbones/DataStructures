import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains the properties and methods of the cadet academy
 * @author Byron Jones
 *
 */
public class MilitaryAcademy{

    /**
     * array to store cadets
     */
	private Cadet[] cadets = new Cadet[20];
	/**
	 * academy name initialized to unknown
	 */
    private String name = "Unknown";
    /**
     * Stores number of cadets enrolled in academy
     */
    private int numCadets = 0;    

    /**
     * Default constructor the the military academy
     */
    public MilitaryAcademy() {

    }

    /**
     * Function to create and add a new cadet to the academy
     * @param scan is the passed Scanner object to read user input
     */
    public void addCadet(Scanner scan) {
        Cadet cadet = new Cadet();
        System.out.print("Please Enter the Cadet's Name: ");
        cadet.setCadetName(scan.nextLine());
        while (true) {
            try {
                System.out.print("Please Enter the Cadet's Number: ");
                cadet.setCadetNumber(scan.nextInt());
                break;
            } catch (InputMismatchException e) {
                System.err.println("Incorrect format");
                scan.next();
            }
        }
        while(true) {
            try {
                System.out.print("Please enter the Cadet's Balance: $");
                cadet.setBalance(scan.nextFloat());
                break;
            } catch (InputMismatchException e) {
                System.err.println("Incorrect format");
                scan.next();
            }
        }
        cadets[numCadets] = cadet;
        numCadets++;
    	Arrays.sort(cadets, 0, numCadets);
    }

    /**
     * This method displays the academy name and cadet information
     */
    public void displayArmy() {
        if (numCadets == 0) {
        	System.out.printf("Military Academy Information:\nName: %s\nCadet List: \nNo Cadets in Military Academy\n", name);
        } else {
            System.out.printf("Military Academy Information:\nName: %s\nCadet List:\n", name);
            for (int i = 0; i < numCadets; i++) {
                System.out.println(cadets[i]);
            }
        }
    }

    /**
     * This method is used to set the academy name
     * @param scan is the passed Scanner object used to read user input
     */
    public void academyName(Scanner scan) {
        System.out.print("Please Enter the military Academy's Name: ");
        name = scan.nextLine();
    }

    /**
     * This method is used to search for a cadet in the academy
     * @param scan is the Scanner object used to read user input
     */
    public void searchCadet(Scanner scan) {
        int tempCadetNum;
        while(true) {
            try {
                System.out.print("Please Enter the Cadet Number to Search for: ");
                tempCadetNum = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Incorrect format");
                scan.next();
            }
        }
        for (int i = 0; i < numCadets; i++) {
            if (tempCadetNum == cadets[i].getCadetNumber()) {
                System.out.println("Cadet found at index " + i);
            	System.out.println(cadets[i]);
                return;                
            }
        }
        System.out.println("Cadet not found in Military Academy");
    }

}