package pt.upacademy.desafiosResolutionJSC.desafio3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DesafioTest {

	@Test
	public void test1() {
		assertEquals(30,
				Desafio.points(new String[] { "1:0", "2:0", "3:0", "4:0", "2:1", "3:1", "4:1", "3:2", "4:2", "4:3" }));
	}

	@Test
	public void test2() {
		assertEquals(10,
				Desafio.points(new String[] { "1:1", "2:2", "3:3", "4:4", "2:2", "3:3", "4:4", "3:3", "4:4", "4:4" }));
	}

	@Test
	public void test3() {
		assertEquals(0,
				Desafio.points(new String[] { "0:1", "0:2", "0:3", "0:4", "1:2", "1:3", "1:4", "2:3", "2:4", "3:4" }));
	}

	@Test
	public void test4() {
		assertEquals(15,
				Desafio.points(new String[] { "1:0", "2:0", "3:0", "4:0", "2:1", "1:3", "1:4", "2:3", "2:4", "3:4" }));
	}

	@Test
	public void test5() {
		assertEquals(12,
				Desafio.points(new String[] { "1:0", "2:0", "3:0", "4:4", "2:2", "3:3", "1:4", "2:3", "2:4", "3:4" }));
	}
}
