package io.altar.jseproject.pratica2States.textInterface.states;

import io.altar.jseproject.pratica2States.models.Shelf;

public class ShelfEdit extends State {

	@Override
	public int run() {
		System.out.println("Editar prateleira");
		long shelfId = SCANNER_UTILS.getValidLong("Introduzir ID da prateleira : ", SHELF_SERVICE.getAllIds());
		Shelf shelf = SHELF_SERVICE.get(shelfId);
		int capacity = SCANNER_UTILS.getInt("Capacidade antiga : " + shelf.getCapacity(), true);
		if (capacity != -1) {
			shelf.setCapacity(capacity);
		}
		float dailyPrice = SCANNER_UTILS.getFloat("Preco diario antigo : " + shelf.getDailyPrice(), true);
		if (dailyPrice != -1) {
			shelf.setDailyPrice(dailyPrice);
		}
		SHELF_SERVICE.update(shelf);
		
		return 1;
	}

}
