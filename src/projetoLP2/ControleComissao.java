package projetoLP2;

import java.util.ArrayList;
import java.util.HashMap;

public class ControleComissao {
	
	/**
	 * Mapa de comissoes.
	 */
	private HashMap <String, Comissao> mapComissao;

	public ControleComissao() {
		this.mapComissao = new HashMap<>();
	}
	
	public HashMap<String, Comissao> getMapComissao() {
		return mapComissao;
	}
	
	/**
	 * FALTAM TRATAR EXCECOES!
	 * Cadastra uma comissao no mapa de comissao. A partir do tema e da lista de politicos.
	 * Se esses campos não estiverem nulos ou vazios e forem validos. Usa o tema como chave
	 * para o mapa.
	 * 
	 * @param tema, tema da comissao
	 * @param politicos, lista de politicos
	 * @throws IllegalArgumentException, campo tema nao pode ser vazio ou nulo
	 * @throws IllegalArgumentException, campo lista de politicos nao pode ser vazio ou nulo
	 * @throws IllegalArgumentException, campo dni invalido 
	 */
	public void cadastrarComissao(String tema, ArrayList<String> politicos) {
		Comissao comissao = new Comissao(tema, politicos);
		this.mapComissao.put(tema, comissao);
	}
}
