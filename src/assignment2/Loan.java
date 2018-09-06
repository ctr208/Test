package assignment2;

/**
 * This is a Loan class with instance variables of a Book object, Patron object,
 * and a borrow date.
 * 
 * @author ChaseRobison
 * 
 */

public class Loan {
	private Book book;
	private Patron patron;
	private String date;

	/**
	 * Constructor for new patron object that takes 3 strings; Book object, Patron
	 * object, and borrow date.
	 * 
	 * @param b
	 * @param p
	 * @param year
	 */
	public Loan(Book b, Patron p, String year) {
		this.book = b;
		this.patron = p;
		this.date = year;
	}

	/**
	 * Returns Book object from the Loan object.
	 * 
	 * @return Book
	 */
	public Book getBook() {
		return this.book;
	}

	/**
	 * Returns Patron object from the Loan object.
	 * 
	 * @return Patron
	 */

	public Patron getPatron() {
		return this.patron;
	}

	/**
	 * Returns borrow date of book.
	 * 
	 * @return date
	 */

	public String getDate() {
		return date;
	}

	/**
	 * Returns bookID, patronID, and date of the Loan object.
	 */

	public String toString() {
		String bID = book.getBookID();
		String pID = patron.getPatronID();
		return bID + "," + pID + "," + date;
	}
}
