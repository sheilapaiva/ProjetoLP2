package entidades;

/**
 * Representacao de uma PLP. Uma plp é representada por todos os atributos de um projeto e artigos. 
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class Plp extends Projeto {

	/**
	 * Os artigos do projeto
	 */
    private String artigos;

    /**
	 * Constroi uma Plp.
	 * 
	 * @param num, o numero geral do projeto
	 * @param codigo, o codigo do projeto
	 * @param dni, o dni o deputado
	 * @param ano, o ano do projeto
	 * @param ementa, a ementa do projeto
	 * @param interesses, os interesses do projeto
	 * @param url, a url do projeto
	 * @param artigos, os artigos do projeto
	 */
    public Plp(int num, String codigo, String dni, int ano, String ementa, String interesses, String url, String artigos) {
        super(num, codigo, dni, ano, ementa, interesses, url);
        this.artigos = artigos;
    }

    /**
	 * Retorna a String que representa uma Plp.
	 * A representação segue o formato: "Projeto de Lei Complementar - codigo - dni - ementa - artigos - situacao (nomeComissao)";
	 * 
	 * @return a representacao em String da Plp.
	 */
    @Override
    public String toString() {
    	String mensagem;
    	if (nomeComissao.equals("-")) {
    		mensagem = "Projeto de Lei Complementar - " + codigo + " - " + dni + " - " + ementa + " - " + this.artigos + " - " + situacao;
    	} else {
    		mensagem = "Projeto de Lei Complementar - " + codigo + " - " + dni + " - " + ementa + " - " + this.artigos + " - " + situacao + " (" + nomeComissao + ")";
    	}
		return mensagem;
    }

	public String getArtigos() {
		return artigos;
	}

}
