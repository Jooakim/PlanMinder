package pm.makery.model;

import javafx.scene.paint.Color;


public class Subject {

	private String subject = "";
	private Color color;

	public Subject() {
		subject = "Untitled";
		color = Color.VIOLET;
	}

	public Subject(String subject) {
		this.subject = subject;
	}

	public Subject(String subject, Color c) {
		this.subject = subject;
		color = c;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setColor(Color c) {
		color = c;
	}

	public String getName() {
		return subject;
	}

	public Color getColor() {
		return color;
	}

/*
	/**
	 * TODO fix so it compares in alphabetic order..
	 *
	public int compareTo(Object o) {
		if(o.getClass() == this.getClass()) {
			Subject a = (Subject) o;
			return a.getName().hashCode() - this.getName().hashCode();
		}
		return 100 + o.hashCode();
	}
*/
}
