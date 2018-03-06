package br.com.caelum.eventos.dominio;

import static br.com.caelum.eventos.dominio.ContextoPalestras.totalDePalestras;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.caelum.eventos.dominio.Agenda;
import br.com.caelum.eventos.dominio.Atividade;
import br.com.caelum.eventos.dominio.ListaDePalestras;
import br.com.caelum.eventos.dominio.Trilha;

public class AgendaTest {
	
	@Test
	public void testarElaboracaoDeConferencias(){
		ListaDePalestras palestras = ContextoPalestras.palestras();
		
		Agenda agenda = new Agenda(palestras);
		List<Trilha> trilhas = agenda.prepararTrilhas();
		
		assertTrue(palestras.estaVazia());
		List<Atividade> eventosAgendadosTrilha1 = trilhas.get(0).lerAtividadesAgendadasEmOrdem();
		List<Atividade> eventosAgendadosTrilha2 = trilhas.get(1).lerAtividadesAgendadasEmOrdem();
		int quantidadeDeAlmocosENetworking = 4;
		
		assertThat(eventosAgendadosTrilha1.size() + eventosAgendadosTrilha2.size(), is(equalTo(totalDePalestras() + quantidadeDeAlmocosENetworking)));
		
	}
}
