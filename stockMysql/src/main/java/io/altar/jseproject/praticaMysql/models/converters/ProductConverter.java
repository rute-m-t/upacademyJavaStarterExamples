package io.altar.jseproject.praticaMysql.models.converters;

import java.util.stream.Collectors;

import javax.inject.Inject;

import io.altar.jseproject.praticaMysql.models.Product;
import io.altar.jseproject.praticaMysql.models.Shelf;
import io.altar.jseproject.praticaMysql.models.DTOS.ProductDTO;
import io.altar.jseproject.praticaMysql.repositories.ShelfRepository;

public class ProductConverter extends EntityConverter<Product, ProductDTO> {
	
	@Inject
	private ShelfRepository SR;

	public Product toEntity(ProductDTO productDTO) {
		Product product = new Product();
		if (productDTO.getId() > 0) {
			product.setId(productDTO.getId());
		}
		product.setIva(productDTO.getIva());
		product.setPvp(productDTO.getPvp());
		product.setDiscount(productDTO.getDiscount());
		product.setShelves(productDTO.getShelfIds().stream().map(entityId -> {
			Shelf shelf = SR.getEntity(entityId);
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
