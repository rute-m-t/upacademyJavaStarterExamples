package io.altar.jseproject.praticaMysql.models.DTOS;

import javax.transaction.Transactional;

@Transactional
public abstract class EntityDTO<E> {

	protected long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
