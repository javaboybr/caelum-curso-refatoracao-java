package br.com.caelum.livraria.dominio;

import org.javamoney.moneta.Money;

public class Livro {
	
	private final String nome;
	private final String descricao;
	private final ISBN isbn;
	private final Money valor;
	
	public Livro(String nome, ISBN isbn, Money valor, String descricao) {
		this.nome = nome;
		this.isbn = isbn;
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public Money lerValor() {
		return valor;
	}
	
	public String lerNome() {
		return nome;
	}
	
	public String lerISBN() {
		return isbn.toString();
	}
	
	public String lerDescricao() {
		return descricao;
	}
}
