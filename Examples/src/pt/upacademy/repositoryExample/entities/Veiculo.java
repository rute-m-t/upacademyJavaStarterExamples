package pt.upacademy.repositoryExample.entities;

public class Veiculo {
	private static long currentId = 0;
	private long  id;
	private int rodas=0;
	private int portas=0;
	private String marca ="";

	public Veiculo(int rodas, int portas, String marca) {
		this.id = currentId;
		currentId++;
		this.rodas = rodas;
		this.portas = portas;
		this.marca = marca;
	}

	public int getRodas() {
		return rodas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setRodas(int rodas) {
		this.rodas = rodas;
	}	
}
