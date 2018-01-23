package br.com.caelum.stella.validation;

public abstract class BaseCadastroPessoaValidator extends BaseValidator {

	public BaseCadastroPessoaValidator(boolean isFormatted) {
		super(isFormatted);
	}

	@Override
	protected Integer getDigitoVerificador(String documentString) {
		int result = 0;
		int[] digitos = getDigitos(documentString);
		int subtracao = getComplementoDoModuloDe11(
				getSomaDosProdutos(documentString, digitos, getMultiplicadores(digitos)));
		if(subtracao > 9) result = 0;
		else result = subtracao;
		return result;
	}
}
