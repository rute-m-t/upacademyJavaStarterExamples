package io.altar.jseproject.pratica2States.textInterface.states;

import io.altar.jseproject.pratica2States.models.Shelf;

public class ShelfAdd extends State {

	@Override
	public int run() {
		System.out.println("Criar prateleira");
		int capacity = SCANNER_UTILS.getInt("Mete a capacidade");
		float dailyPrice = SCANNER_UTILS.getFloat("Mete o preco diario");
		Shelf shelf = new Shelf(capacity, dailyPrice);
		SHELF_SERVICE.create(shelf);
		
		return 1;
	}

}
