package br.com.caelum.eventos.dominio;

import java.time.LocalTime;

public class Palestra extends Atividade {
	
	private final TempoDeDuracao duracao;
		
	public Palestra(String nome, TempoDeDuracao duracao) {
		super(nome, LocalTime.of(0, 0));
		this.duracao = duracao;
	}
	
	public boolean comDuracaoMenorQue(TempoDeDuracao duracao) {
		return this.duracao.menorQue(duracao);
	}
	
	@Override
	public String toString(){
		String duracaoStr = duracao == null ? "" : duracao.toString();
		return super.toString() + " " + duracaoStr;
	}

	public TempoDeDuracao lerTempoDeDuracao() {
		return duracao;
	}
}
