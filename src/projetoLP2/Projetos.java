package projetoLP2;

public abstract class Projetos {

    protected Pessoa autor;
    protected int ano;
    protected String ementa;
    protected String interesses;
    protected String situacao = "EM VOTACAO (CCJ)";
    protected String url;

    public Projetos(Pessoa autor, int ano, String ementa, String interesses, String url) {
        this.autor = autor;
        this.ano = ano;
        this.ementa = ementa;
        this.interesses = interesses;
        this.url = url;
    }

    public abstract String getAno();
    public abstract String toString();
}
