package projetoLP2;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
	
/**
 * Representação de um Controle de Pessoa, responsável por cadastrar uma pessoa, deputado ou listar pessoa.
 * 
 * @author Andre Santana, Caio Arruda, João Vitor e Sheila Paiva
 */
public class ControlePessoa {
	
	/**
	 * Mapa de pessoas.
	 */
	private HashMap<String, Pessoa> mapPessoa;
	
	/**
	 * Mapa de Deputados.
	 
	private HashMap<String, Deputado> mapDeputados;

	/**
	 * Constroi um controle de pessoas.
	 */
	public ControlePessoa() {
		this.mapPessoa = new HashMap<>();
		//this.mapDeputados = new HashMap<>();
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
		if (nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		} else if (dni == null || dni.isEmpty()) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		} else if (estado == null || estado.isEmpty()) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		} else if (!verificaDni(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni invalido");
		} else if (this.mapPessoa.containsKey(dni)) {
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
		if (nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		} else if (dni == null || dni.isEmpty()) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		} else if (estado == null || estado.isEmpty()) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		} else if (!verificaDni(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni invalido");
		} else if (this.mapPessoa.containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
		}
		Pessoa p = new Pessoa(nome, dni, estado, interesses, partido);
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
		if (dni == null || dni.isEmpty()) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: dni nao pode ser vazio ou nulo");
		} else if(!verificaDni(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: dni invalido");
		} else if(!this.mapPessoa.containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa nao encontrada");
		}else if (dataDeInicio == null || dataDeInicio.isEmpty()) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: data nao pode ser vazio ou nulo");
		} else if (this.mapPessoa.get(dni).getPartido() == null) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa sem partido");
		} 
		validaData(dataDeInicio);
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
		if(dni == null || dni.isEmpty()){
			throw new IllegalArgumentException("Erro ao exibir pessoa: dni nao pode ser vazio ou nulo");
		}else if(!verificaDni(dni)){
			throw new IllegalArgumentException("Erro ao exibir pessoa: dni invalido");
		}else if(!this.mapPessoa.containsKey(dni)){
			throw new IllegalArgumentException("Erro ao exibir pessoa: pessoa nao encontrada");
		} 
		return this.mapPessoa.get(dni).toString();
	}
}
