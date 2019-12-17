package pt.upacademy.Examples.StateMachine.States;

public class MenuProduto extends States {

	@Override
	public int run() {
		System.out.println("1)\t Criar Products");
		System.out.println("2)\t Editar Products");
		System.out.println("3)\t Consultar Products");
		System.out.println("4)\t Remover Products");
		System.out.println("5)\t Voltar");
		int[] options = { 1, 2, 3, 4, 5 };
		return SC.getValidInt("Selecionar opção : ", options);
	}

}
