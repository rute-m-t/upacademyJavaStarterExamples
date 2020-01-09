package io.altar.jseproject.praticaMysql.repositories;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;

import io.altar.jseproject.praticaMysql.models.Shelf;
import io.altar.jseproject.praticaMysql.models.DTOS.ShelfDTO;

@ApplicationScoped
public class ShelfRepository extends EntityRepository<Shelf, ShelfDTO> {

	@Override
	protected Class<Shelf> getEntityClass() {
		return Shelf.class;
	}

	@Override
	protected String getAllEntities() {
		return Shelf.GET_ALL_SHELVES;
	}
	
	@Override
	protected String getAllEntitiesIds() {
		return Shelf.GET_ALL_SHELVES_IDS;
	}
	
	@Override
	protected String getEntitiesCount() {
		return Shelf.GET_SHELVES_COUNT;
	}
	
	public List<Shelf> getEmptyShelves() {
		return entityManager.createNamedQuery(Shelf.GET_EMPTY_SHELVES, getEntityClass()).getResultList();
	}

	public List<Shelf> findByProductId(long id) {
		TypedQuery<Shelf> query = entityManager.createNamedQuery(Shelf.GET_SHELVES_BY_PRODUCT_ID, Shelf.class);
		query.setParameter("productId", id);
		return query.getResultList();
	}
	
	public void removeProductsByProductId(long id) {
	    entityManager.createNamedQuery(Shelf.SHELVES_PRODUCT_TO_NULL).setParameter("productId", id).executeUpdate();
	}
	
	public boolean entityExist(long id) {
	    String query = "SELECT COUNT(e) FROM Product e WHERE e.id = " + id;
	    Long count = (Long) entityManager.createQuery( query ).getSingleResult();
	    return ( ( count.equals( 0L ) ) ? false : true );
	}
}