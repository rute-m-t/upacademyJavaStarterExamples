package io.altar.jseproject.pratica2States.textInterface.states;

public class MenuInit extends State {

	@Override
	public int run() {
		System.out.println("1)\t Listar Produtos");
		System.out.println("2)\t Listar Prateleiras");
		System.out.println("3)\t Sair");
		int[] options = { 1, 2, 3 };
		
		return SCANNER_UTILS.getValidInt("Selecione uma das opcoes : ", options);
	}

}
