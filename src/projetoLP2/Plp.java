package projetoLP2;

public class Plp extends Projeto {

    private String artigos;

    public Plp(String codigo, String dni, int ano, String ementa, String interesses, String url, String artigos) {
        super(codigo, dni, ano, ementa, interesses, url);
        this.artigos = artigos;
    }

    @Override
    public String toString() {
    	String mensagem;
    	if (nomeComissao.equals("-")) {
    		mensagem = "Projeto de Lei Complementar - " + codigo + " - " + dni + " - " + ementa + " - " + this.artigos + " - " + situacao;
    	} else {
    		mensagem = "Projeto de Lei Complementar - " + codigo + " - " + dni + " - " + ementa + " - " + this.artigos + " - " + situacao + " (" + nomeComissao + ")";
    	}
		return mensagem;
    }

	public String getArtigos() {
		return artigos;
	}

}
