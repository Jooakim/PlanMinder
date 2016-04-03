package pm.makery.controller;

import java.sql.ResultSet;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import pm.makery.MainApp;
import pm.makery.util.DatabaseUtil;

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
	
	@FXML
	private Label passwordMissmatch;
	@FXML
	private Label usernameTaken;



	// Reference to main application
	private MainApp mainApp;



	public void initialize() {

	}
	// Check if username is taken, if it is in use return false
	private boolean usernameAvailable(String username) {
		String checkIfTaken = "SELECT * FROM Users WHERE Username='" + username + "';";
		ResultSet rs = DatabaseUtil.databaseQuery(checkIfTaken);
		
		return DatabaseUtil.checkEmptyResultSet(rs);
		
	}

	private void registerUser(String username, String password) {
		
		DatabaseUtil.registerUser(username, password);

		// Inform user of completion
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.initOwner(mainApp.getPrimaryStage());
		alert.setTitle("Registration Complete");
		alert.setHeaderText("Registration Complete");
		alert.setContentText("User successfully created");
		
		// Show alert and wait for user to click ok,
		// sends user back to main if clicked.
		alert.showAndWait()
		.filter(response -> response == ButtonType.OK)
		.ifPresent(response -> mainApp.showLoginPage());
	}

	
	@FXML
	private void handleRegisterUser() {
		String username, password, confirmPassword;
		
		// Clear if set previously
		passwordMissmatch.setText("");
		usernameTaken.setText("");
		

		password = passwordField.getText();
		if (!validInput(password)) {
			passwordMissmatch.setText("Cannot be empty");
			passwordMissmatch.setTextFill(Color.rgb(255, 0, 0));
			return;
		}
		
		confirmPassword = confirmPasswordField.getText();
				
		
		// If password matches register new user if username is 
		// available
		if (password.equals(confirmPassword)) {
			username = usernameField.getText();
			if (!validInput(username)) {
				usernameTaken.setText("Cannot be empty");
				usernameTaken.setTextFill(Color.rgb(255, 0, 0));
				return;
			} 
			
			if (usernameAvailable(username)) {
				registerUser(username, password);
			} else {
				usernameTaken.setText("Already in use");
				usernameTaken.setTextFill(Color.rgb(255, 0, 0));
			}

		} else {
			passwordMissmatch.setText("Missmatch");
			passwordMissmatch.setTextFill(Color.rgb(255, 0, 0));
		}


	}
	
	private boolean validInput(String input) {
		return input != null && input.length() > 0;
	}


	@FXML
	private void handleCancelRegistration() {
		mainApp.showLoginPage();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}


}
