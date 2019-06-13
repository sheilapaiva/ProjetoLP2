package projetoLP2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representação de um Controle Geral. Gerencia o controle de pessoas e o controle de partidos.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class ControleGeral {
	
	/**
	 * Controle de pessoas.
	 */
	private ControlePessoa cp;
	/**
	 * Controle de partidos.
	 */
	private ControlePartido cpt;
	
	private ControleProjetos cpl;
	/**
	 * Constroi um mapa de comissoes.
	 */
	private HashMap <String, Comissao> mapComissao;
	
	/**
	 * Constroi um Controle Geral.
	 */
	public ControleGeral() {
		this.cp = new ControlePessoa();
		this.cpt = new ControlePartido();
		this.cpl = new ControleProjetos();
		this.mapComissao = new HashMap<>();
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
		cp.cadastrarPessoa(nome, dni, estado, interesses);
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
		cp.cadastrarPessoa(nome, dni, estado, interesses, partido);
	}

	/**
	 * Cadastra um deputado no mapa de deputados a partir do seu dni e a data de inicio de mandato. 
	 * 
	 * @param dni, dni da pessoa
	 * @param dataDeInicio, data de inicio do mandato 
	 */
	public void cadastrarDeputado(String dni, String dataDeInicio) {
		cp.cadastrarDeputado(dni, dataDeInicio);
	}
	
	/**
	 * Retorna uma String representando a Pessoa com o dni passado como parametro.
	 * 
	 * @param dni, o dni da pessoa
	 * @return uma String representando a Pessoa com o dni passado como parametro
	 */
	public String exibirPessoa(String dni){
		return cp.exibirPessoa(dni);
	}
	
	/**
	 * Cadastra um partido na lista de partidos. A partir do nome do partido.
	 * 
	 * @param nome, o nome do partido
	 */
	public void cadastrarPartido(String partido) {
		cpt.cadastrarPartido(partido);
	}
	
	/**
	 * Retorna uma String representando os partidos cadastrados. 
	 * A representação segue o formato: "nome do partido, ..., nome do partido"
	 * 
	 * @return uma String representando os partidos
	 */
	public String exibirBase() {
		return cpt.exibirBase();
	}
	
	private ArrayList<Pessoa> criaListaPoliticos(String politicos) {
		ArrayList<Pessoa> lista = new ArrayList<>();
		String[] dni = politicos.split(",");
		for (String politico : dni) {
			if (cp.getMapPessoa().containsKey(politico)) {
				lista.add(cp.getMapPessoa().get(politico));
			}
		}
		return lista;
	}
	
	/**
	 * FALTAM TRATAR EXCECOES!
	 * Cadastra uma comissao no mapa de comissao. A partir do tema e da lista de politicos.
	 * Se esses campos não estiverem nulos ou vazios e forem validos. Usa o tema como chave
	 * para o mapa.
	 * 
	 * @param tema, tema da comissao
	 * @param politicos, lista de politicos
	 * @throws IllegalArgumentException, campo tema nao pode ser vazio ou nulo
	 * @throws IllegalArgumentException, campo lista de politicos nao pode ser vazio ou nulo
	 * @throws IllegalArgumentException, campo dni invalido 
	 */
	public void cadastrarComissao(String tema, String politicos) {
		if (tema == null || "".equals(tema.trim())) {
			throw new IllegalArgumentException("Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
		} else if (politicos == null || "".equals(politicos.trim())) {
			throw new IllegalArgumentException("Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo");
		}
		Comissao comissao = new Comissao(tema, criaListaPoliticos(politicos));
		this.mapComissao.put(tema, comissao);
	}
	
	public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		return this.cpl.cadastraPl(dni, ano, ementa, interesses, url, conclusivo);
	}
	
	public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		return this.cpl.cadastraPLP(dni, ano, ementa, interesses, url, artigos);
	}
	
	public String cadastrarPec(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		return this.cpl.cadastraPec(dni, ano, ementa, interesses, url, artigos);
		
	}
	
	public String exibirProjeto(String codigo) {
		return this.cpl.exibirProjeto(codigo);
	}
}
