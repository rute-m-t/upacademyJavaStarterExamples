package pt.upacademy.TISMJSC;

import pt.upacademy.TISMJSC.States.*;

public class TextInterfaceState {

	private State[] states = { 
			new MenuInit(), 		// 0
			new MenuProducts(), 		// 1
			new ProductAdd(),		// 2
			new MenuShelves() }; 	// 3
	// 4. transitions
	private int[][] transition = { 
			{ 1, 3 }, 				// State 0
			{ 2, 1, 1, 1, 0 }, 		// State 1
			{ 1 },					// State 2
			{ 2, 2, 2, 2, 0 }   	// State 3
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
