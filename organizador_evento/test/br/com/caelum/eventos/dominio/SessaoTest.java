package br.com.caelum.eventos.dominio;

import static br.com.caelum.eventos.dominio.TempoDeDuracao.LIGHTING;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.caelum.eventos.dominio.Palestra;
import br.com.caelum.eventos.dominio.Sessao;
import br.com.caelum.eventos.dominio.SessaoDaManha;
import br.com.caelum.eventos.dominio.SessaoDaTarde;
import br.com.caelum.eventos.dominio.TempoDeDuracao;

public class SessaoTest {
	
	@Test
	public void umaPalestraNaoPodeSerMaisLongaQueUmaSessaoDaManha(){
		Sessao sessao = new SessaoDaManha();
		TempoDeDuracao tempoDeDuracaoDaSessao = sessao.lerTempoDeDuracao();
		Palestra palestra = new Palestra("nome qualquer", tempoDeDuracaoDaSessao.mais(1));
		
		assertFalse(sessao.adicionar(palestra));
	}
	
	@Test
	public void umaPalestraNaoPodeSerMaisLongaQueUmaSessaoDaTarde(){
		Sessao sessao = new SessaoDaTarde();
		TempoDeDuracao tempoDeDuracaoDaSessao = sessao.lerTempoDeDuracao();
		Palestra palestra = new Palestra("nome qualquer", tempoDeDuracaoDaSessao.mais(1));
		
		assertFalse(sessao.adicionar(palestra));
	}
	
	@Test
	public void aSessaoDaManhaEstaDevidamentePreenchidaQuandoASomaDaDuracaoDeTodasAsSuasPalestrasSerIgualASuaDuracao(){
		Sessao sessao = new SessaoDaManha();
		
		boolean adicionou = sessao.adicionar(new Palestra("uma boa palestra", new TempoDeDuracao(175)));
		assertTrue(adicionou);
		assertFalse(sessao.estaDevidamentePreenchida());
		
		adicionou = sessao.adicionar(new Palestra("outra boa palestra", LIGHTING));
		assertTrue(adicionou);
		assertTrue(sessao.estaDevidamentePreenchida());
		
		adicionou = sessao.adicionar(new Palestra("palestra rapidinha", LIGHTING));
		assertFalse(adicionou);
	}
	
	@Test
	public void aSessaoDaTardeEstaDevidamentePreenchidaQuandoASomaDaDuracaoDeTodasAsPalestrasEstiverEntreADuracaoEADuracaoMenosUmaHora(){
		Sessao sessao = new SessaoDaTarde();
		
		boolean adicionou = sessao.adicionar(new Palestra("palestra interessante", new TempoDeDuracao(175)));
		assertTrue(adicionou);
		assertFalse(sessao.estaDevidamentePreenchida());
		
		adicionou = sessao.adicionar(new Palestra("palestra sonolenta", TempoDeDuracao.LIGHTING));
		assertTrue(adicionou);
		assertTrue(sessao.estaDevidamentePreenchida());
		
		adicionou = sessao.adicionar(new Palestra("palestra rapidinha", new TempoDeDuracao(200)));
		assertFalse(adicionou);
	}
}
