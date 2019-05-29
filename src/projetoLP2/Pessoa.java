package projetoLP2;

/**
 * Representacao de pessoa que sera cadastrada no Sistema.
 * Identificado por nome, dni, origem, partido e interesses
 * da pessoa.
 * 
 * @author Andre Santana
 *
 */
public class Pessoa {
	
	/**
	 * nome da pessoa.
	 */
	private String nome;
	
	/**
	 * documento nacional de identificacao da pessoa.
	 */
	private String dni;
	
	/**
	 * Estado de origem da pessoa.
	 */
	private String origem;
	
	/**
	 * partido politico da pessoa (opcional).
	 */
	private String partido;
	
	/**
	 * interesses da pessoa.
	 */
	private String interesses;
	
	/**
	 * Constroi a pessoa a ser cadastrada no sistema, passando por parametro 
	 * o nome, o documento nacional de identificacao, o Estado de origem e
	 *  os interesses da pessoa.
	 * 
	 * @param nome
	 * @param dni
	 * @param origem
	 * @param interesses
	 */
	public Pessoa(String nome, String dni, String origem, String interesses) {
		this.nome = nome;
		this.dni = dni;
		this.origem = origem;
		this.interesses = interesses;
	}
	
	/**
	 * Constroi a pessoa a ser cadastrada no sistema, passando por parametro 
	 * o nome, o documento nacional de identificacao, o Estado de origem, os
	 * interesses e o partido politico da pessoa.
	 * @param nome
	 * @param dni
	 * @param origem
	 * @param interesses
	 * @param partido
	 */
	public Pessoa(String nome, String dni, String origem, String interesses, String partido) {
		this.nome = nome;
		this.dni = dni;
		this.origem = origem;
		this.partido = partido;
		this.interesses = interesses;
	}
	
	
	/**
	 * pega o nome da pessoa.
	 * @return nome.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * pega o documento nacional de identificacao.
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * pega o Estado de origem da pessoa.
	 * @return origem.
	 */
	public String getOrigem() {
		return origem;
	}

	/**
	 * pega o partido politico da pessoa.
	 * @return partido
	 */
	public String getPartido() {
		return partido;
	}	
	
	/**
	 * pega os interesses da pessoa.
	 * @return interesses
	 */
	public String getInteresses() {
		return interesses;
	}
	

	/**
	 * Metodo criado para alocar na memoria o documento nacional de
	 * identificacao atraves de valores inteiros. E assim, comparar
	 * no metodo Equals. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	/**
	 * Metodo desenvolvido com o intuito de comparar objetos, verificando
	 * se duas pessoas sao iguais, caso tenha o mesmo documento nacional
	 * de identificacao.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	/**
	 * Retorna a String que representa o nome, o documento nacional de identificacao,
	 * o Estado de origem da pessoa cadastrada, caso tal pessoa possua um partido po-
	 * litico e interesses, tambem serao retornados como String.
	 * 
	 * @return a representacao em String da pessoa. 
	 */
	@Override
	public String toString() {
		String pessoa = this.nome + " - " + this.dni + " (" + this.origem + ")";
		if (this.partido != null) {
			pessoa += " - " + this.partido;
		}
		if (this.interesses.length() > 0) {
			
			String a = " - Interesses: ";
			String[] interesse = this.interesses.split(",");
			
			for (int i = 0; i < interesse.length; i++) {
				if (i == interesse.length - 1) {
					a += interesse[i];
				}else {
					a += interesse[i] + ", ";
				}
			}
			pessoa += a;
		}
		return pessoa;
	}


}
