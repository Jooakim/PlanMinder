package pm.makery.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pm.makery.MainApp;
import pm.makery.util.Database;

public class RegistrationPageController {

	@FXML
	private Label usernameLabel;
	@FXML
	private Label passwordLabel;
	@FXML
	private Label confirmPasswordLabel;

	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private PasswordField confirmPasswordField;



	// Reference to main application
	private MainApp mainApp;

	// Database instance

	private Connection con;


	public RegistrationPageController() {
		con = Database.getConnection();
	}

	public void initialize() {

	}
	// Check if username is taken, if it is in use return false
	private boolean usernameAvailable(String username) {
		String checkIfTaken = "SELECT * FROM Users WHERE Username='" + username + "';";
		ResultSet rs = databaseQuery(checkIfTaken);
		try {
			if (rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		// Username is available
		return true;
	}

	private void registerUser(String username, String password) {
		String registerUser = "INSERT INTO Users VALUES ('" 
				+ username + "','" + password +"');";
		updateDatabase(registerUser);
		// TODO Notify user of completion visually
		System.out.println("User successfully created");
	}

	// Handles select statements
	private ResultSet databaseQuery(String query) {
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
	private void updateDatabase(String query) {
		try  {
			Statement st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handleRegisterUser() {
		String username, password, confirmPassword;

		if (passwordField!=null) {
			password = passwordField.getText();
			System.out.println(password);
			confirmPassword = confirmPasswordField.getText();
			if (password.equals(confirmPassword)) {
				username = usernameField.getText();
				if (usernameAvailable(username)) {
					registerUser(username, password);
				} else {
					// TODO alert the user that the username is taken with a alertbox
					// or something visual rather than plain text in terminal.
					System.out.println("Username already in use");
				}

			} else {
				// TODO Graphical alert
				System.out.println("Missmatch between passwords");
			}
		}

	}

	@FXML
	private void handleCancelRegistration() {
		// TODO go back to main
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	// Testcases for methods
	/*public static void main(String[] args) {
		RegistrationPageController r = new RegistrationPageController();
		r.usernameAvailable("Joakim");
	}*/


}
