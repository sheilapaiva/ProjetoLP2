package projetoLP2;

import java.util.HashMap;

public class ControleProjetos {

	public HashMap<String, Projetos> projetos;
	
	public int numProjetoPlp;
	
	public int numProjetoPl;
	
	public int numProjetoPec;

	public ControleProjetos() {
		this.projetos = new HashMap<>();
		this.numProjetoPlp = 0;
		this.numProjetoPl = 0;
		this.numProjetoPec = 0;
	}

	public String cadastraPl(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		this.numProjetoPl ++;
		Projetos projeto = new Pl(dni, ano, ementa, interesses, url, conclusivo);
		String codigo = "PL " + this.numProjetoPl + "/" + ano;
		projetos.put(codigo, projeto);

		return "Projeto de Lei - " + codigo + " - " + dni + projetos.get(codigo).toString();

	}

	public String cadastraPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		this.numProjetoPlp ++;
		Projetos projeto = new Plp(dni, ano, ementa, interesses, url, artigos);
		String codigo = "PLP " + this.numProjetoPlp + "/" + ano;
		projetos.put(codigo, projeto);
		
		return "Projeto de Lei Complementar - " + codigo + " - " + dni + projetos.get(codigo).toString();
	}
	
	public String cadastraPec(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		this.numProjetoPec ++;
		Projetos projeto = new Pec(dni, ano, ementa, interesses, url, artigos);
		String codigo = "PEC" + this.numProjetoPec + "/" + ano;
		projetos.put(codigo, projeto);
		
		
		return "Projeto de Emenda Constitucional - " + codigo + " - " + dni + projetos.get(codigo).toString();
		
	}
	
	public String exibirProjeto(String codigo) {
		return this.projetos.get(codigo).toString();
		
		
	}
}
