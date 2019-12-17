package io.altar.jseproject.pratica2.repositories;

import io.altar.jseproject.pratica2.models.Product;

public class ProductRepository extends EntityRepository<Product> {

	private static final ProductRepository INSTANCE = new ProductRepository();

	private ProductRepository() {
	}

	public static ProductRepository getInstance() {
		return INSTANCE;
	}
}
