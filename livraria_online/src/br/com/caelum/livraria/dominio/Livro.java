package br.com.caelum.livraria.dominio;

import java.util.Locale;

import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.CurrencyStyle;

public class Livro {
	
	private final String nome;
	private final ISBN isbn;
	private final Money valor;
	
	public Livro(String nome, ISBN isbn, Money valor) {
		this.nome = nome;
		this.isbn = isbn;
		this.valor = valor;
	}
	
	public Money lerValor() {
		return valor;
	}
	
	public String lerValorFormatado() {
		return MonetaryFormats
				.getAmountFormat(AmountFormatQueryBuilder
						.of(Locale.getDefault()).set(CurrencyStyle.SYMBOL).build()).format(valor);
	}
	
	public String lerNome() {
		return nome;
	}
	
	public String lerISBN() {
		return isbn.toString();
	}
}
