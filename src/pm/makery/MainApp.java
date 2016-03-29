package pm.makery;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pm.makery.controller.LoginPageController;
import pm.makery.controller.RegistrationPageController;
import pm.makery.controller.StartPageController;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private BorderPane planeLayout;
	private Scene rootScene, planeScene;
	private String username = "";
	private String password = "";


	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("PlanMinder");

		initRootLayout();
		initPlaneLayout();

		
		showLoginPage();

		this.primaryStage.setResizable(false);

	}


	/**
	 * Initializes the root layout and the scene with the layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PlaneLayout.fxml"));
			rootLayout = loader.load();
			rootScene = new Scene(rootLayout);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initializes the plane layout the scene with the layout.
	 */
	public void initPlaneLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PlaneLayout.fxml"));
			planeLayout = (BorderPane) loader.load();
			planeScene = new Scene(planeLayout);

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}


	/**
	 * Shows the login page inside rootlayout.
	 */
	public void showLoginPage() {



		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/LoginPage.fxml"));
			AnchorPane loginPage = (AnchorPane) loader.load();


			if (rootLayout == null) System.out.println("HEje");
			// Set person overview into the center of root layout.
			rootLayout.setCenter(loginPage);

			// Give the controller access to the main app.
			LoginPageController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// Show the scene containing the root layout.
		primaryStage.setScene(rootScene);
		primaryStage.show();
	}



	/**
	 * Shows startpage for the logged in user.
	 * @param username is the name of the user.
	 */

	public boolean showStartPage(String username, String password) {
		username = this.username;
		password = this.password;
		// TODO testar s� personen finns, just nu g�r allt igenom, vad man �n skriver, JOAKIM fixes...
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/StartPage.fxml"));
			BorderPane page = loader.load();

			planeLayout.setCenter(page);

			// Give the controller access to the main app.
			StartPageController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		primaryStage.setScene(planeScene);
		primaryStage.show();

		return true;
	}

	/**
	 * Shows the registration page inside rootlayout since it 
	 * was loaded in showLoginPage().
	 */
	public void showRegistrationPage() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RegistrationLayout.fxml"));
			AnchorPane registrationPage = loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(registrationPage);


			// Give the controller access to the main app.
			RegistrationPageController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}


	public void closeApplication() {
		System.out.println("test");
		System.exit(0);		
	}
}
