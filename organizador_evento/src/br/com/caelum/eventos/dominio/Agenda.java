package br.com.caelum.eventos.dominio;

import static java.util.Arrays.asList;

import java.util.List;

public class Agenda {

	private final ListaDePalestras listaDePalestras;
	
	public Agenda(ListaDePalestras palestras){
		this.listaDePalestras = palestras;
	}
	
	public List<Trilha> prepararTrilhas() {
		final String nomeDaTrilha1 = "PaPo ReTo";
		final String nomeDaTrilha2 = "DiGiTal";
		SessaoDaManha umaSessaoDaManha = new SessaoDaManha();
		SessaoDaManha outraSessaoDaManha = new SessaoDaManha();
		
		SessaoDaTarde umaSessaoDaTarde = new SessaoDaTarde();
		SessaoDaTarde outraSessaoDaTarde = new SessaoDaTarde();
		
		adicionarPalestrasSePossivel(umaSessaoDaManha, listaDePalestras);
		adicionarPalestrasSePossivel(outraSessaoDaManha, listaDePalestras);
		
		adicionarPalestrasSePossivel(umaSessaoDaTarde, listaDePalestras);
		adicionarPalestrasSePossivel(outraSessaoDaTarde, listaDePalestras);
		
		return asList(new Trilha(nomeDaTrilha1, umaSessaoDaManha, umaSessaoDaTarde), 
				new Trilha(nomeDaTrilha2, outraSessaoDaManha, outraSessaoDaTarde));
	}
	
	private void adicionarPalestrasSePossivel(Sessao sessao, ListaDePalestras palestras){
		boolean sessaoOk = false;
		while(!sessaoOk){
			sessaoOk = adicionarPalestras(sessao, palestras);
			if(!sessaoOk){
				ListaDePalestras palestrasCanceladas = sessao.cancelar();
				palestras.devolver(palestrasCanceladas);
				palestras.embaralhar();
			}
		}
	}
	
	private boolean adicionarPalestras(Sessao sessao, ListaDePalestras listaDePalestras){
		boolean adicionou = true;
		while(adicionou && !listaDePalestras.estaVazia()){
			Palestra novaPalestra = listaDePalestras.obterProxima();
			adicionou = sessao.adicionar(novaPalestra);
			if(!adicionou){
				listaDePalestras.devolver(novaPalestra);
			}
		}
		return sessao.estaDevidamentePreenchida();
	}
}
