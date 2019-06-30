package controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import entidades.Votacao;

/**
 * Representação de um Controle de Votacao, responsavel por cadastrar uma votacao.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class ControleVotacao implements Serializable{
	
	/**
	 * Mapa de votacao.
	 */
	private HashMap<String, ArrayList<Votacao>> mapVotacao;
	
	/**
	 * Constroi um controle de votacao.
	 */
	public ControleVotacao() {
		this.mapVotacao = new HashMap<>();
	}
	
	/**
	 * Retorna um mapa que representa o mapa de votacoes.
	 * 
	 * @return um mapa que representa o mapa de votacoes
	 */
	public HashMap<String, ArrayList<Votacao>> getMapVotacao() {
		return mapVotacao;
	}

	/**
	 * Realiza a votacao de um projeto e registra no mapa de votacao.
	 * 
	 * @param codigo, o codigo do projeto
	 * @param local, o local de votacao
	 * @param afavor, a quantidade de votos a favor
	 * @param total, o total de votos
	 * @param tipo, o tipo de projeto
	 * @return um boolean referente a aprovacao ou nao
	 */
	public boolean realizarVotacao(String codigo, String local, int afavor, int total, String tipo) {
		if (!this.mapVotacao.containsKey(codigo)) {
			this.mapVotacao.put(codigo, new ArrayList<Votacao>());
		}
		boolean b;
		Votacao v = new Votacao();
		if (v.realizaVotacao(afavor, total, tipo)) {
			v.setLocal(local);
			v.setStatus("APROVADO");
			b = true;
		} else {
			v.setLocal(local);
			v.setStatus("REJEITADO");
			b = false;
		}
		
		this.mapVotacao.get(codigo).add(v);
		return b;
	}
	
	/**
	 * Exibe a tramitacao do projeto com o codigo passado como parametro
	 * 
	 * @param codigo, o codigo do projeto
	 * @return uma String referente a tramitacao do projeto 
	 */
	public String exibirTramitacao(String codigo) {
		String tramitacao = "";
		for (int i = 0; i < this.mapVotacao.get(codigo).size(); i++) {
			if (i < this.mapVotacao.get(codigo).size() - 1) {
				tramitacao += this.mapVotacao.get(codigo).get(i).toString() + ", ";
			} else if (i == this.mapVotacao.get(codigo).size() - 1) {
				tramitacao += this.mapVotacao.get(codigo).get(i).toString();				
			}
		}
		
		return tramitacao;
	}
}
