package projetoLP2;

public class Pl extends Projeto {

    private boolean conclusivo;

    public Pl(String codigo, String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
        super(codigo, dni, ano, ementa, interesses, url);
        this.conclusivo = conclusivo;
    }

    @Override
    public String toString() {
    	if (this.conclusivo == true) {
    		return "Projeto de Lei - " + codigo + " - " + dni + " - " + ementa + " - Conclusiva - " + situacao;
    	}
    	return "Projeto de Lei - " + codigo + " - " + dni + " - " + ementa + " - " + situacao;
    }

}
