package br.com.caelum.stella.http;

import static java.util.regex.Pattern.matches;

import br.com.caelum.stella.http.exception.InvalidZipCodeFormatException;
import br.com.caelum.stella.validation.DocumentFormats;

// TODO: TERMINAR?
public class CEP {
	
	private final String cepAsString;
	
	public CEP(String cepAsString) {
		if(cepAsString == null) this.cepAsString = null;
		else if(matches(getRegexFormatted(), cepAsString)) this.cepAsString = unformatCEP(cepAsString);
		else if(matches(getRegexUnformatted(), cepAsString)) this.cepAsString = cepAsString;
		else throw new InvalidZipCodeFormatException();
	}
	
	private static String getRegexFormatted() {
		return DocumentFormats.CEP.toString();
	}
	
	private static String getRegexUnformatted() {
		return DocumentFormats.CEP_DIGITS_ONLY.toString();
	}
	
	private static String unformatCEP(String cepAsString) {
		return cepAsString.replace("-", "");
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		if(obj instanceof CEP) {
			CEP outro = (CEP) obj;
			ret = cepAsString.equals(outro.cepAsString);
		}
		return ret;
	}
	
	@Override
	public int hashCode() {
		return cepAsString.hashCode();
	}
}