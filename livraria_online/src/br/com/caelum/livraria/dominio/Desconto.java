package br.com.caelum.livraria.dominio;

import java.math.BigDecimal;

public class Desconto {

	private final BigDecimal porcentagem;
	
	public static final Desconto NENHUM = new Desconto();
	
	private Desconto() {
		this(BigDecimal.ZERO);
	}

	public Desconto(BigDecimal porcentagem) {
		this.porcentagem = porcentagem;
	}

	public BigDecimal lerValor() {
		return porcentagem;
	}

}
