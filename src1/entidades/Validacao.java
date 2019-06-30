package entidades;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe de validacao.
 *  
 * @author Andre Luis Souza de Andrade Santana - Matricula: 118210116
 * @author Caio Jose dos Santos Arruda - Matricula: 118210844
 * @author Joao Vitor Romao Patricio - Matricula: 118211058
 * @author Sheila Maria Mendes Paiva - Matricula: 118210186
 */
public class Validacao implements Serializable  {
	
	/**
	 * Verifica se uma String passada por parametro eh nula ou vazia.
	 * 
	 * @param palavra, a String a ser verificada
	 * @param mensagem, a mensagem de erro lancada
	 * @throws NullPointerException, palavra nula
	 * @throws IllegalArgumentException, palavra vazia
	 */
	public static void validarString(String palavra, String mensagem) {
		if (palavra == null) {
			throw new NullPointerException(mensagem);
		}else if (palavra.trim().equals("")) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	/**
	 * Verifica se um dni eh valido, verificar se o documento nacional de
	 * identificacao possui os caracteres corretos, composto 
	 * apenas por numeros e o traco(-).
	 * 
	 * @param dni, o dni a ser verificado
	 * @param mensagem, a mensagem de erro lancada
	 * @throws IllegalArgumentException, dni invalido
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
	
	/**
	 * Verifica se o ano é valido.
	 * 
	 * @param ano, ano a ser verificado
	 * @throws IllegalArgumentException, ano anterior a 1988
	 * @throws IllegalArgumentException, ano posterior ao ano atual
	 */
	public static void ValidaAno(int ano) {
		if (ano < 1988) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano anterior a 1988");
		} else if (ano > 2019) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano posterior ao ano atual");
		}
	}
	
}
