import java.sql.SQLException;
import java.util.Scanner;

public class Seller extends User {
    static Scanner in = new Scanner(System.in);
    public Seller (String username, String password, String position){
        super (username, password, position);
    }
    public Seller(){}
    @Override
    public String toString(){
        return "Name: " + getUsername() + ", position: " + getPosition();
    }
    public static void addGadget() throws SQLException{
        Gadget gadget = new Gadget(name, price, category);
        System.out.println("Write the name of the gadget: ");
        String name = in.next();
        double price = in.nextDouble();
        gadget.setPrice(price);
    }
}
