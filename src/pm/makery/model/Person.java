package pm.makery.model;

import java.util.*;
import pm.makery.model.Subject;
import pm.makery.model.Assignment;

public class Person {

	private String username = "";
	private String password = "";
	private HashMap<Subject, ArrayList<Assignment>> subjectsAndAssignments = new HashMap<>();

	public Person(String userName) {

	}

	public String getUsername() {
		return username;
	}

	public HashMap<Subject, ArrayList<Assignment>> getSubjectsAndAssignments() {
		return subjectsAndAssignments;
	}
}
