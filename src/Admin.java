import java.util.*;
import java.sql.*;

public class Admin {
    
    BooksDBconnection db = new BooksDBconnection();
    
    public void registerLibrarian() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
   
            try (Connection conn = db.getConnection()) {
                String query = "INSERT INTO librarians (name, email, phone, username, password) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, phone);
                stmt.setString(4, username);
                stmt.setString(5, password);
                int rowsAffected = stmt.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted successfully.");
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    //deleting a librarian
    public void deleteLibrarian() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the ID of the librarian to delete: ");
            int id = scanner.nextInt();
   
            try (Connection conn = db.getConnection()) {
                String query = "DELETE FROM librarians WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, id);
                int rowsAffected = stmt.executeUpdate();
                System.out.println(rowsAffected + " row(s) deleted successfully.");
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
    
    public void adminPanel() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter\n 1.Register a librarian\n 2. Remove a librarian\n ");
            int choice = scanner.nextInt();
   
            switch (choice) {
                case 1:
                    registerLibrarian();
                    break;
                case 2:
                    deleteLibrarian();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}