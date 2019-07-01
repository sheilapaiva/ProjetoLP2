package testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entidades.Votacao;

import static org.junit.jupiter.api.Assertions.*;

class TesteVotacao {
    Votacao v1;
    Votacao v2;

    @BeforeEach
    void setUp(){
        v1 = new Votacao();
        v2 = new Votacao();
        v1.setStatus("APROVADO");
        v2.setStatus("REJEITADO");
        v1.setLocal("plenario");
        v2.setLocal("CGOV");
    }

    @Test
    void getStatus() {
        assertEquals("APROVADO",v1.getStatus());
        assertEquals("REJEITADO", v2.getStatus());
    }

    @Test
    void setStatus() {
        v1.setStatus("REJEITADO");
        v2.setStatus("APROVADO");
        assertEquals("REJEITADO",v1.getStatus());
        assertEquals("APROVADO",v2.getStatus());
    }

    @Test
    void getLocal() {
        assertEquals("plenario",v1.getLocal());
        assertEquals("CGOV",v2.getLocal());
    }

    @Test
    void setLocal() {
        v1.setLocal("CGOV");
        v2.setLocal("prefeitura");
        assertEquals("(CGOV)",v1.getLocal());
        assertEquals("(prefeitura)",v2.getLocal());
    }

    @Test
    void realizaVotacaoComissao() {
        assertEquals(true,v1.realizaVotacao(6,10,"COMISSAO"));
        assertEquals(false,v2.realizaVotacao(2,10,"COMISSAO"));
    }

    @Test
    void realizaVotacaoPec(){
        assertEquals(true,v1.realizaVotacao(8,10,"PÈC"));
        assertEquals(false,v2.realizaVotacao(6,10,"PEC"));
    }

    @Test
    void realizaVotacaoPl(){
        assertEquals(true,v1.realizaVotacao(8,10,"PL"));
        assertEquals(false,v2.realizaVotacao(5,10,"PL"));
    }

    @Test
    void realizaVotacaoPlp(){
        assertEquals(true,v1.realizaVotacao(9,10,"PLP"));
        assertEquals(false,v2.realizaVotacao(4,10,"PLP"));
    }

    @Test
    void toString1() {
        assertEquals("APROVADO (plenario)", v1.toString());
        assertEquals("REJEITADO (CGOV)", v2.toString());

    }
    
}