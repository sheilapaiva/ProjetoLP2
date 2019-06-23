package projetoLP2;

public class Pec extends Projeto {
	
	private String artigos;

	public Pec(String codigo, String dni, int ano, String ementa, String interesses, String url, String artigos) {
		super(codigo, dni, ano, ementa, interesses, url);
		this.artigos = artigos;
	}

	@Override
	public String toString() {
		String [] art = this.artigos.split(",");
		String artigos = "";
		for (int i = 0; i < art.length; i++) {
			if (i == 0) {
				artigos += art[i];
			}else {
				artigos += ", " + art[i];
			}
		}
		if (!nomeComissao.equals("-")){
			return "Projeto de Emenda Constitucional - " + codigo + " - " + dni + " - " + ementa + " - " + artigos + " - " + situacao + " (" + nomeComissao + ")";
		} else {
			return "Projeto de Emenda Constitucional - " + codigo + " - " + dni + " - " + ementa + " - " + artigos + " - " + situacao;

		}
	}

}