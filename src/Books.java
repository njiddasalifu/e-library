
import java.util.*;
import java.sql.*;

public class Books {
    // Different attributes of a book
    public int bookID;
    public String ISBN;
    public String title;
    public String author;
    Connection connection;


    DBconnection db = new DBconnection();
    public Books() {

        
        // Create a connection to the database
        // try {
        //     String url = "jdbc:mysql://localhost:3306/books";
        //     String username = "root";
        //     String password = "salifu";
        //     connection = DriverManager.getConnection(url, username, password);
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
    }

    public String getAuthor() {
        return author;
    }

    public int getBookID() {
        return bookID;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void create() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("ISBN: ");
            System.out.print("Title: ");
            String ISBN = scanner.nextLine();
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();

        try (Connection conn = db.getConnection()){
            String query = "INSERT INTO books (ISBN, Title, Author) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, ISBN);
            statement.setString(2, title);
            statement.setString(3, author);
            statement.executeUpdate();
         

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findAllBooks() {
        try {
            String query = "SELECT * FROM books";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Process the result set and display the book information
            while (resultSet.next()) {
                int id = resultSet.getInt("bookID");
                String isbn = resultSet.getString("ISBN");
                String title = resultSet.getString("Title");
                String author = resultSet.getString("Author");

                System.out.println("Book ID: " + id);
                System.out.println("ISBN: " + isbn);
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByID(int bookID) {
        try {
            String query = "SELECT * FROM books WHERE bookID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, bookID);
            ResultSet resultSet = statement.executeQuery();

            // Process the result set and display the book information
            while (resultSet.next()) {
                int id = resultSet.getInt("bookID");
                String isbn = resultSet.getString("ISBN");
                String title = resultSet.getString("Title");
                String author = resultSet.getString("Author");

                System.out.println("Book ID: " + id);
                System.out.println("ISBN: " + isbn);
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByTitle(String title) {
        try {
            String query = "SELECT * FROM books WHERE Title LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + title + "%");
            ResultSet resultSet = statement.executeQuery();

            // Process the result set and display the book information
            while (resultSet.next()) {
                int id = resultSet.getInt("bookID");
                String isbn = resultSet.getString("ISBN");
                String Title = resultSet.getString("Title");
                String author = resultSet.getString("Author");

                System.out.println("Book ID: " + id);
                System.out.println("ISBN: " + isbn);
                System.out.println("Title: " + Title);
                System.out.println("Author: " + author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByAuthor(String author) {
        try {
            String query = "SELECT * FROM books WHERE Author LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + author + "%");
            ResultSet resultSet = statement.executeQuery();

            // Process the result set and display the book information
            while (resultSet.next()) {
                int id = resultSet.getInt("bookID");
                String isbn = resultSet.getString("ISBN");
                String title = resultSet.getString("Title");
                String Author = resultSet.getString("Author");

                System.out.println("Book ID: " + id);
                System.out.println("ISBN: " + isbn);
                System.out.println("Title: " + title);
                System.out.println("Author: " + Author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook() {
        try {
            String query = "DELETE FROM books WHERE bookID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, bookID);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book not found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
}