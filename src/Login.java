import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Login extends User {
    private static User currentUser = null;
    static Connection connection = ConnectWithSql.connection();
    static Scanner in;
    public static User getCurrentUser() {
        return currentUser;
    }
    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public Login(String username, String password, String position) {
        super(username, password, position);
    }

    public Login() {
    }
    public static void Login() throws SQLException {
        System.out.println("Write username: ");
        String username = in.next();
        System.out.println("Write password: ");
        String pass = in.next();
        searchUser(username, pass);
    }

}
    private static void searchUser (String name, String pass) throws SQLException {
    String position = null;
    Statement statement = connection.createStatement();
    rs = statement.executeQuery("SELECT * FROM users");
    while (rs.next()){
        if
        ((name.equals(rs.getString("username")))&& pass.equals(rs.getString("password"))){
    rs.getString("position");
    }
    }
    if (position==null){
        System.out.println("There is no such user or wrong password!");
    Main.mainMenu();
}
    successfulLogin (name, pass, position);
}
    private static void successfulLogin(String name, String pass, String position) throws SQLException {
    if (position.equals("seller")) {
        setCurrentUser(new Seller(name,pass,position));
        Main.forTheSeller();
    }
    else if (position.equals("customer")){
        System.out.println("Write your balance: ");
        double balance = in.nextDouble();
        setCurrentUser(new Customer(name,pass,position,balance));
        System.out.println(getCurrentUser());
        Main.forTheCustomer();
        }
    }
    public static void myAccount () throws SQLException{
        System.out.println(getCurrentUser());
        if(getCurrentUser().getPosition().equals("Seller")) {
            Main.forTheSeller();
        } else {
            Main.forTheCustomer();

        }

        }
        public static void logOut ()throws SQLException {
            setCurrentUser(null);
            Main.mainMenu();
        }
        public static void exit (){

    System.exit(0);
        }
}