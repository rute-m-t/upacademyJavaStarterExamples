package io.altar.jseproject.praticaJaxrs.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.altar.jseproject.praticaJaxrs.models.Product;
import io.altar.jseproject.praticaJaxrs.repositories.ProductRepository;
import io.altar.jseproject.praticaJaxrs.services.interfaces.ProductServiceInterface;

public class ProductService extends EntityService<ProductRepository, Product> implements ProductServiceInterface {

	public static final ShelfService SHELF_SERVICE = new ShelfService();

	public ProductService() {
		repository = ProductRepository.getInstance();
	}

	@Override
	public long create(Product product) {
		long currentId = repository.addEntity(product);
		if (product.getShelvesIds().size() > 0) {
			SHELF_SERVICE.updateProductOnShelfs(currentId, new ArrayList<Long>(), product.getShelvesIds());
		}
		return currentId;
	}

	@Override
	public void update(Product product) {
		Product oldProduct = validEntity(product.getId());
		product = validShelvesOnProduct(product);
		if (!oldProduct.getShelvesIds().equals(product.getShelvesIds())) {
			SHELF_SERVICE.updateProductOnShelfs(product.getId(), oldProduct.getShelvesIds(), product.getShelvesIds());
		}
		repository.editEntity(product);
	}

	@Override
	public void delete(long id) {
		Product product = repository.getEntity(id);
		repository.removeEntity(id);
		SHELF_SERVICE.updateProductOnShelfs(product.getId(), product.getShelvesIds(), new ArrayList<Long>());
	}

	@Override
	public void updateShelfOnProduct(long productId, long shelfId) {
		if (productId > 0 && shelfId > 0) {
			Product product = repository.getEntity(productId);
			product.getShelvesIds().remove(shelfId);
			repository.editEntity(product);
		}
	}

	@Override
	public List<Long> getShelfIdsByProductId(long productId) {

		return SHELF_SERVICE.getShelfIdsByProductId(productId);
	}

	private Product validShelvesOnProduct(Product product) {
		List<Long> shelvesIds = product.getShelvesIds();
		List<Long> validShelvesIds = SHELF_SERVICE.getShelfIdsByProductId((long) 0);
		validShelvesIds.addAll(SHELF_SERVICE.getShelfIdsByProductId(product.getId()));
		product.setShelvesIds(shelvesIds.stream().filter(selectId -> validShelvesIds.indexOf(selectId) >= 0)
				.collect(Collectors.toList()));
		return product;
	}

	@Override
	protected String getEntityClassName() {
		return Product.getName();
	}
}
