import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Purchases extends Gadget {
    private String username;
    static Connection connection = ConnectWithSql.connection();
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    public Purchases(String username, String name, String category, double price) {
        super(name, price, category);
        this.setUsername(username);
    }

    public Purchases() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static void insert(Purchases purchases) throws SQLException {
        ps = connection.prepareStatement("INSERT INTO purchases (username, namegadget, categories, price) VALUES (?, ?, ?, ?)");
        ps.setString(1, Login.getCurrentUser().getUsername());
        ps.setString(2, purchases.getName());
        ps.setString(3, purchases.getCategory());
        ps.setDouble(4, purchases.getPrice());
        ps.execute();
    }
    public static void infoRecord(Purchases p) throws SQLException {
        String res = null;
        Statement st = connection.createStatement();
        rs = st.executeQuery("SELECT * FROM purchases");

        while(rs.next()) {
            if (Login.getCurrentUser().getUsername().equals(rs.getString("username")) && p.getName().equals(rs.getString("namegadget")) && p.getCategory().equals(rs.getString("categories")) && p.getPrice() == rs.getDouble("price")) {
                int var10000 = rs.getInt("id");
                res = "ID: " + var10000 + ", username: " + rs.getString("username") + ", gadget name: " + rs.getString("namegadget") + ", price: " + rs.getDouble("price") + " tenge, category " + rs.getString("categories");
            }
        }

        System.out.println(res);
    }

    public static void drop(int id) throws SQLException {
        ps = connection.prepareStatement("delete from purchases where id = ?");
        ps.setInt(1, id);
        ps.execute();
    }

    public static Purchases getPurchases(int id) throws SQLException {
        Purchases p = null;
        Statement st = connection.createStatement();
        rs = st.executeQuery("SELECT * FROM purchases");

        while(rs.next()) {
            if (id == rs.getInt("id") && Login.getCurrentUser().getUsername().equals(rs.getString("username"))) {
                p = new Purchases(rs.getString("username"), rs.getString("namegadget"), rs.getString("categories"), rs.getDouble("price"));
            }
        }

        return p;
    }
}

