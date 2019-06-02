package projetoLP2;

/**
 * Representacao de uma pessoa. Uma pessoa é representada por um nome, dni, origem, partido e interesses.
 * 
 * @author Andre Santana, Caio Arruda, João Vitor e Sheila Paiva
 */
public class Pessoa {
	
	/**
	 * Nome da pessoa.
	 */
	private String nome;
	
	/**
	 * Documento nacional de identificacao da pessoa.
	 */
	private String dni;
	
	/**
	 * Estado de origem da pessoa.
	 */
	private String origem;
	
	/**
	 * Partido politico da pessoa.
	 */
	private String partido;
	
	/**
	 * Interesses da pessoa.
	 */
	private String interesses;
	
	/**
	 * Constroi uma pessoa, a partir do seu nome, o documento nacional de identificacao, o estado de origem e
	 * os interesses da pessoa.
	 * 
	 * @param nome, o nome da pessoa
	 * @param dni, o documento nacional de identificacao
	 * @param origem, a origem da pessoa
	 * @param interesses, os interesses da pessoa
	 */
	public Pessoa(String nome, String dni, String origem, String interesses) {
		this.nome = nome;
		this.dni = dni;
		this.origem = origem;
		this.interesses = interesses;
	}
	
	/**
	 * Constroi uma pessoa, a partir do seu nome, o documento nacional de identificacao, o estado de origem,
	 * interesses da pessoa e o partido.
	 * 
	 * @param nome, o nome da pessoa
	 * @param dni, o documento nacional de identificacao
	 * @param origem, a origem da pessoa
	 * @param interesses, os interesses da pessoa
	 * @param partido, o partido da pessoa
	 */
	public Pessoa(String nome, String dni, String origem, String interesses, String partido) {
		this.nome = nome;
		this.dni = dni;
		this.origem = origem;
		this.partido = partido;
		this.interesses = interesses;
	}
	
	/**
	 * Retorna uma String que representa o nome da pessoa.
	 * 
	 * @return uma String que representa o nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna uma String que representa o documento nacional de identificacao da pessoa.
	 * 
	 * @return uma String que representa o documento nacional de identificacao
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * Retorna uma String que representa o estado de origem da pessoa.
	 * 
	 * @return  uma String que representa o estado de origem
	 */
	public String getOrigem() {
		return origem;
	}

	/**
	 * Retorna uma String que representa o partido politico da pessoa.
	 * 
	 * @return uma String que representa o partido
	 */
	public String getPartido() {
		return partido;
	}	
	
	/**
	 * Retorna uma String que representa os interesses da pessoa.
	 * 
	 * @return uma String que representa os interesses
	 */
	public String getInteresses() {
		return interesses;
	}
	
	/**
	* Retorna a um inteiro referente uma representação númerica do objeto.
	* 
	* @return a um valor inteiro que representa o objeto.
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	/**
	* Retorna a um boolean referente a comparação de um novo objeto Pessoa a ser 
	* criado com os outras Pessoas já existentes, uma pessoa é igual a outra se as 
	* seus dni são iguais.
	* 
	* @return a um boolean.
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
	 * Retorna a String que representa uma Pessoa.
	 * A representação segue o formato: "nome - dni (origen) - partido(se houver) - Interessses: interesse, ..., interesse"
	 * 
	 * @return a representacao em String do nome, dni, origem, partido e interesses de uma Pessoa. 
	 */
	@Override
	public String toString() {
		String pessoa = this.nome + " - " + this.dni + " (" + this.origem + ")";
		if (this.partido != null) {
			pessoa += " - " + this.partido;
		}
		if (this.interesses != null && this.interesses.length() > 0) {
			pessoa += " - Interesses: " + this.interesses;
		}
		return pessoa;
	}
}
