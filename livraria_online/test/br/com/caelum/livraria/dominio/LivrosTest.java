package br.com.caelum.livraria.dominio;

import static br.com.caelum.livraria.dominio.Livraria.reais;
import static br.com.caelum.livraria.dominio.LivroTest.outroLivro;
import static br.com.caelum.livraria.dominio.LivroTest.umLivro;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class LivrosTest {
	
	private Livros livros;
		
	@Test
	public void lerSubtotalDeColecaoVaziaDeLivros() {
		this.livros = new Livros();
		
		assertThat(livros.lerSubtotal(), is(equalTo(Money.of(0, reais))));
	}
	
	@Test
	public void lerSubTotalDeColecaoComDiversosLivros() {
		this.livros = new Livros(umLivro, outroLivro);
		
		assertThat(livros.lerSubtotal(), is(equalTo(Money.of(20, reais))));
	}
	
	@Test
	public void adicionarLivros() {
		this.livros = new Livros(umLivro);
		this.livros.adicionar(outroLivro);
		
		assertThat(livros, contains(umLivro, outroLivro));
	}
}
