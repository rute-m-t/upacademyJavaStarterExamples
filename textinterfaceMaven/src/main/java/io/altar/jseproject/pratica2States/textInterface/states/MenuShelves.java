package io.altar.jseproject.pratica2States.textInterface.states;

import java.util.Set;

public class MenuShelves extends State {

	@Override
	public int run() {
		Set<Long> shelfsIds = SHELF_SERVICE.getAllIds();
		for (Long id : shelfsIds) {
			System.out.println("ID da prateleira : " + id);
		}
		int[] options;
		if (SHELF_SERVICE.isEmpty()) {
			options = new int[] { 1, 5 };
			System.out.println("1)\t Criar Prateleira");
			System.out.println("5)\t Voltar");
		} else {
			options = new int[] { 1, 2, 3, 4, 5 };
			System.out.println("1)\t Criar Prateleira");
			System.out.println("2)\t Editar Prateleira");
			System.out.println("3)\t Consultar Prateleira");
			System.out.println("4)\t Remover Prateleira");
			System.out.println("5)\t Voltar");
		}

		return SCANNER_UTILS.getValidInt("Selecione uma das opcoes : ", options);
	}

}
