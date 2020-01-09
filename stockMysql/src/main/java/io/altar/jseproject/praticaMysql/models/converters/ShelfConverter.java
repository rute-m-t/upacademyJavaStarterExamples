package io.altar.jseproject.praticaMysql.models.converters;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.altar.jseproject.praticaMysql.models.Shelf;
import io.altar.jseproject.praticaMysql.models.DTOS.ShelfDTO;
import io.altar.jseproject.praticaMysql.repositories.ProductRepository;

@RequestScoped
public class ShelfConverter extends EntityConverter<Shelf, ShelfDTO> {

	@Inject
	ProductRepository PR;
	
	public Shelf toEntity(ShelfDTO selfDTO) {
		Shelf shelf = new Shelf();
		if (selfDTO.getId() > 0) {
			shelf.setId(selfDTO.getId());
		}
		shelf.setCapacity(selfDTO.getCapacity());
		shelf.setDailyPrice(selfDTO.getDailyPrice());
		shelf.setProduct(selfDTO.getProductId() > 0 ? PR.getEntity(selfDTO.getProductId()) : null);
		return shelf;
	}
	
	public ShelfDTO toDTO(Shelf self) {
		return new ShelfDTO(
				self.getId(), 
				self.getCapacity(), 
				self.getDailyPrice(),
				(self.getProduct() == null) ? 0 : self.getProduct().getId());
	}
}
