package io.altar.jseproject.pratica2.textinterface;

import java.util.Set;

import io.altar.jseproject.pratica2.models.Shelf;
import io.altar.jseproject.pratica2.repositories.ProductRepository;
import io.altar.jseproject.pratica2.repositories.ShelfRepository;
import io.altar.jseproject.pratica2.textinterface.ScannerUtils.ScannerUtils;

public class TextInterface {
	private ScannerUtils sc = new ScannerUtils();
	private ProductRepository DBP = ProductRepository.getInstance();
	private ShelfRepository DBS = ShelfRepository.getInstance();

	public void ecraInicio() {
		int option = 0;
		do {
			System.out.println("1)\t Listar Produtos");
			System.out.println("2)\t Listar Prateleiras");
			System.out.println("3)\t Sair");
			int[] options = { 1, 2, 3 };
			option = sc.getValidInt("Selecionar opção : ", options);
			switch (option) {
			case 1:
				ecraLProducts();
				break;
			case 2:
				ecraLShelves();
				break;
			case 3:
				System.out.println("Saida");
				break;
			}
		} while (option != 3);
	}

	private void ecraLShelves() {
		int option = 0;
		do {
			Set<Long> shelfsIds = DBS.getAllIds();
			for (Long id : shelfsIds) {
				System.out.println("ID da prateleira : " + id);
			}
			int[] options;
			if (DBS.isEmpty()) {
				options = new int[] { 1, 5 };
				System.out.println("1)\t Criar Prateleira");
				System.out.println("5)\t Voltar");
			} else {
				options = new int[] { 1, 2, 3, 4, 5 };
				System.out.println("1)\t Criar Prateleira");
				System.out.println("2)\t Editar Prateleira");
				System.out.println("3)\t Consultar Prateleira");
				System.out.println("4)\t Remover Prateleira");
				System.out.println("5)\t Voltar");
			}
			option = sc.getValidInt("Selecionar opção : ", options);
			switch (option) {
			case 1:
				ecraNewShelf();
				break;
			case 2:
				System.out.println("TODO - Edit Logic");
				break;
			case 3:
				System.out.println("TODO - View Logic");
				break;
			case 4:
				ecraDeleteShelf();
				break;
			}
		} while (option != 5);
	}
	
	private void ecraNewShelf() {
		System.out.println("Criar prateleira");
		int capacity = sc.getInt("Mete a capacidade");
		float dailyPrice = sc.getFloat("Mete o preco diario");
		Shelf shelf = new Shelf(capacity, dailyPrice);
		DBS.addEntity(shelf);
	}
	
	private void ecraDeleteShelf() {
		System.out.println("Remover prateleira");
		long shelfId = sc.getValidLong("Introduzir ID da prateleira que quer remover : ", DBS.getAllIds());
		DBS.removeEntity(shelfId);
		System.out.println("Prateleira removida");
	}

	private void ecraLProducts() {
		int option = 0;
		do {
			Set<Long> productsIds = DBP.getAllIds();
			for (Long id : productsIds) {
				System.out.println("ID do produto : " + id);
			}
			int[] options;
			if (DBP.isEmpty()) {
				options = new int[] { 1, 5 };
				System.out.println("1)\t Criar Produtos");
				System.out.println("5)\t Voltar");
			} else {
				options = new int[] { 1, 2, 3, 4, 5 };
				System.out.println("1)\t Criar Produtos");
				System.out.println("2)\t Editar Produto");
				System.out.println("3)\t Consultar Produto");
				System.out.println("4)\t Remover Produto");
				System.out.println("5)\t Voltar");
			}
			option = sc.getValidInt("Selecionar opção : ", options);
			switch (option) {
			case 1:
				System.out.println("TODO - New Logic");
				break;
			case 2:
				System.out.println("TODO - Edit Logic");
				break;
			case 3:
				System.out.println("TODO - View Logic");
				break;
			case 4:
				System.out.println("TODO - Delete Logic");
				break;
			}
		} while (option != 5);
	}

}
