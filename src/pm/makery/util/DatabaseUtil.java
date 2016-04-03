package pm.makery.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

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
	
	public static void registerUser(String username, String password) {
		String registerUser = "INSERT INTO Users VALUES (? , ?);";
		try {
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(registerUser);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static ResultSet loginUser(String username, String password) {
		String login = "SELECT * FROM " + userTable + " WHERE Username = ? AND Password = ? ;";
		try {
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(login);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		return pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
