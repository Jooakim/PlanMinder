package pm.makery.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import pm.makery.MainApp;

public class LoginPageController {

	@FXML
    private TextField usernameInput;
	@FXML
    private PasswordField passwordInput;
	@FXML
    private CheckBox rememberMeCheckbox;
	@FXML
    private Hyperlink forgotPassword;

    private MainApp mainApp;

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
    private void initialize() { }

    /**
     * Is called by the main application to give a reference back to itself.
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    /**
     * Called when the user presses the login button.
     * TODO JOAKIM FIXES med databas och allt ;)
     */
    @FXML
    private void handleLogin() {
    	String username = usernameInput.getText();
    	String password = passwordInput.getText();

    	//ska spara inloggningsuppgifter om den �r ikryssad.
    	boolean rememberMeClicked = rememberMeCheckbox.isSelected();

    	boolean loginClicked = mainApp.showStartPage(username, password);
    	if (!loginClicked) {
    		Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Incorrect name or password");
            alert.setHeaderText("Incorrect name or password");
            alert.setContentText("Incorrect username or password. Please try again!");

            alert.showAndWait();
    	}
    }

    /**
     * Called when the user presses the forgot password button.
     */
    @FXML
    private void handleForgotPassword() {
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
    @FXML
    private void handleRegister() {
    	mainApp.showRegistrationPage();
    }
    @FXML
    private void handleCloseApplication() {
    	// TODO handle remember me option

    	mainApp.closeApplication();
    }
}





