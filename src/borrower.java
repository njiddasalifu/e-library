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


    private void removeBorrower() {
        try (Scanner scanner = new Scanner(System.in); Connection conn = db.getConnection()) {
            System.out.print("Borrower ID: ");
            String username  = scanner.nextLine();
            scanner.nextLine(); // consume newline character

            String query = "DELETE FROM borrowers WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
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
