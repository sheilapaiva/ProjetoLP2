package entidades;

import java.io.Serializable;

/**
 * Representação de uma Votacao, responsável realizar a votacao de um projeto.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class Votacao implements Serializable {
	
	/**
	 * Status da votacao.
	 */
	private String status;
	/**
	 * Local da votacao.
	 */
	private String local;

	/**
	 * Constroi uma votacao.
	 */
	public Votacao() {
		this.status = "";
		this.local = "";
	}

	/**
	 * Retorna uma String que representa o status do projeto.
	 * 
	 * @return uma String que representa o status do projeto
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Seta uma String que representa o status do projeto.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Retorna uma String que representa o local do projeto.
	 * 
	 * @return uma String que representa o local do projeto
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * Seta uma String que representa o local do projeto.
	 */
	public void setLocal(String local) {
		this.local = "(" + local + ")";
	}
	
	/**
	 * Realiza uma votacao. A partir dos votos a favor, total de votos e tipo do projeto.
	 * 
	 * @param afavor, os votos a favor da votacao
	 * @param total, o total de votos
	 * @param tipo, o tipo do projeto
	 * @return a um boolean que representa se foi aprovado ou nao
	 */
	public boolean realizaVotacao(int afavor, int total, String tipo) {
		boolean b;
		if (tipo.equals("COMISSAO")) {
			b = votacao(afavor, total);
		}else if (tipo.equals("PEC")) {
			b = votacaoPECPlenario(afavor, total);
		} else {
			b = votacao(afavor, total);
		}
		
		setarStatus(b);
		
		return b;
	}
	
	/**
	 * Seta o status.
	 * 
	 * @param status, o status a ser modificado
	 */
	private void setarStatus(boolean status) {
		if (status) {
			setStatus("APROVADO");
		} else {
			setStatus("REJEITADO");
		}
	}
	
	/**
	 * Votacao.
	 * 
	 * @param afavor, os votos a favor da votacao
	 * @param total, o total de votos
	 * @return a um boolean
	 */
	private boolean votacao(int afavor, int total) {
		return afavor > Math.ceil((total / 2));
	}
	
	/**
	 * Votacao de uma PEC no plenario.
	 * 
	 * @param afavor, os votos a favor da votacao
	 * @param total, o total de votos
	 * @return a um boolean
	 */
	private boolean votacaoPECPlenario(int afavor, int total) {
		return afavor > Math.ceil(((total / 5) * 3));
	}

	/**
	 * Retorna a uma String referente a uma votacao.
	 * A representacao segue o seguinte formato: "status - local"
	 * 
	 * @return  uma String referente a uma votacao
	 */
	@Override
	public String toString() {
		return this.status + " " + this.local;
	}
	
	
}
