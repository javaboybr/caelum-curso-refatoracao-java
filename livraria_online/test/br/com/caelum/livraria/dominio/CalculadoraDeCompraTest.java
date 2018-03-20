package br.com.caelum.livraria.dominio;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.ZERO;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class CalculadoraDeCompraTest {
	
	@Test
	public void calcularValorDaCompraComFreteESemDesconto() {
		Money valorObtido = CalculadoraDeCompra.calcularValorTotal(quantiaDe(TEN), quantiaDe(ONE), new Desconto(ZERO));
		
		assertThat(valorObtido, is(equalTo(quantiaDe(new BigDecimal("11.00")))));
	}
	
	@Test
	public void calcularValorDaCompraComFreteEDesconto() {
		Money valorObtido = CalculadoraDeCompra.calcularValorTotal(quantiaDe(TEN), quantiaDe(ONE), new Desconto(TEN));
		
		assertThat(valorObtido, is(equalTo(quantiaDe(TEN))));
	}
	
	private Money quantiaDe(BigDecimal quantia) {
		return Money.of(quantia, Livraria.reais);
	}
}
