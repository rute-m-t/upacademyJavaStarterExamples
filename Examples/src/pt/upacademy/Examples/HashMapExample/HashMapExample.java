package pt.upacademy.Examples.HashMapExample;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapExample {
	Map<Long,Product> myMap = new HashMap<Long,Product>();
	
	public static void main (String[] args) {
		HashMapExample myApp = new HashMapExample();
		Product p1 = new Product("Coca Cola");
		//System.out.println(p1);
		myApp.addProduct(p1);
		Product p2 = new Product("Batatas");
		myApp.addProduct(p2);
		
		System.out.println(myApp.getAll());
		myApp.printAll();
	}
	
	public void addProduct(Product p) {
		myMap.put(p.getId(), p);
	}
	
	public void removeProduct(Product p) {
		myMap.remove(p.getId(), p);
	}
	
	public boolean isEmpty() {
		return (myMap.size() == 0) ? true: false;
	}
	
	public Collection<Product> getAll() {
		return myMap.values();
	}
	
	public Collection<Long> getAllIds() {
		return myMap.keySet();
	}
	
	public void printAll() {
		Iterator<Product> prodIterator = getAll().iterator();
		while (prodIterator.hasNext()) {
			Product product = (Product) prodIterator.next();
			System.out.println(product);
		}
	}
}
