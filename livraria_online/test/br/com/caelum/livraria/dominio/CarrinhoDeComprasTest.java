package br.com.caelum.livraria.dominio;

import static br.com.caelum.livraria.dominio.ClienteTest.outroCliente;
import static br.com.caelum.livraria.dominio.ClienteTest.umCliente;
import static br.com.caelum.livraria.dominio.Livraria.reais;
import static br.com.caelum.livraria.dominio.LivroTest.outroLivro;
import static br.com.caelum.livraria.dominio.LivroTest.umLivro;
import static br.com.caelum.livraria.dominio.TipoDeDesconto.CUPOM_DE_DESCONTO;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class CarrinhoDeComprasTest {
	
	@Test
	public void calcularValorTotalComFreteSemDescontoParaCompraEnvolvendoApenasUmLivro() {
		Money valorFrete = Money.of(1, reais);
		
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(umCliente, umLivro, valorFrete);
		
		assertThat(carrinho.lerValorTotal(), is(equalTo(Money.of(11, reais))));
	}
	
	@Test
	public void calcularValorTotalComFreteComDescontoParaComprasEnvolvendoDoisLivros() {
		Livros livrosSelecionados = new Livros(umLivro, outroLivro);
		Money valorFrete = Money.of(1, reais);
		
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(umCliente, umLivro, valorFrete);
		carrinho.adicionar(outroLivro);
		carrinho.incluirDesconto(new Desconto(livrosSelecionados.lerSubtotal(), CUPOM_DE_DESCONTO));
		
		assertThat(carrinho.lerValorTotal(), is(equalTo(Money.of(16, reais))));
	}
	
	@Test
	public void verificarSeCarrinhoPertenceOuNaoADeterminadosClientes() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(umCliente, umLivro, Money.of(1, reais));
		
		assertThat(carrinho.doCliente(umCliente), is(true));
		assertThat(carrinho.doCliente(outroCliente), is(false));
	}
}
