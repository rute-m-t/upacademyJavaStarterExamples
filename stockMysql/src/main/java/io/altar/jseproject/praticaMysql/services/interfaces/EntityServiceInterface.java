package io.altar.jseproject.praticaMysql.services.interfaces;

import java.util.Collection;
import java.util.List;

import io.altar.jseproject.praticaMysql.models.Entity_;
import io.altar.jseproject.praticaMysql.models.DTOS.EntityDTO;

public interface EntityServiceInterface<T extends Entity_<D>, D extends EntityDTO> {

	T get(long id);

	List<Long> getAllIds();
	
	Collection<T> getAll();

	long create(T entity);

	void update(T entity);

	void delete(long id);
	
	long size();
}
