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

	public static Object restaurar(String caminho) {

		Object objeto = null;

		try {
			FileInputStream restFile = new FileInputStream(caminho);
			ObjectInputStream stream = new ObjectInputStream(restFile);
			objeto = stream.readObject();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objeto;

	}

	public static void limpar(String arquivo){
		File file = new File(arquivo);
		file.delete();
	} 
	
	
}
