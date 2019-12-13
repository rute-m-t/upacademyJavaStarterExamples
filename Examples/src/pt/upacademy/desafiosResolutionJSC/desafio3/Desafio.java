package pt.upacademy.desafiosResolutionJSC.desafio3;

public class Desafio {

	public static int points(String[] games) {
		int result = 0;
		for (String game : games) {
			char gM = game.charAt(0), gS = game.charAt(2);

			result += gM > gS ? 3 : gM == gS ? 1 : 0;
		}

		return result;
	}

}
