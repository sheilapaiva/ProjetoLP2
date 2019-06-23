package projetoLP2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validacao {
	
	public static void validarString(String palavra, String mensagem) {
		if (palavra == null) {
			throw new NullPointerException(mensagem);
		}else if (palavra.trim().equals("")) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	/**
	 * Retorne a um boolean, depois de verificar se o documento nacional de
	 * identificacao possui os caracteres corretos, composto 
	 * apenas por numeros e o traco(-).
	 * 
	 * @param dni, o dni da pessoa
	 * @return um valor boolean
	 */
	public static void verificaDni(String dni, String mensagem) {
		for (int i = 0 ; i < dni.length(); i++ ) {
			if (!Character.isDigit(dni.charAt(i)) && !(dni.charAt(i) == '-')) {
				throw new IllegalArgumentException(mensagem);
			}
		}
	}
	
	/**
	 * Verifica se a data é valida.
	 * 
	 * @param dataDeInicio, data de inicio de mandato
	 * @throws IllegalArgumentException, data futura
	 * @throws IllegalArgumentException, data invalida
	 */
	public static void validaData(String dataDeInicio) {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		sdf.setLenient(false);
		Date dataAtual = new Date();
		try {
			Date dataDeInicio2 = sdf.parse(dataDeInicio);
			if(dataDeInicio2.compareTo(dataAtual) > 0) {
				throw new IllegalArgumentException("Erro ao cadastrar deputado: data futura");
			}
		} catch (ParseException pe) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: data invalida");
		}	
	}
	
	public static void ValidaAno(int ano) {
		if (ano < 1988) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano anterior a 1988");
		} else if (ano > 2019) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano posterior ao ano atual");
		}
	}
	
}
