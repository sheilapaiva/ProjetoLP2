package controladores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;

import entidades.Comissao;
import entidades.Pessoa;
import entidades.Pl;
import entidades.Projeto;
import entidades.Validacao;

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
	 *  Dados. 
	 */
	private Armazenamento dados;
	
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
		this.dados = new Armazenamento();
	}
	
	/**
	 * Carrega o sistema.
	 */
	public void carregarSistema() {
		this.dados.ler("controleComissao.bin");
		this.dados.ler("controlePartido.bin");
		this.dados.ler("controlePessoa.bin");
		this.dados.ler("controleProjeto.bin");
		this.dados.ler("controleVotacao.bin");
	}
	
	/**
	 * Limpa o sistema.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void limparSistema()  {
		this.dados.limpar("controleComissao.bin");
		this.dados.limpar("controlePartido.bin");
		this.dados.limpar("controlePessoa.bin");
		this.dados.limpar("controleProjeto.bin");
		this.dados.limpar("controleVotacao.bin");
		
	}
	
	/**
	 * Salva o sistema.
	 */
	public void salvarSistema() {
		this.dados.salvarObjeto(controleComissao, "controleComissao.bin");
		this.dados.salvarObjeto(controlePartido, "controlePartido.bin");
		this.dados.salvarObjeto(controlePessoa, "controlePessoa.bin");
		this.dados.salvarObjeto(controleProjeto, "controleProjeto.bin");
		this.dados.salvarObjeto(controleVotacao, "controleVotacao.bin");
		
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
	
	/**
	 * Cria um ArrayListe de Dni de politicos passados por parametro.
	 * 
	 * @param politicos, os politicos
	 * @return ArrayList de dni.
	 */
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
	 * Cadastra uma comissao. A partir do tema e da lista de politicos.
	 * 
	 * @param tema, tema da comissao
	 * @param politicos, lista de politicos 
	 * @throws IllegalArgumentException, tema existente
	 */
	public void cadastrarComissao(String tema, String politicos) {
		Validacao.validarString(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
		Validacao.validarString(politicos, "Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo");
		if (this.controleComissao.getMapComissao().containsKey(tema)) {
			throw new IllegalArgumentException("Erro ao cadastrar comissao: tema existente");
		}
		
		this.controleComissao.cadastrarComissao(tema, criaListaPoliticos(politicos));
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
	 * @throws IllegalArgumentException, pessoa inexistente
	 * @throws IllegalArgumentException, pessoa nao eh deputado
	 * @return codigo gerado do projeto
	 */
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
	
	/**
	 * Cadastra uma PLP. A partir do dni, ano, ementa, interesses, url e artigos.
	 * 
     * @param dni, o numero do projeto
     * @param ano, o ano do projeto
     * @param ementa, as ementas do projeto
     * @param interesses, os interesses do projeto
     * @param url, a url do projeto
	 * @param artigos, os artigos do projeto
	 * @throws IllegalArgumentException, pessoa inexistente
	 * @throws IllegalArgumentException, pessoa nao eh deputado
	 * @return codigo gerado do projeto
	 */
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
	
	/**
	 * Cadastra uma PEC. A partir do dni, ano, ementa, interesses, url e artigos.
	 * 
     * @param dni, o numero do projeto
     * @param ano, o ano do projeto
     * @param ementa, as ementas do projeto
     * @param interesses, os interesses do projeto
     * @param url, a url do projeto
	 * @param artigos, os artigos do projeto
	 * @throws IllegalArgumentException, pessoa inexistente
	 * @throws IllegalArgumentException, pessoa nao eh deputado
	 * @return codigo gerado do projeto
	 */
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
	
	/**
	 * Exibe um projeto, a partir do codigo passado no parametro.
	 * 
	 * @param codigo
	 * @throws IllegalArgumentException, projeto inexistente
	 * @return uma String que representa o projeto
	 */
	public String exibirProjeto(String codigo) {
		Validacao.validarString(codigo, "Erro ao exibir projeto: projeto nao pode ser vazio ou nulo");
		if (!this.controleProjeto.getMapProjetos().containsKey(codigo)) {
			throw new IllegalArgumentException("Erro ao exibir projeto: projeto inexistente");
		}
		
		return this.controleProjeto.exibirProjeto(codigo);
	}
	
	/**
	 * Conta quantos deputados fazem parte da base governista.
	 * 
	 * @param dni, lista de dni de deputados
	 * @return inteiro referete a quantidade de deputados da base
	 */
	private int contagemBase(ArrayList<String> dni) {
		int cont = 0;
		for (int i = 0; i < dni.size(); i++) {
			if (this.controlePartido.getPartidos().contains(this.controlePessoa.getMapPessoa().get(dni.get(i)).getPartido())) {
				cont++;
			}
		}
		
		return cont;
	}
	
	/**
	 * Conta os interesses em comum dos deputados da lista com os interesses passados tambem como parametro.
	 * 
	 * @param dni, a lista de dni
	 * @param interesses, os interesses
	 * @return inteiro referente a contagem de interesses
	 */
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
	
	/**
	 * Vota o projeto em uma comissao
	 * 
	 * @param codigo, o codigo do projeto
	 * @param status, o status da votacao
	 * @throws IllegalArgumentException, comissao nao cadastrada
	 * @return boolean referente ao resultado da votacao
	 */
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
	
	/**
	 * Vota o projeto em uma comissao, com o codigo, o status da votacao e o proximo local passados por parametro.
	 * 
	 * @param codigo, o codigo do projeto.
	 * @param statusGovernista, o status da votacao
	 * @param proximoLocal, o proximo local de votacao
	 * @throws IllegalArgumentException, status invalido
	 * @throws IllegalArgumentException, projeto inexistente
	 * @throws IllegalArgumentException, proposta encaminhada para plenario
	 * @throws IllegalArgumentException, tramitacao encerrada
	 * @return boolean referente ao resultado da votacao
	 */
	public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
		Validacao.validarString(codigo, "Erro ao votar proposta: codigo nao pode ser vazio ou nulo");
		Validacao.validarString(statusGovernista, "Erro ao votar proposta: status governista nao pode ser vazio ou nulo");
		Validacao.validarString(proximoLocal, "Erro ao votar proposta: proximo local vazio");
		if (!statusGovernista.equals("GOVERNISTA") && !statusGovernista.equals("OPOSICAO") && !statusGovernista.equals("LIVRE")) {
			throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
		} else if (!this.controleProjeto.getMapProjetos().containsKey(codigo)) {
			throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
		}else if (this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("Plenario") || this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("Plenario - 1o turno") || this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("Plenario - 2o turno")) {
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
					if (proximoLocal.equals("plenario")) {
						this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao("Plenario");
					} else {
						this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao(proximoLocal);
					}
				} else {
					if (proximoLocal.equals("plenario")) {
						this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao("Plenario - 1o turno");
					} else {
						this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao(proximoLocal);
					}
				}
			}
		} else {
			if (this.controleProjeto.getMapProjetos().get(codigo).getCodigo().substring(0,3).equals("PL ")){
				if (proximoLocal.equals("plenario") && ((Pl)this.controleProjeto.getMapProjetos().get(codigo)).getConclusivo()) {
					this.controleProjeto.getMapProjetos().get(codigo).setSituacao("EM VOTACAO");
					this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao("Plenario");	
				} else {
					this.controleProjeto.getMapProjetos().get(codigo).setSituacao("ARQUIVADO");
					this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao(proximoLocal);
				}
				
			} else {
				this.controleProjeto.getMapProjetos().get(codigo).setSituacao("ARQUIVADO");
				if (proximoLocal.equals("plenario")) {
					this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao("Plenario");	
				} else {
				this.controleProjeto.getMapProjetos().get(codigo).setNomeComissao(proximoLocal);
				}
			}	
		}

		return votacao;	
	}
	
	/**
	 * Cria um array de dni de politicos
	 * 
	 * @param politicos, os politicos
	 * @return ArrayList de Strings com o dni dos politicos
	 */
	private ArrayList<String> criaArrayDni(String politicos){
		String[] listaPoliticos = politicos.split(",");
		ArrayList<String> listaDni = new ArrayList<String>();
		for (String dni : listaPoliticos) {
			listaDni.add(dni);
		}
		
		return listaDni;
	}
	
	/**
	 * Vota o projeto no plenario.
	 * 
	 * @param codigo, o codigo do projeto.
	 * @param statusGovernista, o status da votacao
	 * @param presentes, os deputados presentes na votacao
	 * @param local, o local da votacao
	 * @return boolean referente ao resultado da votacao
	 */
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
	
	/**
	 * Conta os deputados cadastrados no sistema.
	 * 
	 * @return inteiro referente a quantidade de deputados cadastrados
	 */
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
	
	/**
	 * Vota o projeto no plenario, com o codigo,, status e os presentes passados por parametro.
	 * 
	 * @param codigo, o codigo do projeto.
	 * @param statusGovernista, o status da votacao
	 * @param presentes, os deputados presentes na votacao
	 * @throws IllegalArgumentException, status invalido
	 * @throws IllegalArgumentException, projeto inexistente
	 * @throws IllegalArgumentException, tramitacao em comissao
	 * @throws IllegalArgumentException, quorum invalido
	 * @throws IllegalArgumentException, tramitacao encerrada
	 * @return boolean referente ao resultado da votacao
	 */
	public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {		
		Validacao.validarString(codigo, "Erro ao votar proposta: codigo nao pode ser vazio ou nulo");
		Validacao.validarString(statusGovernista, "Erro ao votar proposta: status governista nao pode ser vazio ou nulo");
		Validacao.validarString(presentes, "Erro ao votar proposta: presentes nao pode ser vazio ou nulo");
		if (!statusGovernista.equals("GOVERNISTA") && !statusGovernista.equals("OPOSICAO") && !statusGovernista.equals("LIVRE")) {
			throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
		} else if (!this.controleProjeto.getMapProjetos().containsKey(codigo)) {
			throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
		} else if (this.controleProjeto.getMapProjetos().get(codigo).getSituacao().equals("EM VOTACAO") && !this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("Plenario") && !this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("Plenario - 1o turno") && !this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao().equals("Plenario - 2o turno")) {
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
	
	/**
	 * Exibe a tramitacao da proposta com o codigo passado por parametro.
	 *  
	 * @param codigo, o codigo do projeto
	 * @throws IllegalArgumentException, projeto inexistente
	 * @return String referente a tramitacao do projeto
	 */
	public String exibirTramitacao(String codigo) {
		Validacao.validarString(codigo, "Erro ao exibir tramitacao: codigo nao pode ser vazio ou nulo");
		if (!this.controleProjeto.getMapProjetos().containsKey(codigo)) {
			throw new IllegalArgumentException("Erro ao exibir tramitacao: projeto inexistente");
		}
		
		if (!this.controleVotacao.getMapVotacao().containsKey(codigo)) {
			return this.controleProjeto.getMapProjetos().get(codigo).getSituacao() + " (" + this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao() +")";
		} else if (this.controleProjeto.getMapProjetos().get(codigo).getSituacao().equals("EM VOTACAO")) {
			return this.controleVotacao.exibirTramitacao(codigo) + ", " + this.controleProjeto.getMapProjetos().get(codigo).getSituacao() + " (" + this.controleProjeto.getMapProjetos().get(codigo).getNomeComissao() +")";
		}
		
		return this.controleVotacao.exibirTramitacao(codigo);
	}
	
	/**
	 * Configura a estrategia de um deputado. Com o dni passado por parametro e a estrategia.
	 * 
	 * @param dni, deni do deputado
	 * @param estrategia, estrategia do deputado
	 * @throws IllegalArgumentException, estrategia invalida
	 * @throws IllegalArgumentException, pessoa inexistente
	 */
	public void configurarEstrategiaPropostaRelacionada(String dni, String estrategia) {
		Validacao.validarString(dni, "Erro ao configurar estrategia: pessoa nao pode ser vazia ou nula");
		Validacao.verificaDni(dni, "Erro ao configurar estrategia: dni invalido");
		Validacao.validarString(estrategia, "Erro ao configurar estrategia: estrategia vazia");
		
		if (!estrategia.equals("CONSTITUCIONAL") && !estrategia.equals("CONCLUSAO") && !estrategia.equals("APROVACAO")) {
			throw new IllegalArgumentException("Erro ao configurar estrategia: estrategia invalida");
		} else if (!this.controlePessoa.getMapPessoa().containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao configurar estrategia: pessoa inexistente");
		}
		
		this.controlePessoa.getMapPessoa().get(dni).setEstrategia(estrategia);
	}
	
	/**
	 * Conta os interesses em comum do deputados passado por parametro com os projetos em tramitacao.
	 * 
	 * @param dni, o dni do deputado
	 * @return ArrayList referente aos codigos dos projetos com mais interesses em comum com o deputado
	 */
	private ArrayList<String> contagemProjInteressesDep(String dni) {
		ArrayList<String> projetos = new ArrayList<String>(this.controleProjeto.getMapProjetos().keySet());
		String [] interessesDep = this.controlePessoa.getMapPessoa().get(dni).getInteresses().split(",");
		String projetoInteresseMaior = "";
		int cont = 0;
		int contAux = 0;
		for (String codigoProj : projetos) {
			if (this.controleProjeto.getMapProjetos().get(codigoProj).getSituacao().equals("EM VOTACAO")) {
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
		}
		
		ArrayList<String> listaProjetos = new ArrayList<String>();
		String[] projeto = projetoInteresseMaior.split(",");
		for (String proj : projeto) {
			listaProjetos.add(proj);
		}
	
		return listaProjetos;
	}
	
	/**
	 * Ordena o ArrayList de codigos dos projetos de acordo com a estrategia Constitucional.
	 * 
	 * @param listaProjetos, ArrayList de projetos
	 * @return ArrayList ordenado
	 */
	private ArrayList<String> constitucionalSort(ArrayList<String> listaProjetos){
        boolean troca = true;
        String aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < listaProjetos.size() - 1; i++) {
                if (listaProjetos.get(i).substring(0, 3).equals("PL ") && listaProjetos.get(i + 1).substring(0, 3).equals("PEC")) {
                	aux = listaProjetos.get(i);
                    listaProjetos.set(i, listaProjetos.get(i + 1));
                    listaProjetos.set(i + 1, aux);
                    troca = true;
                } else if (listaProjetos.get(i).substring(0, 3).equals("PLP") && listaProjetos.get(i + 1).substring(0, 3).equals("PEC")) {
                	aux = listaProjetos.get(i);
                    listaProjetos.set(i, listaProjetos.get(i + 1));
                    listaProjetos.set(i + 1, aux);
                    troca = true;
                } else if (listaProjetos.get(i).substring(0, 3).equals("PL ") && listaProjetos.get(i + 1).substring(0, 3).equals("PLP")) {
                    aux = listaProjetos.get(i);
                    listaProjetos.set(i, listaProjetos.get(i + 1));
                    listaProjetos.set(i + 1, aux);
                    troca = true;
                }
            }
        } 
        
        return listaProjetos;
	}
	
	/**
	 * Ordena o ArrayList de codigos dos projetos de acordo com a estrategia Conclusao.
	 * 
	 * @param listaProjetos, ArrayList de projetos
	 * @return ArrayList ordenado
	 */
	private ArrayList<String> conclusaoSort(ArrayList<String> listaProjetos){
		boolean troca = true;
        String aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < listaProjetos.size() - 1; i++) {
            	if (this.controleProjeto.getMapProjetos().get(listaProjetos.get(i)).getSituacao().equals("Plenario - 2o turno") && !this.controleProjeto.getMapProjetos().get(listaProjetos.get(i + 1)).getSituacao().equals("Plenario - 2o turno")) {
            		listaProjetos.remove(i + 1);
                    troca = true;
                    break;
                } else if (this.controleProjeto.getMapProjetos().get(listaProjetos.get(i)).getSituacao().equals("Plenario - 1o turno") && !this.controleProjeto.getMapProjetos().get(listaProjetos.get(i + 1)).getSituacao().equals("Plenario - 1o turno") && !this.controleProjeto.getMapProjetos().get(listaProjetos.get(i + 1)).getSituacao().equals("Plenario - 2o turno")) {
                	listaProjetos.remove(i + 1);
            		aux = listaProjetos.get(i);
                    listaProjetos.set(i, listaProjetos.get(i + 1));
                    listaProjetos.set(i + 1, aux);
                    troca = true;
                    break;
        		} else if (!this.controleProjeto.getMapProjetos().get(listaProjetos.get(i)).getNomeComissao().equals("CCJC") && this.controleProjeto.getMapProjetos().get(listaProjetos.get(i + 1)).getNomeComissao().equals("CCJC")) {
        			listaProjetos.remove(i + 1);
        			System.out.println("kkkkk");
            		
        			aux = listaProjetos.get(i);
                    listaProjetos.set(i, listaProjetos.get(i + 1));
                    listaProjetos.set(i + 1, aux);
        			System.out.println("entrou aq");
                    troca = true;
                    break;
        		} 
            }
        }      
       
        System.out.println(listaProjetos);
        if (listaProjetos.size() > 1) {
        	
        }
	        troca = true;
	        while (troca) {
	            troca = false;
	            for (int i = 0; i < listaProjetos.size() - 1; i++) {
	            	System.out.println(this.controleProjeto.getMapProjetos().get(listaProjetos.get(i)).getAno());
	            	System.out.println(this.controleProjeto.getMapProjetos().get(listaProjetos.get(i + 1)).getAno());
	
	            	if (this.controleProjeto.getMapProjetos().get(listaProjetos.get(i)).getAno() > this.controleProjeto.getMapProjetos().get(listaProjetos.get(i + 1)).getAno()) {
				        			aux = listaProjetos.get(i);
				                    listaProjetos.set(i, listaProjetos.get(i + 1));
				                    listaProjetos.set(i + 1, aux);
				                    listaProjetos.remove(i);
				                    troca = true;
				                    System.out.println("kkkkk");
				                   break;
	                	}
	               	 
	                else if (this.controleProjeto.getMapProjetos().get(listaProjetos.get(i)).getAno() == this.controleProjeto.getMapProjetos().get(listaProjetos.get(i + 1)).getAno()) {
	                	System.out.println(this.controleProjeto.getMapProjetos().get(listaProjetos.get(i)).getNum());
	                	System.out.println(this.controleProjeto.getMapProjetos().get(listaProjetos.get(i + 1)).getNum());
	                	  if (this.controleProjeto.getMapProjetos().get(listaProjetos.get(i)).getNum() > this.controleProjeto.getMapProjetos().get(listaProjetos.get(i + 1)).getNum()) {
			                	aux = listaProjetos.get(i);
			                    listaProjetos.set(i, listaProjetos.get(i + 1));
			                    listaProjetos.set(i + 1, aux);
			                    listaProjetos.remove(i);
			                    System.out.println("kkkassskk");
			                    troca = true;
			                    break;
	                		}
		                  
		            }
                
                }
        }  
  
        return listaProjetos;
		
	}

	/**
	 * Exibe a proposta mais relacionada com o deputado com o dni passado por parametro, respeitando os criterios de empate.
	 *  
	 * @param dni, o dni do deputado
	 * @return String referente ao codigo do projeto mais relacionado
	 */
	private String propostaRelacionada(String dni) {
		ArrayList<String> listaProjetos = contagemProjInteressesDep(dni);	

		if (listaProjetos.get(0).equals("")) {
			return "";
		} else {
			if (this.controlePessoa.getMapPessoa().get(dni).getEstrategia().equals("CONSTITUCIONAL")) {
				listaProjetos.sort(Collator.getInstance());
				listaProjetos = constitucionalSort(listaProjetos);
				return listaProjetos.get(0);
			} else if (this.controlePessoa.getMapPessoa().get(dni).getEstrategia().equals("CONCLUSAO")) {
				System.out.println(listaProjetos);
				//listaProjetos.sort(Collator.getInstance());
				//System.out.println(listaProjetos);
				listaProjetos = constitucionalSort(listaProjetos);
				//listaProjetos.sort(Collator.);
				listaProjetos = conclusaoSort(listaProjetos);
				System.out.println("aq o: " + listaProjetos);
				return listaProjetos.get(0);
			}else {
				
				
				return listaProjetos.get(0);
			}
		}
	}
	
	/**
	 * Exibe a proposta mais relacionada com o deputado com o dni passado cpor parametro.
	 *  
	 * @param dni, o dni do deputado
	 * @throws IllegalArgumentException, pessoa inexistente
	 * @return String referente ao codigo do projeto mais relacionado
	 */
	public String pegarPropostaRelacionada(String dni) {
		Validacao.verificaDni(dni, "Erro ao pegar proposta relacionada: dni invalido");
		Validacao.validarString(dni, "Erro ao pegar proposta relacionada: pessoa nao pode ser vazia ou nula");
		if (!this.controlePessoa.getMapPessoa().containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao pegar proposta relacionada: pessoa inexistente");
		} 
	
		return propostaRelacionada(dni);
	}
	
}
