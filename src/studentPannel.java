import java.util.Scanner;

public class StudentPanel {
    private Student student;
    private Borrower borrow = new Borrower();

    public StudentPanel(Student student) {
        this.student = student;
    }

    public void showPanel() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Borrow a book");
            System.out.println("2. Return a book");
            System.out.println("3. View borrowed books");
            System.out.println("4. Logout");

            try (Scanner scanner = new Scanner(System.in)) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline character

                switch (choice) {
                    case 1:
                        borrow.borrowBook(student.getStudentID());
                        break;
                    case 2:
                        borrow.returnBook(student.getStudentID());
                        break;
                    case 3:
                        borrow.viewBorrowedBooks(student.getStudentID());
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
