package pt.upacademy.repositoryExample.entities;

public class Automovel extends Veiculo {
	private String antena = "";
	private int litrosBagageiras= 0;

	public Automovel( int rodas, int portas, String marca, String antena, int litrosBagageiras) {
		super(rodas, portas, marca);
		this.antena = antena;
		this.litrosBagageiras = litrosBagageiras;
	}

	public String getAntena() {
		return antena;
	}

	public void setAntena(String antena) {
		this.antena = antena;
	}

	public int getLitrosBagageiras() {
		return litrosBagageiras;
	}

	public void setLitrosBagageiras(int litrosBagageiras) {
		this.litrosBagageiras = litrosBagageiras;
	}	
}
