package pt.upacademy.TISMJSC.States;

public class MenuShelves extends State {

	@Override
	public int run() {
		System.out.println("1)\t Criar Shelves");
		System.out.println("2)\t Editar Shelves");
		System.out.println("3)\t Consultar Shelves");
		System.out.println("4)\t Remover Shelves");
		System.out.println("5)\t Voltar");
		int[] options = { 1, 2, 3, 4, 5 };
		return sc.getValidInt("Selecionar opção : ", options);
	}

}
