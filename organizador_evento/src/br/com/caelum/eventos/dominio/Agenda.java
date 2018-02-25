package br.com.caelum.eventos.dominio;

import static java.util.Arrays.asList;

import java.util.List;

public class Agenda {

	public List<Trilha> prepararTrilhas(ListaDePalestras listaDePalestras) {
		SessaoDaManha umaSessaoDaManha = new SessaoDaManha();
		SessaoDaManha outraSessaoDaManha = new SessaoDaManha();
		
		SessaoDaTarde umaSessaoDaTarde = new SessaoDaTarde();
		SessaoDaTarde outraSessaoDaTarde = new SessaoDaTarde();
		
		adicionarPalestrasSePossivel(umaSessaoDaManha, listaDePalestras);
		adicionarPalestrasSePossivel(outraSessaoDaManha, listaDePalestras);
		
		adicionarPalestrasSePossivel(umaSessaoDaTarde, listaDePalestras);
		adicionarPalestrasSePossivel(outraSessaoDaTarde, listaDePalestras);
		
		return asList(new Trilha(umaSessaoDaManha, umaSessaoDaTarde, 1), 
				new Trilha(outraSessaoDaManha, outraSessaoDaTarde, 2));
	}
	
	private void adicionarPalestrasSePossivel(Sessao sessao, ListaDePalestras palestras){
		boolean sessaoOk = false;
		while(!sessaoOk){
			sessaoOk = adicionarPalestras(sessao, palestras);
			if(!sessaoOk){
				List<Palestra> palestrasCanceladas = sessao.cancelar();
				palestras.devolver(palestrasCanceladas);
				palestras.embaralhar();
			}
		}
	}
	
	private boolean adicionarPalestras(Sessao sessao, ListaDePalestras listaDePalestras){
		boolean adicionou = true;
		while(adicionou == true && !listaDePalestras.estaVazia()){
			Palestra novaPalestra = listaDePalestras.obterProxima();
			adicionou = sessao.adicionar(novaPalestra);
			if(!adicionou){
				listaDePalestras.devolver(novaPalestra);
			}
		}
		return sessao.estaDevidamentePreenchida();
	}
}
