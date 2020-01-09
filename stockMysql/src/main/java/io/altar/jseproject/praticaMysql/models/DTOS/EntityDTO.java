package io.altar.jseproject.praticaMysql.models.DTOS;

import javax.transaction.Transactional;

import io.altar.jseproject.praticaMysql.models.Entity_;

@Transactional
public abstract class EntityDTO<E extends Entity_<?>> {

	protected long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
