package projetoLP2;

import java.util.ArrayList;

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
	private ControlePessoa controlePessoa;
	/**
	 * Controle de partidos.
	 */
	private ControlePartido controlePartido;
	/**
	 * Controle de comissoes.
	 */
	private ControleComissao controleComissao;
	/**
	 * Controle de projetos.
	 */
	private ControleProjeto controleProjeto;
	
	/**
	 * Constroi um Controle Geral.
	 */
	public ControleGeral() {
		this.controlePessoa = new ControlePessoa();
		this.controlePartido = new ControlePartido();
		this.controleComissao = new ControleComissao();
		this.controleProjeto = new ControleProjeto();
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
		Validacao.validarString(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		Validacao.validarString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		Validacao.validarString(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		Validacao.verificaDni(dni, "Erro ao cadastrar pessoa: dni invalido");
		controlePessoa.cadastrarPessoa(nome, dni, estado, interesses);
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
		Validacao.validarString(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		Validacao.validarString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		Validacao.validarString(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		Validacao.verificaDni(dni, "Erro ao cadastrar pessoa: dni invalido");
		this.controlePessoa.cadastrarPessoa(nome, dni, estado, interesses, partido);
	}

	/**
	 * Cadastra um deputado no mapa de deputados a partir do seu dni e a data de inicio de mandato. 
	 * 
	 * @param dni, dni da pessoa
	 * @param dataDeInicio, data de inicio do mandato 
	 */
	public void cadastrarDeputado(String dni, String dataDeInicio) {
		Validacao.validarString(dni, "Erro ao cadastrar deputado: dni nao pode ser vazio ou nulo");
		Validacao.verificaDni(dni, "Erro ao cadastrar deputado: dni invalido");
		this.controlePessoa.cadastrarDeputado(dni, dataDeInicio);
	}
	
	/**
	 * Retorna uma String representando a Pessoa com o dni passado como parametro.
	 * 
	 * @param dni, o dni da pessoa
	 * @return uma String representando a Pessoa com o dni passado como parametro
	 */
	public String exibirPessoa(String dni){
		Validacao.validarString(dni, "Erro ao exibir pessoa: dni nao pode ser vazio ou nulo");
		Validacao.verificaDni(dni, "Erro ao exibir pessoa: dni invalido");
		return this.controlePessoa.exibirPessoa(dni);
	}
	
	/**
	 * Cadastra um partido na lista de partidos. A partir do nome do partido.
	 * 
	 * @param nome, o nome do partido
	 */
	public void cadastrarPartido(String partido) {
		Validacao.validarString(partido, "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
		this.controlePartido.cadastrarPartido(partido);
	}
	
	/**
	 * Retorna uma String representando os partidos cadastrados. 
	 * A representação segue o formato: "nome do partido, ..., nome do partido"
	 * 
	 * @return uma String representando os partidos
	 */
	public String exibirBase() {
		return this.controlePartido.exibirBase();
	}
	
	private ArrayList<String> criaListaPoliticos(String politicos) {
		String[] lista = politicos.split(",");
		ArrayList<String> listaDni = new ArrayList<String>();
		for (String dni : lista) {
			Validacao.verificaDni(dni, "Erro ao cadastrar comissao: dni invalido");
			if (!controlePessoa.getMapPessoa().containsKey(dni)) {
				throw new IllegalArgumentException("Erro ao cadastrar comissao: pessoa inexistente");
			} else if (controlePessoa.getMapPessoa().get(dni).getFuncao() == null){
				throw new IllegalArgumentException("Erro ao cadastrar comissao: pessoa nao eh deputado");
			}
			listaDni.add(dni);
		}
		return listaDni;
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
		Validacao.validarString(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
		Validacao.validarString(politicos, "Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo");
		if (this.controleComissao.getMapComissao().containsKey(tema)) {
			throw new IllegalArgumentException("Erro ao cadastrar comissao: tema existente");
		}
		
		this.controleComissao.cadastrarComissao(tema, criaListaPoliticos(politicos));
	}
	
	public void cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		Validacao.validarString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		Validacao.validarString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		Validacao.validarString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		Validacao.validarString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		Validacao.verificaDni(dni, "Erro ao cadastrar projeto: dni invalido");
		if (!this.controlePessoa.getMapPessoa().containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa inexistente");
		} else if (this.controlePessoa.getMapPessoa().get(dni).getFuncao() == null){
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa nao eh deputado");
		}
		Validacao.ValidaAno(ano);
		
		this.controleProjeto.cadastrarPL(dni, ano, ementa, interesses, url, conclusivo);
	}
	
	public void cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		Validacao.validarString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		Validacao.validarString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		Validacao.validarString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		Validacao.validarString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		Validacao.validarString(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
		Validacao.verificaDni(dni, "Erro ao cadastrar projeto: dni invalido");
		if (!this.controlePessoa.getMapPessoa().containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa inexistente");
		} else if (this.controlePessoa.getMapPessoa().get(dni).getFuncao() == null){
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa nao eh deputado");
		}
		Validacao.ValidaAno(ano);
		
		this.controleProjeto.cadastrarPLP(dni, ano, ementa, interesses, url, artigos);
	}
	
	public void cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		Validacao.validarString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		Validacao.validarString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		Validacao.validarString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		Validacao.validarString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		Validacao.validarString(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
		Validacao.verificaDni(dni, "Erro ao cadastrar projeto: dni invalido");
		if (!this.controlePessoa.getMapPessoa().containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa inexistente");
		} else if (this.controlePessoa.getMapPessoa().get(dni).getFuncao() == null){
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa nao eh deputado");
		}
		Validacao.ValidaAno(ano);
		this.controleProjeto.cadastrarPEC(dni, ano, ementa, interesses, url, artigos);
	}
	
	public String exibirProjeto(String codigo) {
		Validacao.validarString(codigo, "Erro ao exibir projeto: projeto nao pode ser vazio ou nulo");
		if (!this.controleProjeto.mapProjetos.containsKey(codigo)) {
			throw new IllegalArgumentException("Erro ao exibir projeto: projeto inexistente");
		}
		
		return this.controleProjeto.exibirProjeto(codigo);
	}
	
	public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
		Validacao.validarString(codigo, "Erro ao votar proposta: codigo nao pode ser vazio ou nulo");
		Validacao.validarString(statusGovernista, "Erro ao votar proposta: status governista nao pode ser vazio ou nulo");
		Validacao.validarString(proximoLocal, "Erro ao votar proposta: proximo local nao pode ser vazio ou nulo");
		
		return true;
	}
	
	public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
		Validacao.validarString(codigo, "Erro ao votar proposta: codigo nao pode ser vazio ou nulo");
		Validacao.validarString(statusGovernista, "Erro ao votar proposta: status governista nao pode ser vazio ou nulo");
		Validacao.validarString(presentes, "Erro ao votar proposta: presentes nao pode ser vazio ou nulo");
		
		return true;
	}
	
	public String exibirTramitacao(String codigo) {
		Validacao.validarString(codigo, "Erro ao exibir tramitacao: codigo nao pode ser vazio ou nulo");

		return "";
	}
	
}
