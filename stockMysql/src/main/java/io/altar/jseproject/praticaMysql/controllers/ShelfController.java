package io.altar.jseproject.praticaMysql.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.altar.jseproject.praticaMysql.models.Shelf;
import io.altar.jseproject.praticaMysql.models.DTOS.ShelfDTO;
import io.altar.jseproject.praticaMysql.repositories.ShelfRepository;
import io.altar.jseproject.praticaMysql.services.ProductService;
import io.altar.jseproject.praticaMysql.services.ShelfService;

@RequestScoped
@Path("shelves")
public class ShelfController extends EntityController<ShelfService, ShelfRepository, Shelf, ShelfDTO> {

	@Inject
	ProductService PS;

	@GET
	@Path("empties")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Shelf> getEmptyShelves() {
		return service.getEmptyShelves();
	}

	@GET
	@Path("/product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ShelfDTO> getShelvesByProductID(@PathParam("id") long id) {
		return service.findByProductId(id);
	}

	@DELETE
	@Path("/product/{id}")
	public Response removeProductsByProductId(@PathParam("id") long id) {
		service.removeProductsByProductId(id);
		return Response.ok().build();
	}

	@Override
	public Shelf toEntity(ShelfDTO entityDTO) {
		Shelf shelf = new Shelf();
		if (entityDTO.getId() > 0) {
			shelf.setId(entityDTO.getId());
		}
		shelf.setCapacity(entityDTO.getCapacity());
		shelf.setDailyPrice(entityDTO.getDailyPrice());
		shelf.setProduct(entityDTO.getProductId() > 0 ? PS.get(entityDTO.getProductId()) : null);
		return shelf;
	}
}
