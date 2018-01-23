package br.com.caelum.stella.validation;

public enum DocumentFormats {
	
	CPF("(\\d{3})[.](\\d{3})[.](\\d{3})-(\\d{2})"),
	CPF_UNFORMATTED("(\\d{3})(\\d{3})(\\d{3})(\\d{2})"),
	CPF_DIGITS_ONLY("^\\d{11}$"),
	
	CNPJ("(\\d{2})[.](\\d{3})[.](\\d{3})\\/(\\d{4})-(\\d{2})"),
	CNPJ_UNFORMATTED("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})"),
	CNPJ_DIGITS_ONLY("^\\d{14}$"),
	
	TITULO_ELEITORAL("(\\d{10})/(\\d{2})"),
	TITULO_ELEITORAL_UNFORMATTED("(\\d{10})(\\d{2})"),
	TITULO_ELEITORAL_DIGITS_ONLY("^\\d{12}$"),
	
	CEP("(\\d{5})-(\\d{3})"),
	CEP_UNFORMATTED("(\\d{5})(\\d{3})"),
	CEP_DIGITS_ONLY("^\\d{8}$");
	
	private String regex;
	
	private DocumentFormats(String regex) {
		this.regex = regex;
	}
	
	@Override
	public String toString() {
		return regex;
	}
}
