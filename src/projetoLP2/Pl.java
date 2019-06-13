package projetoLP2;

public class Pl extends Projetos {

    private boolean conclusivo;

    public Pl(Pessoa autor, int ano, String ementa, String interesses, String url,boolean conclusivo) {
        super(autor, ano, ementa, interesses, url);
        this.conclusivo = conclusivo;
    }

    @Override
    public String getAno() {
        return Integer.toString(this.ano);
    }

    @Override
    public String toString() {
        return " - " + this.ementa + " - " + "-" + this.conclusivo + " - "+ this.situacao;
    }


}
