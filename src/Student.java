
import java.util.Date;
import java.util.*;
import java.sql.*;

public class Student {
    private int StudentID;
    private String Name;
    private String Interest;
    private String Phone;
    private String Address;
    private String password;
    private String username;

    // public Student(String StudentID, String Name, String Interest, String Phone,
    // String Address, String username , String password ){
    // this.StudentID = StudentID;
    // this.Name = Name;
    // this.Interest = Interest;
    // this.Phone = Phone;
    // this.Address = Address;
    // }

    public int getSID() {
        return StudentID;
    }

    public void setSID(int StudentID) {
        this.StudentID = StudentID;
    }

    public String getName() {
        return Name;
    }

    public void setusername(String username) {
        this.Name = username;
    }

    public String getusername() {
        return username;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getInterest() {
        return Interest;
    }

    public void setInterest(String Interest) {
        this.Interest = Interest;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void StudentRegistration() {
        StudentsDBConnection stdb = new StudentsDBConnection();

        Scanner sc = new Scanner(System.in);

        // collecting data from students
        System.out.println("Enter the Student Name");
        String Name = sc.nextLine();

        System.out.println("Enter the Student Phone");
        String Phone = sc.nextLine();

        System.out.println("Enter the Student Email");
        String Email = sc.nextLine();

        System.out.println("Enter the Student Address");
        String Address = sc.nextLine();

        System.out.println("Enter the Student Interest");
        String Interest = sc.nextLine();

        System.out.println("Enter the Student Username");
        String username = sc.nextLine();

        System.out.println("Enter the Student password");
        String password = sc.nextLine();

        // Working with the data from students

        try (Connection conn = stdb.getConnection()) {
            String query = "INSERT INTO students (studentName, Email, Address, Phone, Interest, password, username) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, Name);
            stmt.setString(2, Phone);
            stmt.setString(3, Email);
            stmt.setString(4, Address);
            stmt.setString(5, Interest);
            stmt.setString(6, username);
            stmt.setString(7, password);
            int rowsAffected = stmt.executeUpdate();
            System.out.println(username + "your data were added successfully!");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }
}
