package io.altar.jseproject.praticaJaxrs.controllers;

import javax.ws.rs.Path;

import io.altar.jseproject.praticaJaxrs.models.Shelf;
import io.altar.jseproject.praticaJaxrs.repositories.ShelfRepository;
import io.altar.jseproject.praticaJaxrs.services.ShelfService;

@Path("shelves")
public class ShelfController extends EntityController<ShelfService, ShelfRepository, Shelf> {

	public ShelfController() {
		service = new ShelfService();
	}
}
