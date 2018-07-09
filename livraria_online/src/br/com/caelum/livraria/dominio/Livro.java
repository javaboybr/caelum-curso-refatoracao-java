package br.com.caelum.livraria.dominio;

import java.util.Arrays;
import java.util.List;

import org.javamoney.moneta.Money;

public class Livro {
	
	private final String titulo;
	private final String autor;
	private final ISBN isbn;
	private final Money valor;
	
	public Livro(String titulo, String autor, ISBN isbn, Money valor) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.valor = valor;
	}
	
	public Money getValor() {
		return valor;
	}
	
	//15 - remover intermediário: o código contido em FormatadorUtils.getValorFormatado deve retornar 
	// para esse método. Deve-se remover, portanto, a classe FormatadorUtils e seu teste durante a
	// refatoração.
	public String getValorFormatado() {
		return FormatadorUtils.getValorFormatado(valor);
	}
	
	public String getNome() {
		return titulo;
	}
	
	public String getISBN() {
		return isbn.toString();
	}
	
	//17 - Introduzir Extensão local: Criar a classe Autor para exemplificar essa refatoração.
	public String getAutor() {
		StringBuilder autor = new StringBuilder();
		getTrechosDoNomeDoAutor().stream().forEach(parteDoNome -> {
			autor.append(capitalize(parteDoNome));
			autor.append(" ");
		});
		return autor.toString().trim();
	}
	
	public String getUltimoSobrenomeDoAutor() {
		List<String> nomes = getTrechosDoNomeDoAutor();
		return capitalize(nomes.get(nomes.size() - 1));
	}
	
	private String capitalize(String nome) {
		return Character.toUpperCase(nome.charAt(0)) + nome.substring(1).toLowerCase();
	}

	private List<String> getTrechosDoNomeDoAutor() {
		return Arrays.asList(autor.split(" "));
	}
}
