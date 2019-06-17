package projetoLP2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
	
/**
 * Representação de um Controle de Pessoa, responsável por cadastrar uma pessoa, deputado ou listar pessoa.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class ControlePessoa {
	
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
	 * Retorne a um boolean, depois de verificar se o documento nacional de
	 * identificacao possui os caracteres corretos, composto 
	 * apenas por numeros e o traco(-).
	 * 
	 * @param dni, o dni da pessoa
	 * @return um valor boolean
	 */
	public boolean verificaDni(String dni) {
		for (int i = 0 ; i < dni.length(); i++ ) {
			if (!Character.isDigit(dni.charAt(i)) && !(dni.charAt(i) == '-')) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Cadastra uma pessoa no mapa de pessoa. A partir do nome, identificador, estado e interesses
	 * da pessoa. Se esses campos não estiverem nulos ou vazios e forem validos. Usa o identficador 
	 * como chave para o mapa.
	 * 
	 * @param nome, o nome da pessoa
	 * @param dni, documento nacional de identificacao da pessoa
	 * @param estado, Estado de origem da pessoa
	 * @param interesses, interesses da pessoa
	 * @throws IllegalArgumentException, campo nome nao pode ser vazio ou nulo
	 * @throws IllegalArgumentException, campo dni nao pode ser vazio ou nulo
	 * @throws IllegalArgumentException, campo Estado nao pode ser vazio ou nulo
	 * @throws IllegalArgumentException, campo dni invalido
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
	 * e o partido da pessoa. Se esses campos não estiverem nulos ou vazios e forem validos. 
	 * Usa o identficador como chave para o mapa.
	 * 
	 * @param nome, o nome da pessoa
	 * @param dni, documento nacional de identificacao da pessoa
	 * @param estado, Estado de origem da pessoa
	 * @param interesses, interesses da pessoa
	 * @param partido, partido da pessoa
	 * @throws IllegalArgumentException, campo nome nao pode ser vazio ou nulo
	 * @throws IllegalArgumentException, campo dni nao pode ser vazio ou nulo
	 * @throws IllegalArgumentException, campo Estado nao pode ser vazio ou nulo
	 * @throws IllegalArgumentException, campo dni invalido
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
	 * Se estas forem válidas, nao nulas ou vazias.
	 * 
	 * @param dni, dni da pessoa
	 * @param dataDeInicio, data de inicio do mandato 
	 * @throws IllegalArgumentException, campo dni nao pode ser vazio ou nulo
	 * @throws IllegalArgumentException, campo dni invalido
	 * @throws IllegalArgumentException, pessoa nao encontrada
	 * @throws IllegalArgumentException, data nao pode ser vazio ou nulo
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
	 * Verifica se a data é valida.
	 * 
	 * @param dataDeInicio, data de inicio de mandato
	 * @throws IllegalArgumentException, data futura
	 * @throws IllegalArgumentException, data invalida
	 */
	public void validaData(String dataDeInicio) {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		sdf.setLenient(false);
		Date dataAtual = new Date();
		try {
			Date dataDeInicio2 = sdf.parse(dataDeInicio);
			if(dataDeInicio2.compareTo(dataAtual) > 0) {
				throw new IllegalArgumentException("Erro ao cadastrar deputado: data futura");
			}
		} catch (ParseException pe) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: data invalida");
		}	
	}

	/**
	 * Retorna uma String representando a Pessoa com o dni passado como parametro.
	 * Se este for valido, nao for nulo ou vazio, e estiver cadastrado no mapa.
	 * A representação segue o formato para pessoa: "nome - dni (origen) - partido(se houver) 
	 * - Interessses: interesse, ..., interesse"
	 * A representação segue o formato para deputado: "POL: nome - dni (origen) - partido(se houver) - 
	 * Interessses: interesse, ..., interesse - data de inicio - quantidade de leis"
	 * 
	 * @param dni, o dni da pessoa
	 * @throws IllegalArgumentException, dni invalido
	 * @throws IllegalArgumentException, dni nao pode ser vazio ou nulo
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
