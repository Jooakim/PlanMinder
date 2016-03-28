package pm.makery;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("PlanMinder");

        initRootLayout();

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

	            /*
	            // Give the controller access to the main app.
	            PersonOverviewController controller = loader.getController();
	            controller.setMainApp(this);
	            */
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	public static void main(String[] args) {
		launch(args);
	}
}
