package io.altar.jseproject.pratica2States.textInterface.states;

public class ShelfRemove extends State {

	@Override
	public int run() {
		System.out.println("Remover prateleira");
		long shelfId = SCANNER_UTILS.getValidLong("Introduzir ID da prateleira que quer remover : ",SHELF_SERVICE.getAllIds());
		SHELF_SERVICE.delete(shelfId);
		System.out.println("Prateleira removida");
		
		return 1;
	}

}
