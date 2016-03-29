package pm.makery.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pm.makery.MainApp;
import pm.makery.view.*;

public class StartPageController {

    private Stage startStage;
    public Label settings;
    public Label taskHandler;
    public MenuItem newTaskMenu;
    public MenuItem newAssignmentMenu;
    public MenuItem taskHandlerMenu;
    public MenuItem settingsMenu;
    public MenuItem logOutMenu;
    public Menu colorTheme;
    public MenuItem casualTheme;
    public MenuItem crazyTheme;
    public MenuItem aboutMenu;

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
    private void initialize() {
    }

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
    public void handleLogOut() {
    	//TODO remove person
    	Stage primaryStage = mainApp.getPrimaryStage();
    	mainApp.start(primaryStage);

    }

}
