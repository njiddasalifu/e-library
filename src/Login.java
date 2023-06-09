import java.sql.*;
import java.util.*;

public class Login {

    DBconnection db = new DBconnection();
    Student st = new Student();
    LibrarianPanel librarian = new LibrarianPanel();
    Admin admin = new Admin();

    public void login() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
    
            Connection conn = db.getConnection();
            String query = "";
            PreparedStatement stmt = null;
            ResultSet rs = null;
    
            if (isAdmin(username, password, conn)) {
                System.out.println("Admin login successful!");
                // call admin methods here 
                admin.register();
            } else if (isLibrarian(username, password, conn)) {
                System.out.println("Librarian login successful!");
                // call librarian methods here
            } else if (isStudent(username, password, conn)) {
                System.out.println("Student login successful!");
                // call student methods here
            } else {
                System.out.println("Login failed.");

            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("Error: No input was found.");
        }
    }
    
    private boolean isAdmin(String username, String password, Connection conn) throws SQLException {
        String query = "SELECT * FROM admins WHERE username = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }
    
    private boolean isLibrarian(String username, String password, Connection conn) throws SQLException {
        String query = "SELECT * FROM librarians WHERE username = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }
    
    private boolean isStudent(String username, String password, Connection conn) throws SQLException {
        String query = "SELECT * FROM students WHERE username = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }
}