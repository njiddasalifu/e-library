import java.sql.*;
import java.time.LocalDate;

public class Borrower {

    // ...
    Books book = new Books();

    private void addBorrower(int studentID, int bookID, LocalDate borrowDate, LocalDate returnDate) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root",
                "salifu")) {
            String query = "INSERT INTO borrower (StudentID, BookID, BorrowDate, ReturnDate) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, studentID);
            statement.setInt(2, bookID);
            statement.setDate(3, Date.valueOf(borrowDate));
            statement.setDate(4, Date.valueOf(returnDate));
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding borrower: " + e.getMessage());
        }
    }

    public void borrowBook(int bookID, int studentID, LocalDate borrowDate, LocalDate returnDate) {
        // Check if the book is available
        if (book.getBookQuantity(bookID) > 0 && book.getBookStatus(bookID).equalsIgnoreCase("available")) {
            // Decrement the book quantity by one
            int newQuantity = book.getBookQuantity(bookID) - 1;
            book.updateBookQuantity(bookID, newQuantity);

            // If the book quantity reaches zero, update the status to "unavailable"
            if (newQuantity == 0) {
                book.updateBookStatus(bookID, "unavailable");
            }

            // Add the borrower to the borrower table
            addBorrower(studentID, bookID, borrowDate, returnDate);

            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("The book is not available for borrowing.");
        }
    }

    public void returnBook(int bookID) {
        // Increment the book quantity by one
        book.updateBookQuantity(bookID, book.getBookQuantity(bookID) + 1);

        // If the book quantity was zero, update the status to "available"
        if (book.getQuantity() == 1) {
            book.updateBookStatus(bookID, "available");
        }
        System.out.println("Book returned successfully!");
    }

}
