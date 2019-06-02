package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetoLP2.ControlePartido;

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
