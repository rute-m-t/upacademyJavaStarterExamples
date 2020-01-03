package io.altar.jseproject.praticaJaxrs.repositories;

import io.altar.jseproject.praticaJaxrs.models.Shelf;

public class ShelfRepository extends EntityRepository<Shelf> {

	private static final ShelfRepository INSTANCE = new ShelfRepository();

	private ShelfRepository() {
	}

	public static ShelfRepository getInstance() {
		return INSTANCE;
	}
}