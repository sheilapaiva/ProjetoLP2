package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControlePartido;

/**
 * Testes de Unidade da classe ControlePartido.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */

class TesteControlePartido {

	ControlePartido cp;
	
	@BeforeEach
	void setUp() {
		cp = new ControlePartido();
		cp.cadastrarPartido("ABC");
		cp.cadastrarPartido("ANB");
	}
	
	@Test
	void testeCadastrarPartidoNomeNulo() {
		try {
			cp.cadastrarPartido(null);
		} catch (RuntimeException nn) {
			assertEquals(nn.getMessage(), "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
		} 
	}
	
	@Test
	void testeCadastrarPartidoNomeVazio() {
		try {
			cp.cadastrarPartido("");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	void testeCadastrarPartidoValido() {
		cp.cadastrarPartido("PET");
		assertEquals(cp.exibirBase(), "ABC,ANB,PET");
	}
	
	@Test
	void testeExibeBase() {
		assertEquals(cp.exibirBase(), "ABC,ANB");
	}
	
}
