package br.com.caelum.livraria.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.livraria.dominio.Livros;
import br.com.caelum.livraria.dominio.TodosLivros;

public class ListagemDeLivrosDisponiveisTest {
	
	private ListagemDeLivrosDisponiveis servico;
	private TodosLivros todosLivros;
	
	@Before
	public void setUp() {
		this.todosLivros = mock(TodosLivros.class);
		this.servico = new ListagemDeLivrosDisponiveis(todosLivros);
	}
	
	@Test
	public void retornarListaVaziaDeLivros() {
		Livros esperados = new Livros();
		when(todosLivros.por(anyString())).thenReturn(esperados);
		
		Livros obtidos = servico.listagemPor("nome qualquer");
		
		assertThat(obtidos, is(equalTo(esperados)));
	}
}
