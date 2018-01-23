package br.com.caelum.stella.validation;

public class TituloEleitoralValidator extends BaseValidator {

	public TituloEleitoralValidator() {
		this(false);
	}
	
	public TituloEleitoralValidator(boolean isFormatted) {
		super(isFormatted);
	}

	@Override
	protected int[] getMultiplicadores(int[] digitos) {
        if (digitos.length == getDocumentLength() - 2)
            return new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 0, 0 };
        else
            return new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 7, 8, 9 };
	}

	@Override
	protected Integer getDigitoVerificador(String documentString) {
        int[] digitos = getDigitos(documentString);
        int modulo = (getSomaDosProdutos(documentString, digitos, getMultiplicadores(digitos)) % 11) % 10;

        if (modulo > 9) return 0;
        else return modulo;
	}

	@Override
	protected int getDocumentLength() {
		return 12;
	}

	@Override
	protected String getRegexFormatted() {
		return DocumentFormats.TITULO_ELEITORAL.toString();
	}

	@Override
	protected String getRegexUnformatted() {
		return DocumentFormats.TITULO_ELEITORAL_UNFORMATTED.toString();
	}

}
