package pt.upacademy.Examples.ClassExtends;

class Alpha {
	String getType() {
		return "alpha";
	}
}

class Beta extends Alpha {
	String getType() {
		return "beta";
	}
}

public class AlfaBetaGamma extends Beta {
	String getType() {
		return "gamma";
	}

	public static void main(String[] args) {
//		AlfaBetaGamma g1 = new Alpha();
//		AlfaBetaGamma g2 = new Beta();
		
//		Alpha g1 = new AlfaBetaGamma();
//		Beta g2 = new AlfaBetaGamma();
//		System.out.println(g1.getType() + " " + g2.getType());
		
//		AlfaBetaGamma teste = new AlfaBetaGamma();
		
	}
}