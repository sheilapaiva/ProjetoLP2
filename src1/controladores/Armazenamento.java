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



public class Armazenamento {

	public Armazenamento() {

	}

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
