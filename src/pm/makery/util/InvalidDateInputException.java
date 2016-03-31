package pm.makery.util;

import java.time.LocalDateTime;

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
