package io.altar.jseproject.pratica2States.textInterface.states;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.altar.jseproject.pratica2States.models.Product;

public class ProductAdd extends State {

	@Override
	public int run() {
		System.out.println("Criar Product");
		int[] ivas = { 6, 13, 23 };
		int iva = SCANNER_UTILS.getValidInt("Mete o iva", ivas);
		float pvp = SCANNER_UTILS.getFloat("Mete o pvp");
		int discount = SCANNER_UTILS.getValidInt("Mete o discount", 100);
		if (PRODUCT_SERVICE.getShelfIdsByProductId(0L).size() == 0) {
			save(discount, iva, pvp);
		} else {
			System.out.println("Quer adicionar o producto a uma prateleira vazia?");
			int[] options = { 1, 2 };
			int option = SCANNER_UTILS.getValidInt("1) Sim,\t 2 ou 'Enter') Nao ", options, true);
			if (option == 1) {
				List<Long> shelfIds = new ArrayList<Long>();
				addToShelf(discount, iva, pvp, shelfIds);
			} else {
				save(discount, iva, pvp);
			}
		}

		return 1;
	}
	
	private void save(int discount, int iva, float pvp) {
		Product product = new Product(discount, iva, pvp);
		PRODUCT_SERVICE.create(product);
	}
	
	private void save(List<Long> shelfIds, int discount, int iva, float pvp) {
		Product product = new Product(shelfIds, discount, iva, pvp);
		PRODUCT_SERVICE.create(product);
	}

	private void addToShelf(int discount, int iva, float pvp, List<Long> shelfIds) {
		List<Long> emptyShelfs = PRODUCT_SERVICE.getShelfIdsByProductId(0L);
		@SuppressWarnings("serial")
		Set<Long> options = new HashSet<Long>() {
		};
		for (Long shelfId : emptyShelfs) {
			if (shelfIds.indexOf(shelfId) == -1) {
				options.add(shelfId);
			}
		}
		System.out.println("Prateleiras disponiveis" + options);
		long option = SCANNER_UTILS.getValidLong("Selecionar Id da prateleira ", options);
		shelfIds.add(option);
		if (options.size() == 1) {
			save(shelfIds, discount, iva, pvp);
		} else {
			System.out.println("Quer adicionar o producto a uma outra prateleira vazia?");
			int[] options2 = { 1, 2 };
			int option2 = SCANNER_UTILS.getValidInt("1) Sim,\t 2 ou 'Enter') Nao ", options2, true);
			if (option2 == 1) {
				addToShelf(discount, iva, pvp, shelfIds);
			} else {
				save(shelfIds, discount, iva, pvp);
			}
		}
	}

}
