package io.altar.jseproject.pratica2States.services.interfaces;

import java.util.List;

import io.altar.jseproject.pratica2States.models.Product;

public interface ProductServiceInterface extends EntityServiceInterface<Product> {
	
	void updateShelfOnProduct(long productId, long shelfId);

	List<Long> getShelfIdsByProductId(long productId);
}
