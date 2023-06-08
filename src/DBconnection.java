
import java.sql.*;

public class DBconnection {

    // Establish a database connection
    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgres://localhost:3306/users", "postgres", "bItO2002");
        return conn;
    }

}
