package pt.upacademy.desafios.desafio1;

public class Desafio {
	private int numCycle;
	private int count3;
	private int count5;

	public Desafio(int i) {
		this.numCycle = i;
	}

	public void run() {
		for (int i = 1; i <= numCycle; i++) {
			if (i%3 == 0) {
				count3++;
			}
			if (i%5 == 0) {
				count5++;
			}
		}
	}

	public int getBig3Count() {
		return count3;
	}

	public int getBig5Count() {
		return count5;
	}

}
