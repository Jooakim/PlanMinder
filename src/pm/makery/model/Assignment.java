package pm.makery.model;

import pm.makery.MainApp;
import pm.makery.model.Subject;
import pm.makery.util.InvalidDateInputException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.*;

public class Assignment {

	private Subject subject;
	private MainApp mainApp;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private TreeMap<LocalDateTime, LocalDateTime> recurrentDates;


	public Assignment() {
		subject = new Subject();
	}

	public Assignment(Subject subject) {
		this.subject = subject;
	}

	public Assignment(String subject) {
		new Assignment(new Subject(subject));
	}

	public void setStartDateAndTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public void setStartDate(LocalDate startDate, LocalTime startTime) {
		startDateTime = startDate.atTime(startTime);
	}

	public void setStartDate(LocalDate startDate) {
		LocalTime startTime = startDateTime.toLocalTime();
		startDateTime = LocalDateTime.of(startDate, startTime);
	}

	public void setStartTime(LocalTime startTime) {
		LocalDate startDate = startDateTime.toLocalDate();
		startDateTime = LocalDateTime.of(startDate, startTime);
	}

	public void setEndDateAndTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public void setEndDate(LocalDate endDate, LocalTime endTime) {
		endDateTime = endDate.atTime(endTime);
	}

	public void setEndDate(LocalDate endDate) {
		LocalTime endTime = endDateTime.toLocalTime();
		endDateTime = LocalDateTime.of(endDate, endTime);
	}

	public void setEndTime(LocalTime endTime) {
		LocalDate endDate = endDateTime.toLocalDate();
		endDateTime = LocalDateTime.of(endDate, endTime);
	}

	public LocalDate getStartDate() {
		return startDateTime.toLocalDate();
	}

	public LocalTime getStartTime() {
		return startDateTime.toLocalTime();
	}

	public LocalDate getEndDate() {
		return endDateTime.toLocalDate();
	}

	public LocalTime getEndTime() {
		return endDateTime.toLocalTime();
	}

	/**
	 * Adds recurring dates to an assignment.
	 *
	 * @param startDateTime the start date and time of the first assignment.
	 * @param endDateTime the end date and time of first assignment.
	 * @param finalDateTime the final date and time of the assignment.
	 * @param interval the interval of the recurring assignment.
	 * @param unit unit of the interval.
	 * @return true if dates are set successfully.
	 *
	 */
	public void setRecurrent(LocalDateTime startDateTime, LocalDateTime endDateTime, LocalDateTime finalDateTime, long interval, ChronoUnit unit) throws InvalidDateInputException {
		String startDate = startDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG));
		String endDate = endDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG));
		if ( !isLegalDateInput(startDateTime, endDateTime) ) {
			throw new InvalidDateInputException("Invalid date input exception. The start date " + startDate + " comes before the end date " + endDate);
		} else if ( !isLegalDateInput(endDateTime, finalDateTime) ) {
			throw new InvalidDateInputException("Invalid date input exception. The final date " + startDate + " comes before the end date of first assignment " + endDate);
		}
		if (recurrentDates == null) {
			recurrentDates = new TreeMap<LocalDateTime, LocalDateTime>();
		}
		while(startDateTime.isBefore(finalDateTime)) {
			recurrentDates.put(startDateTime, endDateTime);
			startDateTime = startDateTime.plus(interval, unit);
		}
	}
	/**
	 *
	 * @param startDateTime
	 * @param endDateTime
	 * @return
	 */
	public boolean isLegalDateInput(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		return startDateTime.isBefore(endDateTime);
	}


	public void addRecurrentDate(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {

	}


}
