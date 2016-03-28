package pm.makery.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pm.makery.MainApp;

public class LoginPageController {


    //@FXML
    private TextField usernameInput;
    private PasswordField passwordInput;


    private MainApp mainApp;
    private Stage loginStage;
    private boolean loginClicked = false;
    private String username = "";
    private String password = "";

    /**
     * Constructor.
     * Is called before the initialize() method.
     */
    public LoginPageController() {
    }

    //@FXML
    private void initialize() {
    }

    public void setLoginStage(Stage loginStage) {
        this.loginStage = loginStage;
    }

    public boolean isLoginClicked() {
        return loginClicked;
    }

    //@FXML
    private void handleLogin() {
    	if (isInputValid()) {

    	}
    }

    public boolean isInputValid() {
    	return true;
    }


}
