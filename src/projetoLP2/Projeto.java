package projetoLP2;

public abstract class Projeto {

	protected String codigo;
    protected String dni;
    protected int ano;
    protected String ementa;
    protected String interesses;
    protected String situacao;
    protected String nomeComissao;
    protected String url;

    public Projeto(String codigo, String dni, int ano, String ementa, String interesses, String url) {
        this.codigo = codigo;
    	this.dni = dni;
        this.ano = ano;
        this.ementa = ementa;
        this.interesses = interesses;
        this.situacao = "EM VOTACAO";
        this.nomeComissao = "(CCJC)";
        this.url = url;
    }

    
	public String getInteresses() {
		return interesses;
	}

	public void setInteresses(String interesses) {
		this.interesses = interesses;
	}
	
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getNomeComissao() {
		return nomeComissao.substring(1, nomeComissao.length() - 1);
	}

	public void setNomeComissao(String nomeComissao) {
		this.nomeComissao = "(" + nomeComissao + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((ementa == null) ? 0 : ementa.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (ementa == null) {
			if (other.ementa != null)
				return false;
		} else if (!ementa.equals(other.ementa))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
}
