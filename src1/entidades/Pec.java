package entidades;

/**
 * Representacao de uma PEC. Uma pl é representada por todos os atributos de um projeto e artigos. 
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class Pec extends Projeto {
	
	/**
	 * Os artigos do projeto
	 */
	private String artigos;

	/**
	 * Constroi uma Pec.
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
	public Pec(int num, String codigo, String dni, int ano, String ementa, String interesses, String url, String artigos) {
		super(num, codigo, dni, ano, ementa, interesses, url);
		this.artigos = artigos;
	}

	/**
	 * Retorna a String que representa uma Pec.
	 * A representação segue o formato: "Projeto de Emenda Constitucional - codigo - dni - ementa - artigos - situacao (nomeComissao)";
	 * 
	 * @return a representacao em String da Pec.
	 */
	@Override
	public String toString() {
		String [] art = this.artigos.split(",");
		String artigos = "";
		for (int i = 0; i < art.length; i++) {
			if (i == 0) {
				artigos += art[i];
			}else {
				artigos += ", " + art[i];
			}
		}
		if (!nomeComissao.equals("-")){
			return "Projeto de Emenda Constitucional - " + codigo + " - " + dni + " - " + ementa + " - " + artigos + " - " + situacao + " (" + nomeComissao + ")";
		} else {
			return "Projeto de Emenda Constitucional - " + codigo + " - " + dni + " - " + ementa + " - " + artigos + " - " + situacao;

		}
	}

	public String getArtigos() {
		return artigos;
	}

}