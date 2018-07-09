package br.com.caelum.eventos.dominio;

import java.time.LocalTime;

public class SessaoDaManha extends Sessao{

	private static final TempoDeDuracao duracao = new TempoDeDuracao(180);
	
	@Override
	public TempoDeDuracao lerTempoDeDuracao() {
		return duracao;
	}

	@Override
	public boolean estaDevidamentePreenchida() {
		return tempoTotalDasPalestras().equals(duracao);
	}

	@Override
	public LocalTime comecaAs(){
		return LocalTime.of(9, 0);
	}
}
