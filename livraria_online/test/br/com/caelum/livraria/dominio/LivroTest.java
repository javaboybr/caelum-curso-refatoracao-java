package br.com.caelum.livraria.dominio;

import static br.com.caelum.livraria.dominio.ISBNTest.outroIsbnValido;
import static br.com.caelum.livraria.dominio.ISBNTest.umIsbnValido;
import static br.com.caelum.livraria.dominio.Livraria.reais;
import static br.com.caelum.livraria.dominio.ObjetosParaTestes.umAutor;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class LivroTest {
	
	private static final Money VALOR_DO_LIVRO = Money.of(10, reais);
	public static final Livro UM_LIVRO = new Livro("nome do livro", umAutor, umIsbnValido, VALOR_DO_LIVRO);
	public static final Livro OUTRO_LIVRO = new Livro("outro nome do livro", umAutor, outroIsbnValido, VALOR_DO_LIVRO);
	
	@Test
	public void livroDeveRetornarSeuValorFormatado() {
		assertThat(UM_LIVRO.getValorFormatado(), is(equalTo("R$10,00")));
	}
	
	@Test
	public void livroDeveRetornarSeuNomeSemFormatacao() {
		assertThat(UM_LIVRO.getNome(), is(equalTo("nome do livro")));
	}
	
	@Test
	public void livroDeveRetornarSeuISBNFormatadoEComoString() {
		assertThat(UM_LIVRO.getISBN(), is(equalTo(umIsbnValido.toString())));
	}
	
	@Test
	public void livroDeveRetornarONomeDeSeuAutorFormatado() {
		assertThat(UM_LIVRO.getAutor(), is(equalTo(umAutor.toString())));
	}
}
