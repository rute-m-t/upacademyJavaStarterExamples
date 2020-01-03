package io.altar.jseproject.praticaJaxrs.services.interfaces;

import java.util.List;

import io.altar.jseproject.praticaJaxrs.models.Product;

public interface ProductServiceInterface extends EntityServiceInterface<Product> {
	
	void updateShelfOnProduct(long productId, long shelfId);

	List<Long> getShelfIdsByProductId(long productId);
}
