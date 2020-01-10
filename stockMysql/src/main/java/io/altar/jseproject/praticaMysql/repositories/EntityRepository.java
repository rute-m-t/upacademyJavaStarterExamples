package io.altar.jseproject.praticaMysql.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.altar.jseproject.praticaMysql.models.Entity_;
import io.altar.jseproject.praticaMysql.models.DTOS.EntityDTO;

public abstract class EntityRepository<E extends Entity_<D>, D extends EntityDTO<E>> {

	@PersistenceContext(unitName = "database")
	protected EntityManager entityManager;
	
	protected abstract Class<E> getEntityClass();

	protected abstract String getAllEntitiesIds();
	public List<Long> getAllIds() {
		return entityManager.createNamedQuery(getAllEntitiesIds(), Long.class).getResultList();
	}
	
	protected abstract String getAllEntities();
	public List<E> getAll() {
		return entityManager.createNamedQuery(getAllEntities(), getEntityClass()).getResultList();
	}
	
	protected abstract String getEntitiesCount();
	public long size() {
		return entityManager.createNamedQuery(getEntitiesCount(), Long.class).getSingleResult();
	}
	
	public Long addEntity(E entity) {
		return entityManager.merge(entity).getId();
	}

	public E getEntity(long id) {
		return entityManager.find(getEntityClass(), id);
	}

	public E editEntity(E entity) {
		return entityManager.merge(entity);
	}

	public void removeEntity(long id) {
		E entity = getEntity(id);
		if(entity != null) {
			entityManager.remove(entity);
		}
	}
}
