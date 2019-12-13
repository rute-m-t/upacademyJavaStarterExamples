package pt.upacademy.desafiosResolutionJSC.desafio1;

public class Desafio {
	private int num, big3Count = 0, big5Count = 0;

	public Desafio(int num) {
		this.num = num;
	}

	public void run() {
		for (int i = 1; i <= num; i++) {
			if (i % 5 == 0) { big5Count++; }
			if (i % 3 == 0) { big3Count++; }
		}
	}

	public int getBig3Count() {
		return big3Count;
	}

	public int getBig5Count() {
		return big5Count;
	}
}
