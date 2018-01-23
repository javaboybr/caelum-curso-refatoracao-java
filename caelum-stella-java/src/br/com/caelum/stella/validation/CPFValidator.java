package br.com.caelum.stella.validation;

public class CPFValidator extends BaseCadastroPessoaValidator {

	public CPFValidator() {
		this(false);
	}
	
	public CPFValidator(boolean isFormatted) {
		super(isFormatted);
	}

	@Override
	protected int[] getMultiplicadores(int[] digitos) {
	    if (digitos.length == getDocumentLength() - 2)
            return new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
        else
            return new int[] { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	}

	@Override
	protected int getDocumentLength() {
		return 11;
	}

	@Override
	protected String getRegexFormatted() {
		return DocumentFormats.CPF.toString();
	}

	@Override
	protected String getRegexUnformatted() {
		return DocumentFormats.CPF_UNFORMATTED.toString();
	}

}
