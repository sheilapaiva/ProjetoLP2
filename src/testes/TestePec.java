package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Pec;

class TestePec {
	
	Pec Pec1;
	Pec Pec2;
	Pec Pec3;
	@BeforeEach
	public void setUp() {
		Pec1 = new Pec(1, "Pec 1/2016", "061444444-0",2016,"Regulamenta a tributacao de apostas eletronicas", "fiscal,jogos", "https://example.net/jogos%40aposta", "153");
		Pec2 = new Pec(2, "Pec 1/2016", "061444444-0",2016,"Regulamenta a tributacao de apostas eletronicas", "fiscal,jogos", "https://example.net/jogos%40aposta", "153");
		Pec3 = new Pec(3, "Pec 1/2017", "061444444-9",2017,"Institui a semana do carinho nas escolas", "cidadania,educacao basica", "https://example.net/jogos%40aposta", "153");
	}
	
	
	@Test
	void testConstrutor() {
		assertEquals("Pec 1/2016", Pec1.getCodigo());
		assertEquals("061444444-0", Pec1.getDni());
		assertEquals("fiscal,jogos", Pec1.getInteresses());
	}
	
	@Test
	void testNotEquals() {
		assertNotEquals(Pec1, Pec3);
	}
	
	@Test
	void testEquals() {
		assertEquals(Pec1, Pec2);
	}
	
	@Test
	void testToString() {
		if (Pec1.getNomeComissao().equals("-")) {
			assertEquals("Projeto de Emenda Constitucional - Pec 1/2016 - 061444444-0 - Regulamenta a tributacao de apostas eletronicas - 153 - " + Pec1.getSituacao(), Pec1.toString() );
    	} else {
    		assertEquals( "Projeto de Emenda Constitucional - Pec 1/2016 - 061444444-0 - Regulamenta a tributacao de apostas eletronicas - " + Pec1.getArtigos() + " - " + Pec1.getSituacao() + " (" + Pec1.getNomeComissao() + ")", Pec1.toString());
    	}
	}
	

}
