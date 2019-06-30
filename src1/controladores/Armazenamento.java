package controladores;

import java.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Representa a classe Armazenamento, que serve para auxiliar nas operações de leitura/escrita de arquivos
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 * 
 */

public class Armazenamento {

	/**
	 * Constrói um Armazenamento.
	 */
	public Armazenamento() {

	}

	/**
	 * Salva o objeto em um arquivo binario.
	 * Ao salvar, exibe uma mensagem de conclusão do salvamento.
	 * @param dados Objeto passado como parametro
	 * @param nomeArquivo arquivo em que o objeto será salvo.
	 */
	public void salvarObjeto(Object dados, String nomeArquivo) {
		try {
			FileOutputStream fs = new FileOutputStream(nomeArquivo);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(dados);
			os.close();
			System.out.println("Dados salvos com sucesso!");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	/**
	 * Lê o arquivo passado como parametro utilizando um buffer, dessa forma, permite o "ressurgimento" do objeto
	 * @param nomeArquivo
	 * @return retorna o resultado da leitura. 
	 */
	
	public static String ler(String nomeArquivo){
		BufferedReader br = null;
		FileReader fr = null;
		String resultado = "";
		try{
			fr = new FileReader(nomeArquivo);
			br = new BufferedReader(fr);
			String linha;
			while((linha = br.readLine()) != null){
				resultado += linha + "\n";
			}
			return resultado;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return resultado;
	}
	
	/**
	 * Limpa o arquivo passado como paramêtro e permite que o arquivo seja sobrescrito.
	 * @param arquivo binario 
	 */
	public void limpar(String arquivo) {
		File file = new File(arquivo);
		try {
			PrintWriter pw = new PrintWriter(file);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	
}
