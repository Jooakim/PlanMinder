package pm.makery.model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Assignment {

	private String assignment;
	private LocalDateTime startDate;
	private LocalDateTime endDate;

	public Assignment() {
		assignment = "Untitled";
		startDate = LocalDateTime.now();
		endDate = startDate.plus(1, ChronoUnit.HOURS);
	}

	public Assignment(String assignment) {
		this.assignment = assignment;
		startDate = LocalDateTime.now();
		endDate = startDate.plus(1, ChronoUnit.HOURS);
	}

	public Assignment(String assignment, LocalDateTime startDate, LocalDateTime endDate) {
		this.assignment = assignment;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Assignment(String assignment, LocalDate startDate, LocalDate endDate) {
		this.assignment = assignment;
		this.startDate = startDate.atTime(LocalTime.of(0, 0));
		this.endDate = endDate.atTime(LocalTime.of(0, 0));
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public void setStartDate(LocalDate startDate, LocalTime startTime) {
		this.startDate = startDate.atTime(startTime);
	}

	public void setStartDate(LocalDate startDate) {
		LocalTime startTime = this.startDate.toLocalTime();
		this.startDate = startDate.atTime(startTime);
	}

	public void setStartTime(LocalTime startTime) {
		LocalDate start = startDate.toLocalDate();
		startDate = LocalDateTime.of(start, startTime);
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public void setEndDate(LocalDate endDate, LocalTime endTime) {
		this.endDate = endDate.atTime(endTime);
	}

	public void setEndDate(LocalDate endDate) {
		LocalTime endTime = this.endDate.toLocalTime();
		this.endDate = LocalDateTime.of(endDate, endTime);
	}

	public void setEndTime(LocalTime endTime) {
		LocalDate end = endDate.toLocalDate();
		endDate = LocalDateTime.of(end, endTime);
	}

	public LocalDateTime getStartDateAndTime() {
		return startDate;
	}

	public LocalDate getStartDate() {
		return startDate.toLocalDate();
	}

	public LocalTime getStartTime() {
		return startDate.toLocalTime();
	}

	public LocalDateTime getEndDateAndTime() {
		return endDate;
	}

	public LocalDate getEndDate() {
		return endDate.toLocalDate();
	}

	public LocalTime getEndTime() {
		return endDate.toLocalTime();
	}

	public String getName() {
		return assignment;
	}

/*
	/**
	 * Adds several recurring dates to an assignment according to a given interval.
	 *
	 * @param startDateTime the start date and time of the first assignment.
	 * @param endDateTime the end date and time of first assignment.
	 * @param finalDateTime the final date and time of the assignment.
	 * @param interval the interval of the recurring assignment.
	 * @param unit unit of the interval.
	 * @throws  InvalidDateInputException if start date comes before end date or final date comes before end date.
	 *
	public void setRecurrent(LocalDateTime startDateTime, LocalDateTime endDateTime,
			LocalDateTime finalDateTime, long interval, ChronoUnit unit)
					throws InvalidDateInputException {

		isLegalDateInput(startDateTime, endDateTime);
		isLegalDateInput(endDateTime, finalDateTime);
		while(startDateTime.isBefore(finalDateTime)) {
			recurrentDates.put(startDateTime, endDateTime);
			startDateTime = startDateTime.plus(interval, unit);
		}
	}

	/**
	 * Add a new date and time to an assignment without removing the old ones.
	 *
	 * @param startDateTime
	 * @param endDateTime
	 * @throws InvalidDateInputException if start date comes before end date.
	 *
	public void addDate(LocalDateTime startDateTime, LocalDateTime endDateTime) throws InvalidDateInputException {
		isLegalDateInput(startDateTime, endDateTime);
		recurrentDates.put(startDateTime, endDateTime);
	}

	/**
	 * Removes a given start date and end date from the assignment.
	 *
	 * @param startDateTime
	 * @param endDateTime
	 * @return true if the dates existed and remove correctly.
	 *
	public boolean removeDate(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		LocalDateTime tmp = recurrentDates.get(startDateTime);
		if( tmp != null) {
			return tmp.equals(endDateTime);
		}
		return false;
	}

	/**
	 *
	 * Makes sure two dates comes in the right order.
	 *
	 * @param startDateTime the date that you think should be first.
	 * @param endDateTime the date that you think should be last.
	 * @throws InvalidDateInputException if @param endDateTime comes before @param startDateTime.
	 *
	public void isLegalDateInput(LocalDateTime startDateTime, LocalDateTime endDateTime) throws InvalidDateInputException {
		if (startDateTime.isBefore(endDateTime)) {
			throw new InvalidDateInputException("Invalid date input exception. The date " + startDateTime.toString() + " comes before the date " + endDateTime.toString());
		}
	}
	*/
}
