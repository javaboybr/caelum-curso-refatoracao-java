package br.com.caelum.livraria.dominio;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AutorTest {
	
	public static final Autor umAutor = new Autor("Rodrigo Vieira");
	
	private final Autor autorComSomenteONome = new Autor("rOdRiGo");
	private final Autor autorComNomeESobrenome = new Autor("rOdRiGo fErNaNdEs");
	
	@Test
	public void lerUltimoSobrenomeDeUmAutorComApenasONome() {
		assertThat(autorComSomenteONome.getUltimoSobrenome(), is(equalTo("Rodrigo")));
	}
	
	@Test
	public void lerUltimoSobrenomeDeUmAutorComNomeEUmSobrenome() {
		assertThat(autorComNomeESobrenome.getUltimoSobrenome(), is(equalTo("Fernandes")));
	}
	
	@Test
	public void toStringDeveRetornarAPrimeiraLetraDeCadaParteDoNomeComoMaiusculaNoCasoDeUmAutorComApenasONome() {
		assertThat(autorComSomenteONome.toString(), is(equalTo("Rodrigo")));
	}
	
	@Test
	public void toStringDeveRetornarAPrimeiraLetraDeCadaParteDoNomeComoMaiusculaNoCasoDeUmAutorComNomeESobrenome() {
		assertThat(autorComNomeESobrenome.toString(), is(equalTo("Rodrigo Fernandes")));
	}
}
