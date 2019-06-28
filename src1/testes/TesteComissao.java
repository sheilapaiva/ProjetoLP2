package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Comissao;
import entidades.Partido;
import entidades.Pessoa;

/**
 * Testes de Unidade da classe Comissao.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
class TesteComissao {
	
	Comissao c1;
	Comissao c2;
	Comissao c3;
	
	@BeforeEach
	public void setUp() {
		Partido partido = new Partido("UNE");
		Pessoa p1 = new Pessoa("andre", "876412345-9", "BA", "ensino,educacao", partido);
		Pessoa p2 = new Pessoa("luis", "876412345-0", "BA", "ensino", partido);
		ArrayList<String> listaPessoa = new ArrayList<>();
		listaPessoa.add(p1.getDni());
		listaPessoa.add(p2.getDni());
		c1 = new Comissao("CCJC", listaPessoa);
		c2 = new Comissao("CFT", listaPessoa);
		c3 = new Comissao("CCJC", listaPessoa);
	}
	
	@Test
	void testEquals() {
		assertEquals(c1, c3);
	}
	
	@Test
	void testNotEquals() {
		assertNotEquals(c1, c2);
	}

}
