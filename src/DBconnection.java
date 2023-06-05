
import java.sql.*;
import com.mysql.cj.jdbc.Driver;

public class DBconnection {
    
    // Establish a database connection
    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "salifu");
        return conn;
    }
}