package pt.upacademy.Examples.StateMachine;

import pt.upacademy.Examples.StateMachine.States.*;

public class State {
	
	 // States
	private States[] states = {
			new MenuInit(), //0
			new MenuProduto(), //1
			new ProductAdd(), //2
			//introduzir estados do menu prod
			new MenuShelf()//3
			//introduzir estados do menu shelf
	};
	
	// Transitions
    private int[][] transition = {
    		{1,3},	//State 0
    		{2,1,1,1,0},	//State 1
    		{1}, //State 2
    		{2,2,2,2,0}};	//State 3
    
    // Current
    private int current = 0;

	public void start() {
		while(true) {
			int option = states[current].run();
			if(current == 0 && option==3) {
				System.out.println("Saida");
				break;
			}
			current = transition[current][option-1]; //option-1, pq indexes comecam em 0, opcoes em 1.
		}
		
	}

}
