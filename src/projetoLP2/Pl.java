package projetoLP2;

public class Pl extends Projetos {

    private boolean conclusivo;

    public Pl(String dni, int ano, String ementa, String interesses, String url,boolean conclusivo) {
        super(dni, ano, ementa, interesses, url);
        this.conclusivo = conclusivo;
    }



    @Override
    public String toString() {
    	return " - " + getEmenta() + " - " + "-" + this.conclusivo + " - " + getSituacao();
    }


}
