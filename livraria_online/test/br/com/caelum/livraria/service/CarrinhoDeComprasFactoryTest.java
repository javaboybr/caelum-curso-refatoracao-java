package br.com.caelum.livraria.service;

import static br.com.caelum.livraria.dominio.ClienteTest.outroCliente;
import static br.com.caelum.livraria.dominio.ClienteTest.umCliente;
import static br.com.caelum.livraria.dominio.Livraria.reais;
import static br.com.caelum.livraria.dominio.LivroTest.umLivro;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import org.javamoney.moneta.Money;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.livraria.dominio.CarrinhoDeCompras;
import br.com.caelum.livraria.dominio.CarrinhoDeComprasFactory;

public class CarrinhoDeComprasFactoryTest {
	
	private CarrinhoDeComprasFactory factory;
	private final Money valorFrete = Money.of(10, reais);
	
	@Before
	public void setUp() {
		factory = new CarrinhoDeComprasFactory();
	}
	
	@Test
	public void criarNovoCarrinhoEmFactorySemCarrinhos() {
		CarrinhoDeCompras carrinho = factory.obterCarrinho(umCliente, umLivro, valorFrete);
		
		assertThat(factory, contains(carrinho));
	}
	
	@Test
	public void criarNovoCarrinhoEmFactoryContendoUmCarrinho() {
		CarrinhoDeCompras umCarrinho = factory.obterCarrinho(umCliente, umLivro, valorFrete);
		CarrinhoDeCompras outroCarrinho = factory.obterCarrinho(outroCliente, umLivro, valorFrete);
		
		assertThat(factory, contains(umCarrinho, outroCarrinho));
	}
	
	@Test
	public void atualizarCarrinhoExistente() {
		CarrinhoDeCompras umCarrinho = factory.obterCarrinho(umCliente, umLivro, valorFrete);
		factory.obterCarrinho(umCliente, umLivro, valorFrete);		
		
		assertThat(factory, contains(umCarrinho));
	}
}
