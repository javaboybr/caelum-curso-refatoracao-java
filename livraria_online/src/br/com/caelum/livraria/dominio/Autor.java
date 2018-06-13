package br.com.caelum.livraria.dominio;

import java.util.Arrays;
import java.util.List;

//17 - Introduzir Extensão local: Essa classe será criada para exemplificar 
//essa técnica de refatoração.
public class Autor {

	private final String nome;

	public Autor(String nome) {
		this.nome = nome;
	}

	public String getUltimoSobrenome() {
		List<String> nomes = getTrechosDoNome();
		return capitalize(nomes.get(nomes.size() - 1));
	}
	
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		getTrechosDoNome().stream().forEach(parteDoNome -> {
			ret.append(capitalize(parteDoNome));
			ret.append(" ");
		});
		return ret.toString().trim();
	}

	private String capitalize(String nome) {
		return Character.toUpperCase(nome.charAt(0)) + nome.substring(1).toLowerCase();
	}

	private List<String> getTrechosDoNome() {
		return Arrays.asList(nome.split(" "));
	}
}
