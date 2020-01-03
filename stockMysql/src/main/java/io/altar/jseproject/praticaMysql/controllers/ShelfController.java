package io.altar.jseproject.praticaMysql.controllers;

import javax.ws.rs.Path;

import io.altar.jseproject.praticaMysql.models.Shelf;
import io.altar.jseproject.praticaMysql.repositories.ShelfRepository;
import io.altar.jseproject.praticaMysql.services.ShelfService;

@Path("shelves")
public class ShelfController extends EntityController<ShelfService, ShelfRepository, Shelf> {

}
