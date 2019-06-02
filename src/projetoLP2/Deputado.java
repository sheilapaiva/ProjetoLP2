package projetoLP2;

/**
 * Representacao de um deputado. Uma deputado é representada por uma pessoa e a data de inicio do mandato.
 * 
 * @author Andre Santana, Caio Arruda, João Vitor e Sheila Paiva
 */
public class Deputado {
	
	/**
	 * Pessoa
	 */
	private Pessoa pessoa;
	/**
	 * Data do inicio do mandato
	 */
	private String dataInicio;
	/**
	 * Quantidade de leis do deputado
	 */
	private int qtdLeis;
	
	/**
	 * Constroi um deputado a partir da pessoa e a sua data de inicio de mandato.
	 * 
	 * @param pessoa, a pessoa que será um deputado
	 * @param dataInicio, data de inicio do mandato
	 */
	public Deputado(Pessoa pessoa, String dataInicio) {
		this.pessoa = pessoa;
		this.dataInicio = dataInicio;
		this.qtdLeis = 0;
	}

	/**
	 * Retorna uma String que representa a data de inicio do mandato do deputado.
	 * 
	 * @return uma String que representa  data de inicio do mandato
	 */
	public String getDataInicio() {
		return dataInicio;
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
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		return result;
	}

	/**
	* Retorna a um boolean referente a comparação de um novo objeto Deputado a ser 
	* criado com os outras Deputados já existentes, um deputado é igual a outro se as 
	* pessoas são iguais.
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
		Deputado other = (Deputado) obj;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

	/**
	 * Retorna a String que representa um Deputado.
	 * A representação segue o formato: "POL: nome - dni (origen) - partido(se houver) - 
	 * Interessses: interesse, ..., interesse - data de inicio - quantidade de leis"
	 * 
	 * @return a representacao em String do nome, dni, origem, partido e interesses de uma Pessoa. 
	 */
	@Override
	public String toString() {
		String diaInicio = dataInicio.substring(0, 2);
		String mesInicio = dataInicio.substring(2, 4);
		String anoInicio = dataInicio.substring(4, 8);
		return "POL: " + pessoa.toString() + " - " + diaInicio + "/" + mesInicio + "/" + anoInicio + " - " + qtdLeis + " Leis";
	}
	
}
