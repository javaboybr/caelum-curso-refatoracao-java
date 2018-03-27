package br.com.caelum.livraria.service;

import br.com.caelum.livraria.dominio.Livros;
import br.com.caelum.livraria.dominio.TodosLivros;

public class ListagemDeLivrosDisponiveis {
	
	private final TodosLivros todosLivros;
	
	public ListagemDeLivrosDisponiveis(TodosLivros todosLivros) {
		this.todosLivros = todosLivros;
	}
	
	public Livros listagemPor(String nome) {
		return todosLivros.por(nome);
	}
}
