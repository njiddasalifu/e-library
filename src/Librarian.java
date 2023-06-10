
import java.util.Scanner;



public class Librarian {
    //this is the object reference to the database connection
    DBconnection db = new DBconnection();
    Student student = new Student();
    //  Books book = new Books();
    Book book = new Book();
    Login login = new Login();

    public void showPanel() {
    

            System.out.println("1. View all books");
            System.out.println("2. Add a book");
            System.out.println("3. Remove a book");
            System.out.println("4. View all borrowers");
            System.out.println("5. Dismiss Student");
            System.out.println("6. Impose fine");
            System.out.println("7. Logout");

            try (Scanner scanner = new Scanner(System.in)) {
                int choice = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline character
            if (choice == 7){
                System.out.println("Exiting program...");
                System.exit(0);
                
            }
                switch (choice) {
                    case 1:
                       student.ViewBooks();
                        break;
                    case 2:
                        book.addBook();
                        break;
                    case 3:
                        book.deleteBook();
                        break;
                    case 4:
                        student.viewTransactionHistory();
                        break;
                    case 5:
                        student.deleteStudent();
                        break;
                    case 6:
                        book.imposeFine();
                        break;
                    case 7:
                        login.login();
                        default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
    }
}
