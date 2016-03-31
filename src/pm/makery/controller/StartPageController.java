package pm.makery.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pm.makery.MainApp;
import pm.makery.view.*;

public class StartPageController {

    private Stage startStage;
    @FXML
    private Label settings;
    @FXML
    private Label taskHandler;
    @FXML
    private MenuItem newTaskMenu;
    @FXML
    private MenuItem newAssignmentMenu;
    @FXML
    private MenuItem taskHandlerMenu;
    @FXML
    private MenuItem settingsMenu;
    @FXML
    private MenuItem logOutMenu;
    @FXML
    private Menu colorTheme;
    @FXML
    private MenuItem casualTheme;
    @FXML
    private MenuItem crazyTheme;
    @FXML
    private MenuItem aboutMenu;

    private MainApp mainApp;

     /**
     * Constructor.
     * Is called before the initialize() method.
     */
    public StartPageController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    private void initialize() { }

    public void setStartPage(Stage startStage) {
        this.startStage = startStage;
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

}
