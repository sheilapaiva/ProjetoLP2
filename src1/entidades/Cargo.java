package entidades;

import java.io.Serializable;

/**
 * Representa uma interface de um Cargo de pessoa. 
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public interface Cargo  {
	
	/**
	 * Retorna uma String que representa a data do inicio.
	 * 
	 * @return uma String que representa a data do inicio.
	 */
	public String getDataInicio();
	
	/**
	 * Retorna um inteiro que representa a quantidade de leis.
	 * 
	 * @return um inteiro que representa a quantidade de leis.
	 */
	public int getQtdLeis();
	
	/**
	 * Seta uma String que representa a quantidade de leis.
	 */
	public void setQtdLeis(int qtdLeis);
}
