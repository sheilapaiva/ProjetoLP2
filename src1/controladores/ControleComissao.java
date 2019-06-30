package controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import entidades.Comissao;

/**
 * Representacao o Controle de uma Comissao.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class ControleComissao implements Serializable {
	
	/**
	 * Mapa de comissoes.
	 */
	private HashMap <String, Comissao> mapComissao;

	/**
	 * Constroi um controle de comissao.
	 *
	 */
	public ControleComissao() {
		this.mapComissao = new HashMap<>();
	}
	
	/**
	 * Retorna a um mapa de String que representa as Comissao.
	 * 
	 * @return uma String que representa o nome
	 */
	public HashMap<String, Comissao> getMapComissao() {
		return mapComissao;
	}
	
	/**
	 * Cadastra uma comissao no mapa de comissao. A partir do tema e da lista de politicos.
	 * 
	 * @param tema, tema da comissao
	 * @param politicos, lista de politicos
	 */
	public void cadastrarComissao(String tema, ArrayList<String> politicos) {
		Comissao comissao = new Comissao(tema, politicos);
		this.mapComissao.put(tema, comissao);
	}
}
