import java.sql.*;
import java.util.Scanner;

class borrower {
    DBconnection db = new DBconnection();

    private void viewAllBorrowers() {
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM borrowers");
            System.out.println("All borrowers:");
            System.out.println("ID\tName\t\t\tEmail\t\t\tPhone Number\tAddress");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t\t"
                        + rs.getString("email") + "\t" + rs.getString("phone_number") + "\t"
                        + rs.getString("address"));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void addBorrower() {
        try (Scanner scanner = new Scanner(System.in); Connection conn = db.getConnection()) {
            System.out.print("Borrower name: ");
            String name = scanner.nextLine();
            System.out.print("Borrower email: ");
            String email = scanner.nextLine();
            System.out.print("Borrower phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Borrower address: ");
            String address = scanner.nextLine();

            String query = "INSERT INTO borrowers (name, email, phone_number, address) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phoneNumber);
            stmt.setString(4, address);
            int result = stmt.executeUpdate();
            if (result > 0) {
                System.out.println("Borrower added successfully.");
            } else {
                System.out.println("Failed to add borrower.");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void removeBorrower() {
        try (Scanner scanner = new Scanner(System.in); Connection conn = db.getConnection()) {
            System.out.print("Borrower ID: ");
            int borrowerId = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            String query = "DELETE FROM borrowers WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userID);
            int result = stmt.executeUpdate();
            if (result > 0) {
                System.out.println("Borrower removed successfully.");
            } else {
                System.out.println("Failed to remove borrower.");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
