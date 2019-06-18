package projetoLP2;

import java.util.ArrayList;
import java.util.HashMap;

public class ControleVotacao {
	
	private HashMap<String, ArrayList<Votacao> > mapVotacao;
	//private StatusGovernista status;

	public ControleVotacao() {
		this.mapVotacao = new HashMap<>();
		//this.status = new StatusGovernista();
	}
	
	public boolean realizarVotacao(String codigo, String local, int afavor, int total, String tipo) {
		if (!this.mapVotacao.containsKey(codigo)) {
			this.mapVotacao.put(codigo, new ArrayList<>());
		}
		
		Votacao v = new Votacao(local);
		this.mapVotacao.get(codigo).add(v);
		
		return v.realizaVotacao(afavor, total, tipo);
	}
	
	
	
}
