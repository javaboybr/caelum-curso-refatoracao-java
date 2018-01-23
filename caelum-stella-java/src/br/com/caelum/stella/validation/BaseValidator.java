package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.stella.validation.error.DocumentError;
import br.com.caelum.stella.validation.error.InvalidStateException;

public abstract class BaseValidator {

	protected final boolean isFormatted;

	public BaseValidator(boolean isFormatted) {
		this.isFormatted = isFormatted;
	}

	public void assertValid(String document) throws InvalidStateException {
		List<String> errors = getInvalidValues(document);
		if(!errors.isEmpty()) throw new InvalidStateException(errors);
	}

	private List<String> getInvalidValues(String document) {
		List<String> errors = new ArrayList<>();

		if (document != null && !document.isEmpty()) {
			String unformattedDocument = document;
			if (isFormatted) {
				if (!checkFormattedDocument(document))
					errors.add(DocumentError.INVALID_FORMAT.toString());

				return errors;
			}
			unformattedDocument = new Document().UnformatDocument(document);

			if (!checkUnformattedDocument(unformattedDocument))
				errors.add(DocumentError.INVALID_DIGITS.toString());
			else if (!checkMoreThan1DistinctDigit(unformattedDocument))
				errors.add(DocumentError.REPEATED_DIGITS.toString());
			else
			{
				if (!checkDocumentLength(unformattedDocument))
					errors.add(DocumentError.INVALID_DIGITS.toString());

				String documentSubstring = unformattedDocument.substring(0, getDocumentLength() - 2);

				if (unformattedDocument != documentSubstring 
						+ getDigitoVerificador(documentSubstring).toString()
						+ getDigitoVerificador(documentSubstring + getDigitoVerificador(documentSubstring).toString()).toString())
					errors.add(DocumentError.INVALID_CHECK_DIGITS.toString());
			}

			if (!checkCountryState(unformattedDocument)) {
				errors.add(DocumentError.INVALID_COUNTRY_STATE.toString());
			}
		}

		return errors;
	}

	private boolean checkMoreThan1DistinctDigit(String unformattedDocument) {
		return unformattedDocument.chars().distinct().count() > 1;
	}

	private boolean checkDocumentLength(String document) {
		return document.length() == getDocumentLength();
	}

	private boolean checkFormattedDocument(String formattedDocument) {
		return Pattern.matches(getRegexFormatted(), formattedDocument);
	}

	private boolean checkUnformattedDocument(String unformattedDocument) {
		return Pattern.matches(getRegexUnformatted(), unformattedDocument);
	}

	protected  boolean checkCountryState(String document) {
		return true;
	}

	protected int getComplementoDoModuloDe11(int soma) {
		return 11 - (soma % 11);
	}

	protected int getSomaDosProdutos(String documentSubstring, int[] digitos, int[] multiplicadores) {
		int soma = 0;
		for (int i = 0; i < documentSubstring.length(); i++)
			soma += digitos[i] * multiplicadores[i];
		return soma;
	}

	protected abstract int[] getMultiplicadores(int[] digitos);

	protected static int[] getDigitos(String documentSubstring) {	
		return documentSubstring.replaceAll("[^0-9]+", "").chars().toArray();
	}

	protected abstract Integer getDigitoVerificador(String documentString);
	protected abstract int getDocumentLength();
	protected abstract String getRegexFormatted();
	protected abstract String getRegexUnformatted();
}

class Document {
	public String UnformatDocument(String document) {
		return document.replace(".", "").replace("-", "").replace("/", ""); 
	}
}
