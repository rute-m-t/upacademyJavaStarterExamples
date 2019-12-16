package io.altar.jseproject.pratica1.textinterface;

import io.altar.jseproject.pratica1.textinterface.ScannerUtils.ScannerUtils;

public class TextInterface {
	ScannerUtils sc = new ScannerUtils();

	public void ecraInicio() {
		int option = 0;
		do {
			System.out.println("1)\t Listar Produtos");
			System.out.println("2)\t Listar Shelvess");
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
			System.out.println("1)\t Criar Shelves");
			System.out.println("2)\t Editar Shelves");
			System.out.println("3)\t Consultar Shelves");
			System.out.println("4)\t Remover Shelves");
			System.out.println("5)\t Voltar");
			int[] options = { 1, 2, 3, 4, 5 };
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

	private void ecraLProducts() {
		int option = 0;
		do {
			System.out.println("1)\t Criar Products");
			System.out.println("2)\t Editar Products");
			System.out.println("3)\t Consultar Products");
			System.out.println("4)\t Remover Products");
			System.out.println("5)\t Voltar");
			int[] options = { 1, 2, 3, 4, 5 };
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
