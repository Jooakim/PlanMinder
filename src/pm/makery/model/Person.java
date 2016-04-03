package pm.makery.model;

import java.util.*;
import pm.makery.model.Subject;
import pm.makery.model.Assignment;

public class Person {

	private String username = "";
	private String password = "";
	private HashMap<Subject, ArrayList<Assignment>> subAndAssign = new HashMap<>();


	public Person(String userName) {

	}

	public String getUsername() {
		return username;
	}

	public HashMap<Subject, ArrayList<Assignment>> getSubAndAssign() {
		return subAndAssign;
	}

	public Set<Subject> getSubjects() {
		return subAndAssign.keySet();
	}

	public ArrayList<Assignment> getAssignments(Subject subject) {
		if(subAndAssign.containsKey(subject)) {
			return subAndAssign.get(subject);
		} else {
			return new ArrayList<Assignment>();
		}
	}

}
