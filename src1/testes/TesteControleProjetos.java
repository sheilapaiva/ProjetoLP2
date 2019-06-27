package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControleProjeto;



class TesteControleProjetos {

	ControleProjeto cp;

	@BeforeEach
	void setUp() {
		cp = new ControleProjeto();
		cp.cadastrarPL("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
		cp.cadastrarPL("061222222-0", 2016, "Institui a semana do carinho nas escolas", "cidadania,educacao basica", "http://example.com/semana_cidadania", false);
	}

	

	@Test
	void testeCadastraPL() {
		assertEquals("PL 3/2016", cp.cadastrarPL("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true));
	}

	@Test
	void testaCadastrarPLP() {
		assertEquals("PLP 1/2016", cp.cadastrarPLP("061444444-0", 2016, "Regulamenta a tributacao de apostas eletronicas", "fiscal,jogos", "https://example.net/jogos%40aposta", "153"));
	}

	@Test
	void testaCadastraPEC() {
		assertEquals("PEC 1/2016", cp.cadastrarPEC("061222222-0", 2016, "Permite a associacao sindical livre e com estrutura hierarquica", "trabalho", "https://example.com/sindicato/algo.html", "7,8"));
	}

	@Test
	void testaExibirProjeto() {
		assertEquals("Projeto de Lei - PL 2/2016 - 061222222-0 - Institui a semana do carinho nas escolas - EM VOTACAO (CCJC)", cp.exibirProjeto("PL 2/2016"));
	}
}

