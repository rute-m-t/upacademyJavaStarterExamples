package pt.upacademy.desafios.desafio2;

public class Desafio {

	public static String order(String string) {
		if(string == "") {
			return "";
		}
		String[] words = string.split(" ");
		StringBuilder result = new StringBuilder("");
		int count = 0;
		for (int i = 0; i < 10; i++) {
				for (String word : words) {
					if(word.contains(String.valueOf(i))) {
						result.append(word + " ");
						count++;
					}
				}
				if(count == words.length) {
					break;
				}
		}
		return result.toString().trim();
	}

}
