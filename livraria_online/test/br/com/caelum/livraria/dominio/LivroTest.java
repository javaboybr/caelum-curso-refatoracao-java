package br.com.caelum.livraria.dominio;

import static br.com.caelum.livraria.dominio.AutorTest.umAutor;
import static br.com.caelum.livraria.dominio.ISBNTest.outroIsbnValido;
import static br.com.caelum.livraria.dominio.ISBNTest.umIsbnValido;
import static br.com.caelum.livraria.dominio.Livraria.reais;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class LivroTest {
	
	private static final Money valorDoLivro = Money.of(10, reais);
	public static final Livro umLivro = new Livro("nome do livro", umAutor, umIsbnValido, valorDoLivro);
	public static final Livro outroLivro = new Livro("outro nome do livro", umAutor, outroIsbnValido, valorDoLivro);
	
	@Test
	public void livroDeveRetornarSeuValorFormatado() {
		assertThat(umLivro.getValorFormatado(), is(equalTo("R$10,00")));
	}
	
	@Test
	public void livroDeveRetornarSeuNomeSemFormatacao() {
		assertThat(umLivro.getNome(), is(equalTo("nome do livro")));
	}
	
	@Test
	public void livroDeveRetornarSeuISBNFormatadoEComoString() {
		assertThat(umLivro.getISBN(), is(equalTo(umIsbnValido.toString())));
	}
	
	@Test
	public void livroDeveRetornarONomeDeSeuAutorFormatado() {
		assertThat(umLivro.getAutor(), is(equalTo(umAutor.toString())));
	}
}
