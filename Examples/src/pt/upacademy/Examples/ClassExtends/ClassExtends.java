package pt.upacademy.Examples.ClassExtends;

public class ClassExtends extends ClassSuper {
	private int valueInClass;
	
	public ClassExtends() {
		super();
		System.out.println("ClassExtends Constructor");
	}
	
	public ClassExtends(int num) {
		super(num);
		System.out.println("ClassExtends Constructor with 1 param : " + num);
	}
	
	public ClassExtends(int num, int num2) {
		super(num);
		this.valueInClass = num2;
		System.out.println("ClassExtends Constructor with 2 params : " + num + " : " + num2);
	}
	
	public int getvalueInClass() {
		return this.valueInClass;
	}
	
	public String getvalueSuperInClass() {
		return ("Value of super : " + super.getvalueInSuper());
	}
	
	public static void main(String[] args) {
		ClassExtends myApp = new ClassExtends(2,5);
		System.out.println("MyApp getvalueInSuper : " + myApp.getvalueInSuper());
		System.out.println("MyApp getvalueInClass : " + myApp.getvalueInClass());
		System.out.println("MyApp getvalueSuperInClass : " + myApp.getvalueSuperInClass());
	}
}

class ClassSuper {
	private int valueInClass;
	
	public ClassSuper() {
		System.out.println("ClassSuper Constructor");
	}
	
	public ClassSuper(int num) {
		this.valueInClass = num;
		System.out.println("ClassSuper Constructor with 1 param : " + num);
	}
	
	public int getvalueInSuper() {
		return this.valueInClass;
	}
}
