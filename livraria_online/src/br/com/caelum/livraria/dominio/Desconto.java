package br.com.caelum.livraria.dominio;

import org.javamoney.moneta.Money;

public class Desconto {

	private final Money subtotal;
	private final TipoDeDesconto tipo;
	
	public static final Desconto NENHUM = 
			new Desconto(Money.of(0, Livraria.reais), TipoDeDesconto.NENHUM);

	public Desconto(Money subtotal, TipoDeDesconto tipo) {
		this.subtotal = subtotal;
		this.tipo = tipo;
	}

	// 10 - mover método: preprarar código que necessite dessa refatoração.
	public Money lerValor() {
		return tipo.calcularBaseadoEm(subtotal);
	}

}
