package br.com.caelum.eventos;

import static br.com.caelum.eventos.dominio.TempoDeDuracao.LIGHTING;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import br.com.caelum.eventos.dominio.ListaDePalestras;
import br.com.caelum.eventos.dominio.Palestra;

public class ListaDePalestrasTest {
	
	@Test
	public void obterProximaPalestraDeUmaLista(){
		Palestra palestraAObter = new Palestra("strings e caracteres", LIGHTING);
		Set<Palestra> palestras = new HashSet<>();
		palestras.add(palestraAObter);
		ListaDePalestras lista = new ListaDePalestras(palestras);
		Palestra palestraObtida = lista.obterProxima();
		
		assertThat(palestraObtida, is(equalTo(palestraAObter)));
		assertTrue(lista.estaVazia());
	}
	
	@Test
	public void obterProximaPalestraEDevolverEmSeguida(){
		Palestra palestraAObter = new Palestra("strings e caracteres", LIGHTING);
		Set<Palestra> palestras = new HashSet<>();
		palestras.add(palestraAObter);
		ListaDePalestras lista = new ListaDePalestras(palestras);
		Palestra palestraObtida = lista.obterProxima();
		
		lista.devolver(palestraObtida);
		
		assertFalse(lista.estaVazia());
	}
}
