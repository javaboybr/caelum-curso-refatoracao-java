package br.com.caelum.eventos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.eventos.dominio.Agenda;
import br.com.caelum.eventos.dominio.Atividade;
import br.com.caelum.eventos.dominio.ListaDePalestras;
import br.com.caelum.eventos.dominio.Trilha;
import br.com.caelum.eventos.infra.LeitorDePalestras;

public class Main {
	
	public static void main(String ...args) throws FileNotFoundException{
		System.out.println("Entre com o local onde o arquivo de palestras se encontra:");
		Scanner s = new Scanner(System.in);
		String localArquivo = s.next();
		File arquivoDePalestras = new File(localArquivo);
		s.close();
		
		LeitorDePalestras leitor = new LeitorDePalestras(arquivoDePalestras);
		ListaDePalestras palestras = leitor.lerPalestras();
		
		Agenda agenda = new Agenda(palestras);
		List<Trilha> trilhas = agenda.prepararTrilhas();
		
		for(Trilha trilha : trilhas){
			System.out.println(trilha.nome() + ":");
			for(Atividade e : trilha.lerAtividadesAgendadasEmOrdem()){
				System.out.println(e);
			}
			System.out.println();
		}
	}
}
