package br.com.caelum.livraria;

import org.junit.Test;

public class ISBNTest {
	
	//978-85-7307-610-3
	
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
		String isbnValido = "978-85-7307-610-3"; // É o ISBN do livro Design Patterns,
												// da Gang of Four (GoF)!
		
		new ISBN(isbnValido);
		// se não lançou exceção, o objeto foi criado com sucesso.
	}
}
