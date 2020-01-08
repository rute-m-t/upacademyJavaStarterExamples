package io.altar.jseproject.praticaMysql.controllers;

import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

import io.altar.jseproject.praticaMysql.models.Product;
import io.altar.jseproject.praticaMysql.models.DTOS.ProductDTO;
import io.altar.jseproject.praticaMysql.repositories.ProductRepository;
import io.altar.jseproject.praticaMysql.services.ProductService;
import io.altar.jseproject.praticaMysql.services.ShelfService;

@RequestScoped
@Path("products")
public class ProductController extends EntityController<ProductService, ProductRepository, Product, ProductDTO> {

	@Inject
	ShelfService SS;
	
	@Override
	public Product toEntity(ProductDTO entityDTO) {
		Product product = new Product();
		if (entityDTO.getId() > 0) {
			product.setId(entityDTO.getId());
			SS.removeProductsByProductId(entityDTO.getId());
		}
		product.setIva(entityDTO.getIva());
		product.setPvp(entityDTO.getPvp());
		product.setDiscount(entityDTO.getDiscount());
		product.setShelves(entityDTO.getShelfIds().stream().map(entityId -> SS.get(entityId)).collect(Collectors.toList()));
		
		entityDTO.getShelfIds().forEach(shelfId -> SS.get(shelfId).setProduct(product));
		return product;
	}

}
