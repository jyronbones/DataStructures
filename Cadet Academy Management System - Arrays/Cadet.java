/**
 * This class contains the propoerties of a cadet and methods to access cadet information
 * @author Byron Jones
 *
 */
public class Cadet implements Comparable<Cadet>{

	/**
	 * Stores the cadet number
	 */
    private int cadetNumber;
    /**
     * Stores the cadet name
     */
    private String cadetName;
    /**
     * Stores the cadet balance
     */
    private float balance;
    
    /**
     * Method to access the cadet number
     * @return returns the cadet number
     */
    public int getCadetNumber() {
        return cadetNumber;
    }
    
    /**
     * Method to set the cadet number
     * @param cadetNumber is the passed cadet number to be set
     */
    public void setCadetNumber(int cadetNumber) {
        this.cadetNumber = cadetNumber;
    }
    
    /**
     * Method to access the cadet name
     * @return returns the cadet name
     */
    public String getCadetName() {
        return cadetName;
    }
    
    /**
     * Method to set the cadet name
     * @param cadetName is the passed cadet name to be set
     */
    public void setCadetName(String cadetName) {
        this.cadetName = cadetName;
    }
    
    /**
     * Method to access the cadet balance
     * @return returns the cadet balance
     */
    public float getBalance() {
        return balance;
    }
    
    /**
     * Method to set the cadet balance
     * @param balance is the passed cadet balance to be set
     */
    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    /**
     * Formats cadet details for printing
     */
    @Override
    public String toString() {
        return String.format("Cadet #: %d, Name: %s, Balance: $%.2f", cadetNumber, cadetName, balance);
    }
    
    /**
     * Overrides compareTo(), compares a food item code for sorting
     * @param cadet is the passed cadet to compare it's cadet number
     */
    @Override
    public int compareTo(Cadet cadet) {
        return Integer.compare(cadetNumber, cadet.cadetNumber);
    }
    
    
}
