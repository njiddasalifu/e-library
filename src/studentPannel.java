// import java.util.Scanner;

// public class StudentPanel {
// private Student student;
// borrower borrow = new borrower();

// public StudentPannel();

// public StudentPanel(Student student) {
// this.student = student;
// }

// public void showPanel() {
// boolean exit = false;
// while (!exit) {
// System.out.println("1. Borrow a book");
// System.out.println("2. Return a book");
// System.out.println("3. View borrowed books");
// System.out.println("4. Logout");

// try (Scanner scanner = new Scanner(System.in)) {
// int choice = scanner.nextInt();
// scanner.nextLine(); // consume newline character

// switch (choice) {
// case 1:
// borrow.borrowBook();
// break;
// case 2:
// borrow.returnBook();
// break;
// case 3:
// borrow.viewBorrowedBooks();
// break;
// case 4:
// exit = true;
// break;
// default:
// System.out.println("Invalid choice.");
// break;
// }
// }
// }
// }
