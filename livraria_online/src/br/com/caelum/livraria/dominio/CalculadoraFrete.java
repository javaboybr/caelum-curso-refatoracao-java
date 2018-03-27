package br.com.caelum.livraria.dominio;

import org.javamoney.moneta.Money;

public interface CalculadoraFrete {

	public Money baseadoEm(String cep);

}
