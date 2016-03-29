package pm.makery.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection con;
    private static String URL = "jdbc:mysql://localhost:3306/planminder";
    private static final String USER = "joakim";
    private static final String PASSWORD = "fiskenhej";

    static {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return con;
    }
}
