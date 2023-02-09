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
    public  static  void  infoCategories2() throws  SQLException {
        int c =1 ;
        for (String s : categories){
            System.out.println(c+ " : " + s);
            c++;
        }
            if(Login.getCurrentUser().getRole().equals("seller")){
                Main.forTheSeller();
            } else {
                Main.forTheBuyer();
            }
        }
        public  void  insert() throws SQLException{
        ps = connection.prepareStatement("INSERT INTO gadget  (name, price, categories) VALUES (?, ?, ?)");
        ps.setString(1,getName());
        ps.setDouble(2, getPrice());
        ps.setString(3,getCategory());
        ps.execute();
        }
public  static  void seachProcedure(String name , double price, String category) throws  SQLException{
        String res  = null ;
    Statement statement = connection.createStatement();
    rs = statement.executeQuery("SELECT * FROM  gadget ");
    while (rs.next()){
        if(name.equals(rs.getString("name")) && price==rs.getDouble("price") && categories.equals(rs.getString("categories"))){
            res = "Id: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", price: " +rs.getDouble("price") + " tenge, category: " + rs.getString("categories");
        }
    }
    if(res == null ){
        System.out.println("There is no such gadget!");
    }
    System.out.println( res );
    Main.forTheSeller();

}
public  static  void  infoAllGadget() throws  SQLException {
    Statement st = connection.createStatement();
    rs = st.executeQuery("SELECT * FROM gadget");
    while (rs.next()){
        System.out.println("ID:" + rs.getInt("id") + ", name: "
        + rs.getString("name" ) +", price : "+ rs.getDouble("price ")
                + " tenge, category: " + rs.getString("categories"));
    }
    if (Login.getCurrentUser().getRole().equals("sellar")){
          Main.forTheSeller();
    }else {
        Main.forTheBuyer();
    }
}
public  static  void SearchByCategory(String category) throws SQLException {
    Statement statement = connection.createStatement();
    rs = statement.executeQuery("SELECT * FROM gadget");
    System.out.println(category + ": ");
    while (rs.next()){
        if(category.equals(rs.getString("categories"))){
            System.out.println("ID: " + rs.getInt("id") + ", name: "
                    + rs.getString("name") + ", price: " + rs.getDouble("price")
                    + " tenge" );
        }
    }
    if(Login.getCurrentUser().getRole().equals("seller")){
        Main.forTheSeller();
    }else {
        Main.forTheBuyer();
    }
}

}
