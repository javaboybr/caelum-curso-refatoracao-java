package br.com.caelum.livraria.dominio;

import org.javamoney.moneta.Money;

public class CalculadoraDeCompra {
	
	// 7 - remover atribuições a parametros: aplicar essa técnica de refatoração.
	public Money calcularValorTotal(Money subtotal, Money valorDoFrete, Desconto desconto) {
		if(subtotal.isZero()) return subtotal;
		subtotal = subtotal.subtract(desconto.getValor());
		subtotal = subtotal.add(valorDoFrete);
		return subtotal;
	}
}
