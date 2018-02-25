package br.com.caelum.eventos.dominio;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Palestra {
	
	private final String nome;
	private final TempoDeDuracao duracao;
	private LocalTime hora;
	
	public static final Palestra ALMOCO = new Palestra("Almoço", LocalTime.of(12, 0));
	
	public static final Palestra NETWORKING = new Palestra("Networking", LocalTime.of(17, 0));
	
	public Palestra(String nome, TempoDeDuracao duracao) {
		this.nome = nome;
		this.duracao = duracao;
		this.hora = null;
	}
	
	private Palestra(String nome, LocalTime hora) {
		this.nome = nome;
		this.hora = hora;
		this.duracao = null;
	}

	public boolean comDuracaoMenorQue(TempoDeDuracao duracao) {
		return this.duracao.menorQue(duracao);
	}
	
	public void agendarPara(LocalTime horas){
		this.hora = horas;
	}
	
	@Override
	public boolean equals(Object obj){
		boolean ret = false;
		if(obj instanceof Palestra){
			Palestra outra = (Palestra)obj;
			ret = nome.equals(outra.nome);
		}
		return ret;
	}
	
	@Override
	public int hashCode(){
		return nome.hashCode();
	}
	
	@Override
	public String toString(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma");
		String horaStr = hora == null ? "" : formatter.format(hora) + " ";
		String duracaoStr = duracao == null ? "" : duracao.toString();
		return horaStr + nome + " " + duracaoStr;
	}

	public TempoDeDuracao lerTempoDeDuracao() {
		return duracao;
	}
}
