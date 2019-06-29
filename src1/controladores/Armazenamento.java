package controladores;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Armazenamento {

	public Armazenamento() {
		
	}
	
	public void salvarObjeto(Object dados, String nomeArquivo){
		try {
			FileOutputStream fs = new FileOutputStream(nomeArquivo);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(dados);
			os.close();
			System.out.println("Dados salvos com sucesso!");
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
