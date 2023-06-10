import java.util.*;
import java.sql.*;

public class Book {
    DBconnection db = new DBconnection();
    //adding books
    public void addBook(){
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Quantity: ");
        String quantity = scanner.nextLine();
        
        
        Connection conn = db.getConnection();
        String query = "INSERT INTO books (ISBN, Title, Author, quantity) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, isbn);
        stmt.setString(2, title);
        stmt.setString(3, author);
        stmt.setString(4, quantity);
        int rowsAffected = stmt.executeUpdate();
        System.out.println(rowsAffected + " book added successfully.");
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
 }
}


