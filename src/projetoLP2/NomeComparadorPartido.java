package projetoLP2;

import java.util.Comparator;

/**
 * Representação de um comparador de partido, responsável por comparar partidos.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class NomeComparadorPartido implements Comparator<Partido>{

	/**
	* Compara dois objetos Partidos, retorna a diferença entre as Strings nome 
	* definindo a sua ordem alfabética. 
	* 
	* @return a um inteiro, 
	*/
	@Override
	public int compare(Partido o1, Partido o2) {
		return o1.getPartido().compareTo(o2.getPartido());
	}
}
