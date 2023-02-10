import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Scanner;

public class Customer extends User {
    static Scanner in = new Scanner(System.in);
    public Customer(String username, String password, String position, Double balance ){
        super(username,password, position ,balance);
    }
    public  Customer(){}
    @Override
    return " Name:"+ getUsername()+", balance:"+ getBalance()+  " tenge, position : " + getPosition();
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
    Main.forTheCustomer();
}
    public static void cancel () throws SQLException {
        System.out.println("Write purchase ID: ");
        int id = in.nextInt();
        Purchases p = Purchases.getPurchases(id);
        if (p == null) {
            System.out.println("Incorrect!");
            Main.forTheCustomer();
        }
        changeBalance(p, 1);
        Purchases.drop(id);
        System.out.println("You have successfully deleted the record");
        Main.forTheCustomer();
    }



}
