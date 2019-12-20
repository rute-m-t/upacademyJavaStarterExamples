package io.altar.jseproject.pratica2States.repositories;

import io.altar.jseproject.pratica2States.models.Shelf;

public class ShelfRepository extends EntityRepository<Shelf> {

	private static final ShelfRepository INSTANCE = new ShelfRepository();

	private ShelfRepository() {
	}

	public static ShelfRepository getInstance() {
		return INSTANCE;
	}
}