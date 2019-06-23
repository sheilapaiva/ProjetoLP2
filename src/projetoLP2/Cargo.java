package projetoLP2;

/**
 * Representa uma interface de um Cargo de pessoa. 
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public interface Cargo {
	
	public String getDataInicio();
	
	public int getQtdLeis();
	
	public void setQtdLeis(int qtdLeis);
	
	public String getEstrategia();

	public void setEstrategia(String estrategia);
}
