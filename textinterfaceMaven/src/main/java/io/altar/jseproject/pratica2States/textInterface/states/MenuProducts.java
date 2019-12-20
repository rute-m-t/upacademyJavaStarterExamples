package io.altar.jseproject.pratica2States.textInterface.states;

import java.util.Set;

public class MenuProducts extends State {

	@Override
	public int run() {
		Set<Long> productsIds = PRODUCT_SERVICE.getAllIds();
		for (Long id : productsIds) {
			System.out.println("ID do produto : " + id);
		}
		int[] options;
		if (PRODUCT_SERVICE.isEmpty()) {
			options = new int[] { 1, 5 };
			System.out.println("1)\t Criar Produtos");
			System.out.println("5)\t Voltar");
		} else {
			options = new int[] { 1, 2, 3, 4, 5 };
			System.out.println("1)\t Criar Produtos");
			System.out.println("2)\t Editar Produto");
			System.out.println("3)\t Consultar Produto");
			System.out.println("4)\t Remover Produto");
			System.out.println("5)\t Voltar");
		}

		return SCANNER_UTILS.getValidInt("Selecione uma das opcoes : ", options);
	}

}
