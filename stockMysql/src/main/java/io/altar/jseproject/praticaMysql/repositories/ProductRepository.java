package io.altar.jseproject.praticaMysql.repositories;

import javax.enterprise.context.ApplicationScoped;

import io.altar.jseproject.praticaMysql.models.Product;
import io.altar.jseproject.praticaMysql.models.DTOS.ProductDTO;

@ApplicationScoped
public class ProductRepository extends EntityRepository<Product, ProductDTO> {
	
	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}
	
	@Override
	protected String getAllEntities() {
		return Product.GET_ALL_PRODUCTS;
	}
	
	@Override
	protected String getAllEntitiesIds() {
		return Product.GET_ALL_PRODUCTS_IDS;
	}
	
	@Override
	protected String getEntitiesCount() {
		return Product.GET_PRODUCTS_COUNT;
	}
}
