package br.com.caelum.stella.validation;

public class CNPJValidator extends BaseCadastroPessoaValidator {

	public CNPJValidator(boolean isFormatted) {
		super(isFormatted);
	}
	
	public CNPJValidator() {
		this(false);
	}

	@Override
	protected int[] getMultiplicadores(int[] digitos) {
		if(digitos.length == getDocumentLength() -2) return new int[] {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
		else return new int[] { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
	}

	@Override
	protected int getDocumentLength() {
		return 14;
	}

	@Override
	protected String getRegexFormatted() {
		return DocumentFormats.CNPJ.toString();
	}

	@Override
	protected String getRegexUnformatted() {
		return DocumentFormats.CNPJ_UNFORMATTED.toString();
	}

}
