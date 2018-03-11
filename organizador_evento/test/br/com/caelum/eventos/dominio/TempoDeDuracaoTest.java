package br.com.caelum.eventos.dominio;

import static br.com.caelum.eventos.dominio.TempoDeDuracao.LIGHTING_STRING;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TempoDeDuracaoTest {
	
	@Test
	public void comparacao(){
		TempoDeDuracao umaDuracao = new TempoDeDuracao(10);
		TempoDeDuracao outraDuracao = new TempoDeDuracao(11);
		
		assertTrue(umaDuracao.menorQue(outraDuracao));
		assertFalse(outraDuracao.menorQue(umaDuracao));
	}
	
	@Test
	public void somarOutroTempoDeDuracao(){
		TempoDeDuracao tempo = new TempoDeDuracao(10);
		TempoDeDuracao tempoMaisTempo = tempo.mais(tempo);
		
		TempoDeDuracao tempoEsperado = new TempoDeDuracao(20);
		assertThat(tempoMaisTempo, is(equalTo(tempoEsperado)));
	}
	
	@Test
	public void lighting(){
		TempoDeDuracao lighting = TempoDeDuracao.LIGHTING;
		assertThat(lighting.toString(), is(equalTo(LIGHTING_STRING)));
	}
	
	@Test
	public void entreUmTempoEOutro(){
		TempoDeDuracao menor = new TempoDeDuracao(10);
		TempoDeDuracao doMeio = new TempoDeDuracao(11);
		TempoDeDuracao maior = new TempoDeDuracao(12);
		
		assertTrue(doMeio.entre(menor, maior));
	}
	
	@Test
	public void naoEstaEntreUmTempoEOutroPoisEstaAbaixoDoMenor(){
		TempoDeDuracao menor = new TempoDeDuracao(11);
		TempoDeDuracao doMeio = new TempoDeDuracao(10);
		TempoDeDuracao maior = new TempoDeDuracao(12);
		
		assertFalse(doMeio.entre(menor, maior));
	}
	
	@Test
	public void naoEstaEntreUmTempoEOutroPoisEstaAcimaDoMaior(){
		TempoDeDuracao menor = new TempoDeDuracao(10);
		TempoDeDuracao doMeio = new TempoDeDuracao(13);
		TempoDeDuracao maior = new TempoDeDuracao(12);
		
		assertFalse(doMeio.entre(menor, maior));
	}
	
	@Test
	public void estaEntreUmTempoEOutroPoisEhIgualAoMenor(){
		TempoDeDuracao menor = new TempoDeDuracao(11);
		TempoDeDuracao doMeio = new TempoDeDuracao(11);
		TempoDeDuracao maior = new TempoDeDuracao(12);
		
		assertTrue(doMeio.entre(menor, maior));
	}
	
	@Test
	public void estaEntreUmTempoEOutroPoisEhIgualAoMaior(){
		TempoDeDuracao menor = new TempoDeDuracao(11);
		TempoDeDuracao doMeio = new TempoDeDuracao(12);
		TempoDeDuracao maior = new TempoDeDuracao(12);
		
		assertTrue(doMeio.entre(menor, maior));
	}
}
