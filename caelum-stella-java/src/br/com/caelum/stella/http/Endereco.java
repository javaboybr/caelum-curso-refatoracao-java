package br.com.caelum.stella.http;

import java.io.Serializable;

public class Endereco implements Serializable{

	private static final long serialVersionUID = -4759691831532571369L;

	private final String cep;
	private final String logradouro;
	private final String complemento;
	private final String bairro;
	private final String localidade;
	private final String uf;
	private final String unidade;
	private final String ibge;
	private final String gia;
	
	public Endereco(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String unidade, String ibge, String gia) {
		this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.unidade = unidade;
        this.ibge = ibge;
        this.gia = gia;
	}
	
	public boolean isValid() {
		return cep != null && !cep.isEmpty();
	}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public String getUf() {
		return uf;
	}

	public String getUnidade() {
		return unidade;
	}

	public String getIbge() {
		return ibge;
	}

	public String getGia() {
		return gia;
	}
}
