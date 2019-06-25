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
	
	public HashMap<String, ArrayList<Votacao>> getMapVotacao() {
		return mapVotacao;
	}

	public boolean realizarVotacao(String codigo, String local, int afavor, int total, String tipo) {
		if (!this.mapVotacao.containsKey(codigo)) {
			this.mapVotacao.put(codigo, new ArrayList<>());
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
