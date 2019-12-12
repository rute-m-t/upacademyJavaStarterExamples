package pt.upacademy.desafios.desafio3;

public class Desafio {

	public static int points(String[] strings) {
		int points = 0;
		for (String string : strings) {
			String[] goals = string.split(":");
			if (Integer.parseInt(goals[0]) > Integer.parseInt(goals[1])) {
				points +=3;
			} else if (Integer.parseInt(goals[0]) == Integer.parseInt(goals[1])) {
				points++;
			}
		}
		return points;
	}

}
