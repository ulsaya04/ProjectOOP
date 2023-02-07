import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectWithSql {

        static java.sql.Connection connection = null; //пустая строка
        public static java.sql.Connection connection () {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjectOOP", "postgres", "Shugyla2005");
                if (connection != null) {
                    System.out.println("Connection Established");
                } else {
                    System.out.println("Connection Failed");
                }
            } catch (SQLException e) {
                System.out.println(e);

            }
            return connection;
        }
        public void createTable(Connection connection, String table_name) {
            Statement statement;
            try {
                String query = "Create table " + table_name;                statement = connection.createStatement();
                statement.executeUpdate(query);
                System.out.println("Table Created");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
}
