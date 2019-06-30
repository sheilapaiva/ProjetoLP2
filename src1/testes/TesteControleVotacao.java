package controladores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TesteControleVotacao {

    ControleVotacao cv = new ControleVotacao();
    @BeforeEach

    void setUp(){


    }
    @Test
    void testaRealizarVotacaoPl(){
        assertEquals(true, cv.realizarVotacao("plsaude9","CGOV",6,10,"PL"));
        assertEquals(false,cv.realizarVotacao("plsaude9","CGOV",2,10,"PL"));
    }

    @Test
    void testaRealizarVotacaoPec(){
        assertEquals(true, cv.realizarVotacao("pecsaude9","CGOV",8,10,"PEC"));
        assertEquals(false, cv.realizarVotacao("pecsaude9","CGOV",6,10,"PEC"));
    }

    @Test
    void testaRealizarVotacaoPLP(){
        assertEquals(true, cv.realizarVotacao("plpsaude9","CGOV",7,10,"PLP"));
        assertEquals(false, cv.realizarVotacao("plpsaude9","CGOV",4,10,"PLP"));
    }

    @Test
    void testaRealizarVotacaoComissao(){
        assertEquals(true, cv.realizarVotacao("comissaosaude9","CGOV",6,10,"COMISSAO"));
        assertEquals(false, cv.realizarVotacao("comissaosaude9","CGOV",2,10,"COMISSAO"));
    }

    @Test
    void testaExibirTramitacaoComissao(){
        cv.realizarVotacao("comissaosaude9","CGOV",5,10,"COMISSAO");
        cv.realizarVotacao("comissaosaude8","CGOV",8,10,"COMISSAO");
        assertEquals("REJEITADO (CGOV)",cv.exibirTramitacao("comissaosaude9"));
        assertEquals("APROVADO (CGOV)",cv.exibirTramitacao("comissaosaude8"));
    }

    @Test
    void testaExibirTramitacaoPl(){
        cv.realizarVotacao("plsaude9","CGOV",6,10,"PL");
        cv.realizarVotacao("plsaude8","CGOV",3,10,"PL");
        assertEquals("APROVADO (CGOV)",cv.exibirTramitacao("plsaude9"));
        assertEquals("REJEITADO (CGOV)",cv.exibirTramitacao("plsaude8"));

    }

    @Test
    void testaExibirTramitacaoPec(){
        cv.realizarVotacao("pecsaude9","CGOV",8,10,"PEC");
        cv.realizarVotacao("pecsaude8","CGOV",6,10,"PEC");
        assertEquals("APROVADO (CGOV)",cv.exibirTramitacao("pecsaude9"));
        assertEquals("REJEITADO (CGOV)",cv.exibirTramitacao("pecsaude8"));
    }

    @Test
    void testaExibirTramitacaoPlp(){
        cv.realizarVotacao("plpsaude9","CGOV",7,10,"PLP");
        cv.realizarVotacao("plpsaude8","CGOV",4,10,"PLP");
        assertEquals("APROVADO (CGOV)",cv.exibirTramitacao("plpsaude9"));
        assertEquals("REJEITADO (CGOV)",cv.exibirTramitacao("plpsaude8"));
    }



}