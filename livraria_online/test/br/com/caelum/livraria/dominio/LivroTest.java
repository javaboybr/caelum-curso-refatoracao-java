package br.com.caelum.livraria.dominio;

import static br.com.caelum.livraria.dominio.ISBNTest.outroIsbnValido;
import static br.com.caelum.livraria.dominio.ISBNTest.umIsbnValido;
import static br.com.caelum.livraria.dominio.Livraria.reais;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class LivroTest {
	
	private static final Money valorDoLivro = Money.of(10, reais);
	private static final String descricao = "descricao";
	public static final Livro umLivro = new Livro("nome do livro", umIsbnValido, valorDoLivro, descricao);
	public static final Livro outroLivro = new Livro("outro nome do livro", outroIsbnValido, valorDoLivro, descricao);
	
	@Test
	public void lerValor() {
		
	}
}
