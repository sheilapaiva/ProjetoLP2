package projetoLP2;

/**
 * Representacao de um deputado. Uma deputado é representada por uma pessoa e a data de inicio do mandato.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
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
	 * Estrategia do deputado
	 */
	private String estrategia;
	
	/**
	 * Constroi um deputado a partir da pessoa e a sua data de inicio de mandato.
	 * 
	 * @param dataInicio, data de inicio do mandato
	 */
	public Deputado(String dataInicio) {
		this.dataInicio = dataInicio;
		this.qtdLeis = 0;
		this.estrategia = "CONSTITUCIONAL";
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

	@Override
	public void setQtdLeis(int qtdLeis) {
		this.qtdLeis = qtdLeis;
	}

	public String getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(String estrategia) {
		this.estrategia = estrategia;
	}
	
}
