
import java.util.*;

import java.sql.*;



public class Logintest {

    DBconnection db = new DBconnection();
    LibrarianPanel lb = new LibrarianPanel();
    Admin admin = new Admin();

    public void login() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
    
            Connection conn = db.getConnection();
            
            String query = "SELECT * FROM admins WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) {
                System.out.println("Login successful!");

                admin.register();
            } else {
                System.out.println("Login failed.");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("Error: No input was found.");
        }
        
    }
    
}
