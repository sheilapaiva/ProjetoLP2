package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Plp;

class TestePlp {
	
	Plp plp1;
	Plp plp2;
	Plp plp3;
	@BeforeEach
	public void setUp() {
		plp1 = new Plp(1, "PLP 1/2016", "061444444-0",2016,"Regulamenta a tributacao de apostas eletronicas", "fiscal,jogos", "https://example.net/jogos%40aposta", "153");
		plp2 = new Plp(2, "PLP 1/2016", "061444444-0",2016,"Regulamenta a tributacao de apostas eletronicas", "fiscal,jogos", "https://example.net/jogos%40aposta", "153");
		plp3 = new Plp(3, "PLP 1/2017", "061444444-9",2017,"Institui a semana do carinho nas escolas", "cidadania,educacao basica", "https://example.net/jogos%40aposta", "153");
	}
	
	
	@Test
	void testConstrutor() {
		assertEquals("PLP 1/2016", plp1.getCodigo());
		assertEquals("061444444-0", plp1.getDni());
		assertEquals("fiscal,jogos", plp1.getInteresses());
	}
	
	@Test
	void testNotEquals() {
		assertNotEquals(plp1, plp3);
	}
	
	@Test
	void testEquals() {
		assertEquals(plp1, plp2);
	}
	
	@Test
	void testToString() {
		if (plp1.getNomeComissao().equals("-")) {
			assertEquals("Projeto de Lei Complementar - PLP 1/2016 - 061444444-0 - Regulamenta a tributacao de apostas eletronicas - 153 - " + plp1.getSituacao(), plp1.toString() );
    	} else {
    		assertEquals( "Projeto de Lei Complementar - PLP 1/2016 - 061444444-0 - Regulamenta a tributacao de apostas eletronicas - " + plp1.getArtigos() + " - " + plp1.getSituacao() + " (" + plp1.getNomeComissao() + ")", plp1.toString());
    	}
	}
	
}