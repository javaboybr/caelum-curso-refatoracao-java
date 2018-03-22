package br.com.caelum.livraria.dominio;

import static br.com.caelum.livraria.dominio.ISBNTest.outroIsbnValido;
import static br.com.caelum.livraria.dominio.ISBNTest.umIsbnValido;
import static br.com.caelum.livraria.dominio.Livraria.reais;
import static br.com.caelum.livraria.dominio.TipoDeDesconto.CUPOM_DE_DESCONTO;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class CompraTest {
	
	@Test
	public void calcularValorTotalComFreteSemDescontoParaCompraEnvolvendoApenasUmLivro() {
		Money valorDoLivro = Money.of(10, reais);
		Livro umLivro = new Livro("nome do livro", umIsbnValido, valorDoLivro);
		Livros livrosSelecionados = new Livros(umLivro);
		Money valorFrete = Money.of(1, reais);
		
		Compra compra = new Compra(livrosSelecionados, valorFrete);
		
		assertThat(compra.lerValorTotal(), is(equalTo(Money.of(11, reais))));
	}
	
	@Test
	public void calcularValorTotalComFreteComDescontoParaComprasEnvolvendoDoisLivros() {
		Money valorDoLivro = Money.of(10, reais);
		Livro umLivro = new Livro("um livro", umIsbnValido, valorDoLivro);
		Livro outroLivro = new Livro("outro nome do livro", outroIsbnValido, valorDoLivro);
		Livros livrosSelecionados = new Livros(umLivro, outroLivro);
		Money valorFrete = Money.of(1, reais);
		
		Compra compra = new Compra(livrosSelecionados, valorFrete);
		compra.incluirDesconto(new Desconto(livrosSelecionados.lerSubtotal(), CUPOM_DE_DESCONTO));
		
		assertThat(compra.lerValorTotal(), is(equalTo(Money.of(16, reais))));
	}
}
