package io.altar.jseproject.pratica2States.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.altar.jseproject.pratica2States.models.Entity_;

public abstract class EntityRepository<T extends Entity_> {

	private Map<Long, T> map = new HashMap<Long, T>();

	private long currentID = 1;

	public Long addEntity(T entity) {
		map.put(currentID, entity);
		entity.setId(currentID);
		return currentID++;
	}

	public Set<Long> getAllIds() {
		return map.keySet();
	}
	
	public Collection<T> getAll() {
		return map.values();
	}

	public T getEntity(long id) {
		T entity = map.get(id);
		return entity;
	}

	public void editEntity(T entity) {
		map.put(entity.getId(), entity);
	}

	public void removeEntity(long id) {
		map.remove(id);
	}

	public boolean isEmpty() {
		return (map.size() == 0) ? true : false;
	}
	
	public long size() {
		return map.size();
	}
}
