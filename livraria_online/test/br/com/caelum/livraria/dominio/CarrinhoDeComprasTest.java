package br.com.caelum.livraria.dominio;

import static br.com.caelum.livraria.dominio.Livraria.reais;
import static br.com.caelum.livraria.dominio.LivroTest.OUTRO_LIVRO;
import static br.com.caelum.livraria.dominio.LivroTest.UM_LIVRO;
import static br.com.caelum.livraria.dominio.ObjetosParaTestes.OUTRO_CLIENTE;
import static br.com.caelum.livraria.dominio.ObjetosParaTestes.UM_CLIENTE;
import static br.com.caelum.livraria.dominio.TipoDeDesconto.CUPOM_DE_DESCONTO;
import static java.time.LocalDate.now;
import static java.time.LocalDate.of;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class CarrinhoDeComprasTest {
	
	@Test
	public void calcularValorTotalComFreteSemDescontoParaCompraEnvolvendoApenasUmLivro() {
		Money valorFrete = Money.of(1, reais);
		
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(UM_CLIENTE, UM_LIVRO, valorFrete, now());
		
		assertThat(carrinho.getValorTotal(), is(equalTo(Money.of(11, reais))));
	}
	
	@Test
	public void calcularValorTotalComFreteComDescontoParaComprasEnvolvendoDoisLivros() {
		Livros livrosSelecionados = new Livros(UM_LIVRO, OUTRO_LIVRO);
		Money valorFrete = Money.of(1, reais);
		
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(UM_CLIENTE, UM_LIVRO, valorFrete, now());
		carrinho.getLivros().adicionar(OUTRO_LIVRO);
		carrinho.incluirDesconto(new Desconto(livrosSelecionados.getSubtotal(), CUPOM_DE_DESCONTO));
		
		assertThat(carrinho.getValorTotal(), is(equalTo(Money.of(16, reais))));
	}
	
	@Test
	public void verificarSeCarrinhoPertenceOuNaoADeterminadosClientes() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(UM_CLIENTE, UM_LIVRO, Money.of(1, reais), now());
		
		assertThat(carrinho.doCliente(UM_CLIENTE), is(true));
		assertThat(carrinho.doCliente(OUTRO_CLIENTE), is(false));
	}
	
	@Test
	public void calcularDataDeEntregaQueCaiaNumDiaDaSemana() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(UM_CLIENTE, UM_LIVRO, Money.of(1, reais), of(2018, 3, 25));
		
		assertThat(carrinho.getDataDeEntrega(), is(equalTo(of(2018, 3, 30))));
	}
	
	@Test
	public void calcularDataDeEntregaQueCaiaNumSabado() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(UM_CLIENTE, UM_LIVRO, Money.of(1, reais), of(2018, 3, 26));
		
		assertThat(carrinho.getDataDeEntrega(), is(equalTo(of(2018, 4, 2))));
	}
	
	@Test
	public void calcularDataDeEntregaQueCaiaNumDomingo() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(UM_CLIENTE, UM_LIVRO, Money.of(1, reais), of(2018, 3, 27));
		
		assertThat(carrinho.getDataDeEntrega(), is(equalTo(of(2018, 4, 2))));
	}
}
