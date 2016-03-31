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

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setColor(Color c) {
		color = c;
	}

	public Color getColor() {
		return color;
	}

}
