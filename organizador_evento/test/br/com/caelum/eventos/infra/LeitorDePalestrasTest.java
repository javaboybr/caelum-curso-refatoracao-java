package br.com.caelum.eventos.infra;

import static br.com.caelum.eventos.ContextoPalestras.setPalestras;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

import org.junit.Test;

import br.com.caelum.eventos.dominio.Palestra;

public class LeitorDePalestrasTest {
	
	@Test
	public void lerArquivoDePalestras() throws FileNotFoundException{
		LeitorDePalestras leitor = new LeitorDePalestras(new File("resources/palestras"));
		Set<Palestra> palestras = leitor.lerPalestras();
		
		Set<Palestra> palestrasEsperadas = setPalestras();
		
		assertTrue(palestras.containsAll(palestrasEsperadas));
	}
	
	@Test(expected=FileNotFoundException.class)
	public void tentarLerArquivoDePalestrasInexistente() throws FileNotFoundException {
		LeitorDePalestras leitor = new LeitorDePalestras(new File("arquivoInexistente"));
		leitor.lerPalestras();
	}
}
