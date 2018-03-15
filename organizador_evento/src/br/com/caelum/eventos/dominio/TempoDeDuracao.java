package br.com.caelum.eventos.dominio;

public class TempoDeDuracao implements Comparable<TempoDeDuracao>{
	
	private final Integer tempoEmMinutos;
	
	public static final String LIGHTING_STRING = "lightning";
	
	public static final TempoDeDuracao LIGHTING = new TempoDeDuracao(5){
		@Override
		public String toString(){
			return LIGHTING_STRING;
		}
	};
	
	public TempoDeDuracao(int tempoEmMinutos){
		this.tempoEmMinutos = tempoEmMinutos;
	}
	
	public TempoDeDuracao mais(TempoDeDuracao parcela){
		return new TempoDeDuracao(tempoEmMinutos + parcela.tempoEmMinutos);
	}

	public boolean menorQue(TempoDeDuracao duracao) {
		return compareTo(duracao) < 0;
	}

	@Override
	public int compareTo(TempoDeDuracao outro) {
		return tempoEmMinutos.compareTo(outro.tempoEmMinutos);
	}
	
	//3 - exemplo de introduzir variável explicativa - criar variáveis para
	// as comparações abaixo
	public boolean entre(TempoDeDuracao duracaoMinima,
			TempoDeDuracao duracaoMaxima) {
		return duracaoMinima.compareTo(this) <= 0 && this.compareTo(duracaoMaxima) <= 0;
	}
	
	@Override
	public boolean equals(Object obj){
		boolean ret = false;
		if(obj instanceof TempoDeDuracao){
			TempoDeDuracao outro = (TempoDeDuracao)obj;
			ret = tempoEmMinutos.equals(outro.tempoEmMinutos);
		}
		return ret;
	}
	
	public Integer toInt() {
		return tempoEmMinutos;
	}
	
	@Override
	public int hashCode(){
		return tempoEmMinutos.hashCode();
	}
	
	@Override
	public String toString(){
		return tempoEmMinutos + "min";
	}

}
