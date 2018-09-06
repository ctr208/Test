package assignment2;

/**
 * This is a Patron class with instance variables of a patron ID number and the
 * patron's last name.
 * 
 * @author ChaseRobison
 *
 */

public class Patron {

	private String patronID;
	private String patronName;

	private static int newPatronID = 0;

	/**
	 * Constructor for a Patron object that takes 2 strings; id and name.
	 * 
	 * @param id
	 * @param name
	 */
	public Patron(String patronID, String name) {
		this.patronID = patronID;
		this.patronName = name;

		String id = this.patronID;
		String idNum = id.substring(1);
		int i = Integer.parseInt(idNum);

		if (i > newPatronID) {
			newPatronID = i + 1;
		}
	}

	/**
	 * Constructor for a Patron object that takes 1 string; name. Then generates
	 * unique ID.
	 * 
	 * @param name
	 */
	public Patron(String name) {
		this.patronName = name.toUpperCase();

		int num = patronIDGenerator();
		String idNum = Integer.toString(num);
		idNum = "P" + idNum;

		this.patronID = idNum;
	}

	/**
	 * Returns patronID of Patron object.
	 * 
	 * @return patronID
	 */

	public String getPatronID() {
		return this.patronID;
	}

	/**
	 * Generates unique patron ID.
	 * 
	 * @return newPatronID
	 */

	public int patronIDGenerator() {
		newPatronID++;
		return newPatronID;
	}

	/**
	 * Returns patron name of Patron object.
	 * 
	 * @return patronName
	 */

	public String getName() {
		return this.patronName;
	}

	/**
	 * Returns string of patronID and patronName of Patron object.
	 * 
	 * @return patronID
	 * @return patronName
	 */

	public String toString() {
		return patronID + " " + patronName;
	}

}
