package io.altar.jseproject.pratica2States.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import io.altar.jseproject.pratica2States.models.Shelf;
import io.altar.jseproject.pratica2States.repositories.ShelfRepository;
import io.altar.jseproject.pratica2States.services.interfaces.ShelfServiceInterface;

public class ShelfService extends EntityService<ShelfRepository ,Shelf> implements ShelfServiceInterface {

	public static final ProductService PRODUCT_SERVICE  = new ProductService();
	
	public ShelfService() {
		repository = ShelfRepository.getInstance();
	}
	
	@Override
	public void delete(long id) {
		Shelf shelfToRemove = repository.getEntity(id);
		if (shelfToRemove.getProductId() != 0) {
			PRODUCT_SERVICE.updateShelfOnProduct(shelfToRemove.getProductId(), id);
		}
		repository.removeEntity(id);
	}

	@Override
	public void updateProductOnShelfs(long productId, List<Long> shelfsOld, List<Long> shelfsNew) {
		for (Long shelfId : shelfsOld) {
			Shelf shelf = repository.getEntity(shelfId);
			if (shelfsNew.indexOf(shelfId) == -1) {
				shelf.setProductId((long)0);
				repository.editEntity(shelf);
			}
		}
		for (Long shelfId : shelfsNew) {
			Shelf shelf = repository.getEntity(shelfId);
			if (shelfsOld.indexOf(shelfId) == -1) {
				shelf.setProductId(productId);
				repository.editEntity(shelf);
			}
		}
	}

	@Override
	public List<Long> getShelfIdsByProductId(long productId) {
		Collection<Shelf> values = repository.getAll();
		List<Long> result = values.stream()
		.filter(value -> value.getProductId() == productId)
		.map(value -> value.getId())
		.collect(Collectors.toList());
		
		return result;
	}
}
