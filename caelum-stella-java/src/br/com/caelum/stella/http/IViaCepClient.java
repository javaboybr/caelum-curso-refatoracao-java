package br.com.caelum.stella.http;

public interface IViaCepClient {
	
	String getEndereco(String cep, String outputType);
	
}
