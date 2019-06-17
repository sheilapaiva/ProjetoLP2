package projetoLP2;

import java.util.HashMap;

public class ControleProjeto {

	public HashMap<String, Projeto> mapProjetos;
	
	public int numProjetoPlp;
	
	public int numProjetoPl;
	
	public int numProjetoPec;

	public ControleProjeto() {
		this.mapProjetos = new HashMap<>();
		this.numProjetoPlp = 0;
		this.numProjetoPl = 0;
		this.numProjetoPec = 0;
	}

	public void cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		this.numProjetoPl ++;
		String codigo = "PL " + this.numProjetoPl + "/" + ano;
		Projeto projeto = new Pl(codigo, dni, ano, ementa, interesses, url, conclusivo);
		this.mapProjetos.put(codigo, projeto);
	}

	public void cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		this.numProjetoPlp ++;
		String codigo = "PLP " + this.numProjetoPlp + "/" + ano;
		Projeto projeto = new Plp(codigo, dni, ano, ementa, interesses, url, artigos);
		this.mapProjetos.put(codigo, projeto);
	}
	
	public void cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		this.numProjetoPec ++;
		String codigo = "PEC " + this.numProjetoPec + "/" + ano;
		Projeto projeto = new Pec(codigo, dni, ano, ementa, interesses, url, artigos);
		this.mapProjetos.put(codigo, projeto);	
	}
	
	public String exibirProjeto(String codigo) {
		return this.mapProjetos.get(codigo).toString();
	}
}
