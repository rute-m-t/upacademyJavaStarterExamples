package pt.upacademy.Examples.StateMachine.States;

public class MenuInit extends States {

	@Override
	public int run() {
		System.out.println("1)\t Listar Produtos");
		System.out.println("2)\t Listar Shelvess");
		System.out.println("3)\t Sair");
		int[] options = { 1, 2, 3 };
		return SC.getValidInt("Selecionar opção : ", options);
	}

}
