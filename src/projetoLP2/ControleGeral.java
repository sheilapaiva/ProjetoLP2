package projetoLP2;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Representação de um Controle Geral. Gerencia o controle de pessoas e o controle de partidos.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class ControleGeral{
	
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
	
	public void carregarSistema() {
		
	}
	
	public void limparSistema() {
		
	}
	
	public void salvarSistema() {
		
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
		int cont = 0;
		for (int i = 0; i < dni.size(); i++) {
			if (this.controlePartido.getPartidos().contains(this.controlePessoa.getMapPessoa().get(dni.get(i)).getPartido())) {
				cont++;
			}
		}
		
		return cont;
	}
	
	private int contagemInteresses(ArrayList<String> dni, String interesses) {
		String[] listaInteresses = interesses.split(",");
		ArrayList<String> interessesProjeto = new ArrayList<String>();
		for (String interesse : listaInteresses) {
			interessesProjeto.add(interesse);
		}
		
		int contDep = 0;
		for (int i = 0; i < dni.size(); i++) {
			String [] interessesDep = this.controlePessoa.getMapPessoa().get(dni.get(i)).getInteresses().split(",");
			for (int j = 0; j < interessesDep.length; j++) {
				if (interessesProjeto.contains(interessesDep[j])) {
					contDep++;
					break;
				}
			}
		}
		
		return contDep;
	}
	
	private boolean votacaoComissao(String codigo, String status) {
		Projeto projeto = this.controleProjeto.getMapProjetos().get(codigo);
		Comissao comissao = this.controleComissao.getMapComissao().get(projeto.getNomeComissao());
		if (comissao == null) {
			throw new IllegalArgumentException("Erro ao votar proposta: " + projeto.getNomeComissao() + " nao cadastrada");
		}
		
		int cont;
		if (status.equals("GOVERNISTA")) {
			cont = contagemBase(comissao.getPoliticos());
		} else if (status.equals("OPOSICAO")) {
			cont = comissao.getPoliticos().size() - contagemBase(comissao.getPoliticos());
		} else {	
			String interesses = projeto.getInteresses();
			cont = contagemInteresses(comissao.getPoliticos(), interesses);
		}
		
		return this.controleVotacao.realizarVotacao(codigo, projeto.getNomeComissao(), cont, comissao.getPoliticos().size(), "COMISSAO");
	}
	
	public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
		Validacao.validarString(codigo, "Erro ao votar proposta: codigo nao pode ser vazio ou nulo");
		Validacao.validarString(statusGovernista, "Erro ao votar proposta: status governista nao pode ser vazio ou nulo");
		Validacao.validarString(proximoLocal, "Erro ao votar proposta: proximo local vazio");
		if (!statusGovernista.equals("GOVERNISTA") && !statusGovernista.equals("OPOSICAO") && !statusGovernista.equals("LIVRE")) {
			throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
		} else if (!this.controleProjeto.getMapProjetos().containsKey(codigo)) {
			throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
		}else if (this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("plenario") || this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("Plenario - 1o turno") || this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("Plenario - 2o turno")) {
			throw new IllegalArgumentException("Erro ao votar proposta: proposta encaminhada ao plenario");
		}else if (this.controleProjeto.getMapProjetos().get(codigo).getSituacao().equals("ARQUIVADO") || this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("(-)")) { 
			throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
		}

		boolean votacao = votacaoComissao(codigo, statusGovernista);
		if (votacao) {
			if (proximoLocal.equals("-")) {
				this.controleProjeto.getMapProjetos().get(codigo).setSituacao("APROVADO");
				String dni = this.controleProjeto.getMapProjetos().get(codigo).getDni();
				this.controlePessoa.getMapPessoa().get(dni).getFuncao().setQtdLeis(this.controlePessoa.getMapPessoa().get(dni).getFuncao().getQtdLeis() + 1);
				this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao(proximoLocal);
			}
			else {
				this.controleProjeto.getMapProjetos().get(codigo).setSituacao("EM VOTACAO");
				if (this.controleProjeto.getMapProjetos().get(codigo).getCodigo().substring(0,3).equals("PL ")){
					this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao(proximoLocal);
				} else {
					if (proximoLocal.equals("plenario")) {
						this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao("Plenario - 1o turno");
					} else {
						this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao(proximoLocal);
					}
				}
			}
		} else {
			if (proximoLocal.equals("plenario") && this.controleProjeto.getMapProjetos().get(codigo).getConclusivo()) {
				this.controleProjeto.getMapProjetos().get(codigo).setSituacao("EM VOTACAO");
				this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao(proximoLocal);	
			}
			else {
				this.controleProjeto.getMapProjetos().get(codigo).setSituacao("ARQUIVADO");
				this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao(proximoLocal);
			}	
		}
		
		return votacao;	
	}
	
	private ArrayList<String> criaArrayDni(String politicos){
		String[] listaPoliticos = politicos.split(",");
		ArrayList<String> listaDni = new ArrayList<String>();
		for (String dni : listaPoliticos) {
			listaDni.add(dni);
		}
		
		return listaDni;
	}
	
	private boolean votacaoPlenario(String codigo, String status, String presentes, String local) {
		Projeto projeto = this.controleProjeto.getMapProjetos().get(codigo);
		ArrayList<String> listaDni = new ArrayList<String>();
		listaDni.addAll(criaArrayDni(presentes));
		
		int cont;
		if (status.equals("GOVERNISTA")) {	
			cont = contagemBase(listaDni);
		} else if (status.equals("OPOSICAO")) {	
			cont = listaDni.size() - contagemBase(listaDni);
		} else {	
			String interesses = projeto.getInteresses();
			cont = contagemInteresses(listaDni, interesses);
		}
		
		if (projeto.getCodigo().substring(0,3).equals("PEC")) {
			return this.controleVotacao.realizarVotacao(codigo, local, cont, listaDni.size(), "PEC");
		} else if (projeto.getCodigo().substring(0,3).equals("PLP")) {
			return this.controleVotacao.realizarVotacao(codigo, local, cont, listaDni.size(), "PLP");
		} else {
			return this.controleVotacao.realizarVotacao(codigo, local, cont, listaDni.size(), "PL");
		}
	
	}
	
	private int contarDeputados() {
		int cont = 0;
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		pessoas.addAll(this.controlePessoa.getMapPessoa().values());
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getFuncao() != null) {
				cont ++;
			}
		}
		
		return cont;
	}
	
	
	public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {		
		Validacao.validarString(codigo, "Erro ao votar proposta: codigo nao pode ser vazio ou nulo");
		Validacao.validarString(statusGovernista, "Erro ao votar proposta: status governista nao pode ser vazio ou nulo");
		Validacao.validarString(presentes, "Erro ao votar proposta: presentes nao pode ser vazio ou nulo");
		if (!statusGovernista.equals("GOVERNISTA") && !statusGovernista.equals("OPOSICAO") && !statusGovernista.equals("LIVRE")) {
			throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
		} else if (!this.controleProjeto.getMapProjetos().containsKey(codigo)) {
			throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
		} else if (this.controleProjeto.getMapProjetos().get(codigo).getSituacao().equals("EM VOTACAO") && !this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("plenario") && !this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("Plenario - 1o turno") && !this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("Plenario - 2o turno")) {
			throw new IllegalArgumentException("Erro ao votar proposta: tramitacao em comissao");
		} else if (criaArrayDni(presentes).size() < contarDeputados() / 2) {
			throw new IllegalArgumentException("Erro ao votar proposta: quorum invalido");
		}else if ((this.controleProjeto.getMapProjetos().get(codigo).getSituacao().equals("ARQUIVADO") || this.controleProjeto.getMapProjetos().get(codigo).getSituacao().equals("APROVADO")) && this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("-")){			
			throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
		}
		
		boolean votacao = votacaoPlenario(codigo, statusGovernista, presentes, this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao());
		String dni = this.controleProjeto.getMapProjetos().get(codigo).getDni();
		if (votacao) {
			if (this.controleProjeto.getMapProjetos().get(codigo).getCodigo().substring(0, 3).equals("PL ")) {
				this.controleProjeto.getMapProjetos().get(codigo).setSituacao("APROVADO");
				this.controlePessoa.getMapPessoa().get(dni).getFuncao().setQtdLeis(this.controlePessoa.getMapPessoa().get(dni).getFuncao().getQtdLeis() + 1);
				this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao("-");
			} else {
				if (this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("Plenario - 1o turno")) {
				this.controleProjeto.getMapProjetos().get(codigo).setSituacao("EM VOTACAO");
				this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao("Plenario - 2o turno");
				} else if (this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("Plenario - 2o turno")) {
					this.controleProjeto.getMapProjetos().get(codigo).setSituacao("APROVADO");
					this.controlePessoa.getMapPessoa().get(dni).getFuncao().setQtdLeis(this.controlePessoa.getMapPessoa().get(dni).getFuncao().getQtdLeis() + 1);
					this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao("-");
				}			
			}
		} else {
			if (this.controleProjeto.getMapProjetos().get(codigo).getCodigo().substring(0,3).equals("PL ")) {
				this.controleProjeto.getMapProjetos().get(codigo).setSituacao("ARQUIVADO");
				this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao("-");
			} else {
				this.controleProjeto.getMapProjetos().get(codigo).setSituacao("ARQUIVADO");
				this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao("-");
			}
		}
		
		return votacao;
	}
	
	public String exibirTramitacao(String codigo) {
		Validacao.validarString(codigo, "Erro ao exibir tramitacao: codigo nao pode ser vazio ou nulo");
		if (!this.controleProjeto.getMapProjetos().containsKey(codigo)) {
			throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
		}
		
		if (this.controleProjeto.getMapProjetos().get(codigo).getSituacao().equals("EM VOTACAO")) {
			return this.controleVotacao.exibirTramitacao(codigo) + ", " + this.controleProjeto.getMapProjetos().get(codigo).getSituacao() + " (" + this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao() +").";
		}
		
		return this.controleVotacao.exibirTramitacao(codigo) + ".";
	}
	
	public void configurarEstrategiaPropostaRelacionada(String dni, String estrategia) {
		Validacao.validarString(dni, "Erro ao configurar estrategia: dni nao pode ser vazio ou nulo");
		Validacao.validarString(estrategia, "Erro ao configurar estrategia: estrategia nao pode ser vazio ou nulo");
		Validacao.verificaDni(dni, "Erro ao configurar estrategia: dni invalido");
		if (!estrategia.equals("CONSTITUCIONAL") || !estrategia.equals("CONCLUSAO") || !estrategia.equals("APROVACAO")) {
			throw new IllegalArgumentException("Erro ao configurar estrategia: estrategia invalida");
		} else if (!this.controlePessoa.getMapPessoa().containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao configurar estrategia: pessoa inexistente");
		} else if (this.controlePessoa.getMapPessoa().get(dni).getFuncao() == null){ 
			throw new IllegalArgumentException("Erro ao configurar estrategia: pessoa nao eh deputado");
		}
		
		this.controlePessoa.getMapPessoa().get(dni).getFuncao().setEstrategia(estrategia);
	}
	
	private ArrayList<String> contagemProjInteressesDep(String dni) {
		ArrayList<String> projetos = new ArrayList<>(this.controleProjeto.getMapProjetos().keySet());
		String [] interessesDep = this.controlePessoa.getMapPessoa().get(dni).getInteresses().split(",");
		String projetoInteresseMaior = "";
		int cont = 0;
		int contAux = 0;
		for (String codigoProj : projetos) {
			String [] interessesProj = this.controleProjeto.getMapProjetos().get(codigoProj).getInteresses().split(",");
			for (String interesseProj : interessesProj) {
				for (String interesse : interessesDep) {
					if (interesseProj.contains(interesse)) {
						cont++;
						break;
					}
				}
			}

			if(cont > 0 && cont > contAux) {
				projetoInteresseMaior = codigoProj;
				contAux = cont;
			}else if(cont > 0 && cont == contAux) {
				projetoInteresseMaior += "," + codigoProj;
			}
			cont = 0;
		}
		
		ArrayList<String> listaProjetos = new ArrayList<>();
		String[] projeto = projetoInteresseMaior.split(",");
		for (String proj : projeto) {
			listaProjetos.add(proj);
		}
		
		return listaProjetos;
	}
	
	
	private String propostaRelacionada(String dni) {
		ArrayList<String> listaProjetos = contagemProjInteressesDep(dni);
		NomeComparador comparador =  new NomeComparador();
		Collections.sort(listaProjetos, comparador);
		//listaProjetos.sort(Collator.getInstance());
		System.out.println(listaProjetos);
		if (this.controlePessoa.getMapPessoa().get(dni).getFuncao().getEstrategia().equals("CONSTITUCIONAL")) {
			if (listaProjetos.size() == 1) {
				return listaProjetos.get(0);
			} else {
				
				return listaProjetos.get(0);
			}
		} else if (this.controlePessoa.getMapPessoa().get(dni).getFuncao().getEstrategia().equals("CONCLUSAO")) {
			if (listaProjetos.size() == 1) {
				return listaProjetos.get(0);
			} else {
				return listaProjetos.get(0);
			}
		}else {
			if (listaProjetos.size() == 1) {
				return listaProjetos.get(0);
			} else {
				return listaProjetos.get(0);
			}
		}
			
	}
	
	public String pegarPropostaRelacionada(String dni) {
		Validacao.validarString(dni, "Erro ao pegar proposta: dni nao pode ser vazio ou nulo");
		Validacao.verificaDni(dni, "Erro ao pegar proposta: dni invalido");
		if (!this.controlePessoa.getMapPessoa().containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao pegar proposta: pessoa inexistente");
		} else if (this.controlePessoa.getMapPessoa().get(dni).getFuncao() == null){ 
			throw new IllegalArgumentException("Erro ao pegar proposta: pessoa nao eh deputado");
		}
		
		//System.out.println(contagemProjInteressesDep(dni));
		
		return this.controleProjeto.getMapProjetos().get(propostaRelacionada(dni)).toString();
	}
	
}
