import java.sql.*;
import java.sql.Connection;
import java.util.Random;
import java.util.Scanner;
public class User {
    private String username;
    private String password;
    private String Position;
    private Double Balance;


    public User(String username, String password, String position, Double balance) {
        setUsername(username);
        setPassword(password);
        setPosition(position);
        setBalance(balance);
    }

    public User(String username, String password, String position) {
        setUsername(username);
        setPassword(password);
        setPosition(position);
    }

    public User() {
    }

    Connection connection = ConnectWithSql.connection();
    PreparedStatement ps = null;
    static ResultSet rs = null;


    public String getPosition() {
        return Position;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        this.Balance = balance;
    }

    public void setPosition(String position) {
        this.Position = position;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void insert() throws SQLException {
        ps = connection.prepareStatement("INSERT INTO users (username,password,position) values (?,?,?)");
        ps.setString(1, getUsername());
        ps.setString(2, getPassword());
        ps.setString(3, getPosition());
        ps.execute();
    }

    public static void findByCategory() throws SQLException {
        System.out.println("Write the gadget category: ");
        Gadget.infoCategories();
        int x = in.nextInt();
        switch (x) {
            case 1 -> Gadget.FindByCategory("Mobile Phones");
            case 2 -> Gadget.FindByCategory("Laptop");
            case 3 -> Gadget.FindByCategory("Smart Watch");
            case 4 -> Gadget.FindByCategory("Headphones");

        }
        if (Login.getCurrentUser().getPosition().equals("seller")) {
            Main.forTheSeller();
        } else {
            Main.forTheCustomer();
        }
    }
}
