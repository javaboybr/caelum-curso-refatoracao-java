package br.com.caelum.eventos;

import static br.com.caelum.eventos.ContextoPalestras.totalDePalestras;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.caelum.eventos.dominio.Agenda;
import br.com.caelum.eventos.dominio.ListaDePalestras;
import br.com.caelum.eventos.dominio.Palestra;
import br.com.caelum.eventos.dominio.Trilha;

public class AgendaTest {
	
	@Test
	public void testarElaboracaoDeConferencias(){
		ListaDePalestras palestras = ContextoPalestras.palestras();
		
		Agenda agenda = new Agenda();
		List<Trilha> trilhas = agenda.prepararTrilhas(palestras);
		
		assertTrue(palestras.estaVazia());
		List<Palestra> palestrasAgendadasTrilha1 = trilhas.get(0).lerPalestrasAgendadasEmOrdem();
		List<Palestra> palestrasAgendadasTrilha2 = trilhas.get(1).lerPalestrasAgendadasEmOrdem();
		int quantidadeDeAlmocosENetworking = 4;
		
		assertThat(palestrasAgendadasTrilha1.size() + palestrasAgendadasTrilha2.size(), is(equalTo(totalDePalestras() + quantidadeDeAlmocosENetworking)));
		
	}
}
