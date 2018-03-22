package br.com.caelum.livraria.dominio;

import static br.com.caelum.livraria.dominio.Livraria.reais;
import static java.math.BigDecimal.ONE;

import java.math.BigDecimal;

import javax.money.MonetaryAmount;
import javax.money.MonetaryOperator;

import org.javamoney.moneta.Money;

public enum TipoDeDesconto {
	
	CUPOM_DE_DESCONTO(5) {

		@Override
		MonetaryOperator operacaoDeDesconto() {
			return (MonetaryAmount quantia) -> quantia
					.subtract(Money.of(fatorDeCalculo, reais));
		}
		
	}, FIDELIDADE(10) {

		@Override
		MonetaryOperator operacaoDeDesconto() {
			return (MonetaryAmount quantia) -> quantia
					.multiply(ONE.subtract(porcentagem()));
		}
		
		private BigDecimal porcentagem() {
			return fatorDeCalculo.divide(BigDecimal.valueOf(100));
		}

	}, NENHUM(0){

		@Override
		MonetaryOperator operacaoDeDesconto() {
			return (MonetaryAmount quantia) -> quantia;
		}
		
	};
	
	protected BigDecimal fatorDeCalculo;
	
	private TipoDeDesconto(double fatorDeCalculo) {
		this.fatorDeCalculo = BigDecimal.valueOf(fatorDeCalculo);
	}

	public Money calcularBaseadoEm(Money subtotal) {
		return subtotal.subtract(subtotal.with(operacaoDeDesconto()));
	}
	
	abstract MonetaryOperator operacaoDeDesconto();
}