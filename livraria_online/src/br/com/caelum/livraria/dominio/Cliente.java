package br.com.caelum.livraria.dominio;

// 11 - mover campo: O campo cep deverá estar aqui no final da refatoração, como agora.
public class Cliente {

	private final String id;
	private final String cep;
	private final Telefone telefone;
	
	public Cliente(String id, String cep, Telefone telefone) {
		this.id = id;
		this.cep = cep;
		this.telefone = telefone;
	}

	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		if(obj instanceof Cliente) {
			Cliente outra = (Cliente) obj;
			ret = id.equals(outra.id);
		}
		return ret;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}

	public String lerCep() {
		return cep;
	}
	
	public String lerTelefone() {
		return telefone.toString();
	}
}