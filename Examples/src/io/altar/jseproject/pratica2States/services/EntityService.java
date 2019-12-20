package io.altar.jseproject.pratica2States.services;

import java.util.Set;

import io.altar.jseproject.pratica2States.models.Entity_;
import io.altar.jseproject.pratica2States.repositories.EntityRepository;
import io.altar.jseproject.pratica2States.services.interfaces.EntityServiceInterface;

public abstract class EntityService<R extends EntityRepository<E>,E extends Entity_> implements EntityServiceInterface<E> {
	protected R repository;

	@Override
	public E get(long id) {
		return repository.getEntity(id);
	}

	@Override
	public Set<Long> getAllIds() {
		return repository.getAllIds();
	}

	@Override
	public long create(E entity) {
		return repository.addEntity(entity);
	}

	@Override
	public void update(E entity) {
		repository.editEntity(entity);
	}

	@Override
	public void delete(long id) {
		repository.removeEntity(id);
	}

	@Override
	public boolean isEmpty() {
		return repository.isEmpty();
	}
}
