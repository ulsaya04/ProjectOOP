import java.sql.SQLException;
import java.util.Scanner;
public class Registration extends User{
static Scanner in = new Scanner(System.in);

public Registration(String username,
                    String password, String position) {
    super(username, password, position);
}
public static void reg() throws
SQLException {
    User user = new User();
    System.out.println("Write username: ");
    String username = in.next();
    user.setUsername(username);
    System.out.println("Write password: ");
    String pass = in.next();
    user.setPassword(checkPass(pass));
    System.out.println("Choose position: 1) seller or 2) buyer");
    int position = in.nextInt();
    switch (position) {
        case 1 -> user.setPosition("seller");
        case 2 -> user.setPosition("buyer");
    }
    user.insert();
    System.out.println("You have successfully registered!");
    Main.mainMenu();
}
private static String checkPass(String pass) {
    if (!checkCorrrectPassword(pass)) {
        System.out.println("Your password is weak! It should contain both large and small letters and numbers");
        String password = in.next();
        checkPass(password);
    }
    return pass;
}

}

