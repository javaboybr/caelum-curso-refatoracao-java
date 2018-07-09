package br.com.caelum.livraria.dominio;

import org.javamoney.moneta.Money;

public class Livro {
	
	private final String nome;
	private final Autor autor;
	private final ISBN isbn;
	private final Money valor;
	
	public Livro(String nome, Autor autor, ISBN isbn, Money valor) {
		this.nome = nome;
		this.autor = autor;
		this.isbn = isbn;
		this.valor = valor;
	}
	
	public Money getValor() {
		return valor;
	}
	
	//15 - remover intermediário: o código contido em FormatadorUtils.getValorFormatado deve retornar 
	// para esse método. Deve-se remover, portanto, a classe FormatadorUtils e seu teste durante a
	// refatoração.
	public String getValorFormatado() {
		return FormatadorUtils.getValorFormatado(valor);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getISBN() {
		return isbn.toString();
	}
	
	public String getAutor() {
		return autor.getNomeFormatado();
	}
}
