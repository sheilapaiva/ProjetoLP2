package projetoLP2;

public abstract class Projetos {

    private String dni;
    private int ano;
    private String ementa;
    private String interesses;
    private String situacao = "EM VOTACAO (CCJ)";
    private String url;

    public Projetos(String dni, int ano, String ementa, String interesses, String url) {
        this.dni = dni;
        this.ano = ano;
        this.ementa = ementa;
        this.interesses = interesses;
        this.url = url;
    }

	public String getDni() {
		return dni;
	}

	public int getAno() {
		return ano;
	}

	public String getEmenta() {
		return ementa;
	}

	public String getInteresses() {
		return interesses;
	}

	public String getSituacao() {
		return situacao;
	}

	public String getUrl() {
		return url;
	}
    
    
    
}
