package io.altar.jseproject.pratica2States.textInterface.scannerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ScannerUtils {
	private Scanner sc = new Scanner(System.in);
	private Scanner lineSc;

	private String getInput() {
		return sc.nextLine();
	}

	private int getIntHelper(String input, boolean canBeNull) {
		if (canBeNull && input.equals("")) {
			return -1;
		} else if (isType(input, "Integer")) {
			lineSc = new Scanner(input);
			return (lineSc.nextInt());
		} else {
			return -2;
		}
	}

	public int getInt(String msg, boolean canBeNull) {
		int result = -2;
		do {
			System.out.println(msg);
			result = getIntHelper(getInput(), canBeNull);
		} while (result == -2);
		return result;
	}

	public int getInt(String msg) {
		return getInt(msg, false);
	}

	public int getValidInt(String msg, int max, boolean canBeNull) {
		int result;
		do {
			result = getInt(msg, canBeNull);
			if (result > max)
				System.out.println("O Numero tem de ser menor que " + max);
		} while (result > max);
		return result;
	}

	public int getValidInt(String msg, int max) {
		return getValidInt(msg, max, false);
	}

	public int getValidInt(String msg, int[] ivas, boolean canBeNull) {
		int result;
		boolean validInt = false;
		do {
			result = getInt(msg, canBeNull);
			if (canBeNull && result == -1) {
				return -1;
			} else {
				for (int i : ivas) {
					if (result == i) {
						validInt = true;
					}
				}
				if (!validInt) {
					String validString = "";
					for (int i : ivas) {
						validString += " " + i;
					}
					System.out.println("Numero errado tem de ser" + validString);
				}
			}
		} while (!validInt);
		return result;
	}

	public int getValidInt(String msg, int[] ivas) {
		return getValidInt(msg, ivas, false);
	}

	public float getFloat(String msg, boolean canBeNull) {
		String input;
		do {
			System.out.println(msg);
			input = sc.nextLine();
			if (canBeNull && input.equals("")) {
				return -1;
			}
		} while (!isType(input, "Float"));
		lineSc = new Scanner(input);
		return (lineSc.nextFloat());
	}

	public float getFloat(String msg) {
		return getFloat(msg, false);
	}

	public long getLong(String msg, boolean canBeNull) {
		String input;
		do {
			System.out.println(msg);
			input = sc.nextLine();
			if (canBeNull && input.equals("")) {
				return -1;
			}
		} while (!isType(input, "Long"));
		lineSc = new Scanner(input);
		return (lineSc.nextLong());
	}

	public long getLong(String msg) {
		return getLong(msg, false);
	}

	public List<Long> getLongs(String msg) {
		List<Long> result = new ArrayList<Long>();
		System.out.println(msg);
		String sInput = sc.nextLine();
		lineSc = new Scanner(sInput);
		while (lineSc.hasNextLong()) {
			result.add(lineSc.nextLong());
		}
		return result;
	}

	public List<Long> getValidsLongs(String msg, List<Long> options) {
		List<Long> result;
		int validInt = 0;
		do {
			result = getLongs(msg);
			if (result.size() > 0 && result.get(0) != 0) {
				for (long i : options) {
					for (long value : result) {
						if (value == i) {
							validInt++;
						}
					}
				}
				if (validInt < result.size()) {
					System.out.println("Ids nao validos...");
				}
			}
			if (result.size() == 1 && result.get(0) == 0) {
				return result;
			}
		} while (result.size() != 0 && validInt < result.size());
		return result;
	}

	public long getValidLong(String msg, Set<Long> setLongs, boolean canBeNull) {
		long result;
		boolean validInt = false;
		do {
			result = getLong(msg, canBeNull);
			if (canBeNull && result == -1) {
				return -1;
			} else {
				for (long i : setLongs) {
					if (result == i) {
						validInt = true;
					}
				}
				if (!validInt) {
					String validString = "";
					for (long i : setLongs) {
						validString += " " + i;
					}
					System.out.println("Numero errado tem de ser" + validString);
				}
			}
		} while (!validInt);
		return result;
	}

	public long getValidLong(String msg, Set<Long> setLongs) {
		return getValidLong(msg, setLongs, false);
	}

	public boolean isType(String input, String type) {
		Scanner lineSc = new Scanner(input);
		boolean result = false;
		switch (type) {
		case "Integer":
			if (lineSc.hasNextInt()) {
				result = true;
			} else {
				System.out.println("Numero invalido colocar um numero inteiro");
			}
			break;
		case "Float":
			if (lineSc.hasNextFloat()) {
				result = true;
			} else {
				System.out.println("Numero invalido colocar um numero flutuante");
			}
			break;
		case "Long":
			if (lineSc.hasNextLong()) {
				result = true;
			} else {
				System.out.println("Numero invalido colocar um numero flutuante");
			}
			break;
		default:
			System.out.println("Type Not Supported!!!");
		}
		lineSc.close();
		return result;
	}
}
