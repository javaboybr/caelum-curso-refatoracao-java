package br.com.caelum.livraria.dominio;

import static br.com.caelum.livraria.dominio.Livraria.reais;
import static br.com.caelum.livraria.dominio.TipoDeDesconto.CUPOM_DE_DESCONTO;
import static br.com.caelum.livraria.dominio.TipoDeDesconto.FIDELIDADE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class DescontoTest {
	
	private final Money CEM_REAIS = Money.of(100, reais);
	
	@Test
	public void calcularDescontoOriundoDeCupom() {
		Desconto desconto = new Desconto(CEM_REAIS, CUPOM_DE_DESCONTO);
		
		assertThat(desconto.lerValor(), is(equalTo(Money.of(5, reais))));
	}
	
	@Test
	public void calcularDescontoOriundoDeFidelidade() {
		Desconto desconto = new Desconto(CEM_REAIS, FIDELIDADE);
		
		assertThat(desconto.lerValor(), is(equalTo(Money.of(10, reais))));
	}
}
