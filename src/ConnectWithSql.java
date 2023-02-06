import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectWithSql {
    static java.sql.Connection connection = null; //пустая строка
    public static java.sql.Connection connection() {
        try {
            connection = DriverManager.getConnection()
        }
    }

}
