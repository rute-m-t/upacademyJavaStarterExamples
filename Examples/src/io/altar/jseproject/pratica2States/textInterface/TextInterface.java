package io.altar.jseproject.pratica2States.textInterface;

import io.altar.jseproject.pratica2States.textInterface.states.*;

public class TextInterface {
	private State[] states = { 
			new MenuInit(), 		// 0
			new MenuProducts(), 	// 1
			new MenuShelves(),		// 2
			new ProductAdd(), 		// 3
			new ProductEdit(), 		// 4
			new ProductConsult(), 	// 5
			new ProductRemove(),	// 6
			new ShelfAdd(), 		// 3
			new ShelfEdit(), 		// 4
			new ShelfConsult(), 	// 5
			new ShelfRemove() 		// 6
	};
	// 4. transitions
	private int[][] transition = { 
			{ 1, 2 }, 				// State 0
			{ 3, 4, 5, 6, 0 }, 		// State 1
			{ 7, 8, 9, 10, 0 },		// State 2
			{ 1 },   				// State 3
			{ 1 },   				// State 4
			{ 1 },   				// State 5
			{ 1 },   				// State 6
			{ 2 },   				// State 7
			{ 2 },   				// State 8
			{ 2 },   				// State 9
			{ 2 },   				// State 10
	};
	// 3. current
	private int current = 0;

	public void start() {
		
		while(true) {
			int option = states[current].run();
			if (current == 0 && option == 3) {
				System.out.println("Saida");
				break;
			}
			current = transition[current][option-1];
		}
	}
}
