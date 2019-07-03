package controladores;

import java.io.Serializable;
import java.util.HashMap;

import entidades.Partido;
import entidades.Pessoa;
import entidades.Validacao;
	
/**
 * Representação de um Controle de Pessoa, responsável por cadastrar uma pessoa, deputado ou listar pessoa.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class ControlePessoa implements Serializable {
	
	/**
	 * Mapa de pessoas.
	 */
	private HashMap<String, Pessoa> mapPessoa;

	/**
	 * Constroi um controle de pessoas.
	 */
	public ControlePessoa() {
		this.mapPessoa = new HashMap<>();
	}
	
	/**
	 * Retorna um mapa que representa o mapa de comissoes.
	 * 
	 * @return um mapa que representa o mapa de comissoes
	 */
	public HashMap<String, Pessoa> getMapPessoa() {
		return mapPessoa;
	}

	/**
	 * Cadastra uma pessoa no mapa de pessoa. A partir do nome, identificador, estado e interesses
	 * da pessoa. Usa o identficador como chave para o mapa.
	 * 
	 * @param nome, o nome da pessoa
	 * @param dni, documento nacional de identificacao da pessoa
	 * @param estado, Estado de origem da pessoa
	 * @param interesses, interesses da pessoa
	 * @throws IllegalArgumentException, pessoa ja cadastrada
	 */
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
		if (this.mapPessoa.containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
		}
		Pessoa p = new Pessoa(nome, dni, estado, interesses);
		this.mapPessoa.put(dni, p);
	}
	
	/**
	 * Cadastra uma pessoa no mapa de pessoa. A partir do nome, identificador, estado, interesses
	 * e o partido da pessoa. Usa o identficador como chave para o mapa.
	 * 
	 * @param nome, o nome da pessoa
	 * @param dni, documento nacional de identificacao da pessoa
	 * @param estado, Estado de origem da pessoa
	 * @param interesses, interesses da pessoa
	 * @param partido, partido da pessoa
	 * @throws IllegalArgumentException, pessoa ja cadastrada
	 */
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
		if (this.mapPessoa.containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
		}
		Partido novoPartido = new Partido(partido);
		Pessoa p = new Pessoa(nome, dni, estado, interesses, novoPartido);
		this.mapPessoa.put(dni, p);
	}
	
	/**
	 * Cadastra um deputado no mapa de deputados a partir do seu dni e a data de inicio de mandato. 
	 *
	 * @param dni, dni da pessoa
	 * @param dataDeInicio, data de inicio do mandato 
	 * @throws IllegalArgumentException, pessoa sem partido
	 * @throws IllegalArgumentException, deputado ja existe
	 */
	public void cadastrarDeputado(String dni, String dataDeInicio) {
		if(!this.mapPessoa.containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa nao encontrada");
		} else if (this.mapPessoa.get(dni).getPartido() == null) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa sem partido");
		} 
		Validacao.validarString(dataDeInicio, "Erro ao cadastrar deputado: data nao pode ser vazio ou nulo");
		Validacao.validaData(dataDeInicio);
		this.mapPessoa.get(dni).setFuncao(dataDeInicio);
	}

	/**
	 * Retorna uma String representando a Pessoa com o dni passado como parametro.
	 * A representação segue o formato para pessoa: "nome - dni (origen) - partido(se houver) 
	 * - Interessses: interesse, ..., interesse"
	 * A representação segue o formato para deputado: "POL: nome - dni (origen) - partido(se houver) - 
	 * Interessses: interesse, ..., interesse - data de inicio - quantidade de leis"
	 * 
	 * @param dni, o dni da pessoa
	 * @throws IllegalArgumentException, pessoa nao encontrada
	 * @return uma String representando a Pessoa com o dni passado como parametro
	 */
	public String exibirPessoa(String dni){
		if(!this.mapPessoa.containsKey(dni)){
			throw new IllegalArgumentException("Erro ao exibir pessoa: pessoa nao encontrada");
		} 
		return this.mapPessoa.get(dni).toString();
	}
	
}
