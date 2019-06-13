package projetoLP2;

public class Plp extends Projetos {

    private String artigos;

    public Plp(Pessoa autor, int ano, String ementa, String interesses, String url,String artigos) {
        super(autor, ano, ementa, interesses, url);
        this.artigos = artigos;
    }

    @Override
    public String getAno() {
        return Integer.toString(this.ano);
    }

    @Override
    public String toString() {
        return " - " + this.ementa + " - " + "-" + this.artigos + " - "+ this.situacao;
    }
}
