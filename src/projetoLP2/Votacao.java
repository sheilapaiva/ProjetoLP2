package projetoLP2;

public class Votacao {
	
	private String status;
	
	private String local;

	public Votacao() {
		this.status = "";
		this.local = "";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = "(" + local + ")";
	}
	
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
	
	private void setarStatus(boolean b) {
		if (b) {
			setStatus("APROVADO");
		} else {
			setStatus("REJEITADO");
		}
	}
	
	private boolean votacao(int afavor, int total) {
		return afavor > Math.ceil((total / 2));
	}
	
	private boolean votacaoPECPlenario(int afavor, int total) {
		return afavor > Math.ceil(((total / 5) * 3));
	}

	@Override
	public String toString() {
		return this.status + " " + this.local;
	}
	
	
}