package io.altar.jseproject.praticaJaxrs.services;

import java.util.Collection;
import java.util.Set;

import io.altar.jseproject.praticaJaxrs.models.Entity_;
import io.altar.jseproject.praticaJaxrs.repositories.EntityRepository;
import io.altar.jseproject.praticaJaxrs.services.interfaces.EntityServiceInterface;

public abstract class EntityService<R extends EntityRepository<E>,E extends Entity_> implements EntityServiceInterface<E> {
	protected R repository;

	@Override
	public E get(long id) {
		return validEntity(id);
	}

	@Override
	public Set<Long> getAllIds() {
		return repository.getAllIds();
	}
	
	@Override
	public Collection<E> getAll() {
		return repository.getAll();
	}

	@Override
	public long create(E entity) {
		return repository.addEntity(entity);
	}

	@Override
	public void update(E entity) {
		validEntity(entity.getId());
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
	
	public E validEntity(long entityId) {
		E entity = repository.getEntity(entityId);
		if (entity == null) {
			throw new IllegalArgumentException(
					String.format("No %s with Id [%d].",getEntityClassName() ,entityId));
		}
		return entity;
	}
	
	protected abstract String getEntityClassName();
}
