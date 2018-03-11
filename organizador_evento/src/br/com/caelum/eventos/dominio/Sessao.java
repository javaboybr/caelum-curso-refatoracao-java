package br.com.caelum.eventos.dominio;

import java.time.LocalTime;
import java.util.Iterator;

public abstract class Sessao implements Iterable<Palestra>{
	
	private final ListaDePalestras palestras;
	private TempoDeDuracao tempoDeDuracaoDasPalestras;
	
	protected Sessao(){
		this.palestras = new ListaDePalestras();
		this.tempoDeDuracaoDasPalestras = new TempoDeDuracao(0);
	}
	
	public boolean adicionar(Palestra novaPalestra) {
		boolean ret = false;
		if(podeAdicionar(novaPalestra)){
			ret = palestras.adicionar(novaPalestra);
			tempoDeDuracaoDasPalestras = tempoDeDuracaoDasPalestras.mais(novaPalestra.lerTempoDeDuracao());
		}
		return ret;
	}
	
	public ListaDePalestras cancelar() {
		tempoDeDuracaoDasPalestras = new TempoDeDuracao(0);
		return palestras.removerTodas();
	}
	
	//3 - Introduzir variável explicativa - outro exemplo
	private boolean podeAdicionar(Palestra novaPalestra){
		TempoDeDuracao tempoAcumulado = tempoTotalDasPalestras().mais(novaPalestra.lerTempoDeDuracao());
		return tempoAcumulado.menorQue(lerTempoDeDuracao()) || tempoAcumulado.equals(lerTempoDeDuracao()) 
				&& novaPalestra.comDuracaoMenorQue(lerTempoDeDuracao());
	}
	
	protected TempoDeDuracao tempoTotalDasPalestras() {
		return tempoDeDuracaoDasPalestras;
	}
	
	@Override
	public Iterator<Palestra> iterator(){
		return palestras.iterator();
		
	}

	public abstract TempoDeDuracao lerTempoDeDuracao();
	public abstract boolean estaDevidamentePreenchida();
	public abstract LocalTime comecaAs();
}
