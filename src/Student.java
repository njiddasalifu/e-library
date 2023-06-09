


import java.sql.Date.*;
import java.util.*;
import java.sql.*;
import java.time.*;


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
    Book book = new Book();
    Login login = new Login();

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

    Scanner scanner = new Scanner(System.in);

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
            String borrowQuery = "INSERT INTO transactions (StudentID, BookID, issue_date, due_date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement borrowStatement = conn.prepareStatement(borrowQuery);
            borrowStatement.setInt(1, this.StudentID);  
            borrowStatement.setInt(2, availabilityResult.getInt("BookID"));  
            borrowStatement.setDate(3, new Date(System.currentTimeMillis()));  // Set the current date as the borrow date
            System.out.print("Enter the due date (yyyy-MM-dd): ");
            String due_date = scanner.nextLine();
            borrowStatement.setString(4, due_date);
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
  
    // see transactions
    public void viewTransactionHistory() {
        System.out.println("Enter the student ID to view the transaction history of the student");
        int studentId = scanner.nextInt();
        try(Connection conn = db.getConnection()) {
            String sql = "SELECT * FROM transactions WHERE student_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int bookId = rs.getInt("book_id");
                LocalDate issueDate = rs.getObject("issue_date", LocalDate.class);
                LocalDate dueDate = rs.getObject("due_date", LocalDate.class);
                LocalDate returnDate = rs.getObject("return_date", LocalDate.class);
                boolean returned = rs.getBoolean("returned");
                String status = returned ? "Returned" : "Not Returned";
                System.out.println("Transaction ID: " + id);
                System.out.println("Book ID: " + bookId);
                System.out.println("Issue Date: " + issueDate);
                System.out.println("Due Date: " + dueDate);
                System.out.println("Return Date: " + returnDate);
                System.out.println("Status: " + status);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //dismissing a student
    public void deleteStudent() {
        System.out.println("Enter the student ID to dismiss:");
        int studentId = scanner.nextInt();
        try(Connection conn = db.getConnection()) {
            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, studentId);
            pstmt.executeUpdate();
            System.out.println("Student deleted successfully");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



    // The student PAnel

    public void StudentPanel() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!exit) {
            System.out.println("1. View all books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Reserve a Book");
            System.out.println("4. View Your borrow transaction");
            System.out.println("5. Return a Book");
            System.out.println("6. Logout");
            
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
                        // borrowBook();
            
                        break;
                    case 3:
                        book.reserveBook();
                        break;
                    case 4:
                        viewTransactionHistory();                        
                    break;
                    case 5:
                        book.returnBook();
                        break;
                    case 6:
                        login.login();
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
