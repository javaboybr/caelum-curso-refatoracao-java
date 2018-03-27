package br.com.caelum.livraria.dominio;

// 11 - mover campo: O campo cep deverá estar aqui no final da refatoração, como agora.
public class Cliente {

	private final String id;
	private final String cep;
	
	public Cliente(String id, String cep) {
		this.id = id;
		this.cep = cep;
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
}
