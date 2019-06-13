package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetoLP2.ControleProjetos;



class TesteControleProjetos {
	
	ControleProjetos cp;
	
	@BeforeEach
	void setUp() {
		cp = new ControleProjetos();
		cp.cadastraPl("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
		
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
