import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Scanner;

public class Customer extends  User {
    static Scanner in = new Scanner(System.in);
    public Customer(String username, String password, String fole, Double balance ){
        super(username,password,role,balance);
    }
    public  Customer(){}
    @Override
    return " Name:"+ getUsername()+", balance:"+ getBalance()+  " tenge, role: " + getRole();
}
public  static void buy() throws  SQLException{
    System.out.println("Write the gadget  ID");
    int id = in.nextInt();
    Gadget gadget = searchGadget(id);
    Purchases purchases = new
            Purchases(Login.getCurrentUser().getUsername(), gadget.getName(), gadget.getCategory(), gadget.getPrice());
    changeBalance(gadget, -1);
    Purchases.insert(purchases);
    Purchases.infoRecord(purchases);
    System.out.println("You have successfully signed up!");
    Main.forTheBuyer();
}



}
