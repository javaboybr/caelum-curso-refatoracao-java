package br.com.caelum.livraria.dominio;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.javamoney.moneta.Money;

public class Livros implements Iterable<Livro> { 
	
	private final List<Livro> livros;
	
	public Livros(Livro ... livros) {
		this.livros = Arrays.stream(livros)
				.collect(Collectors.toList());
	}
	
	private Livros(List<Livro> livros) {
		this.livros = livros;
	}
	
	//9 - substituir algoritmo: é possível utilizar for e outros recursos para tornar o código "bagunçado" e 
	// exemplificar essa técnica de refatoração.
	public Money lerSubtotal() {
		return livros.stream()
				.map(Livro::lerValor)
				.reduce(Money.of(0, Livraria.reais), Money::add);
	}

	@Override
	public Iterator<Livro> iterator() {
		return livros.iterator();
	}

	public void adicionar(Livro livro) {
		this.livros.add(livro);
	}
}
