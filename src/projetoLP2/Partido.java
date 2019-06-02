package projetoLP2;

/**
 * Representação de um Partido. Um partido e representado por um nome.
 * 
 * @author Andre Santana, Caio Arruda, João Vitor e Sheila Paiva
 */
public class Partido {
	
	/**
	 * Nome do partido.
	 */
	private String partido;

	/**
	 * Constroi um partido, a partir do seu nome.
	 * 
	 * @param nome, o nome do partido
	 */
	public Partido(String partido) {
		this.partido = partido;
	}
	
	/**
	 * Retorna uma String que representa o nome do partido.
	 * 
	 * @return uma String que representa o partido
	 */
	public String getPartido() {
		return partido;
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
		result = prime * result + ((partido == null) ? 0 : partido.hashCode());
		return result;
	}

	/**
	* Retorna a um boolean referente a comparação de um novo objeto Partido a ser 
	* criado com os outras Partidos já existentes, uma partido é igual a outra se as 
	* seus nomes são iguais.
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
		Partido other = (Partido) obj;
		if (partido == null) {
			if (other.partido != null)
				return false;
		} else if (!partido.equals(other.partido))
			return false;
		return true;
	}

	/**
	 * Retorna a String que representa uma Pessoa.
	 * A representação segue o formato: "nome do partido"
	 * 
	 * @return a representacao em String do nome
	 */
	@Override
	public String toString() {
		return this.partido;
	}
}
