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
	 * TODO fix this....
	 *
	@Override
	public int compareTo(Object o) {
		if(o.getClass() == this.getClass()) {
			Assignment a = (Assignment) o;
			return a.getName().hashCode() - this.getName().hashCode();
		}
		return 100 + o.hashCode();
	}
	*/
}
