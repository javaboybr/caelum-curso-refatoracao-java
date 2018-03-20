package br.com.caelum.livraria.dominio;

import static java.math.BigDecimal.ONE;

import java.math.BigDecimal;

import javax.money.MonetaryAmount;
import javax.money.MonetaryOperator;

import org.javamoney.moneta.Money;

public class CalculadoraDeCompra {
	
	// para forçar a não-instanciação dessa classe.
	private CalculadoraDeCompra() {}
	
	// 7 - remover atribuições a parametros: preparar código para usar essa refatoração.
	public static Money calcularValorTotal(Money subtotal, Money valorDoFrete, Desconto desconto) {
		Money ret = subtotal;
		
		MonetaryOperator operacaoDeDesconto = 
				(MonetaryAmount descontoEmReais) -> descontoEmReais
					.multiply(ONE.subtract(desconto.lerValor().divide(BigDecimal.valueOf(100L))));
		ret = ret.with(operacaoDeDesconto);
		ret = ret.add(valorDoFrete);
		return ret;
	}
}
