package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetoLP2.ControleProjeto;



class TesteControleProjetos {
	
	ControleProjeto cp;
	
	@BeforeEach
	void setUp() {
		cp = new ControleProjeto();
		cp.cadastrarPL("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
		
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
