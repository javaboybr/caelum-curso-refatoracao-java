package br.com.caelum.eventos.dominio;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Atividade {
	
	private final String nome;
	private LocalTime inicio;
	
	public static final Atividade ALMOCO = new Atividade("Almoço", LocalTime.of(12, 0));
	
	public static final Atividade NETWORKING = new Atividade("Networking", LocalTime.of(17, 0));

	public Atividade(String nome, LocalTime inicio) {
		this.nome = nome;
		this.inicio = inicio;
	}
	
	public void agendarPara(LocalTime inicio){
		this.inicio = inicio;
	}
	
	@Override
	public boolean equals(Object obj){
		boolean ret = false;
		if(obj instanceof Atividade){
			Atividade outra = (Atividade)obj;
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
		String horaStr = inicio == null ? "" : formatter.format(inicio) + " ";
		return horaStr + nome;
	}
}
