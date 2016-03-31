package pm.makery.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {

	public static final String userTable = "Users";

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

	// Handles select statements
	public static ResultSet databaseQuery(String query) {
		ResultSet rs = null;
		try  {
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	// Handles create and inserts statements
	public static void updateDatabase(String query) {
		try  {
			Statement st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkEmptyResultSet(ResultSet rs) {
		try {
			if (rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}
}
