package pm.testing;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import pm.makery.view.*;

public class CalendarTest extends Application {
	
	public void start(Stage primaryStage) {
		Scene calendar = new Scene(new WeekPane());
		primaryStage.setScene(calendar);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
