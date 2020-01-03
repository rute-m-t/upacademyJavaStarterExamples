package io.altar.jseproject.praticaMysql.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.jseproject.praticaMysql.models.Product;
import io.altar.jseproject.praticaMysql.models.ProductDTO;
import io.altar.jseproject.praticaMysql.models.Shelf;
import io.altar.jseproject.praticaMysql.repositories.ProductRepository;
import io.altar.jseproject.praticaMysql.services.ProductService;

@Path("products")
public class ProductController extends EntityController<ProductService, ProductRepository, Product> {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductDTO> getAll() {
		return service.getAll().stream()
				.map(product -> new ProductDTO(
						product.getShelves().stream().map(
								Shelf::getId).collect(Collectors.toList()),
						product.getDiscount(),
						product.getIva(),
						product.getPvp()
						)
				)
				.collect(Collectors.toList());
	}
}
