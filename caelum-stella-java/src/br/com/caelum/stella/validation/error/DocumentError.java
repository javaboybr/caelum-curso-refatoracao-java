package br.com.caelum.stella.validation.error;

public enum DocumentError {

	INVALID_FORMAT("Formato inválido!"),
	REPEATED_DIGITS("Dígito repetido!"),
	INVALID_CHECK_DIGITS("Dígito de verificação inválido!"),
	INVALID_DIGITS("Dígito inválido!"),
	DOCUMENT_IS_EMPTY("Número não informado!"),
	INVALID_COUNTRY_STATE("UF inválida!");
	
	private String descricao;
	
	private DocumentError(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
}
