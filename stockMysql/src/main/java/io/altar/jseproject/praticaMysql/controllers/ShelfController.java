package io.altar.jseproject.praticaMysql.controllers;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.jseproject.praticaMysql.models.Shelf;
import io.altar.jseproject.praticaMysql.repositories.ShelfRepository;
import io.altar.jseproject.praticaMysql.services.ShelfService;

@Path("shelves")
public class ShelfController extends EntityController<ShelfService, ShelfRepository, Shelf> {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Shelf> getAll() {
		return service.getAll();
	}
}
