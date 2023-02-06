import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;
public class User {
    private String username;
    private String password;
    private String Position;
    private Double Balance;


    public User(String username, String password, String position, Double balance)
    {
    setUsername(username);
    setPassword(password);
    setPosition(position);
    setBalance(balance);
    }
    public User (String username, String password, String position){
        setUsername(username);
        setPassword(password);
        setPosition(position);
    }
    public User(){
    }
    Connection connection = ConnectWithSql.connection();


}
