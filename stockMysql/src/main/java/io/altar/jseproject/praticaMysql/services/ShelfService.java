package io.altar.jseproject.praticaMysql.services;

import io.altar.jseproject.praticaMysql.models.Shelf;
import io.altar.jseproject.praticaMysql.repositories.ShelfRepository;
import io.altar.jseproject.praticaMysql.services.interfaces.ShelfServiceInterface;

public class ShelfService extends EntityService<ShelfRepository ,Shelf> implements ShelfServiceInterface {

	@Override
	protected String getEntityClassName() {
		return Shelf.getName();
	}
}
