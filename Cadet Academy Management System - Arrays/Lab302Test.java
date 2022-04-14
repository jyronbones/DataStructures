import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class contains method main and display menu
 * @author Byron Jones
 *
 */
public class Lab302Test {

	/**
	 * Driver method running the menu
	 * @param args is the runtime argument array
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		displayMenu(scan);
		scan.close();
	}

	/**
	 * Displays a menu to user for option selection
	 * @param scan is the Scanner object for user input
	 */
	public static void displayMenu(Scanner scan) {
		int choice;
		boolean continueProgram = true;
		MilitaryAcademy mil = new MilitaryAcademy();
		do {
			try {
				System.out.print("Please select one of the following:\n" + "1: Add Cadet to Military Academy\n"
						+ "2: Display Cadets in the Academy\n" + "3: Set Military Academy Name\n"
						+ "4: Search for a Cadet\n" + "5: Exit\n" + "Enter your Selection: ");
				choice = scan.nextInt();
				scan.nextLine();
				switch (choice) {
				case 1:
					mil.addCadet(scan);
					break;
				case 2:
					mil.displayArmy();
					break;
				case 3:
					mil.academyName(scan);
					break;
				case 4:
					mil.searchCadet(scan);
					break;
				case 5:
					continueProgram = false;
					System.out.println("Exiting...bye...");
					break;

				default:
					System.out.println("Unsupported Choice\n");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Your choice is invalid\n");
				scan.nextLine();
			}

		} while (continueProgram);
	}
}