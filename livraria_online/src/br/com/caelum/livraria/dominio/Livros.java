package br.com.caelum.livraria.dominio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.javamoney.moneta.Money;

public class Livros { 
	
	private final List<Livro> livros;
	
	public Livros(Livro ... livros) {
		this.livros = Arrays.stream(livros)
				.collect(Collectors.toList());
	}
	
	public Money lerSubtotal() {
		return livros.stream()
				.map(Livro::lerValor)
				.reduce(Money.of(0, Livraria.reais), Money::add);
	}
}
