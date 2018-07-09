package br.com.caelum.eventos.dominio;

import static java.util.Arrays.asList;

import java.util.List;

public class Agenda {

	private final ListaDePalestras listaDePalestras;
	
	public Agenda(ListaDePalestras palestras){
		this.listaDePalestras = palestras;
	}
	
	public List<Trilha> prepararTrilhas() {
		SessaoDaManha umaSessaoDaManha = new SessaoDaManha();
		SessaoDaManha outraSessaoDaManha = new SessaoDaManha();
		
		SessaoDaTarde umaSessaoDaTarde = new SessaoDaTarde();
		SessaoDaTarde outraSessaoDaTarde = new SessaoDaTarde();
		
		adicionarPalestrasSePossivel(umaSessaoDaManha, listaDePalestras);
		adicionarPalestrasSePossivel(outraSessaoDaManha, listaDePalestras);

		adicionarPalestrasSePossivel(umaSessaoDaTarde, listaDePalestras);
		adicionarPalestrasSePossivel(outraSessaoDaTarde, listaDePalestras);
		
		//6 - dividir variável temporária - criar 2 variáveis String
		// a variável 'nomeDaTrilha' está recebendo mais de uma atribuição, o que indica que ela pode
		// estar com responsabilidades demais. Daí a aplicação dessa técnica de refatoração.
		String nomeDaTrilha = "PaPo ReTo";
		Trilha trilha1 = new Trilha(nomeDaTrilha, umaSessaoDaManha, umaSessaoDaTarde);
		nomeDaTrilha = "DiGiTal";
		Trilha trilha2 = new Trilha(nomeDaTrilha, outraSessaoDaManha, outraSessaoDaTarde);
		return asList(trilha1, trilha2);	
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
