package projetoLP2;

public class Pec extends Projetos {
	
	private String artigos;

	public Pec(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		super(dni, ano, ementa, interesses, url);
		this.artigos = artigos;
	}


	@Override
	public String toString() {
		return " - " + getEmenta() + " - " + "-" + this.artigos + " - " + getSituacao();
	}

}
