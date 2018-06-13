package br.com.caelum.livraria.dominio;

import static javax.money.format.AmountFormatQueryBuilder.of;
import static org.javamoney.moneta.format.CurrencyStyle.SYMBOL;

import java.util.Locale;

import javax.money.format.MonetaryFormats;

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
	
	//15 - remover intermediário: para demonstrar essa refatoração, será criada uma classe que
	// realizará apenas a formatação desse valor monetário e a formatação de cep do cliente. Uma
	// espécie de FormatadorUtils.
	public String getValorFormatado() {
		return MonetaryFormats
				.getAmountFormat(of(Locale.getDefault()).set(SYMBOL).build()).format(valor);
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
