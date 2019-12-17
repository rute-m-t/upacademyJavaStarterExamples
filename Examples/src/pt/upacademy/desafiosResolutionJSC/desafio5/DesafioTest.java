package pt.upacademy.desafiosResolutionJSC.desafio5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DesafioTest {

	@Test
	void test1() {
		assertEquals(31, Desafio.countDays("01 01 2019", "01 02 2019"));
	}
	
	@Test
	void test2() {
		assertEquals(4, Desafio.countDays("01 01 2019", "05 01 2019"));
	}
	
	@Test
	void test3() {
		assertEquals(365, Desafio.countDays("01 01 2019", "01 01 2020"));
	}
	
	@Test
	void test4() {
		assertEquals(366, Desafio.countDays("01 01 2016", "01 01 2017"));
	}

}
