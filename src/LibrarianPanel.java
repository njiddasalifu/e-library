import java.util.*;
import java.sql.*;

public class LibrarianPanel {

    // private DBconnection db;

    // public LibrarianPanel(DBconnection db) {
    //     this.db = db;
    // }
    DBconnection db = new DBconnection();

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
                       // viewAllBooks();
                        break;
                    case 2:
                       // addBook();
                        break;
                    case 3:
                       // removeBook();
                        break;
                    case 4:
                       // viewAllBorrowers();
                        break;
                    case 5:
                        //addBorrower();
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

    // private void viewAllBooks() {
    //     try (Connection conn = db.getConnection()) {
    //         Statement stmt = conn.createStatement();
    //         ResultSet rs = stmt.executeQuery("SELECT * FROM books");
    //         System.out.println("All books:");
    //         System.out.println("ID\tTitle\t\tAuthor\t\tPublisher\tPublished Year");
    //         while (rs.next()) {
    //             System.out.println(rs.getInt("id") + "\t" + rs.getString("title") + "\t"
    //                     + rs.getString("author") + "\t" + rs.getString("publisher") + "\t"
    //                     + rs.getInt("published_year"));
    //         }
    //     } catch (SQLException ex) {
    //         System.out.println("Error: " + ex.getMessage());
    //     }
    // }

    // private void addBook() {
    //     try (Scanner scanner = new Scanner(System.in);
    //          Connection conn = db.getConnection()) {
    //         System.out.print("Book title: ");
    //         String title = scanner.nextLine();
    //         System.out.print("Book author: ");
    //         String author = scanner.nextLine();
    //         System.out.print("Book publisher: ");
    //         String publisher = scanner.nextLine();
    //         System.out.print("Book published year: ");
    //         int publishedYear = scanner.nextInt();
    //         scanner.nextLine(); // consume newline character

    //         String query = "INSERT INTO books (title, author, publisher, published_year) VALUES (?, ?, ?, ?)";
    //         PreparedStatement stmt = conn.prepareStatement(query);
    //         stmt.setString(1, title);
    //         stmt.setString(2, author);
    //         stmt.setString(3, publisher);
    //         stmt.setInt(4, publishedYear);
    //         int result = stmt.executeUpdate();
    //         if (result > 0) {
    //             System.out.println("Book added successfully.");
    //         } else {
    //             System.out.println("Failed to add book.");
    //         }
    //     } catch (SQLException ex) {
    //         System.out.println("Error: " + ex.getMessage());
    //     }
    // }

    // private void removeBook() {
    //     try (Scanner scanner = new Scanner(System.in);
    //          Connection conn = db.getConnection()) {
    //         System.out.print("Book ID: ");
    //         int bookId = scanner.nextInt();
    //         scanner.nextLine(); // consume newline character

    //         String query = "DELETE FROM books WHERE id = ?";
    //         PreparedStatement stmt = conn.prepareStatement(query);
    //         stmt.setInt(1, bookId);
    //         int result = stmt.executeUpdate();
    //         if (result > 0) {
    //             System.out.println("Book removed successfully.");
    //         } else {
    //             System.out.println("Failed to remove book.");
    //         }
    //     } catch (SQLException ex) {
    //         System.out.println("Error: " + ex.getMessage());
    //     }
    // }

    // private void viewAllBorrowers() {
    //     try (Connection conn = db.getConnection()) {
    //         Statement stmt = conn.createStatement();
    //         ResultSet rs = stmt.executeQuery("SELECT * FROM borrowers");
    //         System.out.println("All borrowers:");
    //         System.out.println("ID\tName\t\t\tEmail\t\t\tPhone Number\tAddress");
    //         while (rs.next()) {
    //             System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t\t"
    //                     + rs.getString("email") + "\t" + rs.getString("phone_number") + "\t"
    //                     + rs.getString("address"));
    //         }
    //     } catch (SQLException ex) {
    //         System.out.println("Error: " + ex.getMessage());
    //     }
    // }

    // private void addBorrower() {
    //     try (Scanner scanner = new Scanner(System.in);
    //         Connection conn = db.getConnection()) {
    //         System.out.print("Borrower name: ");
    //         String name = scanner.nextLine();
    //         System.out.print("Borrower email: ");
    //         String email = scanner.nextLine();
    //         System.out.print("Borrower phone number: ");
    //         String phoneNumber = scanner.nextLine();
    //         System.out.print("Borrower address: ");
    //         String address = scanner.nextLine();

    //         String query = "INSERT INTO borrowers (name, email, phone_number, address) VALUES (?, ?, ?, ?)";
    //         PreparedStatement stmt = conn.prepareStatement(query);
    //         stmt.setString(1, name);
    //         stmt.setString(2, email);
    //         stmt.setString(3, phoneNumber);
    //         stmt.setString(4, address);
    //         int result = stmt.executeUpdate();
    //         if (result > 0) {
    //             System.out.println("Borrower added successfully.");
    //         } else {
    //             System.out.println("Failed to add borrower.");
    //         }
    //     } catch (SQLException ex) {
    //         System.out.println("Error: " + ex.getMessage());
    //     }
    // }

    // private void removeBorrower() {
    //     try (Scanner scanner = new Scanner(System.in);
    //          Connection conn = db.getConnection()) {
    //         System.out.print("Borrower ID: ");
    //         int borrowerId = scanner.nextInt();
    //         scanner.nextLine(); // consume newline character

    //         String query = "DELETE FROM borrowers WHERE id = ?";
    //         PreparedStatement stmt = conn.prepareStatement(query);
    //         stmt.setInt(1, borrowerId);
    //         int result = stmt.executeUpdate();
    //         if (result > 0) {
    //             System.out.println("Borrower removed successfully.");
    //         } else {
    //             System.out.println("Failed to remove borrower.");
    //         }
    //     } catch (SQLException ex) {
    //         System.out.println("Error: " + ex.getMessage());
    //     }
    // }

}