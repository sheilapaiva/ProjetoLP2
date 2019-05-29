package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projetoLP2.CrudPessoa;

class TesteCrudPessoa {
	CrudPessoa cp;
	
	@BeforeEach
	void setUp() {
		this.cp = new CrudPessoa();
	}
	
	@Test
	void test1CadastraPessoa() {
		cp.cadastrarPessoa("jose", "123456789-0", "PE", "saude,educacao,ensino");
		assertTrue(cp.getMapPessoa().containsKey("123456789-0"));
		assertFalse(cp.getMapPessoa().containsKey("123456789-8"));
	}
	
	@Test
	void test2CadastraPessoa() {
		cp.cadastrarPessoa("jose", "123456789-0", "PE", "saude,educacao,ensino, UNE");
		assertTrue(cp.getMapPessoa().containsKey("123456789-0"));
		assertFalse(cp.getMapPessoa().containsKey("123456789-8"));
	}
	
	@Test
	void testNomeNulo() {
		try {
			cp.cadastrarPessoa(null, "123456789-0", "PE", "saude,educacao,ensino");
		} catch (RuntimeException nn) {
			assertEquals(nn.getMessage(), "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		} 
	}
	
	@Test
	void testNomeVazio() {
		try {
			cp.cadastrarPessoa("", "123456789-0", "PE", "saude,educacao,ensino");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	void testDniNulo() {
		try {
			cp.cadastrarPessoa("jose", null, "PE", "saude,educacao,ensino");
		} catch (RuntimeException nn) {
			assertEquals(nn.getMessage(), "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		} 
	}
	
	@Test
	void testDniVazio() {
		try {
			cp.cadastrarPessoa("jose", "", "PE", "saude,educacao,ensino");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	void testEstadoNulo() {
		try {
			cp.cadastrarPessoa("jose", "123456789-0", null, "saude,educacao,ensino");
		} catch (RuntimeException nn) {
			assertEquals(nn.getMessage(), "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		} 
	}
	
	@Test
	void testEstadoVazio() {
		try {
			cp.cadastrarPessoa("jose", "123456789-0", "", "saude,educacao,ensino");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	void testFormatoDni() {
		try {
			cp.cadastrarPessoa("jose", "123456789.0", "PE", "saude,educacao,ensino");
		} catch(RuntimeException msg) {
			assertEquals(msg.getMessage(), "Erro ao cadastrar pessoa: dni invalido");
		}
	}
	
	@Test
	void testConsultaPessoa() {
		cp.cadastrarPessoa("jose", "123456789-0", "PE", "saude,educacao,ensino");
		try {
			cp.cadastrarPessoa("aline", "123456789-0", "PB", "saude,educacao");
		} catch(RuntimeException msg) {
			assertEquals(msg.getMessage(), "Erro ao cadastrar pessoa: dni ja cadastrado");
		}
	}


}

