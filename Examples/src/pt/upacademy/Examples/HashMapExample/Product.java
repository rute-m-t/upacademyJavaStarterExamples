package pt.upacademy.Examples.HashMapExample;

public class Product {
	static long count = 1;
	private long id;
	private String name;
	public Product(String name) {
		super();
		this.name = name;
		this.id = count++;
	}
	public long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}
	
	
}
