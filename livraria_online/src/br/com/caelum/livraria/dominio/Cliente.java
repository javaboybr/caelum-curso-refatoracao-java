package br.com.caelum.livraria.dominio;

// 11 - mover campo: O campo cep deverá estar aqui no final da refatoração.
public class Cliente {

	private final String id;
	private final Telefone telefone;
	
	public Cliente(String id, Telefone telefone) {
		this.id = id;
		this.telefone = telefone;
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguais = false;
		if(obj instanceof Cliente) {
			Cliente outra = (Cliente) obj;
			iguais = id.equals(outra.id);
		}
		return iguais;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}

	public String getTelefone() {
		return telefone.toString();
	}
}
