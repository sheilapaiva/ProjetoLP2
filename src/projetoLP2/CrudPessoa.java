package projetoLP2;


import java.util.HashMap;
	
/**
 * Representacao do sistema de controle de 
 * de pessoas para cadastrar tais pessoas.
 * 
 * @author Andre Santana
 *
 */
public class CrudPessoa {
	
	/**
	 * Representa um mapa de pessoas.
	 */
	private HashMap<String, Pessoa> mapPessoa;

	/**
	 * Constroi um crud de pessoas.
	 * 
	 * @param mapPessoa
	 */
	public CrudPessoa() {
		this.mapPessoa = new HashMap<>();
	}
	
	/**
	 * pega mapa de pessoa.
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
	private boolean verificaDni(String dni) {
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

}
