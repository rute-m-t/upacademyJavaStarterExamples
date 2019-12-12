package pt.upacademy.Examples.ClassExtends;

public class ClassExtendsExample {

	public static void main(String[] args) {

		ClassA a = new ClassB(); // possible because B extends A
		a.show(); // this will now call to show() method of class B
//		a.display(); // impossible because display only exist on class B
//		ClassB b = new ClassB();
//		b.show();
//		b.display();
	}

}

class ClassA {
	public void show() {
		System.out.println("Ze");
	}
}

class ClassB extends ClassA {
	public void display() {
		System.out.println("Ze Carlos");
	}

	public void show() {

		System.out.println("Ze Manel");
	}
}
