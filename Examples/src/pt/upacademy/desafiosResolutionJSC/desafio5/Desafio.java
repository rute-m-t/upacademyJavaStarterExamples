package pt.upacademy.desafiosResolutionJSC.desafio5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Desafio {

	public static long countDays(String stringDate1, String stringDate2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");

		LocalDate date1 = LocalDate.parse(stringDate1, formatter);
		LocalDate date2 = LocalDate.parse(stringDate2, formatter);
		
//		return ChronoUnit.DAYS.between(date1, date2);
		return date1.until(date2, ChronoUnit.DAYS);
	}

}
