package pm.makery.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import pm.makery.MainApp;
import pm.makery.model.Person;
import pm.makery.util.DatabaseUtil;

import java.sql.ResultSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class LoginPageController {

	//Ska alla vara private egentligen..
	public TextField usernameInput;
	public PasswordField passwordInput;
	public CheckBox rememberMeCheckbox;
	public Hyperlink forgotPassword;

	private MainApp mainApp;

	private final String REMEMBER_ME_FILE = ".topSecretRememberMe";

	/**
	 * Constructor.
	 * Is called before the initialize() method.
	 */
	public LoginPageController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	private void initialize() {
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}


	/**
	 * Called when the user presses the login button.
	 */
	public void handleLogin() {
		String username = usernameInput.getText();
		String password = passwordInput.getText();

		// Saves username and password if remember me is ticked
		// otherwise it deletes the file.
		if (rememberMeCheckbox.isSelected()) {
			writeRememberMe(username, password);
		} else {
			clearRememberMe();
		}


		tryUsernamePassword(username, password);
	}

	private void writeRememberMe(String username, String password) {
		try {
			PrintWriter writer = new PrintWriter(REMEMBER_ME_FILE, "UTF-8");
			writer.println(username);
			writer.println(password);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * If remember me file exists, it will set the username and password
	 * contained in that file as default values in the input fields.
	 */
	public void readRememberMe() {
		File f = new File(REMEMBER_ME_FILE);
		if (f.exists() && !f.isDirectory()) {
			rememberMeCheckbox.setSelected(true);
			Scanner scan;
			try {
				scan = new Scanner(f);
				String username = scan.nextLine();
				String password = scan.nextLine();
				usernameInput.setText(username);
				passwordInput.setText(password);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * If called the 'remember me' file gets deleted if it exist.
	 */
	private void clearRememberMe() {
		Path path = FileSystems.getDefault().getPath("", REMEMBER_ME_FILE);
		try {
			Files.deleteIfExists(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void tryUsernamePassword(String username, String password) {
		String loginQuery = "SELECT * FROM " + DatabaseUtil.userTable 
				+ " WHERE Username='" + username 
				+ "' AND Password='" + password + "';"; 
		ResultSet rs = DatabaseUtil.databaseQuery(loginQuery);
		if (!DatabaseUtil.checkEmptyResultSet(rs)) {
			mainApp.showStartPage(new Person(username));
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Wrong Username/Password");
			alert.setHeaderText("Wrong Username/Password");    
			alert.setContentText("Incorrect username or password. Please try again!");
			alert.showAndWait();
		}

	}

	/**
	 * Called when the user presses the forgot password button.
	 */
	public void handleForgotPassword() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.initOwner(mainApp.getPrimaryStage());
		alert.setTitle("Under building");
		alert.setHeaderText("Under construction.");
		alert.setContentText("At the moment you can not get your password. Thanks for being patient.");
		alert.showAndWait();
	}
	
	/**
	 * Called when the user presses the register button.
	 */
	public void handleRegister() {
		mainApp.showRegistrationPage();
	}
	
	@FXML
	/**
	 * Called when the user presses the close button in the menu.
	 */
	private void handleCloseApplication() {
		// TODO handle remember me option
		mainApp.closeApplication();
	}
}





