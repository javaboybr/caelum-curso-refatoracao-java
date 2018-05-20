package br.com.caelum.livraria.dominio;

import static br.com.caelum.livraria.dominio.Livraria.reais;
import static br.com.caelum.livraria.dominio.TipoDeDesconto.CUPOM_DE_DESCONTO;
import static br.com.caelum.livraria.dominio.TipoDeDesconto.NENHUM;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class CalculadoraDeCompraTest {
	
	private final Money subtotal = Money.of(100, reais);
	private final Money frete = Money.of(1, reais);
	
	private final CalculadoraDeCompra calculadora = new CalculadoraDeCompra();
	
	@Test
	public void calcularValorDaCompraComFreteESemDesconto() {
		Money valorObtido = calculadora.calcularValorTotal(subtotal, frete, new Desconto(subtotal, NENHUM));
		
		assertThat(valorObtido, is(equalTo(Money.of(101, reais))));
	}
	
	@Test
	public void calcularValorDaCompraComFreteEDesconto() {
		Money valorObtido = calculadora.calcularValorTotal(subtotal, frete, new Desconto(subtotal, CUPOM_DE_DESCONTO));
		
		assertThat(valorObtido, is(equalTo(Money.of(96, reais))));
	}
	
	@Test
	public void calcularValorDaCompraComSubtotalIgualAZero() {
		Money valorObtido = calculadora.calcularValorTotal(Money.of(0, reais), frete, new Desconto(subtotal, CUPOM_DE_DESCONTO));
		
		assertThat(valorObtido, is(equalTo(Money.of(0, reais))));
	}
}
