package pt.upacademy.Examples.Exceptions;

public class ExceptionCheched {

	public static void main(String[] args) {
//		ExceptionCheched test = new ExceptionCheched();
//		test.somemethod();
		
		try {
			ExceptionCheched test = new ExceptionCheched();
			test.somemethod();
		} catch (IllegalArgumentException e) {
			System.out.println("Catch IllegalArgumentException");
		} catch (Exception e) {
			System.out.println("Catch Exception : " + e.getMessage());
		}

	}
	
	public void somemethod() throws Exception {
		throwmethod();
	}

	public void throwmethod() throws Exception {
		throw new Exception("Message error on throwmethod");
	}
}
