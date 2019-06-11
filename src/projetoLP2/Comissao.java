package projetoLP2;

import java.util.ArrayList;

public class Comissao {
	
	/**
	 * tema da comissao
	 */
	private String tema;
	
	/**
	 * lista de politicos
	 */
	private ArrayList<Pessoa> politicos;
	
	/**
	 * Constroi uma comissao
	 * 
	 * @param tema
	 * @param politicos
	 */
	public Comissao(String tema, ArrayList<Pessoa> politicos) {
		this.tema = tema;
		this.politicos = new ArrayList<>();
		this.politicos.addAll(politicos);
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
