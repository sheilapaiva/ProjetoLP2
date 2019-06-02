package projetoLP2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Representação de um Controle de Partido, responsável por cadastrar uma partido e exibir as bases dos partidos.
 * 
 * @author Andre Santana, Caio Arruda, João Vitor e Sheila Paiva
 */
public class ControlePartido {
	
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
	 * Cadastra um partido na lista de partidos. A partir do nome do partido.
	 * Se esse campo não estiver nulo ou vazio.
	 * 
	 * @param nome, o nome do partido
	 * @throws IllegalArgumentException, campo partido nao pode ser vazio ou nulo
	 */
	public void cadastrarPartido(String partido) {
		if(partido == null || partido.isEmpty()){
			throw new IllegalArgumentException("Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
		}
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
		Collections.sort(this.partidos, this.comparador);
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
