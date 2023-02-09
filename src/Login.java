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
