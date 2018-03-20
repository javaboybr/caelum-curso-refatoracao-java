package br.com.caelum.livraria.dominio;

import org.javamoney.moneta.Money;

public class Compra {
	
	private final Money valorFrete;
	private final Livros livros;
	private Desconto desconto;
	
	public Compra(Livros livros, Money valorFrete) {
		this.livros = livros;
		this.valorFrete = valorFrete;
		this.desconto = Desconto.NENHUM;
	}

	public Money lerValorTotal() {
		return CalculadoraDeCompra.calcularValorTotal(livros.lerSubtotal(), valorFrete, desconto);
	}

	public void incluirDesconto(Desconto desconto) {
		this.desconto = desconto;
	}
}
