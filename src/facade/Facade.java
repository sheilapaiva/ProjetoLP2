package facade;

import easyaccept.EasyAccept;
import controladores.*;

/**
 * Representa um fachada que oferece métodos simples e de uso geral do usuário. 
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class Facade {
	
	/**
	 * Controle geral.
	 */
	ControleGeral controleGeral = new ControleGeral();
	
	/**
	 * Carrega o sistema.
	 */
	public void carregarSistema() {
		controleGeral.carregarSistema();
	}
	
	/**
	 * Limpa o sistema.
	 */
	public void limparSistema() {
		controleGeral.limparSistema();
	}
	
	/**
	 * Salva o sistema.
	 */
	public void salvarSistema() {
		controleGeral.salvarSistema();
	}

	/**
	 * Cadastra uma pessoa no mapa de pessoa. A partir do nome, identificador, estado e interesses
	 * da pessoa.
	 * 
	 * @param nome, o nome da pessoa
	 * @param dni, documento nacional de identificacao da pessoa
	 * @param estado, Estado de origem da pessoa
	 * @param interesses, interesses da pessoa
	 */
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
		controleGeral.cadastrarPessoa(nome, dni, estado, interesses);
	}
	
	/**
	 * Cadastra uma pessoa no mapa de pessoa. A partir do nome, identificador, estado, interesses
	 * e o partido da pessoa. 
	 * 
	 * @param nome, o nome da pessoa
	 * @param dni, documento nacional de identificacao da pessoa
	 * @param estado, Estado de origem da pessoa
	 * @param interesses, interesses da pessoa
	 * @param partido, partido da pessoa
	 */
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
		controleGeral.cadastrarPessoa(nome, dni, estado, interesses, partido);
	}

	/**
	 * Cadastra um deputado no mapa de deputados a partir do seu dni e a data de inicio de mandato. 
	 * 
	 * @param dni, dni da pessoa
	 * @param dataDeInicio, data de inicio do mandato 
	 */
	public void cadastrarDeputado(String dni, String dataDeInicio) {
		controleGeral.cadastrarDeputado(dni, dataDeInicio);
	}
	
	/**
	 * Retorna uma String representando a Pessoa com o dni passado como parametro.
	 * 
	 * @param dni, o dni da pessoa
	 * @return uma String representando a Pessoa com o dni passado como parametro
	 */
	public String exibirPessoa(String dni){
		return controleGeral.exibirPessoa(dni);
	}
	
	/**
	 * Cadastra um partido na lista de partidos. A partir do nome do partido.
	 * 
	 * @param nome, o nome do partido
	 */
	public void cadastrarPartido(String partido) {
		controleGeral.cadastrarPartido(partido);
	}
	
	/**
	 * Retorna uma String representando os partidos cadastrados. 
	 * A representação segue o formato: "nome do partido, ..., nome do partido"
	 * 
	 * @return uma String representando os partidos
	 */
	public String exibirBase() {
		return controleGeral.exibirBase();
	}
	
	/**
	 * Cadastra uma comissao no mapa de comissao. A partir do tema e da lista de politicos.
	 * 
	 * @param tema
	 * @param politicos
	 */
	public void cadastrarComissao(String tema, String politicos) {
		controleGeral.cadastrarComissao(tema, politicos);
	}
	
	/**
	 * Cadastra uma PL. A partir do dni, ano, ementa, interesses, url e conclusivo.
	 * 
     * @param dni, o numero do projeto
     * @param ano, o ano do projeto
     * @param ementa, as ementas do projeto
     * @param interesses, os interesses do projeto
     * @param url, a url do projeto
	 * @param conclusivo, o conclusivo do projeto
	 * @return codigo gerado do projeto
	 */
	public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		return controleGeral.cadastrarPL(dni, ano, ementa, interesses, url, conclusivo);
	}
	
	/**
	 * Cadastra uma PLP. A partir do dni, ano, ementa, interesses, url e artigos.
	 * 
     * @param dni, o numero do projeto
     * @param ano, o ano do projeto
     * @param ementa, as ementas do projeto
     * @param interesses, os interesses do projeto
     * @param url, a url do projeto
	 * @param artigos, os artigos do projeto
	 * @return codigo gerado do projeto
	 */
	public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		return controleGeral.cadastrarPLP(dni, ano, ementa, interesses, url, artigos);
	}
	
	/**
	 * Cadastra uma PEC. A partir do dni, ano, ementa, interesses, url e artigos.
	 * 
     * @param dni, o numero do projeto
     * @param ano, o ano do projeto
     * @param ementa, as ementas do projeto
     * @param interesses, os interesses do projeto
     * @param url, a url do projeto
	 * @param artigos, os artigos do projeto
	 * @return codigo gerado do projeto
	 */
	public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		return controleGeral.cadastrarPEC(dni, ano, ementa, interesses, url, artigos);
		
	}
	
	/**
	 * Exibe um projeto, a partir do codigo passado no parametro.
	 * 
	 * @param codigo
	 * @return uma String que representa o projeto
	 */
	public String exibirProjeto(String codigo) {
		return controleGeral.exibirProjeto(codigo);
	}
	
	/**
	 * Vota o projeto em uma comissao, com o codigo, o status da votacao e o proximo local passados por parametro.
	 * 
	 * @param codigo, o codigo do projeto.
	 * @param statusGovernista, o status da votacao
	 * @param proximoLocal, o proximo local de votacao
	 * @return boolean referente ao resultado da votacao
	 */
	public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
		return controleGeral.votarComissao(codigo, statusGovernista, proximoLocal);
	}
	
	/**
	 * Vota o projeto no plenario, com o codigo,, status e os presentes passados por parametro.
	 * 
	 * @param codigo, o codigo do projeto.
	 * @param statusGovernista, o status da votacao
	 * @param presentes, os deputados presentes na votacao
	 * @return boolean referente ao resultado da votacao
	 */
	public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
		return controleGeral.votarPlenario(codigo, statusGovernista, presentes);
	}
	
	/**
	 * Exibe a tramitacao da proposta com o codigo passado por parametro.
	 *  
	 * @param codigo, o codigo do projeto
	 * @throws IllegalArgumentException, projeto inexistente
	 * @return String referente a tramitacao do projeto
	 */
	public String exibirTramitacao(String codigo) {
		return controleGeral.exibirTramitacao(codigo);
	}
	
	/**
	 * Configura a estrategia de um deputado. Com o dni passado por parametro e a estrategia.
	 * 
	 * @param dni, deni do deputado
	 * @param estrategia, estrategia do deputado
	 */
	public void configurarEstrategiaPropostaRelacionada(String dni, String estrategia) {
		controleGeral.configurarEstrategiaPropostaRelacionada(dni, estrategia);
	}
	
	/**
	 * Exibe a proposta mais relacionada com o deputado com o dni passado por parametro.
	 *  
	 * @param dni, o dni do deputado
	 * @return String referente ao codigo do projeto mais relacionado
	 */
	public String pegarPropostaRelacionada(String dni) {
		return controleGeral.pegarPropostaRelacionada(dni);
	}
	
	public static void main(String[] args) {
		//args = new String[] {"projetoLP2.Facade", "testes-eco/use_case_1.txt", "testes-eco/use_case_2.txt", "testes-eco/use_case_3.txt", "testes-eco/use_case_4.txt", "testes-eco/use_case_5.txt", "testes-eco/use_case_6.txt"}; 
		//args = new String[] {"facade.Facade", "testes-eco/use_case_7.txt",  "testes-eco/use_case_8.txt",  "testes-eco/use_case_9.txt"};
		args = new String[] {"facade.Facade", "testes-eco/use_case_7.txt","testes-eco/use_case_8.txt"};
		EasyAccept.main(args);
	}
}
