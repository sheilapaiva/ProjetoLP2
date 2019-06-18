package projetoLP2;

public class Votacao {
	
	private String status;
	
	private String local;

	public Votacao(String local) {
		this.status = "";
		this.local = local;
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
		this.local = local;
	}
	
	public boolean realizaVotacao(int afavor, int total, String tipo) {
		boolean b;
		if (tipo.equals("PEC")) {
			b = votacaoPEC(afavor, total);
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
		return afavor > (total / 2);
	}
	
	private boolean votacaoPEC(int afavor, int total) {
		return afavor > ((total / 5) * 3);
	}
	
}
