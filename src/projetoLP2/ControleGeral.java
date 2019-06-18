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
	 * Controle de Votacao.
	 */
	private ControleVotacao controleVotacao;
	
	/**
	 * Constroi um Controle Geral.
	 */
	public ControleGeral() {
		this.controlePessoa = new ControlePessoa();
		this.controlePartido = new ControlePartido();
		this.controleComissao = new ControleComissao();
		this.controleProjeto = new ControleProjeto();
		this.controleVotacao = new ControleVotacao();
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
	
	public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
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
		
		return this.controleProjeto.cadastrarPL(dni, ano, ementa, interesses, url, conclusivo);
	}
	
	public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
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
		
		return this.controleProjeto.cadastrarPLP(dni, ano, ementa, interesses, url, artigos);
	}
	
	public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
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
		return this.controleProjeto.cadastrarPEC(dni, ano, ementa, interesses, url, artigos);
	}
	
	public String exibirProjeto(String codigo) {
		Validacao.validarString(codigo, "Erro ao exibir projeto: projeto nao pode ser vazio ou nulo");
		if (!this.controleProjeto.getMapProjetos().containsKey(codigo)) {
			throw new IllegalArgumentException("Erro ao exibir projeto: projeto inexistente");
		}
		
		return this.controleProjeto.exibirProjeto(codigo);
	}
	
	private int contagemBase(ArrayList<String> dni) {
		int i = 0;
		for (int b = 0; b < dni.size(); b++) {
			if (this.controlePartido.getPartidos().contains(this.controlePessoa.getMapPessoa().get(dni.get(b)).getPartido())) {
				i++;
			}
		}
		return i;
	}
	
	private int contagemInteresses(ArrayList<String> dni, String interesses) {
		String[] lista = interesses.split(",");
		ArrayList<String> interessesProj = new ArrayList<String>();
		for (String interesse : lista) {
			interessesProj.add(interesse);
		}
		
		int contDep = 0;
		for (int b = 0; b < dni.size(); b++) {
			String [] interessesDep = this.controlePessoa.getMapPessoa().get(dni.get(b)).getInteresses().split(",");
			for (int a = 0; a < interessesDep.length; a++) {
				if (interessesProj.contains(interessesDep[a])) {
					contDep++;
					break;
				}
			}
		}
		return contDep;
	}
	
	private boolean verificaStatus(String codigo, String status) {
		Projeto p = this.controleProjeto.getMapProjetos().get(codigo);
		Comissao c = this.controleComissao.getMapComissao().get(p.getNomeComissao());
		if (c == null) {
			throw new IllegalArgumentException("Erro ao votar proposta: " + p.getNomeComissao() + " nao cadastrada");
		}
	
		int cont;
		
		if (status.equals("GOVERNISTA")) {
			
			cont = contagemBase(c.getPoliticos());
			System.out.println(cont);
			System.out.println(c.getPoliticos().size());
			return this.controleVotacao.realizarVotacao(codigo, p.getNomeComissao(), cont, c.getPoliticos().size(), "COMISSAO");
		} else if (status.equals("OPOSICAO")) {
			
			cont = c.getPoliticos().size() - contagemBase(c.getPoliticos());
			System.out.println(cont);
			System.out.println(c.getPoliticos().size());
			return this.controleVotacao.realizarVotacao(codigo, p.getNomeComissao(), cont, c.getPoliticos().size(), "COMISSAO");
		} else {	
			String interesses = p.getInteresses();
			cont = contagemInteresses(c.getPoliticos(), interesses);
			System.out.println(cont);
			System.out.println(c.getPoliticos().size());
			return this.controleVotacao.realizarVotacao(codigo, p.getNomeComissao(), cont, c.getPoliticos().size(), "COMISSAO");
		}
	}
	
	public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
		Validacao.validarString(codigo, "Erro ao votar proposta: codigo nao pode ser vazio ou nulo");
		Validacao.validarString(statusGovernista, "Erro ao votar proposta: status governista nao pode ser vazio ou nulo");
		Validacao.validarString(proximoLocal, "Erro ao votar proposta: proximo local vazio");
		if (!statusGovernista.equals("GOVERNISTA") && !statusGovernista.equals("OPOSICAO") && !statusGovernista.equals("LIVRE")) {
			throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
		} else if (!this.controleProjeto.getMapProjetos().containsKey(codigo)) {
			throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
		}
		boolean v = verificaStatus(codigo, statusGovernista);
		this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao(proximoLocal);
		return v;
	
	}
	
	private boolean verificaStatusPlenaria(String codigo, String status) {
		Projeto p = this.controleProjeto.getMapProjetos().get(codigo);
		Comissao c = this.controleComissao.getMapComissao().get(p.getNomeComissao());
		if (c == null) {
			throw new IllegalArgumentException("Erro ao votar proposta: " + p.getNomeComissao() + " nao cadastrada");
		}
	
		int cont;
		
		if (status.equals("GOVERNISTA")) {
			
			cont = contagemBase(c.getPoliticos());
			System.out.println(cont);
			System.out.println(c.getPoliticos().size());
			return this.controleVotacao.realizarVotacao(codigo, p.getNomeComissao(), cont, c.getPoliticos().size(), "COMISSAO");
		} else if (status.equals("OPOSICAO")) {
			
			cont = c.getPoliticos().size() - contagemBase(c.getPoliticos());
			System.out.println(cont);
			System.out.println(c.getPoliticos().size());
			return this.controleVotacao.realizarVotacao(codigo, p.getNomeComissao(), cont, c.getPoliticos().size(), "COMISSAO");
		} else {	
			String interesses = p.getInteresses();
			cont = contagemInteresses(c.getPoliticos(), interesses);
			System.out.println(cont);
			System.out.println(c.getPoliticos().size());
			return this.controleVotacao.realizarVotacao(codigo, p.getNomeComissao(), cont, c.getPoliticos().size(), "COMISSAO");
		}
	}
	
	public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
		Validacao.validarString(codigo, "Erro ao votar proposta: codigo nao pode ser vazio ou nulo");
		Validacao.validarString(statusGovernista, "Erro ao votar proposta: status governista nao pode ser vazio ou nulo");
		Validacao.validarString(presentes, "Erro ao votar proposta: presentes nao pode ser vazio ou nulo");
		if (!statusGovernista.equals("GOVERNISTA") && !statusGovernista.equals("OPOSICAO") && !statusGovernista.equals("LIVRE")) {
			throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
		} else if (!this.controleProjeto.getMapProjetos().containsKey(codigo)) {
			throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
		}
		
		boolean v = verificaStatusPlenaria(codigo, statusGovernista);

		return v;
		
		
		
		return true;
	}
	
	public String exibirTramitacao(String codigo) {
		Validacao.validarString(codigo, "Erro ao exibir tramitacao: codigo nao pode ser vazio ou nulo");

		return "mmm";
	}
	
}
