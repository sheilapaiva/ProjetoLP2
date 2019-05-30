package projetoLP2;

public class Deputado {
	/**
	 * Pessoa que será deputado
	 */
	private Pessoa pessoa;
	/**
	 * Data do inicio do mandato
	 */
	private String dataInicio;
	/**
	 * Quantidade de leis do deputado
	 */
	private int qtdLeis;
	
	/**
	 * Constrói um deputado a partir do seu nome,dni,estado,interesses,partido, e sua data de inicio de mandato
	 * @param pessoa que será um deputado
	 * @param dataInicio data de inicio do mandato
	 */
	public Deputado(Pessoa pessoa,String dataInicio) {
		this.pessoa = pessoa;
		this.dataInicio = dataInicio;
		this.qtdLeis = 0;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deputado other = (Deputado) obj;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

	/**
	 * Representação textual de um Deputado.
	 */
	public String toString() {
		String diaInicio = dataInicio.substring(0, 2);
		String mesInicio = dataInicio.substring(2, 4);
		String anoInicio = dataInicio.substring(4, 8);
		return "POL: " + pessoa.toString() + " - " + diaInicio+"/"+mesInicio+"/"+anoInicio + " - " + qtdLeis + " Leis";
	}
	
}
