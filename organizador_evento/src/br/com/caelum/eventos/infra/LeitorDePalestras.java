package br.com.caelum.eventos.infra;

import static br.com.caelum.eventos.dominio.TempoDeDuracao.LIGHTING_STRING;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import br.com.caelum.eventos.dominio.Palestra;
import br.com.caelum.eventos.dominio.TempoDeDuracao;

public class LeitorDePalestras {

	private final File arquivoDePalestras;
	
	public LeitorDePalestras(File arquivoDePalestras) {
		this.arquivoDePalestras = arquivoDePalestras;
	}

	public Set<Palestra> lerPalestras() throws FileNotFoundException {
		Scanner scanner = new Scanner(arquivoDePalestras);
		Set<Palestra> ret = new HashSet<>();
		while(scanner.hasNextLine()){
			String linha = scanner.nextLine();
			Palestra palestra = lerPalestra(linha);
			ret.add(palestra);
		}
		scanner.close();
		return ret;
	}
	
	private Palestra lerPalestra(String linha){
		int indiceDaDivisaoEntreNomeETempo = linha.lastIndexOf(" ");
		String nome = linha.substring(0, indiceDaDivisaoEntreNomeETempo);
		String tempoString = linha.substring(indiceDaDivisaoEntreNomeETempo + 1, linha.length() - 3);
		TempoDeDuracao duracao = LIGHTING_STRING.contains(tempoString) ? TempoDeDuracao.LIGHTING : new TempoDeDuracao(Integer.valueOf(tempoString));
		
		return new Palestra(nome, duracao);
	}
}
