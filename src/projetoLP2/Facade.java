package projetoLP2;

import easyaccept.EasyAccept;

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
	
	public void carregarSistema() {
		controleGeral.carregarSistema();
	}
	
	public void limparSistema() {
		controleGeral.limparSistema();
	}
	
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
	
	public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		return controleGeral.cadastrarPL(dni, ano, ementa, interesses, url, conclusivo);
	}
	
	public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		return controleGeral.cadastrarPLP(dni, ano, ementa, interesses, url, artigos);
	}
	
	public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		return controleGeral.cadastrarPEC(dni, ano, ementa, interesses, url, artigos);
		
	}
	
	public String exibirProjeto(String codigo) {
		return controleGeral.exibirProjeto(codigo);
	}
	
	public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
		return controleGeral.votarComissao(codigo, statusGovernista, proximoLocal);
	}
	
	public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
		return controleGeral.votarPlenario(codigo, statusGovernista, presentes);
	}
	
	public String exibirTramitacao(String codigo) {
		return controleGeral.exibirTramitacao(codigo);
	}
	
	public void configurarEstrategiaPropostaRelacionada(String dni, String estrategia) {
		controleGeral.configurarEstrategiaPropostaRelacionada(dni, estrategia);
	}
	
	public String pegarPropostaRelacionada(String dni) {
		return controleGeral.pegarPropostaRelacionada(dni);
	}
	
	public static void main(String[] args) {
		//args = new String[] {"projetoLP2.Facade", "testes-eco/use_case_1.txt", "testes-eco/use_case_2.txt", "testes-eco/use_case_3.txt", "testes-eco/use_case_4.txt", "testes-eco/use_case_5.txt", "testes-eco/use_case_6.txt"}; 
		args = new String[] {"projetoLP2.Facade", "testes-eco/use_case_7.txt",  "testes-eco/use_case_8.txt",  "testes-eco/use_case_9.txt"};
		EasyAccept.main(args);
	}
}
