package br.com.caelum.livraria.dominio;

import org.javamoney.moneta.Money;

public class Livro {
	
	private final String nome;
	private String descricao;
	private final ISBN isbn;
	private final Money valor;
	private Livros recomendacoes;
	
	public Livro(String nome, ISBN isbn, Money valor) {
		this.nome = nome;
		this.isbn = isbn;
		this.valor = valor;
	}
	
	public Money lerValor() {
		return valor;
	}
}
