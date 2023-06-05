<<<<<<< HEAD
import java.util.Scanner;
import com.books.books;
=======
import java.util.*;
>>>>>>> 0dc71d5 (added admin into the db)

public class LibrarianPanel {
    DBconnection db = new DBconnection();
    books book = new books();

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
                        book.findAllBooks();
                        break;
                    case 2:
                        addBook();
                        break;
                    case 3:
                        removeBook();
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

    private void addBook() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter ISBN: ");
            book.ISBN = scanner.nextLine();
            System.out.print("Enter Title: ");
            book.title = scanner.nextLine();
            System.out.print("Enter Author: ");
            book.author = scanner.nextLine();
            book.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void removeBook() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Book ID: ");
            int bookID = scanner.nextInt();
            book.deleteBook(bookID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Rest of the methods and functionality
    // ...
}