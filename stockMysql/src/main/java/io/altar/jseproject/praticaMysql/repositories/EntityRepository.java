package io.altar.jseproject.praticaMysql.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import io.altar.jseproject.praticaMysql.models.Entity_;

@Transactional
public abstract class EntityRepository<T extends Entity_> {

	@PersistenceContext(unitName = "database")
	protected EntityManager entityManager;
	
	protected abstract Class<T> getEntityClass();

	protected abstract String getAllEntitiesIds();
	public List<Long> getAllIds() {
		return entityManager.createNamedQuery(getAllEntitiesIds(), Long.class).getResultList();
	}
	
	protected abstract String getAllEntities();
	public List<T> getAll() {
		return entityManager.createNamedQuery(getAllEntities(), getEntityClass()).getResultList();
	}
	
	public Long addEntity(T entity) {
		return entityManager.merge(entity).getId();
	}

	public T getEntity(long id) {
		return entityManager.find(getEntityClass(), id);
	}

	public T editEntity(T entity) {
		return entityManager.merge(entity);
	}

	public void removeEntity(long id) {
		T entity = getEntity(id);
		if(entity != null) {
			entityManager.remove(entity);
		}
	}
}
