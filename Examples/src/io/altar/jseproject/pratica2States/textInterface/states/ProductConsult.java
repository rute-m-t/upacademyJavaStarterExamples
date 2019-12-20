package io.altar.jseproject.pratica2States.textInterface.states;

import io.altar.jseproject.pratica2States.models.Product;

public class ProductConsult extends State {

	@Override
	public int run() {
		
		System.out.println("Ver detalhes do Produto");
		long productId = SCANNER_UTILS.getValidLong("Introduzir ID do Produto que quer ver os detalhes : ",
				PRODUCT_SERVICE.getAllIds());
		Product product = PRODUCT_SERVICE.get(productId);
		System.out.println(product);

		return 1;
	}

}
