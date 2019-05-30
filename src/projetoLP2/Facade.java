package projetoLP2;

import easyaccept.EasyAccept;

public class Facade {
	CrudPessoa cp = new CrudPessoa();
	
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
		cp.cadastrarPessoa(nome, dni, estado, interesses);
	}
	
	/**
	 * Cadastra pessoa a partir do seu nome, dni, estado de origem, interesses e o seu partido
	 * @param nome, nome do deputado
	 * @param dni, dni do deputado
	 * @param estado
	 * @param interesses
	 * @param partido
	 * @see CrudPessoa#cadastrarPessoa(String, String, String, String) 
	 *
	 */
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
		cp.cadastrarPessoa(nome, dni, estado, interesses, partido);
	}

	/**
	 * Cadastra deputado a partir do dni e sua data de inicio de mandato
	 * @param dni, dni de uma pessoa
	 * @param dataDeInicio, data de inicio do mandato
	 */
	public void cadastrarDeputado(String dni, String dataDeInicio) {
		cp.cadastrarDeputado(dni, dataDeInicio);
	}
	
	public static void main(String[] args) {
		args = new String[] {"projetoLP2.Facade", "testes-eco/use_case_1.txt", "testes-eco/use_case_2.txt"};
		EasyAccept.main(args);
	}
}
