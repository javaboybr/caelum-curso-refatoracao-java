package aula06.r12.extractclass.depois;

public class Empresa {

	public String razaoSocial;
	public String cnpj;

	public Endereco endEntrega;
	public Endereco endComercial;

	public Empresa(String razaoSocial, String cnpj, String endEntregaLogradouro, String endEntregaNumero,
			String endEntregaComplemento, String endEntregaBairro, String endEntregaCEP, String endEntregaMunicipio,
			String endEntregaUF, String endComercialLogradouro, String endComercialNumero,
			String endComercialComplemento, String endComercialBairro, String endComercialCEP,
			String endComercialMunicipio, String endComercialUF) {
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;

		this.endEntrega = new Endereco(endEntregaLogradouro, endEntregaNumero, endEntregaComplemento, endEntregaBairro,
				endEntregaCEP, endEntregaMunicipio, endEntregaUF);
		this.endComercial = new Endereco(endComercialLogradouro, endComercialNumero, endComercialComplemento,
				endComercialBairro, endComercialCEP, endComercialMunicipio, endComercialUF);
	}

	public String getTextoEnderecoComercial() {
		return endComercial.toString();
	}

	public String getTextoEnderecoEntrega() {
		return endEntrega.toString();
	}

	public void UpdateEnderecoEntrega(String endEntregaLogradouro, String endEntregaNumero,
			String endEntregaComplemento, String endEntregaBairro, String endEntregaCEP, String endEntregaMunicipio,
			String endEntregaUF) {
		endEntrega.update(endEntregaLogradouro, endEntregaNumero, endEntregaComplemento, endEntregaBairro, endEntregaCEP, endEntregaMunicipio, endEntregaUF);
	}

	public void UpdateEnderecoComercial(String endComercialLogradouro, String endComercialNumero,
			String endComercialComplemento, String endComercialBairro, String endComercialCEP,
			String endComercialMunicipio, String endComercialUF) {
		endComercial.update(endComercialLogradouro, endComercialNumero, endComercialComplemento, endComercialBairro, endComercialCEP, endComercialMunicipio, endComercialCEP);
	}
}

class Endereco {

	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String municipio;
	private String uf;

	public Endereco(String endEntregaLogradouro, String endEntregaNumero, String endEntregaComplemento,
			String endEntregaBairro, String endEntregaCEP, String endEntregaMunicipio, String endEntregaUF) {
		this.logradouro = endEntregaLogradouro;
		this.numero = endEntregaNumero;
		this.complemento = endEntregaComplemento;
		this.bairro = endEntregaBairro;
		this.cep = endEntregaCEP;
		this.municipio = endEntregaMunicipio;
		this.uf = endEntregaUF;
	}

	public void update(String logradouro, String numero, String complemento,
			String bairro, String cep, String municipio, String uf) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.municipio = municipio;
		this.uf = uf;
	}

	@Override
	public String toString() {
		return String.format("Endereço: %s %s %s - %s - CEP %s - %s - %s", logradouro, numero, complemento, bairro, cep,
				municipio, uf);
	}
}
