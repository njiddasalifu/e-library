import java.util.*;

import java.sql.*;

public class Login{

    DBconnection db = new DBconnection();
    LibrarianPanel lb = new LibrarianPanel();
    Student st = new Student();

    Admin admin = new Admin();
    public void login() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("Please what is your role in the system:");
                System.out.println("1. Student");
                System.out.println("2. Librarian");
                System.out.println("3. Admin");
                System.out.println("4. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline character

                switch (choice) {
                    case 1:
                        // Check if the user is a student
                        System.out.print("Student username: ");
                        String studentUsername = scanner.nextLine();
                        System.out.print("Student password: ");
                        String studentPassword = scanner.nextLine();
                        try (Connection conn = db.getConnection()) {
                            String query = "SELECT * FROM students WHERE username = ? AND password = ?";
                            PreparedStatement stmt = conn.prepareStatement(query);
                            stmt.setString(1, studentUsername);
                            stmt.setString(2, studentPassword);
                            ResultSet rs = stmt.executeQuery();
                            if (rs.next()) {
                                System.out.println("\nWelcome, " + rs.getString("name") + " (Student)!");
                                
                                //call the student panel here
                            } else {
                                System.out.println("Invalid username or password.");
                                System.out.println("Please Register to access the Library");
                                st.StudentRegistration();

                            }
                        } catch (SQLException ex) {
                            System.out.println("Error: " + ex.getMessage());
                        }
                        break;
                    case 2:
                        // Check if the user is a librarian
                        System.out.print("Librarian username: ");
                        String librarianUsername = scanner.nextLine();
                        System.out.print("Librarian password: ");
                        String librarianPassword = scanner.nextLine();
                        try (Connection conn = db.getConnection()) {
                            String query = "SELECT * FROM librarians WHERE username = ? AND password = ?";
                            PreparedStatement stmt = conn.prepareStatement(query);
                            stmt.setString(1, librarianUsername);
                            stmt.setString(2, librarianPassword);
                            ResultSet rs = stmt.executeQuery();
                            if (rs.next()) {
                                System.out.println("\nWelcome, " + rs.getString("name") + " (Librarian)!");

                                //call the librarian panel here
                                lb.showPanel();

                            } else {
                                System.out.println("Invalid username or password.");
                            }
                        } catch (SQLException ex) {
                            System.out.println("Error: " + ex.getMessage());
                        }
                        break;
                    case 3:
                        // Check if the user is an admin
                        System.out.print("Admin username: ");
                        String adminUsername = scanner.nextLine();
                        System.out.print("Admin password: ");
                        String adminPassword = scanner.nextLine();
                        try (Connection conn = db.getConnection()) {
                            String query = "SELECT * FROM admins WHERE username = ? AND password = ?";
                            PreparedStatement stmt = conn.prepareStatement(query);
                            stmt.setString(1, adminUsername);
                            stmt.setString(2, adminPassword);
                            ResultSet rs = stmt.executeQuery();
                            if (rs.next()) {
                                System.out.println("\nWelcome, " + rs.getString("username") + " (Admin)!");

                                //call the admin panel here.
                                admin.adminPanel();
                            } else {
                                System.out.println("Invalid username or password.");
                            }
                        } catch (SQLException ex) {
                            System.out.println("Error: " + ex.getMessage());
                        }
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        }
    }


}