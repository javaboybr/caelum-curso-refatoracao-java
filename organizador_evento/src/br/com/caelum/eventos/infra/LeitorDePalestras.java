package br.com.caelum.eventos.infra;

import static br.com.caelum.eventos.dominio.TempoDeDuracao.LIGHTING_STRING;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import br.com.caelum.eventos.dominio.ListaDePalestras;
import br.com.caelum.eventos.dominio.Palestra;
import br.com.caelum.eventos.dominio.TempoDeDuracao;

public class LeitorDePalestras {

	private final File arquivoDePalestras;
	
	public LeitorDePalestras(File arquivoDePalestras) {
		this.arquivoDePalestras = arquivoDePalestras;
	}

	public ListaDePalestras lerPalestras() throws FileNotFoundException {
		Set<Palestra> ret = new HashSet<>();
		try(Scanner scanner = new Scanner(arquivoDePalestras)){
			while(scanner.hasNextLine()){
				Palestra palestra = lerPalestra(scanner);
				ret.add(palestra);
			}
		}
		return new ListaDePalestras(ret);
	}

	// 2 - exemplo de inline method - deve-se retornar o seu conteúdo ao local onde ele é chamado.
	// Esse método é chamado uma única vez, além de ser uma indireção desnecessária. Logo, essa técnica pode ser aplicada aqui.
	private Palestra lerPalestra(Scanner scanner) {
		String linha = scanner.nextLine();
		return lerPalestra(linha);
	}
	
	private Palestra lerPalestra(String linha){
		int indiceDaDivisaoEntreNomeETempo = linha.lastIndexOf(' ');
		
		//5 - substituir variável temporária por consulta - criar método que retorne o nome da palestra
		String nome = linha.substring(0, indiceDaDivisaoEntreNomeETempo);
		//5 - substituir variável temporária por consulta - criar método que retorne o nome da palestra
		String tempoString = linha.substring(indiceDaDivisaoEntreNomeETempo + 1, linha.length() - 3);
		TempoDeDuracao duracao = LIGHTING_STRING.contains(tempoString) 
				? TempoDeDuracao.LIGHTING 
				: new TempoDeDuracao(Integer.valueOf(tempoString));
		
		return new Palestra(nome, duracao);
	}
}
