package pm.makery.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pm.makery.MainApp;

public class SettingsController {

	@FXML
	private MenuItem startPageMenu, logOutMenu;
	@FXML
	private Button startPageButton, searchButton;
	@FXML
	private TextField searchField;



	private MainApp mainApp;



	public SettingsController() {
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
     * Called when the user presses log out from menu.
     */
    @FXML
    private void handleLogOut() {
    	//TODO remove person
    	Stage primaryStage = mainApp.getPrimaryStage();
    	mainApp.start(primaryStage);
    }

	@FXML
	private void handleCancel() {
		mainApp.showStartPage(mainApp.getUser());
	}
}
