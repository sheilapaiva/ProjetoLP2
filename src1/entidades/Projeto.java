package entidades;

import java.io.Serializable;

/**
 * Representacao de um projeto. Um projeto é representado por um numero, codigo, dni, ano, ementa, interesses,
 * situacao, nome da comissao e url.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public abstract class Projeto implements Serializable {

	/**
	 * o numero do projeto
	 */
	protected int numProjeto;
	/**
	 * o codigo do projeto
	 */
	protected String codigo;
	/**
	 * o dni da pessoa
	 */
    protected String dni;
    /**
	 * o ano do projeto
	 */
    protected int ano;
    /**
	 * a ementa do projeto
	 */
    protected String ementa;
    /**
	 * os interesses do projeto
	 */
    protected String interesses;
    /**
	 * a situacao do projeto
	 */
    protected String situacao;
    /**
	 * o nome da comissao do projeto
	 */
    protected String nomeComissao;
    /**
	 * a url do projeto
	 */
    protected String url;

    /**
     * Constroi um Projeto.
     * 
     * @param num, o numero do projeto
     * @param codigo, o codigo do projeto
     * @param dni, o numero do projeto
     * @param ano, o ano do projeto
     * @param ementa, as ementas do projeto
     * @param interesses, os interesses do projeto
     * @param url, a url do projeto
     */
    public Projeto(int num, String codigo, String dni, int ano, String ementa, String interesses, String url) {
    	this.numProjeto = num;
        this.codigo = codigo;
    	this.dni = dni;
        this.ano = ano;
        this.ementa = ementa;
        this.interesses = interesses;
        this.situacao = "EM VOTACAO";
        this.nomeComissao = "CCJC";
        this.url = url;
    }

    /**
	 * Retorna um inteiro que representa o ano.
	 * 
	 * @return um inteiro que representa o ano.
	 */    
	public int getAno() {
		return ano;
	}

	/**
	 * Retorna um inteiro que representa o numero do projeto.
	 * 
	 * @return um inteiro que representa o numero do projeto
	 */  
	public int getNum() {
		return numProjeto;
	}

	/**
	 * Retorna uma String que representa dni do projeto.
	 * 
	 * @return uma String que representa dni do projeto.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Retorna uma String que representa codigo do projeto.
	 * 
	 * @return uma String que representa codigo do projeto.
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Retorna uma String que representa os interesses do projeto.
	 * 
	 * @return uma String que representa os interesses do projeto.
	 */
	public String getInteresses() {
		return interesses;
	}

	/**
	 * Retorna uma String que representa a situacao do projeto.
	 * 
	 * @return uma String que representa a situacao do projeto.
	 */
	public String getSituacao() {
		return situacao;
	}

	/**
	 * Seta uma String que representa a situacao.
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	/**
	 * Retorna uma String que representa o nome da comissao do projeto.
	 * 
	 * @return uma String que representa o nome da comissao do projeto
	 */
	public String getNomeComissao() {
		return nomeComissao;
	}

	/**
	 * Seta uma String que representa o nome da comissao.
	 */
	public void setNomeComissao(String nomeComissao) {
		this.nomeComissao = nomeComissao;
	}
	


	/**
	* Retorna a um inteiro referente uma representação númerica do objeto.
	* 
	* @return a um valor inteiro que representa o objeto.
	*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((ementa == null) ? 0 : ementa.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	/**
	* Retorna a um boolean referente a comparação de um novo objeto Projeto a ser 
	* criado com os outras Projeto já existentes, uma projeto é igual a outra se as 
	* seus dni são iguais.
	* 
	* @return a um boolean.
	*/
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
