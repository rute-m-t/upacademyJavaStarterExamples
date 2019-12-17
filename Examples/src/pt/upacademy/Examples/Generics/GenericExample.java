package pt.upacademy.Examples.Generics;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GenericExample {

//	https://docs.oracle.com/javase/tutorial/java/generics/types.html
	
	public static void main(String[] args) {
		FizzBuzzRep fizzRep = new FizzBuzzRep();
		TestRep testRep = new TestRep();
		
		Test t1 = new Test();
		testRep.addEntity(t1);
		
		Test t2 = new Test();
		testRep.addEntity(t2);
		
		FizzBuzz f1 = new FizzBuzz();
		fizzRep.addEntity(f1);
		
		Test t3 = new Test();
		testRep.addEntity(t3);
		
		FizzBuzz f2 = new FizzBuzz();
		fizzRep.addEntity(f2);
		
		System.out.println(fizzRep.getAll());
		System.out.println(testRep.getAll());
	}

}

class Entity {
	private int ID;
	
	public int getID() {
		return this.ID;
	}
	public void setID(int id) {
		this.ID = id;
	}
	
	public String toString() {
		return "Id : " + this.ID;
	}
}
class Test extends Entity {}

class FizzBuzz extends Entity {}

class EntityRep <T extends Entity> {
	private int nextID = 0;
	
	Map<Integer, T> map = new HashMap<Integer, T>();
	public void addEntity(T entity) {
		entity.setID(nextID);
		map.put(entity.getID(), entity);
		nextID++;
	}
	public Collection<T> getAll() {
		return map.values();
	}
}

class FizzBuzzRep extends EntityRep<FizzBuzz> {}

class TestRep extends EntityRep<Test> {}