package projetoLP2;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
	
/**
 * Representacao do sistema de controle de 
 * de pessoas para cadastrar tais pessoas.
 * 
 * @author Andre Santana e Caio Arruda
 *
 */
public class CrudPessoa {
	
	/**
	 * Representa um mapa de pessoas.
	 */
	private HashMap<String, Pessoa> mapPessoa;
	
	/**
	 * Representa um mapa de Deputados.
	 */
	private HashMap<String, Deputado> mapaDeputados;

	/**
	 * Constroi um crud de pessoas.
	 * 
	 * @param mapPessoa
	 * @param mapaDeputados
	 */
	public CrudPessoa() {
		this.mapPessoa = new HashMap<>();
		this.mapaDeputados = new HashMap<>();
	}
	
	/**
	 * retorna mapa de pessoa.
	 * 
	 * @return mapPessoa
	 */
	public HashMap<String, Pessoa> getMapPessoa() {
		return mapPessoa;
	}
	
	/**
	 * metodo criado para verificar se o documento nacional de
	 * identificacao possui os caracteres corretos, composto 
	 * apenas por numeros e o traco (-).
	 * 
	 * @param dni
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
	 * Cadastra pessoa no mapa de pessoa, tendo como identificador o documento
	 * nacional de identificacao, cadastrando o nome, o documento nacional de 
	 * identificacao, o Estado, e os interesses se tal pessoa tiver.
	 * 
	 * @param nome, o nome da pessoa
	 * @param dni, documento nacional de identificacao da pessoa
	 * @param estado, Estado de origem da pessoa
	 * @param interesses, interesses da pessoa
	 * @throws IllegalArgumentException, campo nome nao pode ser vazio ou nulo!
	 * @throws IllegalArgumentException, campo DNI nao pode ser vazio ou nulo!
	 * @throws IllegalArgumentException, campo Estado nao pode ser vazio ou nulo!
	 * @throws IllegalArgumentException, campo DNI invalido!
	 * @throws IllegalArgumentException, pessoa ja cadastrada!
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
	 * Cadastra pessoa no mapa de pessoa, tendo como identificador o documento
	 * nacional de identificacao, cadastrando o nome, o documento nacional de 
	 * identificacao, o Estado da pessoa e caso tenha interesses e partido 
	 * ocorre tambem o cadastradamento de tais.
	 * 
	 * @param nome, o nome da pessoa
	 * @param dni, documento nacional de identificacao da pessoa
	 * @param estado, Estado de origem da pessoa
	 * @param interesses, interesses da pessoa
	 * @param partido, partido politico da pessoa
	 * @throws IllegalArgumentException, campo nome nao pode ser vazio ou nulo!
	 * @throws IllegalArgumentException, campo DNI nao pode ser vazio ou nulo!
	 * @throws IllegalArgumentException, campo Estado nao pode ser vazio ou nulo!
	 * @throws IllegalArgumentException, campo partido nao pode ser vazio ou nulo!
	 * @throws IllegalArgumentException, campo DNI invalido!
	 * @throws IllegalArgumentException, pessoa ja cadastrada!
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
	 * Cadastra um deputado a partir de sua DNI e a data de inicio de mandato se forem válidas
	 * @param dni, dni da pessoa
	 * @param dataDeInicio, data de inicio do mandato 
	 * @throws IllegalArgumentException, Campo dni nao pode ser vazio ou nulo
	 * @throws IllegalArgumentException, Campo dni invalido
	 * @throws IllegalArgumentException, pessoa nao encontrada
	 * @throws IllegalArgumentException, data nao pode ser vazio ou nulo
	 * @throws IllegalArgumentException, pessoa sem partido
	 * @throws IllegalArgumentException, deputado ja existe
	 */
	
	public void cadastrarDeputado(String dni, String dataDeInicio) {
		
		if (dni == null || dni.isEmpty()) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
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
		if (mapaDeputados.containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: deputado já existe");
		} 
		Deputado deputado = new Deputado(this.mapPessoa.get(dni), dataDeInicio);
		this.mapaDeputados.put(dni, deputado);
		
		
	}
	/**
	 * Valida a data 
	 * @param dataDeInicio, data de inicio de mandato
	 * @throws java.text.ParseException 
	 */
	public void validaData(String dataDeInicio) {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
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
}
