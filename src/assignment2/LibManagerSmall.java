package assignment2;

import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LibManagerSmall {
	private ArrayList<Book> bookList = new ArrayList<Book>();
	private ArrayList<Patron> patronList = new ArrayList<Patron>();
	private ArrayList<Loan> loanList = new ArrayList<Loan>();
	private String[] menuOptions;

	public static void main(String[] args) {
		LibManagerSmall lm = new LibManagerSmall();
		lm.execute();
	}

	public LibManagerSmall() {
		bookList = readBooks("Resources/books.txt");
		patronList = readPatrons("Resources/patrons.txt");
		loanList = readLoans("Resources/loans.txt");

		menuOptions = new String[] { "Add Book", "Add Patron", "List By Author", "List By Year", "Show Borrower",
				"Show Borrowed Books", "Return Book", "Exit" };
	}

	private void execute() {

		while (true) {
			int opt = getMenuOption();
			switch (opt) {
			case 1:
				addBook();
				break;
			case 2:
				addPatron();
				break;
			case 3:
				listByAuthor();
				break;
			case 4:
				listByYear();
				break;
			case 5:
				showBorrowers();
				break;
			case 6:
				showBorrowedBooks();
				break;
			case 7:
				returnBook();
				break;
			case 8:
				exitProgram();
				break;
			default:
				System.out.println("No such option");
			}
		}

	}

	private int getMenuOption() {

		System.out.println("Select one of the following options");
		for (int i = 0; i < menuOptions.length; i++) {
			System.out.println("\t" + (i + 1) + ". " + menuOptions[i]);
		}

		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();

		return choice;
	}

	/* MAKE NO CHANGES ABOVE THIS LINE */
	/* COMPLETE ALL THE CODE STUBS BELOW */

	private void exitProgram() {

		writeLoanFile();
		writeBookFile();
		writePatronFile();

		System.out.println("Exiting..");
		System.exit(0);
	}

	private void writeBookFile() {
		int count = 0;
		BufferedWriter write;
		try {
			write = new BufferedWriter(new FileWriter("Resources/books.txt"));
			while (count < bookList.size()) {
				Book b = bookList.get(count);
				write.write(b.toString());
				if (count != bookList.size() - 1) {
					write.newLine();
				}
				count++;
				write.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void writeLoanFile() {
		int count = 0;
		BufferedWriter write;
		try {
			write = new BufferedWriter(new FileWriter("Resources/loans.txt"));
			while (count < loanList.size()) {
				Loan l = loanList.get(count);
				write.write(l.toString());
				if (count != loanList.size() - 1) {
					write.newLine();
				}
				count++;
				write.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void writePatronFile() {
		int count = 0;
		BufferedWriter write;
		try {
			write = new BufferedWriter(new FileWriter("Resources/patrons.txt"));
			while (count < patronList.size()) {
				Patron p = patronList.get(count);
				write.write(p.toString());
				if (count != patronList.size() - 1) {
					write.newLine();
				}
				count++;
				write.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private ArrayList<Book> readBooks(String filename) {
		Scanner input = null;
		try {
			input = new Scanner(new File(filename), "UTF-8");
			input.useDelimiter("[;\n]");
		} catch (FileNotFoundException e) {
			System.out.println("No file found");
		}
		String bookID, title, author, year;

		while (input.hasNext()) {

			bookID = input.next().trim();
			title = input.next().trim();
			author = input.next().trim();
			year = input.next().trim();

			Book b = new Book(bookID, title, author, year);
			bookList.add(b);

		}
		input.close();
		System.out.println("Reading file " + filename);
		return bookList;
	}

	private ArrayList<Patron> readPatrons(String filename) {
		Scanner input = null;
		try {
			input = new Scanner(new File(filename), "UTF-8");
		} catch (FileNotFoundException e) {
			System.out.println("No file found");
		}

		while (input.hasNext()) {
			String patronID = input.next();
			String patronName = input.next();

			Patron p = new Patron(patronID, patronName);
			patronList.add(p);
		}
		input.close();
		System.out.println("Reading file " + filename);
		return patronList;
	}

	private ArrayList<Loan> readLoans(String filename) {
		Scanner input = null;
		try {
			input = new Scanner(new File(filename), "UTF-8");
			input.useDelimiter("[,\n]");
		} catch (FileNotFoundException e) {
			System.out.println("No file found");
		}

		while (input.hasNext()) {

			String bookID = input.next();
			String patronID = input.next();
			String date = input.next().trim();

			Book b = locateBook(bookID);
			Patron p = locatePatron(patronID);

			Loan l = new Loan(b, p, date);
			loanList.add(l);

		}
		input.close();
		System.out.println("Reading file " + filename);
		return loanList;
	}

	private Book locateBook(String bookId) {
		int count = 0;

		while (!(bookId.equals(bookList.get(count).getBookID()))) {
			count++;
		}
//		System.out.println("Locating book with id = " + bookId);
		return bookList.get(count);
	}

	private Patron locatePatron(String patronId) {
		int count = 0;

		while (!(patronId.equals(patronList.get(count).getPatronID()))) {
			count++;
		}
//		System.out.println("Locating patron with id =" + patronId);
		return patronList.get(count);

	}

	private void showBorrowedBooks() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Patron ID to see Books Borrowed");
		String id = input.next();
		boolean temp = false;

		int count = 0;
		while (count < loanList.size()) {
			if (id.equals(loanList.get(count).getPatron().getPatronID())) {
				System.out.println(loanList.get(count).getBook().toString());
				count++;
				temp = true;
			} else {
				count++;
			}

		}
		if (temp == false) {
			System.out.println("This patron is not in our database or has no borrowed books");
		}

		System.out.println("Executing showBorrowedBooks");

	}

	private Patron locateBorrower(String id) {
		int count = 0;

		while (!(id.equals(loanList.get(count).getBook().getBookID()))) {
			
			if(count == loanList.size() - 1  && !(id.equals(loanList.get(count).getBook().getBookID()))) {
				return null;
			}
			count++;
		
		}
		return loanList.get(count).getPatron();
	}

	private void showBorrowers() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Book ID to see Borrow");
		String id = input.next();
		Patron p = locateBorrower(id);
		
		if(p == null) {
			System.out.println("This Book is currently not being borrowed or is not in our database.");
		}else {
			System.out.println(p.getName());
		}

		System.out.println("Executing showBorrowers");
	}

	private void listByYear() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Start Year:");
		int startYear = input.nextInt();
		System.out.println("Enter End Year:");
		int endYear = input.nextInt();
		
		boolean temp = false;
		int count = 0;

		while (count < bookList.size()) {
			if (bookList.get(count).getYear() > startYear) {
				if (bookList.get(count).getYear() < endYear) {
					System.out.println(bookList.get(count).getBookIDAuthorTitle());
					count++;
					temp = true;
				} else {
					count++;
				}

			} else {
				count++;
			}
		}
		if(temp == false) {
			System.out.println("There are no books in our system that have been published between "+ startYear + " and " + endYear+ ".");
		}

		System.out.println("Executing listByYear");

	}

	private void listByAuthor() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Author's Name:");
		String name = input.nextLine();

		int count = 0;
		boolean temp = false;

		while (count < bookList.size()) {
			if (name.equals(bookList.get(count).getAuthor())) {
				System.out.println(bookList.get(count).getBookIDTitleYear());
				count++;
				temp = true;
				;
			} else {
				count++;
			}

		}
		if (temp == false) {
			System.out.println("This author is not in our database.");
		}
		System.out.println("Executing listByAuthor");

	}

	private void addPatron() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Your Last Name:");
		String name = input.next();

		Patron p = new Patron(name);
		patronList.add(p);
		System.out.println("Executing addPatron");

	}

	private void addBook() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter author:");
		String author = input.nextLine();
		System.out.println("Enter Book Title:");
		String title = input.nextLine();
		System.out.println("Enter Books Publication Year:");
		String year = input.nextLine();

		Book b = new Book(title, author, year);
		bookList.add(b);
		System.out.println("Executing addBook");

	}

	private void returnBook() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter ID of Book Begining Returned: ");
		String id = input.next();

		int count = 0;
		boolean temp = false;

		while (count < loanList.size()) {
			if (id.equals(loanList.get(count).getBook().getBookID())) {
				loanList.remove(count);
			} else {
				count++;
			}

		}

		System.out.println("Executing returnBook");
	}

}
