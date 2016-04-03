package pm.makery.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pm.makery.MainApp;
import pm.makery.view.*;

public class StartPageController {

    private Stage startStage;
    @FXML
    private MenuItem newTaskMenu, newAssignmentMenu, taskHandlerMenu,
    settingsMenu, logOutMenu, colorTheme, casualTheme, crazyTheme, aboutMenu;
    @FXML
    private Label settings, taskHandler;
    @FXML
    private Button newSubjectButton, newAssignmentButton, settingsButton;

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

    @FXML
    private void handleSettings() {
    	mainApp.showSettingPage();
    }

    @FXML
    private void handleNewAssignment(){
    	mainApp.showNewAssignment();
    }

}
