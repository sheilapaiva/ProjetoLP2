package controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import entidades.Pec;
import entidades.Pl;
import entidades.Plp;
import entidades.Projeto;

/**
 * Representação de um Controle de Projeto, responsavel por cadastrar um projeto ou listar projeto.
 * 
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class ControleProjeto implements Serializable {

	/**
	 * Mapa de projetos.
	 */
	private HashMap<String, Projeto> mapProjetos;
	/**
	 * Mapa de numeros de projetos PLP.
	 */
	private HashMap<Integer, ArrayList<Integer> > mapNumProjetoPlp;
	/**
	 * Mapa de numeros de projetos PL.
	 */
	private HashMap<Integer, ArrayList<Integer> > mapNumProjetoPl;
	/**
	 * Mapa de numeros de projetos PEC.
	 */
	private HashMap<Integer, ArrayList<Integer> >  mapNumProjetoPec;
	/**
	 * numero total de projetos.
	 */
	private int numeroDeProjetos;
	
	/**
	 * Constroi um controle de projetos.
	 */
	public ControleProjeto() {
		this.mapProjetos = new HashMap<>();
		this.mapNumProjetoPlp = new HashMap<>();
		this.mapNumProjetoPl = new HashMap<>();
		this.mapNumProjetoPec = new HashMap<>();
		this.numeroDeProjetos = 0;
	}
	
	/**
	 * Retorna um mapa que representa o mapa de projetos.
	 * 
	 * @return um mapa que representa o mapa de projetos
	 */
	public HashMap<String, Projeto> getMapProjetos() {
		return mapProjetos;
	}

	/**
	 * Cadastra uma projeto do tipo PL no mapa de projetos. A partir do dni do deputado, ano, ementa, interesses do projeto,
	 * url e conclusivo. Usa um codigo gerado a partir do noe do projeto numero e ano como chave para o mapa.
	 * 
	 * @param dni, documento nacional de identificacao da pessoa
	 * @param ano, o ano do projeto
	 * @param ementa, a ementa do projeto
	 * @param interesses, interesses da pessoa
	 * @param url, a url do projeto
	 * @param conclusivo, o conclusivo do projeto
	 * @return codigo, o codigo gerado no projeto
	 */
	public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		if (!this.mapNumProjetoPl.containsKey(ano)) {
			this.mapNumProjetoPl.put(ano, new ArrayList<>());
		}
		this.mapNumProjetoPl.get(ano).add(this.mapNumProjetoPl.get(ano).size() + 1);
		this.numeroDeProjetos ++;
		String codigo = "PL " + this.mapNumProjetoPl.get(ano).size() + "/" + ano;
		Projeto projeto = new Pl(this.numeroDeProjetos, codigo, dni, ano, ementa, interesses, url, conclusivo);
		this.mapProjetos.put(codigo, projeto);
		return codigo;
	}

	/**
	 * Cadastra uma projeto do tipo PLP no mapa de projetos. A partir do dni do deputado, ano, ementa, interesses do projeto,
	 * url e artigos. Usa um codigo gerado a partir do noe do projeto numero e ano como chave para o mapa.
	 * 
	 * @param dni, documento nacional de identificacao da pessoa
	 * @param ano, o ano do projeto
	 * @param ementa, a ementa do projeto
	 * @param interesses, interesses da pessoa
	 * @param url, a url do projeto
	 * @param artigos, os artigos do projeto
	 * @return codigo, o codigo gerado no projeto
	 */
	public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		if (!this.mapNumProjetoPlp.containsKey(ano)) {
			this.mapNumProjetoPlp.put(ano, new ArrayList<>());
		}
		this.mapNumProjetoPlp.get(ano).add(this.mapNumProjetoPlp.get(ano).size() + 1);
		this.numeroDeProjetos ++;
		String codigo = "PLP " + this.mapNumProjetoPlp.get(ano).size() + "/" + ano;
		Projeto projeto = new Plp(this.numeroDeProjetos, codigo, dni, ano, ementa, interesses, url, artigos);
		this.mapProjetos.put(codigo, projeto);
		return codigo;
	}
	
	/**
	 * Cadastra uma projeto do tipo PEC no mapa de projetos. A partir do dni do deputado, ano, ementa, interesses do projeto,
	 * url e artigos. Usa um codigo gerado a partir do noe do projeto numero e ano como chave para o mapa.
	 * 
	 * @param dni, documento nacional de identificacao da pessoa
	 * @param ano, o ano do projeto
	 * @param ementa, a ementa do projeto
	 * @param interesses, interesses da pessoa
	 * @param url, a url do projeto
	 * @param artigos, os artigos do projeto
	 * @return codigo, o codigo gerado no projeto
	 */
	public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		if (!this.mapNumProjetoPec.containsKey(ano)) {
			this.mapNumProjetoPec.put(ano, new ArrayList<>());
		}
		this.mapNumProjetoPec.get(ano).add(this.mapNumProjetoPec.get(ano).size() + 1);
		this.numeroDeProjetos ++;
		String codigo = "PEC " + this.mapNumProjetoPec.get(ano).size() + "/" + ano;
		Projeto projeto = new Pec(this.numeroDeProjetos, codigo, dni, ano, ementa, interesses, url, artigos);
		this.mapProjetos.put(codigo, projeto);	
		return codigo;
	}
	
	/**
	 * Exibe um projeto do mapa de projetos. A partir do codigo do projeto.
	 * 
	 * @param codigo, o codigo do projeto
	 * @return ao projeto com o codigo passado como parametro.
	 */
	public String exibirProjeto(String codigo) {
		return this.mapProjetos.get(codigo).toString();
	}
}
