
import java.util.Scanner;
import java.sql.*;


public class LibrarianPanel {
    //this is the object reference to the database connection
    DBconnection db = new DBconnection();
    //  Books book = new Books();
    Book book = new Book();

    public void showPanel() {
        boolean exit = false;
        while (!exit) {

            System.out.println("1. View all books");
            System.out.println("2. Add a book");
            System.out.println("3. Remove a book");
            System.out.println("4. View all borrowers");
            System.out.println("5. Add a borrower");
            System.out.println("6. Remove a borrower");
            System.out.println("7. Logout");

            try (Scanner scanner = new Scanner(System.in)) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline character

                switch (choice) {
                    case 1:
                        // book.findAllBooks();
                        break;
                    case 2:
                        book.addBook();
                        break;
                    case 3:
                    //    book.deleteBook();
                        break;
                    case 4:
                        // viewAllBorrowers();
                        break;
                    case 5:
                        // addBorrower();
                        break;
                    case 6:
                        // removeBorrower();
                        break;
                    case 7:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        }
    }
}