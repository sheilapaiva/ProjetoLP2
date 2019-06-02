package projetoLP2;

import java.util.Comparator;

/**
 * Representação de um comparador de partido, responsável por comparar partidos.
 * 
 * @author Andre Santana, Caio Arruda, João Vitor e Sheila Paiva
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
