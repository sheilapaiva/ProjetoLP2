package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Partido;

/**
 * Testes de Unidade da classe Partido.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */

class TestePartido {

	Partido p1;
	Partido p2;
	Partido p3;
	
	@BeforeEach
	public void setUp() {
		p1 = new Partido("UNB");
		p2 = new Partido("UNE");
		p3 = new Partido("UNB");
	}
	
	@Test
	void testConstrutor() {
		assertEquals(p1.getPartido(), "UNB");
	}
	
	@Test
	void testEquals() {
		assertEquals(p1, p3);
	}
	
	@Test
	void testNotEquals() {
		assertNotEquals(p1, p2);
	}
	
	@Test
	void testToString1() {
		assertEquals(p1.toString(), "UNB");
	}
}
