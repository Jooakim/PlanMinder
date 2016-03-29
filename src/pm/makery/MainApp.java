package pm.makery;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pm.makery.view.LoginPageController;
import pm.makery.view.StartPageController;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private BorderPane planeLayout;
	private String username = "";
	private String password = "";


	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("PlanMinder");

		initRootLayout();
		initPlaneLayout();

		showLoginPage();
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initializes the plane layout
	 */
	public void initPlaneLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PlaneLayout.fxml"));
			planeLayout = (BorderPane) loader.load();
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

			// Set person overview into the center of root layout.
			rootLayout.setCenter(loginPage);

			// Give the controller access to the main app.
			LoginPageController controller = (LoginPageController) loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows startpage for the logged in user.
	 * @param username is the name of the user.
	 */
	public boolean showStartPage(String username, String password) {
		username = this.username;
		password = this.password;
		//testar så personen finns, just nu går allt igenom, vad man än skriver, JOAKIM fixes...
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/StartPage.fxml"));
			BorderPane page = (BorderPane) loader.load();

			Scene scene = new Scene(planeLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			planeLayout.setCenter(page);

			// Give the controller access to the main app.
			StartPageController controller = (StartPageController) loader.getController();
			controller.setMainApp(this);

			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
