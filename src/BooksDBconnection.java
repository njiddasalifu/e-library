
import java.sql.*;

public class BooksDBconnection {
    
    // Establish a database connection
    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "salifu");
        return conn;
    }
    
}