package pt.upacademy.Examples.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
	
	Map<Long,Product> myMap = new HashMap<Long, Product>();
	
	
	public static void main(String[] args) {
		HashMapExample myapp = new HashMapExample();
		myapp.run();
	}
	
	public void run() {
		Product p1 = new Product("Coca Cola");
		System.out.println(p1);
		Product p2 = new Product("Batatas");
		System.out.println(p2);

		myMap.put(p1.getId(), p1);
		myMap.put(p2.getId(), p2);
		
		System.out.println(myMap.values());
	}

}

class Product {
	static long count = 1;
	private long id;
	private String name;
	
	public Product(String name) {
		this.name = name;
		this.id = count++;
	}
	
	public long getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}

	
	
}
