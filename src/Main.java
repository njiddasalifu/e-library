public class Main {
    //this is the main class for the project
    public static void main(String[] args) throws Exception {
        System.out.println("\n******Hello, Welcome to our Library management System.******");
        //create all classes objects here 
        Admin admin = new Admin();
        // admin.registerLibrarian();
        Login login = new Login();
        login.login();
       
        
    }
}
