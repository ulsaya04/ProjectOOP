import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

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
        gadget.setName(name);
        System.out.println("Write the price of the gadget:");
        double price = in.nextDouble();
        gadget.setPrice(price);
        System.out.println("Write the product category:");
        Gadget.infoCategories();
        int x=in.nextInt();
        switch (x){
            case 1 ->gadget.setCategory("Mobile Phones" );
            case 2 ->gadget.setCategory("Laptop");
            case 3 ->gadget.setCategory("Smart Watch");
            case 4 ->gadget.setCategory("Headphones");
        }
        gadget.insert();
        Gadget.seachProcedure(gadget.getName(), gadget.getPrice(), gadget.getCategory());
        Main.forTheSeller();
    }
    public void deleteGadget() throws  SQLException{
        System.out.println("Write the ID of the gadget you want to delete");
        int id = in.nextInt();
        dropMovie(id);
        System.out.println("You have successfully deleted the gadget!");
        Main.forTheSeller();
    }
    private static void dropMovie(int id) throws SQLException{
    Connection connection = ConnectWithSql.connection();
    Gadget.ps = connection.prepareStatement("DELETE FROM gadgets WHERE id = ?");
    Gadget.ps.setInt(1,id);
    Gadget.ps.execute();
    }
}