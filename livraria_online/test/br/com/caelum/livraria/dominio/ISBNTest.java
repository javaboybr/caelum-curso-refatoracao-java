package br.com.caelum.livraria.dominio;

import org.junit.Test;

public class ISBNTest {
	
	// É o ISBN do livro Design Patterns,
	// da Gang of Four (GoF)!
	private static final String stringIsbnValido = "978-85-7307-610-3";
	public static final ISBN umIsbnValido = new ISBN(stringIsbnValido);
	public static final ISBN outroIsbnValido = new ISBN("978-85-363-0638-4");
	
	@Test(expected=IllegalArgumentException.class)
	public void invalidarISBNNulo() {
		new ISBN(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void invalidarISBNInvalido() {
		String isbnInvalido = "este é um isbn inválido";
		new ISBN(isbnInvalido);
	}
	
	@Test
	public void validarISBN() {
		new ISBN(stringIsbnValido);
		// se não lançou exceção, o objeto foi criado com sucesso.
	}
}
