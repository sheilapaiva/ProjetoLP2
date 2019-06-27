package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Pl;

class TestePl {
	
	Pl Pl1;
	Pl Pl2;
	Pl Pl3;
	@BeforeEach
	public void setUp() {
		Pl1 = new Pl(1, "Pl 1/2016", "061444444-0",2016,"Regulamenta a tributacao de apostas eletronicas", "fiscal,jogos", "https://example.net/jogos%40aposta", true );
		Pl2 = new Pl(2, "Pl 1/2016", "061444444-0",2016,"Regulamenta a tributacao de apostas eletronicas", "fiscal,jogos", "https://example.net/jogos%40aposta", true );
		Pl3 = new Pl(3, "Pl 1/2017", "061444444-9",2017,"Institui a semana do carinho nas escolas", "cidadania,educacao basica", "https://example.net/jogos%40aposta", true );
	}
	
	
	@Test
	void testConstrutor() {
		assertEquals("Pl 1/2016", Pl1.getCodigo());
		assertEquals("061444444-0", Pl1.getDni());
		assertEquals("fiscal,jogos", Pl1.getInteresses());
		assertEquals(true, Pl1.getConclusivo());
	}
	
	@Test
	void testNotEquals() {
		assertNotEquals(Pl1, Pl3);
	}
	
	@Test
	void testEquals() {
		assertEquals(Pl1, Pl2);
	}
	
	@Test
	void testToString() {
	  	if (Pl1.getConclusivo() == true && !Pl1.getNomeComissao().equals("-")) {
    		 assertEquals("Projeto de Lei - Pl 1/2016 - 061444444-0 - Regulamenta a tributacao de apostas eletronicas - Conclusiva - " + Pl1.getSituacao() + " (" + Pl1.getNomeComissao() + ")" , Pl1.toString());
    	}else if (Pl1.getConclusivo() == false && !Pl1.getNomeComissao().equals("(-)")) {
    		assertEquals("Projeto de Lei - Pl 1/2016 - 061444444-0 - Regulamenta a tributacao de apostas eletronicas - " + Pl1.getSituacao() +  " (" + Pl1.getNomeComissao() + ")" , Pl1.toString());
    	}else if (Pl1.getNomeComissao().equals("-")) {
    		assertEquals("Projeto de Lei - Pl 1/2016 - 061444444-0 - Regulamenta a tributacao de apostas eletronicas - Conclusiva - " + Pl1.getSituacao(), Pl1.toString()); 
    	}else {
    		assertEquals("Projeto de Lei - Pl 1/2016 - 061444444-0 - Regulamenta a tributacao de apostas eletronicas - " + Pl1.getSituacao() + " (" + Pl1.getNomeComissao() + ")", Pl1.toString());
    	}
	}


}
