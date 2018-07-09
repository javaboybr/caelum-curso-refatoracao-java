package br.com.caelum.livraria.dominio;

import static javax.money.format.AmountFormatQueryBuilder.of;
import static org.javamoney.moneta.format.CurrencyStyle.SYMBOL;

import java.util.Locale;

import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.Money;

public class FormatadorUtils {
	
	private FormatadorUtils() {}
	
	public static final String getValorFormatado(Money valor) {
		return MonetaryFormats
				.getAmountFormat(of(Locale.getDefault()).set(SYMBOL).build()).format(valor);
	}
}
