package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtility {
    private static Connection connection;
    private ConnectionUtility() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_online_store", "root", "jsks8102");
            System.out.println("Connection established");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Connection getConnection() {
        ConnectionUtility d1 = new ConnectionUtility();
        return connection;
    }
}
