package pm.testing;

import pm.makery.model.Assignment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * FULASTE PROGRAMMET JAG VET MEN HANN RADERA INNAN JAG FRÅGADE DIG VART JAG SKULLE LÄGGA DET
 * OCH JA CAPS LOCK ÄR KUL!
 *
 */
public class TestingAssignment {


	public static void main(String[] args) {

		Assignment a = new Assignment();
		Assignment b = new Assignment("kvantfysik");
		Assignment c = new Assignment("Fasta tillståndet");


		System.out.println("Assignment: " + a.getName());
		System.out.println("Assignment start " + a.getStartDateAndTime() + " end: " + a.getEndDateAndTime());


		LocalDateTime date1 = LocalDateTime.of(2016, 1, 2, 0, 0, 1);
		LocalDate date2 = LocalDate.of(2015, 1, 1);
		LocalTime time2 = LocalTime.of(01, 00);
		a.setStartDate(date1);
		b.setStartDate(date2);

		System.out.println("1. Date and time " + b.getStartDate() + " and " + b.getStartTime());
		b.setStartTime(time2);


		System.out.println("2. Date and time " + a.getStartDate() + " and " + a.getStartTime());
		System.out.println("3. Date and time " + b.getStartDate() + " and " + b.getStartTime());

	}
}
