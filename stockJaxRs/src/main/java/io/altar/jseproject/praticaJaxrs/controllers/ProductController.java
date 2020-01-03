package io.altar.jseproject.praticaJaxrs.controllers;

import javax.ws.rs.Path;

import io.altar.jseproject.praticaJaxrs.models.Product;
import io.altar.jseproject.praticaJaxrs.repositories.ProductRepository;
import io.altar.jseproject.praticaJaxrs.services.ProductService;

@Path("products")
public class ProductController extends EntityController<ProductService, ProductRepository, Product> {

	public ProductController() {
		service = new ProductService();
	}
}
