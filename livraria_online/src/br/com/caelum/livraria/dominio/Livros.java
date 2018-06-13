package br.com.caelum.livraria.dominio;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.javamoney.moneta.Money;

public class Livros implements Iterable<Livro> { 
	
	private final List<Livro> lista;
	
	public Livros(Livro ... livros) {
		this.lista = Arrays.stream(livros)
				.collect(Collectors.toList());
	}
	
	//9 - substituir algoritmo: é possível utilizar for e outros recursos para tornar o código "bagunçado" e 
	// exemplificar essa técnica de refatoração.
	public Money getSubtotal() {
		return lista.stream()
				.map(Livro::getValor)
				.reduce(Money.of(0, Livraria.reais), Money::add);
	}

	@Override
	public Iterator<Livro> iterator() {
		return lista.iterator();
	}

	public void adicionar(Livro livro) {
		this.lista.add(livro);
	}
}
