package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetoLP2.Deputado;

class TesteDeputado {

	Deputado d1;
	Deputado d2;
	Deputado d3;
	
	@BeforeEach
	public void setUp() {
		d1 = new Deputado("01022019");
		d2 = new Deputado("01012019");
		d3 = new Deputado("02032019");
	}
	
	@Test
	void testConstrutor() {
		assertEquals("01022019", d1.getDataInicio());
	}
	
	@Test
	void testEquals() {
		assertEquals(d1, d3);
	}
	
	@Test
	void testNotEquals() {
		assertNotEquals(d1, d2);
	}
	
	@Test
	void testToString1() {
		assertEquals(d1.toString(), "POL: jose - 123456789-0 (PE) - UNB - Interesses: saude,educacao,ensino - 01/02/2019 - 0 Leis");
	}
}
