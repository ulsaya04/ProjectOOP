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
        ps = connection.prepareStatement("INSERT INTO purchases (username, nameproduct, categories, price) VALUES (?, ?, ?, ?)");
        ps.setString(1, Login.getCurrentUser().getUsername());
        ps.setString(2, purchases.getName());
        ps.setString(3, purchases.getCategory());
        ps.setDouble(4, purchases.getPrice());
        ps.execute();
    }
}
