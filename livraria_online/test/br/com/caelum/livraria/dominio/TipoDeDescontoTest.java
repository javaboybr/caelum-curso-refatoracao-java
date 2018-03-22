package br.com.caelum.livraria.dominio;

import static br.com.caelum.livraria.dominio.Livraria.reais;
import static br.com.caelum.livraria.dominio.TipoDeDesconto.CUPOM_DE_DESCONTO;
import static br.com.caelum.livraria.dominio.TipoDeDesconto.FIDELIDADE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class TipoDeDescontoTest {
	
	private final Money CEM_REAIS = Money.of(100, reais);
	
	@Test
	public void calcularDescontoParaCupomDeDesconto() {
		Money descontoEmReais = CUPOM_DE_DESCONTO.calcularBaseadoEm(CEM_REAIS);
		
		assertThat(descontoEmReais, is(equalTo(Money.of(5, reais))));
	}
	
	@Test
	public void calcularDescontoParaFidelidade() {
		Money descontoEmReais = FIDELIDADE.calcularBaseadoEm(CEM_REAIS);
		
		assertThat(descontoEmReais, is(equalTo(Money.of(10, reais))));
	}
	
	@Test
	public void calcularDescontoParaNenhumTipo() {
		Money descontoEmReais = TipoDeDesconto.NENHUM.calcularBaseadoEm(CEM_REAIS);
		
		assertThat(descontoEmReais, is(equalTo(Money.of(0, reais))));
	}
}
