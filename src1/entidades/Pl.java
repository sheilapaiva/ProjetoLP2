package entidades;

/**
 * Representacao de uma PL. Uma pl é representada por todos os atributos de um projeto e conclusivo. 
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class Pl extends Projeto {

	/**
	 * O conclusivo do projeto
	 */
    private boolean conclusivo;

    /**
	 * Constroi uma Pl.
	 * 
	 * @param num, o numero geral do projeto
	 * @param codigo, o codigo do projeto
	 * @param dni, o dni o deputado
	 * @param ano, o ano do projeto
	 * @param ementa, a ementa do projeto
	 * @param interesses, os interesses do projeto
	 * @param url, a url do projeto
	 * @param conclusivo, o conclusivo do projeto
	 */
    public Pl(int num, String codigo, String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
        super(num, codigo, dni, ano, ementa, interesses, url);
        this.conclusivo = conclusivo;
    }

    /**
	 * Retorna um boolean que representa conclusivo.
	 * 
	 * @return um boolean que representa conclusivo
	 */
    public boolean getConclusivo() {
		return this.conclusivo;
	}

    /**
	 * Retorna a String que representa uma PL.
	 * A representação segue o formato: "Projeto de Lei - codigo - dni - ementa - conclusivo - situacao (nomeComissao)";
	 * 
	 * @return a representacao em String da Pl.
	 */
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
