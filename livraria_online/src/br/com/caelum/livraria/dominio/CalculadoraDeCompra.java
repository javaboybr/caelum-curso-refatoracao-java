package br.com.caelum.livraria.dominio;

import org.javamoney.moneta.Money;

public class CalculadoraDeCompra {
	
	// para forçar a não-instanciação dessa classe.
	private CalculadoraDeCompra() {}
	
	// 7 - remover atribuições a parametros: preparar código para usar essa refatoração.
	public static Money calcularValorTotal(Money subtotal, Money valorDoFrete, Desconto desconto) {
		Money valorTotal = subtotal;
		if(valorTotal.isZero()) return valorTotal;
		valorTotal = valorTotal.subtract(desconto.lerValor());
		valorTotal = valorTotal.add(valorDoFrete);
		return valorTotal;
	}
}
