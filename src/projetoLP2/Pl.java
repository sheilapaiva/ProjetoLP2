package projetoLP2;

public class Pl extends Projeto {

    private boolean conclusivo;

    public Pl(String codigo, String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
        super(codigo, dni, ano, ementa, interesses, url);
        this.conclusivo = conclusivo;
    }

    @Override
    public String toString() {
    	String mensagem;
    	if (this.conclusivo == true && nomeComissao != null) {
    		mensagem = "Projeto de Lei - " + codigo + " - " + dni + " - " + ementa + " - Conclusiva - " + situacao + " " + nomeComissao;
    	}else if (nomeComissao == null) {
    		mensagem = "Projeto de Lei - " + codigo + " - " + dni + " - " + ementa + " - Conclusiva - " + situacao;
    	}else {
    		mensagem = "Projeto de Lei - " + codigo + " - " + dni + " - " + ementa + " - " + situacao + " " + nomeComissao;
    	}
    	return mensagem;
    }

}
