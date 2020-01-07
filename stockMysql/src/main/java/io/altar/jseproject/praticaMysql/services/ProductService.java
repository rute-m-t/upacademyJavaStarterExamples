package io.altar.jseproject.praticaMysql.services;

import javax.enterprise.context.RequestScoped;

import io.altar.jseproject.praticaMysql.models.Product;
import io.altar.jseproject.praticaMysql.models.DTOS.ProductDTO;
import io.altar.jseproject.praticaMysql.repositories.ProductRepository;
import io.altar.jseproject.praticaMysql.services.interfaces.ProductServiceInterface;

@RequestScoped
public class ProductService extends EntityService<ProductRepository, Product, ProductDTO> implements ProductServiceInterface {

	protected String getEntityClassName() {
		return Product.getName();
	}

	public boolean canDelete(Product product) {
		if (product.getShelves().size() > 0) {
			throw new UnsupportedOperationException(
					String.format("Product exist in [%d] shelves.",product.getShelves().size()));
		}
		return true;
	}
}
