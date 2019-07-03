package controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import entidades.NomeComparadorPartido;
import entidades.Partido;

/**
 * Representação de um Controle de Partido, responsável por cadastrar uma partido e exibir as bases dos partidos.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class ControlePartido implements Serializable {
	
	/**
	 * ArrayList de partidos
	 */
	private ArrayList<Partido> partidos;
	
	/**
	* Comparador de partido.
	*/
	private Comparator<Partido> comparador;

	/**
	 * Constroi um controle de partidos.
	 */
	public ControlePartido() {
		this.partidos = new ArrayList<>();
		this.comparador =  new NomeComparadorPartido();
	}
	
	/**
	 * Retorna a um arraylist Partidos que representa os partidos.
	 * 
	 * @return a um arraylist Partidos que representa os partidos.
	 */
	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	/**
	 * Cadastra um partido na lista de partidos. A partir do nome do partido.
	 * 
	 * @param nome, o nome do partido
	 */
	public void cadastrarPartido(String partido) {
		Partido p = new Partido(partido);
		this.partidos.add(p);
	}
	
	/**
	 * Retorna uma String representando os partidos cadastrados. 
	 * A representação segue o formato: "nome do partido, ..., nome do partido"
	 * 
	 * @return uma String representando os partidos
	 */
	public String exibirBase() {
		String base = "";
		int i = 0;
		Collections.sort(this.partidos, comparador);
		for (Partido p : this.partidos) {
			if (i == 0) {
				base += p.toString();
				i++;
			}else {
				base += ",";
				base += p.toString();
			}
		}
		return base;
	}
	
}
