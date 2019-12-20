package io.altar.jseproject.pratica2.textinterface.ScannerUtils;

import java.util.Scanner;
import java.util.Set;

public class ScannerUtils {
	private Scanner sc = new Scanner(System.in);
	private Scanner lineSc;

	public String getValue() {
		return sc.nextLine();
	}

//	********************************************
	
//	Integer 
	
//	********************************************
	
	public boolean isInt(String value) {
		lineSc = new Scanner(value);
		return lineSc.hasNextInt();
	}

	public int toInt(String value) {
		lineSc = new Scanner(value);
		return lineSc.nextInt();
	}

	public int getInt(String msg) {
		boolean valid = false;
		int result = 0;
		do {
			System.out.println(msg);
			String value = getValue();
			if (isInt(value)) {
				valid = true;
				result = toInt(value);
			}
		} while (!valid);
		return result;
	}

	public int getValidInt(String msg, int[] values) {
		int result;
		boolean valid = false;
		do {
			String validString = msg + "(";
			for (int i : values) {
				validString += " " + i;
			}
			validString += " )";
			result = getInt(validString);
			for (int i : values) {
				if (result == i) {
					valid = true;
				}
			}
		} while (!valid);
		return result;
	}

	public int getValidInt(String msg, int min, int max) {
		int result;
		do {
			String myMsg = msg + min + " e " + max;
			result = getInt(myMsg);
		} while (result < min || result > max);
		return result;
	}
	
//	********************************************
	
//	Float 
	
//	********************************************
	
	public boolean isFloat(String value) {
		lineSc = new Scanner(value);
		return lineSc.hasNextFloat();
	}

	public float toFloat(String value) {
		lineSc = new Scanner(value);
		return lineSc.nextFloat();
	}

	public float getFloat(String msg) {
		boolean valid = false;
		float result = 0;
		do {
			System.out.println(msg);
			String value = getValue();
			if (isFloat(value)) {
				valid = true;
				result = toFloat(value);
			}
		} while (!valid);
		return result;
	}

	public float getValidFloat(String msg, float[] values) {
		float result;
		boolean valid = false;
		do {
			String validString = msg + "(";
			for (float i : values) {
				validString += " " + i;
			}
			validString += " )";
			result = getFloat(validString);
			for (float i : values) {
				if (result == i) {
					valid = true;
				}
			}
		} while (!valid);
		return result;
	}

	public float getValidInt(String msg, float min, float max) {
		float result;
		do {
			String myMsg = msg + min + " e " + max;
			result = getFloat(myMsg);
		} while (result < min || result > max);
		return result;
	}
	
	
//	********************************************
	
//	Long 
	
//	********************************************
	
	public boolean isLong(String value) {
		lineSc = new Scanner(value);
		return lineSc.hasNextLong();
	}

	public long toLong(String value) {
		lineSc = new Scanner(value);
		return lineSc.nextLong();
	}

	public long getLong(String msg) {
		boolean valid = false;
		long result = 0;
		do {
			System.out.println(msg);
			String value = getValue();
			if (isLong(value)) {
				valid = true;
				result = toLong(value);
			}
		} while (!valid);
		return result;
	}

	public long getValidLong(String msg, Set<Long> values) {
		long result;
		boolean valid = false;
		do {
			String validString = msg + "(";
			for (long i : values) {
				validString += " " + i;
			}
			validString += " )";
			result = getLong(validString);
			for (long i : values) {
				if (result == i) {
					valid = true;
				}
			}
		} while (!valid);
		return result;
	}

	public long getValidInt(String msg, long min, long max) {
		long result;
		do {
			String myMsg = msg + min + " e " + max;
			result = getLong(myMsg);
		} while (result < min || result > max);
		return result;
	}

}
