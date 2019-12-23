package io.altar.jseproject.pratica2States.textInterface.states;

public class ProductRemove extends State {

	@Override
	public int run() {
		System.out.println("Remover Produto");
		long productId = SCANNER_UTILS.getValidLong("Introduzir ID do Produto que quer remover : ",
				PRODUCT_SERVICE.getAllIds());
		PRODUCT_SERVICE.delete(productId);
		System.out.println("Produto removido");
		return 1;
	}

}
