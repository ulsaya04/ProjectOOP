import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Customer extends User {
    static Scanner in = new Scanner(System.in);
    public Customer(String username, String password, String position, Double balance ){
        super(username,password, position ,balance);
    }

    @Override
    public String toString(){
    return " Name:" + getUsername()+", balance:"+ getBalance()+  " tenge, position : " + getPosition();
    }
public  static void buy() throws  SQLException{
    System.out.println("Write the gadget ID");
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
        assert p != null;
        changeBalance(p, 1);
        Purchases.drop(id);
        System.out.println("You have successfully deleted the record");
        Main.forTheCustomer();
    }
    private static Gadget searchGadget(int id) throws SQLException {
        Connection connection= ConnectWithSql.connection();
        Gadget gadget = null;
        Statement st = connection.createStatement();
        rs = st.executeQuery("SELECT * FROM gadgets");
        while (rs.next()){
            if(id==rs.getInt("id")){
                 gadget = new Gadget(rs.getString("name"),rs.getDouble("price"), rs.getString("categories"));
            }
        }
        if(gadget==null){
            System.out.println("There is no such procedure!");
            Gadget.infoAllGadget();
            Main.forTheCustomer();
        }
        return gadget;
    }
    private static void changeBalance(Gadget gadget, int reduceOrReturn) throws SQLException {
        double res = Login.getCurrentUser().getBalance()+(reduceOrReturn * (gadget.getPrice()));
        if(res<0) {
            System.out.println("Insufficient funds");
            Main.forTheCustomer();
        }
        Login.getCurrentUser().setBalance(res);
    }
}




