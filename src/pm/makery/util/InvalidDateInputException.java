package pm.makery.util;



@SuppressWarnings("serial")
public class InvalidDateInputException extends Exception {

	public InvalidDateInputException() {
		super();
	}

	public InvalidDateInputException(String message) {
		super(message);
	}

	public InvalidDateInputException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidDateInputException(Throwable cause) {
		super(cause);
	}

}
