


import java.sql.Date;
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


    // Creating connection object
    DBconnection db = new DBconnection();

    // StudentsDBConnection stdb = new StudentsDBConnection();


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


    
    public void StudentRegistration(){
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

        try (Connection conn = db.getConnection()) {
            String query = "INSERT INTO students (Name, phone, email, Address, Interest, username, password) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, Name);
                stmt.setString(2, Phone);
                stmt.setString(3, Email);
                stmt.setString(4, Address);
                stmt.setString(5, Interest);
                stmt.setString(6, username);
                stmt.setString(7, password);
                int rowsAffected = stmt.executeUpdate();
                System.out.println(username + " " + " you have registered successfully!");
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }

        

    }


    // Faunction to view all Books in the Library
    public void ViewBooks() {
        
        try (Connection conn = db.getConnection()){
            Statement statement = conn.createStatement();
            // Execute the query to retrieve all books
            String query = "SELECT * FROM books";
            ResultSet resultSet = statement.executeQuery(query);
            
            // Iterate over the result set and display the books
            while (resultSet.next()) {
                String isbn = resultSet.getString("ISBN");
                String author = resultSet.getString("Author");
                String title = resultSet.getString("Title");
                
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Title: " + isbn);
                System.out.println("--------------------");
            }
            
            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    // Borrow Book
    public void borrowBook() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the title of the book you want to borrow:");
    String bookTitle = scanner.nextLine();

    try (Connection conn = db.getConnection()) {
        // Check if the book exists and is available for borrowing
        String availabilityQuery = "SELECT * FROM books WHERE Title = ? AND Availability = 'Available'";
        PreparedStatement availabilityStatement = conn.prepareStatement(availabilityQuery);
        availabilityStatement.setString(1, bookTitle);
        ResultSet availabilityResult = availabilityStatement.executeQuery();

        if (availabilityResult.next()) {
            // Book is available for borrowing, proceed with borrowing logic

            // Insert the borrow record into the borrow table
            String borrowQuery = "INSERT INTO borrow (StudentID, BookID, BorrowDate) VALUES (?, ?, ?)";
            PreparedStatement borrowStatement = conn.prepareStatement(borrowQuery);
            borrowStatement.setInt(1, this.StudentID);  
            borrowStatement.setInt(2, availabilityResult.getInt("BookID"));  
            borrowStatement.setDate(3, new Date(System.currentTimeMillis()));  // Set the current date as the borrow date
            borrowStatement.executeUpdate();

            // Update the book availability to 'Borrowed'
            String updateAvailabilityQuery = "UPDATE books SET Availability = 'Borrowed' WHERE BookID = ?";
            PreparedStatement updateAvailabilityStatement = conn.prepareStatement(updateAvailabilityQuery);
            updateAvailabilityStatement.setInt(1, availabilityResult.getInt("BookID"));
            updateAvailabilityStatement.executeUpdate();

            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("The requested book is not available for borrowing.");
        }

        availabilityResult.close();
        availabilityStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}




    // The student PAnel

    public void StudentPanel() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!exit) {
            System.out.println("1. View all books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. View Your borrow status");
            System.out.println("4. Logout");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline character
                
                switch (choice) {
                    case 1:
                        // book.ViewAllBooks();
                        ViewBooks();
                        break;
                    case 2:
                        // Handle borrowing logic
                        borrowBook();
                        break;
                    case 3:
                        // Handle borrow status view logic
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer choice.");
                scanner.nextLine(); // consume the invalid input
            }
        }
        
        scanner.close();
    }

}
