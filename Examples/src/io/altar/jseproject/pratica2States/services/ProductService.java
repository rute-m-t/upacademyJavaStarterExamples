package io.altar.jseproject.pratica2States.services;

import java.util.ArrayList;
import java.util.List;

import io.altar.jseproject.pratica2States.models.Product;
import io.altar.jseproject.pratica2States.repositories.ProductRepository;
import io.altar.jseproject.pratica2States.services.interfaces.ProductServiceInterface;

public class ProductService extends EntityService<ProductRepository ,Product> implements ProductServiceInterface{

	public static final ShelfService SHELF_SERVICE = new ShelfService();
	
	public ProductService() {
		repository = ProductRepository.getInstance();
	}

	@Override
	public long create(Product product) {
		long currentId = repository.addEntity(product);
		if (product.getShelvesIds().size() > 0) {
			SHELF_SERVICE.updateProductOnShelfs(currentId,new ArrayList<Long>(),product.getShelvesIds());
		}
		return currentId;
	}
	
	@Override
	public void update(Product product) {
		Product oldProduct = repository.getEntity(product.getId());
		if (!oldProduct.getShelvesIds().equals(product.getShelvesIds())) {
			SHELF_SERVICE.updateProductOnShelfs(product.getId(),oldProduct.getShelvesIds(),product.getShelvesIds());
		}
		repository.editEntity(product);
	}
	
	@Override
	public void delete(long id) {
		Product product = repository.getEntity(id);
		repository.removeEntity(id);
		SHELF_SERVICE.updateProductOnShelfs(product.getId(),product.getShelvesIds(),new ArrayList<Long>());
	}
	
	@Override
	public void updateShelfOnProduct(long productId, long shelfId) {
		Product product = repository.getEntity(productId);
		product.getShelvesIds().remove(shelfId);
		repository.editEntity(product);
	}

	@Override
	public List<Long> getShelfIdsByProductId(long productId) {
		
		return SHELF_SERVICE.getShelfIdsByProductId(productId);
	}

}
