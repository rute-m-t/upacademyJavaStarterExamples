package io.altar.jseproject.praticaMysql.models.converters;

import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.altar.jseproject.praticaMysql.models.Product;
import io.altar.jseproject.praticaMysql.models.Shelf;
import io.altar.jseproject.praticaMysql.models.DTOS.ProductDTO;
import io.altar.jseproject.praticaMysql.services.ShelfService;

@RequestScoped
public class ProductConverter extends EntityConverter<Product, ProductDTO> {
	
	@Inject
	private ShelfService SS;

	public Product toEntity(ProductDTO productDTO) {
		Product product = new Product();
		if (productDTO.getId() > 0) {
			product.setId(productDTO.getId());
            SS.removeProductsByProductId(productDTO.getId());
		}
		product.setIva(productDTO.getIva());
		product.setPvp(productDTO.getPvp());
		product.setDiscount(productDTO.getDiscount());
		product.setShelves(productDTO.getShelfIds().stream().map(entityId -> {
			Shelf shelf = SS.get(entityId);
			shelf.setProduct(product);
			return shelf;
		}).collect(Collectors.toList()));
		return product;
	}
	
	public ProductDTO toDTO(Product product) {
		return new ProductDTO(
				product.getId(), 
				product.getShelves().stream().map(Shelf::getId).collect(Collectors.toList()),
				product.getDiscount(), 
				product.getIva(), 
				product.getPvp());
	}
}
