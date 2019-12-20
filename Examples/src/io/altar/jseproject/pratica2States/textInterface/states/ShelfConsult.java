package io.altar.jseproject.pratica2States.textInterface.states;

import io.altar.jseproject.pratica2States.models.Shelf;

public class ShelfConsult extends State {

	@Override
	public int run() {
		System.out.println("Ver detalhes da prateleira");
		long shelfId = SCANNER_UTILS.getValidLong("Introduzir ID da prateleira que quer ver os detalhes : ", SHELF_SERVICE.getAllIds());
		Shelf shelf = SHELF_SERVICE.get(shelfId);
		System.out.println(shelf);
		
		return 1;
	}

}
