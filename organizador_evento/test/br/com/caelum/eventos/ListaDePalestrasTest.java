package br.com.caelum.eventos;

import static br.com.caelum.eventos.dominio.TempoDeDuracao.LIGHTING;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import br.com.caelum.eventos.dominio.ListaDePalestras;
import br.com.caelum.eventos.dominio.Palestra;

public class ListaDePalestrasTest {
	
	private final Palestra palestra = new Palestra("strings e caracteres", LIGHTING);
	
	@Test
	public void obterProximaPalestraDeUmaLista(){
		Set<Palestra> palestras = Set.of(palestra);
		ListaDePalestras lista = new ListaDePalestras(palestras);
		
		assertTrue(lista.iterator().hasNext());
		
		Palestra palestraObtida = lista.obterProxima();
		assertThat(palestraObtida, is(equalTo(palestra)));
		assertTrue(lista.estaVazia());
	}
	
	@Test
	public void obterProximaPalestraEDevolverEmSeguida(){
		Set<Palestra> palestras = Set.of(palestra);
		ListaDePalestras lista = new ListaDePalestras(palestras);
		Palestra palestraObtida = lista.obterProxima();
		lista.devolver(palestraObtida);
		
		assertFalse(lista.estaVazia());
	}
	
	@Test
	public void criarUmaListaVaziaDePalestras() {
		ListaDePalestras listaVazia = new ListaDePalestras();
		
		assertTrue(listaVazia.estaVazia());
		assertFalse(listaVazia.iterator().hasNext());
	}
	
	@Test
	public void inserirPalestraEmListaInicialmenteVazia() {
		ListaDePalestras lista = new ListaDePalestras();
		lista.adicionar(palestra);
		
		assertTrue(lista.iterator().hasNext());
	}
	
	@Test
	public void removerTodasAsPalestrasDeUmaListaVazia() {
		ListaDePalestras lista = new ListaDePalestras();
		ListaDePalestras listaComRemocoes = lista.removerTodas();
		
		assertTrue(lista.estaVazia());
		assertTrue(listaComRemocoes.estaVazia());
	}
	
	@Test
	public void removerTodasAsPalestrasDeUmaListaUnitaria() {
		Set<Palestra> palestras = Set.of(palestra);
		ListaDePalestras lista = new ListaDePalestras(palestras);
		
		ListaDePalestras listaComRemocoes = lista.removerTodas();
		
		assertTrue(lista.estaVazia());
		assertThat(listaComRemocoes, hasItem(palestra));
	}
}
