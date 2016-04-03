package pm.makery.view;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class WeekPane extends BorderPane {
	
	// private final int TIME_INTERVAL_LABEL = 1;
	
	public WeekPane() {
		setLeft(createTimeTable());
		setCenter(createDayTable());
	}
	
	private GridPane createTimeTable() {
		GridPane timeTable = new GridPane();
		timeTable.getColumnConstraints().add(new ColumnConstraints(30));
		for (int i = 0; i < 24; i++) {
			timeTable.getRowConstraints().add(new RowConstraints(20));
			String hours = String.format("%02d", i);
			timeTable.add(new Label(hours+":00"), 1, 2*i);
			timeTable.getRowConstraints().add(new RowConstraints(20));
		}
		
		return timeTable;
		
	}
	
	private FlowPane createDayTable() {

		FlowPane fp = new FlowPane();
		fp.getChildren().add(createTimeTable());
		
		for (int i = 0; i < 7; i++) {
			fp.getChildren().add(new DayPane());
		}
		
		return fp;
		
	}
	
	

}
