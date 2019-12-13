package pt.upacademy.desafiosResolutionJSC.desafio1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DesafioTest {

	@BeforeEach
	public void initEach(){
	    System.out.println("\nInit Test\n");
	}
	
	@AfterEach
	public void endEach(){
	    System.out.println("\nEnd Test\n");
	}
	
	@Test
	void test1() {
		Desafio desafio = new Desafio(20);
		desafio.run();
		assertEquals(6, desafio.getBig3Count());
		assertEquals(4, desafio.getBig5Count());
	}
	
	@Test
	void test2() {
		Desafio desafio = new Desafio(1);
		desafio.run();
		assertEquals(0, desafio.getBig3Count());
		assertEquals(0, desafio.getBig5Count());
	}
	
	@Test
	void test3() {
		Desafio desafio = new Desafio(50);
		desafio.run();
		assertEquals(16, desafio.getBig3Count());
		assertEquals(10, desafio.getBig5Count());
	}

}
