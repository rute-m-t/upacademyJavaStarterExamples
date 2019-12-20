package io.altar.jseproject.pratica2States.textInterface.states;

import java.util.ArrayList;
import java.util.List;

import io.altar.jseproject.pratica2States.models.Product;


public class ProductEdit extends State {

	@Override
	public int run() {
		System.out.println("Editar Produto");
		long productId = SCANNER_UTILS.getValidLong("Introduzir ID do Produto : ",
				PRODUCT_SERVICE.getAllIds());
		Product product = PRODUCT_SERVICE.get(productId);
		Product updatedProduct = new Product(0, 0, 0);
		updatedProduct.setId(product.getId());
		updatedProduct.setShelvesIds(product.getShelvesIds());
		int[] ivas = { 6, 13, 23 };
		int iva = SCANNER_UTILS.getValidInt("Iva antigo : " + product.getIva(), ivas, true);
		updatedProduct.setIva((iva != -1)? iva : product.getIva());
		float pvp = SCANNER_UTILS.getFloat("Pvp antigo : " + product.getPvp(), true);
		updatedProduct.setPvp((pvp != -1)? pvp : product.getPvp());
		int discount = SCANNER_UTILS.getValidInt("Discount antigo : " + product.getDiscount(), 100, true);
		updatedProduct.setDiscount((discount != -1)? discount : product.getDiscount());
		List<Long> options = new ArrayList<Long>();
		options.addAll(PRODUCT_SERVICE.getShelfIdsByProductId(0L));
		options.addAll(product.getShelvesIds());
		String msg = "Selecionar Ids das prateleiras \nPrateleiras disponiveis : " + options;
		if (product.getShelvesIds().size() > 0) {
			msg += " (\n0 : Retirar o produto de todas as prateleiras)";
		}
		List<Long> shelfIds = SCANNER_UTILS.getValidsLongs(msg, options);
		if (shelfIds.size() > 0) {
			if (shelfIds.get(0) == 0) {
				shelfIds =  new ArrayList<Long>();
			}
			updatedProduct.setShelvesIds(shelfIds);
		}
		PRODUCT_SERVICE.update(updatedProduct);
		return 1;
	}

}
