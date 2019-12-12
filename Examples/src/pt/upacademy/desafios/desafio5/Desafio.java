package pt.upacademy.desafios.desafio5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Desafio {

	public static int countDays(String string, String string2) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
		LocalDate startDate = LocalDate.parse(string, formatter);
		LocalDate endDate = LocalDate.parse(string2, formatter);
		int numberOfDays = (int)startDate.until(endDate, ChronoUnit.DAYS);
		
		return numberOfDays;
	}

}
