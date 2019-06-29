package entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Representa uma classe de uma Comissao. 
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class Comissao implements Serializable  {
	
	/**
	 * Tema da comissao
	 */
	private String tema;
	
	/**
	 * Lista de politicos
	 */
	private ArrayList<String> politicos;
	
	/**
	 * Constroi uma comissao
	 * 
	 * @param tema
	 * @param politicos
	 */
	public Comissao(String tema, ArrayList<String> politicos) {
		this.tema = tema;
		this.politicos = new ArrayList<>();
		this.politicos.addAll(politicos);
	}
	
	/**
	 * Retorna uma String que representa o tema do projeto.
	 * 
	 * @return  uma String que representa o tema
	 */
	public String getTema() {
		return tema;
	}

	/**
	 * Retorna um Array de String que representa os politicos do projeto.
	 * 
	 * @return um Array de String que representa os politicos
	 */
	public ArrayList<String> getPoliticos() {
		return politicos;
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
		result = prime * result + ((tema == null) ? 0 : tema.hashCode());
		return result;
	}

	/**
	* Retorna a um boolean referente a comparação de um novo objeto Comissao a ser 
	* criado com os outras Comissoes já existentes, uma comissao é igual a outra se as 
	* seus temas são iguais.
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
		Comissao other = (Comissao) obj;
		if (tema == null) {
			if (other.tema != null)
				return false;
		} else if (!tema.equals(other.tema))
			return false;
		return true;
	}
}
