package io.altar.jseproject.pratica2States.services.interfaces;

import java.util.Set;

import io.altar.jseproject.pratica2States.models.Entity_;

public interface EntityServiceInterface<T extends Entity_> {

	T get(long id);

	Set<Long> getAllIds();

	long create(T entity);

	void update(T entity);

	void delete(long id);

	boolean isEmpty();
}
