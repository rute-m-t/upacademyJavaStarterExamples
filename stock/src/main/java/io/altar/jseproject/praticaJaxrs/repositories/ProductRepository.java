package io.altar.jseproject.praticaJaxrs.repositories;

import io.altar.jseproject.praticaJaxrs.models.Product;

public class ProductRepository extends EntityRepository<Product> {

	private static final ProductRepository INSTANCE = new ProductRepository();

	private ProductRepository() {
	}

	public static ProductRepository getInstance() {
		return INSTANCE;
	}
}
