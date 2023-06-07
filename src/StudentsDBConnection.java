
import java.sql.*;


public class StudentsDBConnection {
    
    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "salifu");
        return conn;
    }
}
