package io.altar.jseproject.praticaJaxrs.services.interfaces;

import java.util.Collection;
import java.util.Set;

import io.altar.jseproject.praticaJaxrs.models.Entity_;

public interface EntityServiceInterface<T extends Entity_> {

	T get(long id);

	Set<Long> getAllIds();
	
	Collection<T> getAll();

	long create(T entity);

	void update(T entity);

	void delete(long id);

	boolean isEmpty();
}
