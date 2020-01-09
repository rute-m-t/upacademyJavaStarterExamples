package io.altar.jseproject.praticaMysql.controllers;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;

import io.altar.jseproject.praticaMysql.models.Product;
import io.altar.jseproject.praticaMysql.models.DTOS.ProductDTO;
import io.altar.jseproject.praticaMysql.models.converters.ProductConverter;
import io.altar.jseproject.praticaMysql.repositories.ProductRepository;
import io.altar.jseproject.praticaMysql.services.ProductService;

@RequestScoped
@Path("products")
public class ProductController extends EntityController<ProductService, ProductRepository,ProductConverter , Product, ProductDTO> {

}
