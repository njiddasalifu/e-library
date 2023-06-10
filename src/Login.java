
import java.sql.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Login {
    DBconnection db = new DBconnection();
    Student student = new Student();
     LibrarianPanel librarian = new LibrarianPanel();
     Admin admin = new Admin();
    
    public void login() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your role\n 1 - Student\n 2 - Librarian\n 3 - Admin\n 4 - Exit\n");
            int role = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline character
            if (role == 4){
                System.out.println("Exiting program...");
                System.exit(0);
                
            }
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            Connection conn = db.getConnection();
            String query = "";
            PreparedStatement stmt = null;
            ResultSet rs = null;

            switch (role) {
                case 1:
                query = "SELECT COUNT(*) FROM students";
                stmt = conn.prepareStatement(query);
                rs = stmt.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    // No students in the database, call StudentRegistration method
                    System.out.println("No students found in the database. Please register a student.");
                    student.StudentRegistration();
                    break;
                } else {
                    query = "SELECT * FROM students WHERE username = ? AND password = ?";
                    stmt = conn.prepareStatement(query);
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        // Student login successful
                        System.out.println("login successful!");
                        // Call student methods here
                        student.StudentPanel();
                    } else {
                        // Invalid login credentials
                        System.out.println("Invalid username or password.");
                    }
                    break;
                }
                case 2:
                    if (isLibrarian(username, password, conn)) {
                        System.out.println("login successful!");
                        // call librarian methods here
                        librarian.showPanel();
                    } else {
                        System.out.println("Login failed.");
                        return;
                    }
                    break;
                case 3:
                    if (isAdmin(username, password, conn)) {
                        System.out.println("Admin login successful!");
                        // call admin methods here
                        System.out.println("Welcome to Admin panel. Choose an operation to perform.");
                        System.out.println("1 - Add a new Librarian\n 2 - See Librarians in the System\n 3 - Remove a Librarian\n 4 - Go back");
                        try {
                            int choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    // calling the add librarian method
                                    admin.register();
                                    break;
                                case 2:
                                    // calling see all librarians in the System
                                    break;
                                case 3:
                                    // removing a Librarian
                                    admin.deleteLibrarian();
                                    break;
                                case 4:
                                    // go back to login page
                                    login();
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                                    break;
                            }
                        } catch (Exception ex) {
                            System.out.println("Invalid input. Please enter a valid choice.");
                        }
                    } else {
                        System.out.println("Login failed.");
                        return;
                    }
                    break;
                
                default:
                    System.out.println("Invalid role.");
                    return;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("Error: No input was found.");
        }
    }
    
    private boolean isStudent(String username, String password, Connection conn) throws SQLException {
        String query = "SELECT * FROM students WHERE username = ? AND password = ?";
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
    
    private boolean isAdmin(String username, String password, Connection conn) throws SQLException {
        String query = "SELECT * FROM admins WHERE username = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }
    
    private boolean isStudentInDB(Connection conn) throws SQLException {
        String query = "SELECT * FROM students";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }
}