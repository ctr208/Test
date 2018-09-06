package assignment2;

/**
 * This is a Book class with instance variables of a book ID number, book title,
 * book author, and year publication year.
 * 
 * @author ChaseRobison
 *
 */

public class Book {
	private String bookID;
	private String title;
	private String author;
	private String year;

	private static int newBookID = 0;

	/**
	 * Constructor for a Book object that takes in 4 strings; bookID, title, author,
	 * and year. Then finds out if this.bookID is higher than newBookID. If it is,
	 * the newBookID variable is updated to this.bookID + 1.
	 * 
	 * @param bookID
	 * @param title
	 * @param author
	 * @param year
	 */
	public Book(String bookID, String title, String author, String year) {
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.year = year;

		String id = this.bookID;
		String idNum = id.substring(1);
		int i = Integer.parseInt(idNum);

		if (i > newBookID) {
			newBookID = i + 1;
		}

	}

	/**
	 * Constructor for a Book object that takes in 3 strings; title, author, and
	 * year. Then generates a bookID.
	 * 
	 * @param title
	 * @param author
	 * @param year
	 */

	public Book(String title, String author, String year) {
		this.title = title;
		this.author = author;
		this.year = year;

		int num = bookIDGenerator();
		String idNum = Integer.toString(num);
		idNum = "B" + idNum;

		this.bookID = idNum;
	}

	/**
	 * Class method that generates a new bookID for constructor.
	 * 
	 * @return newBookID
	 */
	public static int bookIDGenerator() {
		newBookID++;
		return newBookID;
	}

	/**
	 * Returns bookID of Book object.
	 * 
	 * @return bookID
	 */
	public String getBookID() {
		return this.bookID;
	}

	/**
	 * Returns author of Book object.
	 * 
	 * @return author
	 */

	public String getAuthor() {
		return this.author;
	}

	/**
	 * Returns year of Book object as an integer.
	 * 
	 * @return year
	 */

	public int getYear() {
		int x = Integer.parseInt(this.year);
		return x;
	}

	/**
	 * Returns string of book ID, author, title, and year.
	 * 
	 * @return bookID
	 * @return title
	 * @return author
	 * @return year
	 */

	public String toString() {
		return bookID + " ; " + title + " ; " + author + " ; " + year;
	}

	/**
	 * Returns string of book ID, author,and title.
	 * 
	 * @return bookID
	 * @return title
	 * @return author
	 */

	public String getBookIDAuthorTitle() {
		return bookID + ": " + title + " , " + author;
	}

	/**
	 * Returns string of book ID, author, title, and year.
	 * 
	 * @return bookID
	 * @return title
	 * @return year
	 */

	public String getBookIDTitleYear() {
		return bookID + ": " + title + " , " + year;
	}
}
