package projetoLP2;

public class Pl extends Projeto {

    private boolean conclusivo;

    public Pl(String codigo, String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
        super(codigo, dni, ano, ementa, interesses, url);
        this.conclusivo = conclusivo;
    }

    @Override
    public boolean getConclusivo() {
		return conclusivo;
	}
    
    public boolean isConclusivo() {
		return conclusivo;
	}

	public void setConclusivo(boolean conclusivo) {
		this.conclusivo = conclusivo;
	}

	@Override
    public String toString() {
    	String mensagem;
    	if (this.conclusivo == true && !nomeComissao.equals("-")) {
    		mensagem = "Projeto de Lei - " + codigo + " - " + dni + " - " + ementa + " - Conclusiva - " + situacao + " (" + nomeComissao + ")";
    	}else if (this.conclusivo == false && !nomeComissao.equals("(-)")) {
    		mensagem = "Projeto de Lei - " + codigo + " - " + dni + " - " + ementa + " - " + situacao +  " (" + nomeComissao + ")";
    	}else if (nomeComissao.equals("-")) {
    		mensagem = "Projeto de Lei - " + codigo + " - " + dni + " - " + ementa + " - Conclusiva - " + situacao;
    	}else {
    		mensagem = "Projeto de Lei - " + codigo + " - " + dni + " - " + ementa + " - " + situacao + " (" + nomeComissao + ")";
    	}
    	return mensagem;
    }

}
