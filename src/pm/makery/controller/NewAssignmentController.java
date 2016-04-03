package pm.makery.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pm.makery.MainApp;
import pm.makery.model.Assignment;
import pm.makery.model.Person;
import pm.makery.model.Subject;

public class NewAssignmentController {

	@FXML
	private MenuItem logOutMenu, startPageMenu;
	@FXML
	private Label createNewAssignmentLabel, chooseSubjectLabel, nameLabel, placeLabel, startDateLabel, startTimeLabel;
	@FXML
	private Label endDateLabel, endTimeLabel, noteLabel;
	@FXML
	private ChoiceBox<String> chooseSubject = new ChoiceBox<String>();
	@FXML
	private TextField nameField, placeField;
	@FXML
	private DatePicker startDate, endDate;
	@FXML
	private Slider startHour, startMinute, endHour, endMinute;
	@FXML
	private CheckBox recurringCheckBox;
	@FXML
	private Hyperlink createNewSubjectLink;
	@FXML
	private TextArea noteText;

	private MainApp mainApp;
	private Person p;


	public NewAssignmentController(){


	}

	private void initialize() {
	}

	public void initializeSubjects() {
		List<Subject> sub = new ArrayList<Subject>(p.getSubjects());// sort subjects in alphabetic order..
		sub.add(new Subject());
		sub.add(new Subject("hej"));
		sub.add(new Subject("på"));
		sub.add(new Subject("dig"));
		sub.add(new Subject("tada!!"));
		List<String> l = new ArrayList<String>();
		for(Subject s : sub) {
			l.add(s.getName());
		}
		ObservableList<String> list = FXCollections.observableList(l);
		System.out.println(list.get(4));
		chooseSubject.setItems(list);
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		p = mainApp.getUser();
	}

	@FXML
	private void handleChooseSubject() {

	}

	@FXML
	private void handleStartPage() {
		mainApp.showStartPage(p);
	}











}
