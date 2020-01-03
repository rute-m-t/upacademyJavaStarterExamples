package io.altar.jseproject.praticaMysql.services;

import io.altar.jseproject.praticaMysql.models.Product;
import io.altar.jseproject.praticaMysql.repositories.ProductRepository;
import io.altar.jseproject.praticaMysql.services.interfaces.ProductServiceInterface;

public class ProductService extends EntityService<ProductRepository, Product> implements ProductServiceInterface {

	@Override
	protected String getEntityClassName() {
		return Product.getName();
	}

}
