package projetoLP2;

import easyaccept.EasyAccept;

public class Facade {
	CrudPessoa cp = new CrudPessoa();
	
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
		cp.cadastrarPessoa(nome, dni, estado, interesses);
	}
	
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
		cp.cadastrarPessoa(nome, dni, estado, interesses, partido);
	}

	
	public static void main(String[] args) {
		args = new String[] {"projetoLP2.Facade", "testes-eco/use_case_1.txt"};
		EasyAccept.main(args);
	}
}
