package pt.upacademy.Examples.Exceptions;

public class RuntimeException {

	public static void main(String[] args) {
		RuntimeException test = new RuntimeException();
		test.somemethod();
		
//		try {
//			RuntimeException test = new RuntimeException();
//			test.somemethod();
//		} catch (IllegalArgumentException e) {
//			System.out.println("Catch IllegalArgumentException : " + e.getMessage());
////			e.printStackTrace();
//		} catch (Exception e) {
//			System.out.println("Catch Exception");
//		}

	}
	
	public void somemethod(){
		throwmethod();
	}

	public void throwmethod() throws IllegalArgumentException {
		throw new IllegalArgumentException("Message error on throwmethod");
	}
}
