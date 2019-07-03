package testes;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControleGeral;


/**
 * Testes de Unidade da classe ControleGeral.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */

class TesteControleGeral {

	ControleGeral cp;
	
	@BeforeEach
	void setUp() {
		cp = new ControleGeral();
		
		cp.cadastrarPessoa("jose", "123456789-0", "PE", "saude,educacao,ensino");
		cp.cadastrarPessoa("roberto", "123456789-2", "PE", "educacao,ensino", "UNB");
		cp.cadastrarPessoa("joao", "123456789-1", "PB", "saude,educacao", "UNB");
		cp.cadastrarDeputado("123456789-1", "05052019");
		
		cp.cadastrarPartido("ABC");
		cp.cadastrarPartido("ANB");
	}
	
	@Test
	void testeCadastrarPessoa1NomeNulo() {
		try {
			cp.cadastrarPessoa(null, "123456789-0", "PE", "saude,educacao,ensino");
		} catch (RuntimeException nn) {
			assertEquals(nn.getMessage(), "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		} 
	}
	
	@Test
	void testeCadastrarPessoa1NomeVazio() {
		try {
			cp.cadastrarPessoa("", "123456789-0", "PE", "saude,educacao,ensino");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	void testeCadastrarPessoa1DniNulo() {
		try {
			cp.cadastrarPessoa("jose", null, "PE", "saude,educacao,ensino");
		} catch (RuntimeException nn) {
			assertEquals(nn.getMessage(), "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		} 
	}
	
	@Test
	void testeCadastrarPessoa1DniVazio() {
		try {
			cp.cadastrarPessoa("jose", "", "PE", "saude,educacao,ensino");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	void testeCadastrarPessoa1EstadoNulo() {
		try {
			cp.cadastrarPessoa("jose", "123456789-0", null, "saude,educacao,ensino");
		} catch (RuntimeException nn) {
			assertEquals(nn.getMessage(), "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		} 
	}
	
	@Test
	void testeCadastrarPessoa1EstadoVazio() {
		try {
			cp.cadastrarPessoa("jose", "123456789-0", "", "saude,educacao,ensino");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	void testeCadastrarPessoa1DniInvalido() {
		try {
			cp.cadastrarPessoa("jose", "123456789.0", "PE", "saude,educacao,ensino");
		} catch(RuntimeException msg) {
			assertEquals(msg.getMessage(), "Erro ao cadastrar pessoa: dni invalido");
		}
	}
	
	@Test
	void testeCadastrarPessoa1JaCadastrada() {
		try {
			cp.cadastrarPessoa("jose", "123456789-0", "PE", "saude,educacao,ensino");
		} catch(RuntimeException msg) {
			assertEquals(msg.getMessage(), "Erro ao cadastrar pessoa: dni ja cadastrado");
		}
	}
	
	@Test
	void testeCadastrarPessoa1Valida() {
		cp.cadastrarPessoa("joana", "123456709-0", "PE", "saude");
		assertEquals(cp.exibirPessoa("123456709-0"), "joana - 123456709-0 (PE) - Interesses: saude");
	}

	@Test
	void testeCadastrarPessoa2NomeNulo() {
		try {
			cp.cadastrarPessoa(null, "123456789-0", "PE", "saude,educacao,ensino", "UNE");
		} catch (RuntimeException nn) {
			assertEquals(nn.getMessage(), "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		} 
	}
	
	@Test
	void testeCadastrarPessoa2NomeVazio() {
		try {
			cp.cadastrarPessoa("", "123456789-0", "PE", "saude,educacao,ensino", "UNE");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	void testeCadastrarPessoa2DniNulo() {
		try {
			cp.cadastrarPessoa("jose", null, "PE", "saude,educacao,ensino", "UNE");
		} catch (RuntimeException nn) {
			assertEquals(nn.getMessage(), "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		} 
	}
	
	@Test
	void testeCadastrarPessoa2DniVazio() {
		try {
			cp.cadastrarPessoa("jose", "", "PE", "saude,educacao,ensino", "UNE");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	void testeCadastrarPessoa2EstadoNulo() {
		try {
			cp.cadastrarPessoa("jose", "123456789-0", null, "saude,educacao,ensino", "UNE");
		} catch (RuntimeException nn) {
			assertEquals(nn.getMessage(), "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		} 
	}
	
	@Test
	void testeCadastrarPessoa2EstadoVazio() {
		try {
			cp.cadastrarPessoa("jose", "123456789-0", "", "saude,educacao,ensino", "UNE");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	void testeCadastrarPessoa2DniInvalido() {
		try {
			cp.cadastrarPessoa("jose", "123456789.0", "PE", "saude,educacao,ensino", "UNE");
		} catch(RuntimeException msg) {
			assertEquals(msg.getMessage(), "Erro ao cadastrar pessoa: dni invalido");
		}
	}
	
	@Test
	void testeCadastrarPessoa2JaCadastrada() {
		try {
			cp.cadastrarPessoa("joao", "123456789-1", "PB", "saude,educacao", "UNB");
		} catch(RuntimeException msg) {
			assertEquals(msg.getMessage(), "Erro ao cadastrar pessoa: dni ja cadastrado");
		}
	}
	
	@Test
	void testeCadastrarPessoa2Valida() {
		cp.cadastrarPessoa("joana", "123456709-0", "PE", "saude", "UNB");
		assertEquals(cp.exibirPessoa("123456709-0"), "joana - 123456709-0 (PE) - UNB - Interesses: saude");
	}
	
	@Test
	void testeCadastrarDeputadoDniNulo() {
		try {
			cp.cadastrarDeputado(null, "01092018");
		} catch (RuntimeException nn) {
			assertEquals(nn.getMessage(), "Erro ao cadastrar deputado: dni nao pode ser vazio ou nulo");
		} 
	}
	
	@Test
	void testeCadastrarDeputadoDniVazio() {
		try {
			cp.cadastrarDeputado("", "01092018");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar deputado: dni nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	void testeCadastrarDeputadoDniInvalido() {
		try {
			cp.cadastrarDeputado("A786595-0", "01092018");
		} catch (RuntimeException nn) {
			assertEquals(nn.getMessage(), "Erro ao cadastrar deputado: dni invalido");
		} 
	}
	
	@Test
	void testeCadastrarDeputadoPessoaNaoEncontrada() {
		try {
			cp.cadastrarDeputado("9908765456-0", "01092018");
		} catch (RuntimeException nn) {
			assertEquals(nn.getMessage(), "Erro ao cadastrar deputado: pessoa nao encontrada");
		} 
	}
	
	@Test
	void testeCadastrarDeputadoDataNulo() {
		try {
			cp.cadastrarDeputado("123456789-2", null);
		} catch (RuntimeException nn) {
			assertEquals(nn.getMessage(), "Erro ao cadastrar deputado: data nao pode ser vazio ou nulo");
		} 
	}
	
	@Test
	void testeCadastrarDeputadoDataVazio() {
		try {
			cp.cadastrarDeputado("123456789-2", "");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar deputado: data nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	void testeCadastrarDeputadoPessoaSemPartido() {
		try {
			cp.cadastrarDeputado("123456789-0", "02032019");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar deputado: pessoa sem partido");
		}
	}
	
	@Test
	void testeCadastrarDeputadoDataInvalida1() {
		try {
			cp.cadastrarDeputado("123456789-2", "020319");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar deputado: data invalida");
		}
	}
	
	@Test
	void testeCadastrarDeputadoDataInvalida2() {
		try {
			cp.cadastrarDeputado("123456789-2", "31042019");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar deputado: data invalida");
		}
	}
	
	@Test
	void testeCadastrarDeputadoDataFutura() {
		try {
			cp.cadastrarDeputado("123456789-2", "07092019");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar deputado: data futura");
		}
	}
	
	@Test
	void testeCadastrarDeputadoJaCadastrado() {
		try {
			cp.cadastrarDeputado("123456789-2", "05052019");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro ao cadastrar deputado: data invalida");
		}
	}
	
	@Test
	void testeCadastrarDeputadoValido() {
		cp.cadastrarPessoa("joana", "123456709-0", "PE", "saude", "UNB");
		cp.cadastrarDeputado("123456709-0", "01042019");
		assertEquals(cp.exibirPessoa("123456709-0"), "POL: joana - 123456709-0 (PE) - UNB - Interesses: saude - 01/04/2019 - 0 Leis");
	}
	
	@Test
	void testExibePessoaDniInvalido(){
		try{
			cp.exibirPessoa("A23456789-0");
		}catch (IllegalArgumentException msg) {
			assertEquals(msg.getMessage(), "Erro ao exibir pessoa: dni invalido");
		}
	}
	
	@Test
	void testExibePessoaDniNulo(){
		try{
			cp.exibirPessoa(null);
		}catch (IllegalArgumentException msg) {
			assertEquals(msg.getMessage(), "Erro ao exibir pessoa: dni nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	void testExibePessoaDniVazio(){
		try{
			cp.exibirPessoa("");
		}catch (IllegalArgumentException msg) {
			assertEquals(msg.getMessage(), "Erro ao exibir pessoa: dni nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	void testExibePessoaNaoEncontrada(){
		try{
			cp.exibirPessoa("987654321-0");
		}catch (IllegalArgumentException msg) {
			assertEquals(msg.getMessage(), "Erro ao exibir pessoa: pessoa nao encontrada");
		}
	}
	
	@Test
	void testExibePessoaValido(){
		assertEquals(cp.exibirPessoa("123456789-0"), "jose - 123456789-0 (PE) - Interesses: saude,educacao,ensino");
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
