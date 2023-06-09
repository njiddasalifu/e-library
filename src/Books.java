// import java.util.*;
// import java.sql.*;

// public class Books {
//     DBconnection db = new DBconnection();
//     // Different attributes of a book
//     private int bookID;
//     private String ISBN;
//     private String title;
//     private String author;
//     private int quantity;
//     private Connection connection;
//     // private DBconnection db = new DBconnection();

//     public Books() {
//         // try {
//         //     String url = "jdbc:postgresql://localhost:3306/books";
//         //     String username = "postgres";
//         //     String password = "bItO2002";
//         //     connection = DriverManager.getConnection(url, username, password);
//         // } catch (SQLException e) {
//         //     e.printStackTrace();
//         // }
//     }

//     public int getBookID() {
//         return bookID;
//     }

//     public String getISBN() {
//         return ISBN;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public String getAuthor() {
//         return author;
//     }

//     public int getQuantity() {
//         return quantity;
//     }

//     public void create() {
//         try (Scanner scanner = new Scanner(System.in)) {
//             System.out.print("ISBN: ");
//             ISBN = scanner.nextLine();
//             System.out.print("Title: ");
//             title = scanner.nextLine();
//             System.out.print("Author: ");
//             author = scanner.nextLine();
//             System.out.print("Quantity: ");
//             quantity = scanner.nextInt();

//             Connection conn = db.getConnection();
//             String query = "INSERT INTO books (ISBN, Title, Author, Quantity) VALUES (?, ?, ?, ?)";
//             PreparedStatement statement = conn.prepareStatement(query);
//             statement.setString(1, ISBN);
//             statement.setString(2, title);
//             statement.setString(3, author);
//             statement.setInt(4, quantity);
//             statement.executeUpdate();
//             int rowsAffected = statement.executeUpdate();
//             System.out.println(rowsAffected + " Book added successfully.");
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     public void findAllBooks() {
//         try(Connection conn = db.getConnection()) {
//             String query = "SELECT * FROM books";
//             PreparedStatement statement = conn.prepareStatement(query);
//             ResultSet resultSet = statement.executeQuery();

//             // Process the result set and display the book information
//             while (resultSet.next()) {
//                 int id = resultSet.getInt("bookID");
//                 String isbn = resultSet.getString("ISBN");
//                 String title = resultSet.getString("Title");
//                 String author = resultSet.getString("Author");
//                 int quantity = resultSet.getInt("Quantity");

//                 System.out.println("Book ID: " + id);
//                 System.out.println("ISBN: " + isbn);
//                 System.out.println("Title: " + title);
//                 System.out.println("Author: " + author);
//                 System.out.println("Quantity: " + quantity);
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     public void getByID(int bookID) {
//         try {
//             String query = "SELECT * FROM books WHERE bookID = ?";
//             PreparedStatement statement = connection.prepareStatement(query);
//             statement.setInt(1, bookID);
//             ResultSet resultSet = statement.executeQuery();

//             // Process the result set and display the book information
//             while (resultSet.next()) {
//                 int id = resultSet.getInt("bookID");
//                 String isbn = resultSet.getString("ISBN");
//                 String title = resultSet.getString("Title");
//                 String author = resultSet.getString("Author");
//                 String status = resultSet.getString("Status");
//                 int quantity = resultSet.getInt("Quantity");

//                 System.out.println("Book ID: " + id);
//                 System.out.println("ISBN: " + isbn);
//                 System.out.println("Title: " + title);
//                 System.out.println("Author: " + author);
//                 System.out.println("Status: " + status);
//                 System.out.println("Quantity: " + quantity);
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     public void getByTitle(String title) {
//         try {
//             String query = "SELECT * FROM books WHERE Title LIKE ?";
//             PreparedStatement statement = connection.prepareStatement(query);
//             statement.setString(1, "%" + title + "%");
//             ResultSet resultSet = statement.executeQuery();

//             // Process the result set and display the book information
//             while (resultSet.next()) {
//                 int id = resultSet.getInt("bookID");
//                 String isbn = resultSet.getString("ISBN");
//                 String bookTitle = resultSet.getString("Title");
//                 String author = resultSet.getString("Author");
//                 String status = resultSet.getString("Status");
//                 int quantity = resultSet.getInt("Quantity");

//                 System.out.println("Book ID: " + id);
//                 System.out.println("ISBN: " + isbn);
//                 System.out.println("Title: " + bookTitle);
//                 System.out.println("Author: " + author);
//                 System.out.println("Status: " + status);
//                 System.out.println("Quantity: " + quantity);
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     public void getByAuthor(String author) {
//         try {
//             String query = "SELECT * FROM books WHERE Author LIKE ?";
//             PreparedStatement statement = connection.prepareStatement(query);
//             statement.setString(1, "%" + author + "%");
//             ResultSet resultSet = statement.executeQuery();

//             //Process the result set and display the book information
//             while (resultSet.next()) {
//                 int id = resultSet.getInt("bookID");
//                 String isbn = resultSet.getString("ISBN");
//                 String title = resultSet.getString("Title");
//                 String bookAuthor = resultSet.getString("Author");
//                 String status = resultSet.getString("Status");
//                 int quantity = resultSet.getInt("Quantity");

//                 System.out.println("Book ID: " + id);
//                 System.out.println("ISBN: " + isbn);
//                 System.out.println("Title: " + title);
//                 System.out.println("Author: " + bookAuthor);
//                 System.out.println("Status: " + status);
//                 System.out.println("Quantity: " + quantity);
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     public void deleteBook() {
//         try {
//             String query = "DELETE FROM books WHERE title = ?";
//             PreparedStatement statement = connection.prepareStatement(query);
//             statement.setString(1, title);
//             int rowsAffected = statement.executeUpdate();
//             if (rowsAffected > 0) {
//                 System.out.println("Book deleted successfully!");
//             } else {
//                 System.out.println("Book not found with the given ID.");
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }