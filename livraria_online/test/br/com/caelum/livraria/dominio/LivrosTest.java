package br.com.caelum.livraria.dominio;

import static br.com.caelum.livraria.dominio.ISBNTest.outroIsbnValido;
import static br.com.caelum.livraria.dominio.ISBNTest.umIsbnValido;
import static br.com.caelum.livraria.dominio.Livraria.reais;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class LivrosTest {
	
	private Livros livros;
	
	private final Livro umLivro = new Livro("um livro", umIsbnValido, Money.of(5, Livraria.reais));
	private final Livro outroLivro = new Livro("outro livro", outroIsbnValido, Money.of(5, Livraria.reais));

	
	@Test
	public void lerSubtotalDeColecaoVaziaDeLivros() {
		this.livros = new Livros();
		
		assertThat(livros.lerSubtotal(), is(equalTo(Money.of(0, reais))));
	}
	
	@Test
	public void lerSubTotalDeColecaoComDiversosLivros() {
		this.livros = new Livros(umLivro, outroLivro);
		
		assertThat(livros.lerSubtotal(), is(equalTo(Money.of(10, reais))));
	}
	
	@Test
	public void adicionarLivros() {
		this.livros = new Livros(umLivro);
		this.livros.adicionar(outroLivro);
		
		assertThat(livros, contains(umLivro, outroLivro));
	}
}
