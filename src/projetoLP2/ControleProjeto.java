package projetoLP2;

import java.util.ArrayList;
import java.util.HashMap;

public class ControleProjeto {

	private HashMap<String, Projeto> mapProjetos;
	
	private HashMap<Integer, ArrayList<Integer> > mapNumProjetoPlp;
	
	private HashMap<Integer, ArrayList<Integer> > mapNumProjetoPl;
	
	private HashMap<Integer, ArrayList<Integer> >  mapNumProjetoPec;

	public ControleProjeto() {
		this.mapProjetos = new HashMap<>();
		this.mapNumProjetoPlp = new HashMap<>();
		this.mapNumProjetoPl = new HashMap<>();
		this.mapNumProjetoPec = new HashMap<>();
	}
	
	public HashMap<String, Projeto> getMapProjetos() {
		return mapProjetos;
	}

	public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		if (!this.mapNumProjetoPl.containsKey(ano)) {
			this.mapNumProjetoPl.put(ano, new ArrayList<>());
		}
		this.mapNumProjetoPl.get(ano).add(this.mapNumProjetoPl.get(ano).size() + 1);
		
		String codigo = "PL " + this.mapNumProjetoPl.get(ano).size() + "/" + ano;
		Projeto projeto = new Pl(codigo, dni, ano, ementa, interesses, url, conclusivo);
		this.mapProjetos.put(codigo, projeto);
		return codigo;
	}

	public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		if (!this.mapNumProjetoPlp.containsKey(ano)) {
			this.mapNumProjetoPlp.put(ano, new ArrayList<>());
		}
		this.mapNumProjetoPlp.get(ano).add(this.mapNumProjetoPlp.get(ano).size() + 1);
		
		String codigo = "PLP " + this.mapNumProjetoPlp.get(ano).size() + "/" + ano;
		Projeto projeto = new Plp(codigo, dni, ano, ementa, interesses, url, artigos);
		this.mapProjetos.put(codigo, projeto);
		return codigo;
	}
	
	public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		if (!this.mapNumProjetoPec.containsKey(ano)) {
			this.mapNumProjetoPec.put(ano, new ArrayList<>());
		}
		this.mapNumProjetoPec.get(ano).add(this.mapNumProjetoPec.get(ano).size() + 1);
		
		String codigo = "PEC " + this.mapNumProjetoPec.get(ano).size() + "/" + ano;
		Projeto projeto = new Pec(codigo, dni, ano, ementa, interesses, url, artigos);
		this.mapProjetos.put(codigo, projeto);	
		return codigo;
	}
	
	public String exibirProjeto(String codigo) {
		return this.mapProjetos.get(codigo).toString();
	}
}
