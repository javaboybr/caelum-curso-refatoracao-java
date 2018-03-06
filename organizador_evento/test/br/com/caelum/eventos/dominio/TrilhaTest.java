package br.com.caelum.eventos.dominio;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TrilhaTest {
	
	@Test
	public void lerNomedaTrilha() {
		Trilha umaTrilha = new Trilha("teste", new SessaoDaManha(), new SessaoDaTarde());
		
		assertThat(umaTrilha.nome(), is(equalTo("Trilha teste")));
	}
}
