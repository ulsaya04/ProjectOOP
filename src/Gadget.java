import  java.sql.*;
import java.util.Arrays;
import  java.util.List;

public class Gadget {
    private  String name ;
    private  double price;
    private String category;
    static  final  List<String> categories = Arrays.asList("Mobile Phones","Laptop","Smart Watch","Headphones");
    static  Connection connection = ConnectWithSql.connection();
    static PreparedStatement ps =null;
    static  ResultSet rs = null ;


    public Gadget(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public  Gadget (){
    }
    public  String getName(){
        return  name ;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price ;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
   public  static  void infoCategories() throws  SQLException {
        int c = 1;
        for (String s: categories){
            System.out.println( c+ " : " + s );
            c++;
        }
    }
    public static void infoCategories2 () throws SQLException {
    int c = 1;
    for (String s: categories){
        System.out.println(c + " : " + s);
        c++;
    }
    if (Login.getCurrentUser().getPosition().equals("seller")) {
        Main.forTheSeller();
    } else {
        Main.forTheCustomer()

    }
    }
}