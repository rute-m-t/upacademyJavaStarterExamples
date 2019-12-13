package pt.upacademy.desafiosResolutionJSC.desafio2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DesafioTest {

	@Test
	public void test1() {
		assertEquals("Thi1s is2 3a T4est", Desafio.order("is2 Thi1s T4est 3a"));
	}
	
	@Test
	public void test2() {
		assertEquals("Fo1r the2 g3ood 4of th5e pe6ople", Desafio.order("4of Fo1r pe6ople g3ood th5e the2"));
	}
	
	@Test
	public void test3() {
		assertEquals("", Desafio.order(""));
	}

}
