package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetoLP2.Pessoa;

class TestePessoa {
	Pessoa p1;
	Pessoa p2;
	Pessoa p3;
	Pessoa p4;
	
	@BeforeEach
	public void setUp() {
		p1 = new Pessoa("jose", "123456789-0", "PE", "saude,educacao,ensino");
		p2 = new Pessoa("jose", "123456789-0", "PE", "saude,educacao,ensino");
		p3 = new Pessoa("maria", "987654321-0", "PB", "saude,ensino");
		p4 = new Pessoa("andre", "876412345-9", "BA", "ensino,educacao" ,"UNE");
		
	}
	@Test
	void testConstrutor1() {
		assertEquals("jose", p1.getNome());
		assertEquals("123456789-0", p1.getDni());
		assertEquals("PE", p1.getOrigem());
		assertEquals("saude,educacao,ensino", p1.getInteresses());
		
	}

	@Test
	void testConstrutor2() {
		assertEquals("andre", p4.getNome());
		assertEquals("876412345-9", p4.getDni());
		assertEquals("BA", p4.getOrigem());
		assertEquals("ensino,educacao", p4.getInteresses());
		assertEquals("UNE", p4.getPartido());
		
	}
	
	@Test
	void testEquals() {
		assertEquals(p1,p2);
	}
	
	@Test
	void testNotEquals() {
		assertNotEquals(p1,p3);
	}
	
	@Test
	void testToString1() {
		assertEquals(p1.toString(), "jose - 123456789-0 (PE) - Interesses: saude,educacao,ensino");
	}
	
	@Test
	void testToString2() {
		assertEquals(p4.toString(), "andre - 876412345-9 (BA) - UNE - Interesses: ensino,educacao");
	}
}
