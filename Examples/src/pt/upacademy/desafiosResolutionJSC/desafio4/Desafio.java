package pt.upacademy.desafiosResolutionJSC.desafio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desafio {

	private static Scanner scanner;

	public static int[] ints(String msg) {
		List<Integer> result = new ArrayList<Integer>();
		
		scanner = new Scanner(msg);
		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
				result.add(scanner.nextInt());
			} else {
				scanner.next();
			}		
		}
		
//		String[] numbers = msg.split(" ");
//		for (String string : numbers) {
//			try {
//				int num = Integer.parseInt(string);
//				result.add(num);
//			} catch (Exception e) {}
//		}
		
//		if (msg == "") return new int[]{};
//		String[] numbers = msg.split(" ");
//		for (String s : numbers) {
//			boolean isInt = true;
//			for(int i = 0; i < s.length(); i++) {
//		        if(Character.digit(s.charAt(i),10) < 0) {
//		        	isInt = false;
//		        	break;
//		        }
//		    }
//			if (isInt) result.add(Integer.parseInt(s));
//		}

		
		return result.stream().mapToInt(i -> i).toArray();
	}
}