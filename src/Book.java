import java.util.*;
import java.sql.*;
import java.time.*;

public class Book {
    DBconnection db = new DBconnection();
    Scanner scanner = new Scanner(System.in);
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


 //deleting a book
 public void deleteBook() {
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.print("Enter the ISBN of the Book to delete: ");
        String isbn = scanner.nextLine();

        try (Connection conn = db.getConnection()) {
            String query = "DELETE FROM books WHERE isbn = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, isbn);
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) book deleted successfully.");

            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
  }

//   //method to view all books
//   public void viewAllBooks() {
//     try (Connection conn = db.getConnection()) {
//         String query = "SELECT * FROM books";
//         PreparedStatement stmt = conn.prepareStatement(query);
//         ResultSet rs = stmt.executeQuery();
//         while (rs.next()) {
//             int bookID = rs.getInt("bookID");
//             String isbn = rs.getString("ISBN");
//             String title = rs.getString("Title");
//             String author = rs.getString("Author");
//             int quantity = rs.getInt("quantity");
//             System.out.println("Book ID: " + bookID + ", \nISBN: " + isbn + ", \nTitle: " + title + ", \nAuthor: " + author + ", \nQuantity: " + quantity);
//         }
//     } catch (SQLException ex) {
//         System.out.println("Error: " + ex.getMessage());
//     }
// }

// borrow book
public void borrowBook(int studentId, int bookId, LocalDate dueDate) {
    System.out.println("Enter your details to borrow a book");
    try(Connection conn = db.getConnection()) {
        String sql = "INSERT INTO transactions(studentID, bookID, issue_date, due_date, returned) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, studentId);
        pstmt.setInt(2, bookId);
        pstmt.setObject(3, LocalDate.now());
        pstmt.setObject(4, dueDate);
        pstmt.setBoolean(5, false);
        pstmt.executeUpdate();
        System.out.println("Book borrowed successfully");
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
}

// method for returning book
public void returnBook() {
    System.out.println("Enter transaction id for the book you want to return: ");
        int transactionId = scanner.nextInt();

    try (Connection conn = db.getConnection()){
        String sql = "UPDATE transactions SET returned=true, return_date=? WHERE id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setObject(1, LocalDate.now());
        pstmt.setInt(2, transactionId);
        pstmt.executeUpdate();
        System.out.println("Book returned successfully");
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
}


// reserving a book
public void reserveBook() {
    System.out.println("Enter your StudentID");
    int studentId = scanner.nextInt(); 
    System.out.println("Enter the bookID you want to reserve");
    int bookId = scanner.nextInt();

    try(Connection conn = db.getConnection()) {
        String sql = "INSERT INTO reservations(studentID, bookID) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, studentId);
        pstmt.setInt(2, bookId);
        pstmt.executeUpdate();
        System.out.println("Book reserved successfully");
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
}

}


