package pt.upacademy.TISMJSC.States;

public class MenuInit extends State {

	@Override
	public int run() {
		System.out.println("1)\t Listar Produtos");
		System.out.println("2)\t Listar Shelvess");
		System.out.println("3)\t Sair");
		int[] options = { 1, 2, 3 };
		return sc.getValidInt("Selecionar opção : ", options);
	}

}
