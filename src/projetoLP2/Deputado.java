package projetoLP2;

/**
 * Representacao de um deputado. Uma deputado é representada por uma pessoa e a data de inicio do mandato.
 * 
 * @author Andre Santana, Caio Arruda, João Vitor e Sheila Paiva
 */
public class Deputado implements Cargo {
	
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
	 * @param dataInicio, data de inicio do mandato
	 */
	public Deputado(String dataInicio) {
		this.dataInicio = dataInicio;
		this.qtdLeis = 0;
	}

	/**
	 * Retorna uma String que representa a data de inicio do mandato do deputado.
	 * 
	 * @return uma String que representa  data de inicio do mandato
	 */
	public String getDataInicio() {
		return this.dataInicio;
	}

	/**
	 * Retorna uma String que representa a quantidade de leis do deputado.
	 * 
	 * @return uma String que representa a quantidade de leis
	 */
	public int getQtdLeis() {
		return this.qtdLeis;
	}
}
