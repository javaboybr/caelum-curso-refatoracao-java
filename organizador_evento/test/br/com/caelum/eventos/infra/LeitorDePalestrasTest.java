package br.com.caelum.eventos.infra;

import static br.com.caelum.eventos.dominio.ContextoPalestras.setPalestras;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

import org.junit.Test;

import br.com.caelum.eventos.dominio.ListaDePalestras;
import br.com.caelum.eventos.dominio.Palestra;
import br.com.caelum.eventos.infra.LeitorDePalestras;

public class LeitorDePalestrasTest {
	
	@Test
	public void lerArquivoDePalestras() throws FileNotFoundException{
		LeitorDePalestras leitor = new LeitorDePalestras(new File("resources/palestras"));
		ListaDePalestras palestras = leitor.lerPalestras();
		
		Set<Palestra> palestrasEsperadas = setPalestras();
		
		palestrasEsperadas.forEach(palestraEsperada -> {
			assertThat(palestras, hasItem(palestraEsperada));
		});
	}
	
	@Test(expected=FileNotFoundException.class)
	public void tentarLerArquivoDePalestrasInexistente() throws FileNotFoundException {
		LeitorDePalestras leitor = new LeitorDePalestras(new File("arquivoInexistente"));
		leitor.lerPalestras();
	}
}
