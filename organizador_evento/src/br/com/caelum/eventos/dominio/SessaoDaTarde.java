package br.com.caelum.eventos.dominio;

import java.time.LocalTime;

public class SessaoDaTarde extends Sessao {

	private static final TempoDeDuracao duracaoMaxima = new TempoDeDuracao(240);
	private static final TempoDeDuracao duracaoMinima = new TempoDeDuracao(180);
	
	@Override
	public TempoDeDuracao lerTempoDeDuracao() {
		return duracaoMaxima;
	}

	@Override
	public boolean estaDevidamentePreenchida() {
		return tempoTotalDasPalestras().entre(duracaoMinima, duracaoMaxima);
	}

	@Override
	public LocalTime comecaAs() {
		return LocalTime.of(13, 0);
	}

}
