package pt.upacademy.desafiosResolutionJSC.desafio2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Desafio {

	public static String order(String words) {
		
//		String[] arrayWords = words.split(" ");
//		StringBuilder result = new StringBuilder("");
//		for (int i = 1; i <= 9; i++) {
//			for (String word : arrayWords) {
//				if (word.contains(String.valueOf(i))) {
//					result.append(word + " ");
//				}
//			}
//		}
//		return result.toString().trim();
		

//		String[] arrayWords = words.split(" ");
//		Arrays.sort(arrayWords, (String s1, String s2) -> s1.replaceAll("\\D", "").compareTo(s2.replaceAll("\\D", "")));
//		return String.join(" ", arrayWords).trim();
		
		
		return Arrays.stream(words.split(" "))
				.sorted(Comparator.comparing(word -> Integer.valueOf(word.replaceAll("\\D", ""))))
				.collect(Collectors.joining(" "));
	}

}
